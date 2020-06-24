package com.irongbei;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QianDuanChongZhi {
	@Test(dataProvider="chongzhi")
	public void qiandcz(String phone) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		ChangePhoneBack cp=new ChangePhoneBack();
		cp.changePhoneBack(phone,"18701473018", "test");
		dr.get("http://rbtest.irongbei.com/UserLogin/index");
		dr.findElement(By.id("user_name")).clear();
		dr.findElement(By.id("user_name")).sendKeys(phone);
		dr.findElement(By.id("user_password")).clear();
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
//		dr.navigate().to("http://rbtest.irongbei.com/UserCenter/index");
		
		dr.navigate().to("http://rbtest.irongbei.com/UserCenter/wyzzcharge");
		dr.findElement(By.linkText("快捷充值")).click();
		
		dr.findElement(By.name("howMuch")).sendKeys("10000");
		
		dr.findElement(By.id("chkbox")).click();
		dr.findElement(By.id("sub_charge")).click();
		
		GetNextHandle gnh=new GetNextHandle();
		gnh.getNextHandle(dr);
		
		dr.findElement(By.id("pass")).sendKeys("121121");
		dr.findElement(By.id("smsBtn")).click();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入验证码:");
		while(sc.hasNext()) {
			String yanzhengma=sc.next();
			dr.findElement(By.id("SMS_CODE")).sendKeys(yanzhengma);
			dr.findElement(By.id("sub")).click();
			break;
		}
	
		Thread.sleep(2000);
		
		cp.changePhoneBack(phone, phone, "test");
		
		dr.quit();
		dr.close();
}
	
	@DataProvider(name="chongzhi")
	public Object[][] getphone(){
		
		Object[][] phone= {{"17409240065"}};
		return phone;
		
	}
}

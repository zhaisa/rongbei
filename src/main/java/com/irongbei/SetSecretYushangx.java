package com.irongbei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetSecretYushangx {
	public void setSecret(String userphone,String usercard,String backtime,String bankcard) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("only.irongbei.com/UserLogin/index");
		dr.findElement(By.id("user_name")).sendKeys(userphone);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(2000);
		dr.navigate().to("only.irongbei.com/UserCenter/index");
		dr.findElement(By.linkText("设置交易密码")).click();
		dr.navigate().to("only.irongbei.com/UserCenter/tradepwd");
		dr.findElement(By.id("resend")).click();
		Thread.sleep(2000);
		dr.findElement(By.id("pyzm")).clear();
		dr.findElement(By.id("pyzm")).sendKeys(backtime);// 后台时间
		dr.findElement(By.linkText("确定")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 得到所有窗口的句柄
		String currentWindow = dr.getWindowHandle();
		Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = dr.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
			String sss1 = window.getCurrentUrl();
			dr.navigate().to(sss1);
			Thread.sleep(2000);
			dr.findElement(By.id("BIND_CARD_NO")).clear();
			dr.findElement(By.id("BIND_CARD_NO")).sendKeys(bankcard);
			dr.findElement(By.id("NAME")).clear();
			dr.findElement(By.id("NAME")).sendKeys("测试翟");
			dr.findElement(By.id("IDNO")).clear();
			dr.findElement(By.id("IDNO")).sendKeys(usercard);
			dr.findElement(By.id("encPin1")).clear();
			dr.findElement(By.id("encPin1")).sendKeys("121121");
			dr.findElement(By.id("encPin2")).clear();
			dr.findElement(By.id("encPin2")).sendKeys("121121");
			dr.findElement(By.id("PHONE")).clear();
			dr.findElement(By.id("PHONE")).sendKeys("18701473018");
			dr.findElement(By.id("smsBtn")).click();
			Thread.sleep(1000);
			  System.out.println("请输入验证码：");
			    Scanner scan=new Scanner(System.in);
			    if (scan.hasNext()) {
			    	
					String str1 = scan.next();
					System.out.println("输入的数据为：" + str1);
					
			    dr.findElement(By.id("smsInput")).sendKeys(str1);
			    Thread.sleep(3000);
			dr.findElement(By.id("sub")).click();}
			    Thread.sleep(5000);
			dr.close();
			dr.quit();
		}

	}
}

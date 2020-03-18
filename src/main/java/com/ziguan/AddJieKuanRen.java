package com.ziguan;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.fengkong.NewUserCardAndBankCard;
import com.irongbei.CreateDriver;
import com.rongbei.util.ReadTxtForOne;

public class AddJieKuanRen {
	@Test(invocationCount=10,threadPoolSize=1)
	public void addjkr() throws InterruptedException, IOException {
		CreateDriver cd=new CreateDriver();
		WebDriver dr=CreateDriver.getDriver("chrome");
		dr.get("http://alpha.business.irongbei.com");
		Thread.sleep(2000);
		dr.findElement(By.name("username")).sendKeys("zsph0001");
		dr.findElement(By.name("password")).sendKeys("123456");
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入验证码:");
		if(sc.hasNext()) {
			
			String aaa=sc.next();
			dr.findElement(By.name("vercode")).sendKeys(aaa);
			
		}
		dr.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div/div[2]/div[4]/div[2]/div")).click();
		dr.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div/div[2]/div[4]/div[1]/i")).click();
		dr.findElement(By.xpath("//*[@id=\"LAY-user-login\"]/div/div[2]/div[5]/button")).click();
		Thread.sleep(2000);
		dr.navigate().to("http://alpha.business.irongbei.com/#/");
		Thread.sleep(1000);
		dr.navigate().to("http://alpha.business.irongbei.com/#/borrower/create");
		Thread.sleep(1000);
		Calendar cc=new GregorianCalendar();
		String nowtime=new SimpleDateFormat("HHmmss").format(cc.getTime());
		String username="测试翟"+nowtime;
		dr.findElement(By.name("borrower_name")).sendKeys(username);
		String usercard = NewUserCardAndBankCard.Calculate();
		dr.findElement(By.name("id_number")).sendKeys(usercard);
		ReadTxtForOne rt = new ReadTxtForOne();
		String readname = rt.readline();
		dr.findElement(By.name("borrower_phone")).sendKeys(readname);
		dr.findElement(By.name("nation")).sendKeys("汉族");
		dr.findElement(By.name("work_linkman[]")).sendKeys("AAA");
		dr.findElement(By.name("work_relation[]")).sendKeys("同事");
//		WebElement tbody =dr.findElement(By.xpath("//*[@id=\"LAY_app_body\"]/div/div[2]/div/div/form[1]/div[9]/table/tbody"));
//		List tr=tbody.findElements(By.tagName("tr"));
		dr.findElement(By.name("work_units[]")).sendKeys("家里蹲");
		dr.findElement(By.name("work_address[]")).sendKeys("北京办事处");
		dr.findElement(By.name("work_positions[]")).sendKeys("高级研究员");
		dr.findElement(By.name("work_phone[]")).sendKeys("17409040211");
		
		dr.findElement(By.xpath("//*[@id=\"LAY_app_body\"]/div/div[2]/div/div/form[1]/div[12]/button[1]")).click();
		Thread.sleep(2000);
		dr.findElement(By.linkText("确定")).click();
		Thread.sleep(1000);
		dr.close();
		dr.quit();
	}

}

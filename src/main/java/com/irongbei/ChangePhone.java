package com.irongbei;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.irongbeipages.LoginPage;

public class ChangePhone {
public void changePhone() throws Exception {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	Calendar cc = new GregorianCalendar();
	LoginPage lp=new LoginPage(dr);
	lp.login("测试专用管理员", "123456");
	Thread.sleep(2000);
	dr.findElement(By.partialLinkText("用户列表")).click();
	Thread.sleep(2000);
	dr.findElement(By.id("list_username")).sendKeys(aaaa);
	dr.findElement(By.id("userlistbutton")).click();
	Thread.sleep(2000);
	dr.findElement(By.linkText("[查看]")).click();
	
	
}
}

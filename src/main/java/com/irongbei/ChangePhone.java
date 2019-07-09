package com.irongbei;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.irongbeipages.LoginPage;

public class ChangePhone {
public void changePhone(String phone,String distphone,String env) throws Exception {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	Calendar cc = new GregorianCalendar();
	MyEnviment me=new MyEnviment();
	String beorba=env+"admin";
	String url=me.getEvi(env, beorba);
	dr.get(url+"/admin/Login");
	LoginPage lp=new LoginPage(dr);
	lp.login("测试专用管理员", "123456");
	Thread.sleep(2000);
	dr.findElement(By.linkText("用户管理")).click();
	Thread.sleep(2000);
	dr.findElement(By.partialLinkText("用户列表")).click();
//	ReadTxt rt=new ReadTxt();
//	String aaaa=rt.readFS("D://users//newusers.txt",lineNo);
	dr.findElement(By.id("list_username")).sendKeys(phone);
	dr.findElement(By.id("userlistbutton")).click();
	Thread.sleep(2000);
	dr.findElement(By.linkText("[查看]")).click();
	Thread.sleep(2000);
	dr.findElement(By.partialLinkText("[用户修改手机号")).click();//uat 为认证开户的：[用户修改手机号
	Thread.sleep(2000);
	dr.findElement(By.id("mobile1")).clear();
	dr.findElement(By.id("mobile1")).sendKeys(distphone);
	dr.findElement(By.linkText("确定")).click();
	Thread.sleep(2000);
	dr.close();
	dr.quit();
	
}
}

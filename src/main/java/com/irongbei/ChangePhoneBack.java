package com.irongbei;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.irongbeipages.LoginPage;

public class ChangePhoneBack {
public void changePhoneBack(String phone,String distphone,String env) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	Calendar cc = new GregorianCalendar();
	MyEnviment me=new MyEnviment();
	String admin=env+"admin";
	String url=me.getEvi(env, admin);
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
	Thread.sleep(1000);
//	dr.findElement(By.partialLinkText("[修改并认证通过]")).click();
	dr.findElement(By.xpath("html/body/div[5]/div/div[2]/p[4]/span[3]/a[2]")).click();
	dr.findElement(By.id("mobile1")).clear();
	dr.findElement(By.id("mobile1")).sendKeys(distphone);
//	dr.findElement(By.id("resend")).click();
//	Thread.sleep(2000);
//	dr.findElement(By.id("yzphone")).sendKeys("111111");
	Thread.sleep(2000);
	dr.findElement(By.linkText("确定")).click();
	Thread.sleep(2000);
	dr.close();
	dr.quit();
}
}

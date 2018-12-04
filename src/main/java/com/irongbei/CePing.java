package com.irongbei;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CePing {
	
public void cePing(String phone) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	dr.get("http://testhf.irongbei.com/UserLogin/index");
	dr.findElement(By.id("user_name")).sendKeys(phone);
	dr.findElement(By.id("user_password")).sendKeys("123456");
	dr.findElement(By.id("qianlogin")).click();
	Thread.sleep(1000);
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
	Thread.sleep(1000);
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/userinfo");
	Thread.sleep(2000);
	dr.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div/div[5]/ul/li[10]/span[3]/a")).click();
	Thread.sleep(1000);
	GetNextHandle gnh=new GetNextHandle();
	gnh.getNextHandle(dr);
	List<WebElement> list=dr.findElements(By.className("manner_list10_timu"));
	for(int i=0;i<list.size();i++) {
		List<WebElement> ul=list.get(i).findElements(By.tagName("ul"));
		for(int j=0;j<ul.size();j++) {
			List<WebElement> li=ul.get(j).findElements(By.tagName("li"));
			for(int k=0;k<li.size();k++) {
				System.out.println(li.get(k).getText());
				dr.findElement(By.linkText(li.get(1).getText())).click();
			}
		}
	}
	List<WebElement> list1=dr.findElements(By.className("manner_list05_timu"));
	for(int i=0;i<list1.size();i++) {
		List<WebElement> ul=list1.get(i).findElements(By.tagName("ul"));
		for(int j=0;j<ul.size();j++) {
			List<WebElement> li=ul.get(j).findElements(By.tagName("li"));
			for(int k=0;k<li.size();k++) {
				System.out.println(li.get(k).getText());
				dr.findElement(By.linkText(li.get(2).getText())).click();
			}
		}
	}
	dr.findElement(By.linkText("提交")).click();
	Thread.sleep(3000);
	dr.close();
	dr.quit();
}
}

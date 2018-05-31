package com.irongbei;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyZhiTou {
public void buyZhiTou() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://testhf.irongbei.com/UserLogin/index");
	dr.findElement(By.id("user_name")).clear();
	dr.findElement(By.id("user_name")).sendKeys("17409090042");
	dr.findElement(By.id("user_password")).clear();
	dr.findElement(By.id("user_password")).sendKeys("123456");
	dr.findElement(By.id("qianlogin")).click();
	Thread.sleep(1000);
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
	dr.findElement(By.linkText("我要出借")).click();
	dr.navigate().to("http://testhf.irongbei.com/index/fplist");
	dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	dr.findElement(By.linkText("项目直投")).click();
	dr.navigate().to("http://testhf.irongbei.com/Index/plist");
	dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	String hurl="http://testhf.irongbei.com/index/pdetail?id=";
	int id=8706;
	String url=hurl+id;
	dr.navigate().to(url);
	dr.findElement(By.id("invest_account")).clear();
	dr.findElement(By.id("invest_account")).sendKeys("100");
	Thread.sleep(1000);
	dr.findElement(By.id("investSubmit")).click();
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/confirm?program=9132&account=100&uvId=0&key=5715c1b1a1c2b3bd0b3529abb2b94921&isuse=0");
	dr.findElement(By.className("magBtn")).click();
	dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	String currentWindow = dr.getWindowHandle();
	// 得到所有窗口的句柄
	Set<String> handles = dr.getWindowHandles();
	Iterator<String> it = handles.iterator();
	while (it.hasNext()) {
		String handle = it.next();
		if (currentWindow.equals(handle))
			continue;
		WebDriver window = dr.switchTo().window(handle);
		System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
		String sss = window.getCurrentUrl();
		dr.navigate().to(sss);
        Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123456");
		dr.findElement(By.id("sub")).click();
		Thread.sleep(3000);
		
		
	}
	dr.quit();
	
}
}

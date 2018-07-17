package com.irongbei;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetSecret {
	public void setSecret(String userphone,String usercard) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");
		dr.findElement(By.id("user_name")).sendKeys(userphone);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(2000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
		dr.findElement(By.linkText("设置交易密码")).click();
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/tradepwd");
		dr.findElement(By.id("resend")).click();
		Thread.sleep(2000);
		dr.findElement(By.id("pyzm")).clear();
		dr.findElement(By.id("pyzm")).sendKeys("081718");// 后台时间
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
			dr.findElement(By.id("idNo")).clear();
			dr.findElement(By.id("idNo")).sendKeys(usercard);
			dr.findElement(By.id("encPin1")).clear();
			dr.findElement(By.id("encPin1")).sendKeys("121121");
			dr.findElement(By.id("encPin2")).clear();
			dr.findElement(By.id("encPin2")).sendKeys("121121");
			dr.findElement(By.id("sub")).click();
			dr.close();
			dr.quit();
		}

	}
}

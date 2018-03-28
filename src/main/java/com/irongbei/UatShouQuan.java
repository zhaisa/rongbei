package com.irongbei;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UatShouQuan {
	@Test
	public void uatShouQuan(int lineNo) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");
		dr.manage().window().maximize();
		ReadTxt rt = new ReadTxt();// 给出要循环多少次时，循环读取文件
		String a = rt.readFS("D:\\users\\uatsquser.txt", lineNo);

		System.out.println(a);
		dr.findElement(By.id("user_name")).sendKeys(a);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");

		dr.findElement(By.xpath(".//div[2]/ul/li[5]/dt/a"));
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/autoauth");
		Thread.sleep(1000);
		dr.findElement(By.linkText("开通自动投标授权")).click();
		dr.findElement(By.id("captchapic")).clear();
		dr.findElement(By.id("captchapic")).sendKeys("");// 输入验证码
		dr.findElement(By.id("resend")).click();
		dr.findElement(By.className("inputCase")).sendKeys("111111");
		Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			WebDriver window = dr.switchTo().window(handle);
			dr.navigate().to(window.getCurrentUrl());
		}
		dr.findElement(By.xpath("//*[@id=\"encPin1\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"encPin1\"]")).sendKeys("123456");
		dr.findElement(By.xpath("//*[@id=\"encPin2\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"encPin2\"]")).sendKeys("123456");
		dr.findElement(By.id("sub")).click();
		Thread.sleep(3000);
		dr.close();
		dr.quit();
	}
}

package com.irongbei;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewRegister {
	@Test
	public void register(int lineNo) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		ReadTxt rt = new ReadTxt();
		String aaa = rt.readFS("D:\\users\\newusers.txt", lineNo);
		dr.get("http://dev-test.irongbei.com/userRegister/index");
		dr.findElement(By.id("mobile")).clear();
		dr.findElement(By.id("mobile")).sendKeys(aaa);
		dr.findElement(By.id("resend")).click();
		Thread.sleep(2000);
		dr.findElement(By.id("phoneyzcode")).clear();
		dr.findElement(By.id("phoneyzcode")).sendKeys("070118");
		
		dr.get("http://dev-test.irongbei.com/ImageCode/getImageCode?ran='+Math.random()");
		dr.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "t");// 在同一浏览器上打开下面的链接
		// String aaa = "请输入验证码：";
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入验证码");
		if (scan.hasNext()) {
			String str1 = scan.next();
			System.out.println("输入的数据为：" + str1);
		
	
		}

	}
}

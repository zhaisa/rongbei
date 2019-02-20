package com.irongbei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KaiTongCunGan {
	public static void testPlan(String userphone, String usercard, String bankcard) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://dev-test.irongbei.com/UserLogin/index");

		dr.findElement(By.id("user_name")).sendKeys(userphone);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(2000);
		dr.navigate().to("http://dev-test.irongbei.com/UserCenter/index");
		Thread.sleep(2000);
		dr.findElement(By.linkText("开通银行存管账户")).click();
		dr.navigate().to("http://dev-test.irongbei.com/UserCenter/jxaccount");
		Thread.sleep(3000);
		dr.findElement(By.id("realname")).clear();
		dr.findElement(By.id("realname")).sendKeys("测试翟");

		dr.findElement(By.id("usercode")).clear();
		dr.findElement(By.id("usercode")).sendKeys(usercard);
        dr.findElement(By.id("xy_checkbox")).click();
		dr.findElement(By.linkText("同意并开通银行存管账户")).click();

		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Thread.sleep(4000);
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
			if(sss.contains("url_seq_no")) {
			dr.navigate().to(sss);
			Thread.sleep(3000);
			
			
//			if (dr.findElement(By.id("smsBtn")).isDisplayed()) {

				dr.findElement(By.id("BIND_CARD_NO")).clear();
				dr.findElement(By.id("BIND_CARD_NO")).sendKeys(bankcard);
				dr.findElement(By.id("IDNO")).clear();
				dr.findElement(By.id("IDNO")).sendKeys(usercard);
				dr.findElement(By.id("encPin1")).clear();
				dr.findElement(By.id("encPin1")).sendKeys("121121");
				dr.findElement(By.id("encPin2")).clear();
				dr.findElement(By.id("encPin2")).sendKeys("121121");

				dr.findElement(By.id("smsBtn")).click();
				System.out.println("请输入验证码：");
				Scanner scan = new Scanner(System.in);
				if (scan.hasNext()) {

					String str1 = scan.next();
					System.out.println("输入的数据为：" + str1);

					dr.findElement(By.id("smsInput")).sendKeys(str1);
					Thread.sleep(3000);
					dr.findElement(By.id("mainAcceptIpt")).click();
					dr.findElement(By.id("sub")).click();
					Thread.sleep(8000);
				} }else {
					return;
				}


				// fr.close();
				dr.close();

				dr.quit();
			}
		}
	}

package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyDaBiao {

	public static void testPlan(int lineNo) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");
//		ReadTxt rt = new ReadTxt();
//		String username = rt.readFS("D:\\users\\usertext1.txt", lineNo);
		dr.findElement(By.id("user_name")).sendKeys("17409090042");
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
		Thread.sleep(1000);
		dr.findElement(By.linkText("我要出借")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/fplist");
		
		dr.findElement(By.className("mai-btn")).click();
		dr.navigate().to("http://testhf.irongbei.com/Index/fpdetail?id=60");
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys("100");
		dr.findElement(By.id("investSubmit")).click();
		String url1="http://testhf.irongbei.com/UserCenter/fpconfirm?program=";
		int id=60;
		String url2="&account=";
		int account=100;
		String url3="&uvId=0&key=";
		String key="4884557ecfe71457e97bffc45013c570";
		String url4="&isuse=0";
		String url=url1+id+url2+account+url3+key+url4;
		dr.navigate().to(url);
		dr.findElement(By.className("fzz_btn")).click();
		Thread.sleep(1000);

		dr.quit();

	}
}
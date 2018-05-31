package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyDaBiao {

	public static void testPlan(int id,String account,String key) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://dev-test.irongbei.com/UserLogin/index");
//		ReadTxt rt = new ReadTxt();
//		String username = rt.readFS("D:\\users\\usertext1.txt", lineNo);
		dr.findElement(By.id("user_name")).sendKeys("17409090057");
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://dev-test.irongbei.com/UserCenter/index");
		Thread.sleep(1000);
		dr.findElement(By.linkText("我要出借")).click();
		dr.navigate().to("http://dev-test.irongbei.com/index/fplist");
		
		dr.findElement(By.className("current")).click();
		int myid2=id;
		dr.navigate().to("http://dev-test.irongbei.com/Index/fpdetail?id="+id);
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys(account);
		dr.findElement(By.id("investSubmit")).click();
		String url1="http://dev-test.irongbei.com/UserCenter/fpconfirm?program=";
		int  myid=id;
		String url2="&account=";
		String myaccount=account;
		String url3="&uvId=0&key=";
		String mykey=key;
		String url4="&isuse=0";
		String url=url1+myid+url2+myaccount+url3+mykey+url4;
		dr.navigate().to(url);
		dr.findElement(By.className("magBtn")).click();
		Thread.sleep(1000);

		dr.quit();

	}
}
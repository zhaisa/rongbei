package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class BuyZzs {
	@Test(invocationCount=20)
	public void buyZzs() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://dev-test.irongbei.com/UserLogin/index");
	dr.findElement(By.id("user_name")).clear();
	dr.findElement(By.id("user_name")).sendKeys("su03");
	dr.findElement(By.id("user_password")).clear();
	dr.findElement(By.id("user_password")).sendKeys("123456");
	dr.findElement(By.id("qianlogin")).click();
	Thread.sleep(1000);
	dr.navigate().to("http://dev-test.irongbei.com/UserCenter/index");
//	dr.findElement(By.linkText("我要出借")).click();
	Actions action=new Actions(dr);
	action.moveToElement(dr.findElement(By.id("ld_wycj_a")));
//	action.perform();

//	action.sendKeys(Keys.DOWN);
	action.sendKeys(Keys.ENTER);
	action.perform();
	
	//dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	dr.findElement(By.linkText("周周升")).click();
	dr.navigate().to("http://dev-test.irongbei.com/index/currentDetail");
	dr.findElement(By.id("invest_account")).sendKeys("1000");	
	dr.findElement(By.xpath("//*[@id=\"irb-content\"]/div/div/div[1]/div/div[2]/div/div[6]/div/img")).click();
	dr.findElement(By.id("investSubmit")).click();
	GetNextHandle gnh = new GetNextHandle();
	gnh.getNextHandle(dr);
	Thread.sleep(2000);
	dr.findElement(By.className("magBtn")).click();
	Thread.sleep(1000);
	
	
	dr.close();
	dr.quit();
	
	
	
	
	
	
	}
}
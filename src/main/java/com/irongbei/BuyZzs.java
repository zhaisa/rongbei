package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BuyZzs {
	public void buyZzs() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://testhf.irongbei.com/UserLogin/index");
	dr.findElement(By.id("user_name")).clear();
	dr.findElement(By.id("user_name")).sendKeys("17409040018");
	dr.findElement(By.id("user_password")).clear();
	dr.findElement(By.id("user_password")).sendKeys("123456");
	dr.findElement(By.id("qianlogin")).click();
	Thread.sleep(1000);
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
//	dr.findElement(By.linkText("我要出借")).click();
	Actions action=new Actions(dr);
	action.moveToElement(dr.findElement(By.id("ld_wycj_a")));
//	action.perform();

//	action.sendKeys(Keys.DOWN);
	action.sendKeys(Keys.ENTER);
	action.perform();
	
	//dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	dr.findElement(By.linkText("周周升")).click();
	dr.navigate().to("http://testhf.irongbei.com/index/currentDetail");
	dr.findElement(By.id("invest_account")).sendKeys("200");
	dr.findElement(By.id("investSubmit")).click();
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/currentConfirm?program=25&account=200&uvId=0&key=c05c2ca3a26677326107ac2ea5759869&isuse=0");
	dr.findElement(By.className("magBtn")).click();
	
	dr.close();
	dr.quit();
	
	
	
	
	
	
	}
}
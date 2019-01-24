package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BuyDaBiao {

	public static void testPlan(int id, String account, String value, String user) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/?version=2");
		dr.get("http://testhf.irongbei.com/UserLogin/index");
		// ReadTxt rt = new ReadTxt();
		// String username = rt.readFS("D:\\users\\usertext1.txt", lineNo);
		dr.findElement(By.id("user_name")).sendKeys(user);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
		Thread.sleep(1000);
		dr.findElement(By.linkText("我要出借")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/fplist");

		dr.findElement(By.className("current")).click();
		int myid2 = id;
		dr.navigate().to("http://testhf.irongbei.com/Index/fpdetail?id=" + id);
		Thread.sleep(1000);
		Select ss1 = new Select(dr.findElement(By.id("financial_plan")));
		ss1.selectByValue(value);
		Thread.sleep(1000);
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys(account);
		dr.findElement(By.xpath("//*[@id=\"irb-content\"]/div/div/div[1]/div/div[2]/div/div[7]/div/img")).click();
		dr.findElement(By.id("investSubmit")).click();
		Thread.sleep(3000);
//		ElementIsAppear eia = new ElementIsAppear();
//		boolean aa = eia.isContentAppeared(dr, "jiaxiquan");
//		if (aa == true) {
//			dr.findElement(By.linkText("暂不使用")).click();
//			dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//			GetNextHandle gnh = new GetNextHandle();
//			gnh.getNextHandle(dr);
//			Thread.sleep(2000);
//			dr.findElement(By.className("magBtn")).click();
//			Thread.sleep(1000);
//		}
//if(dr.findElement(By.id("jiaxiquan")).isDisplayed()) {
//	dr.findElement(By.linkText("暂不使用")).click();
			GetNextHandle gnh = new GetNextHandle();
			gnh.getNextHandle(dr);
			Thread.sleep(3000);
			dr.findElement(By.className("magBtn")).click();
			Thread.sleep(1000);
//}

		dr.close();
		dr.quit();
	}
}
package com.irongbei;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BuyZhiTou {

	@Test(dataProvider = "getdata",invocationCount=8,threadPoolSize=2)
	public void buyZhiTou(String user, String bmoney, int proid) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");
		dr.findElement(By.id("user_name")).clear();
		dr.findElement(By.id("user_name")).sendKeys(user);
		dr.findElement(By.id("user_password")).clear();
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
		dr.findElement(By.linkText("我要出借")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/fplist");
			Thread.sleep(1000);
		dr.findElement(By.linkText("项目直投")).click();
		dr.navigate().to("http://testhf.irongbei.com/Index/plist");
			Thread.sleep(1000);
		String hurl = "http://testhf.irongbei.com/index/pdetail?id=";
		int id = proid;
		String url = hurl + id;
		dr.navigate().to(url);
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).sendKeys(bmoney);
		Thread.sleep(1000);
		dr.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/div/div[2]/div/div[5]/div/img")).click();
		dr.findElement(By.id("investSubmit")).click();
		// dr.navigate().to("http://testhf.irongbei.com/UserCenter/confirm?program=9132&account=100&uvId=0&key=5715c1b1a1c2b3bd0b3529abb2b94921&isuse=0");
		GetNextHandle gnh = new GetNextHandle();
		gnh.getNextHandle(dr);
		Thread.sleep(1000);
		dr.findElement(By.className("magBtn")).click();
		Thread.sleep(1000);

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
			dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
			Thread.sleep(1000);
			dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
			Thread.sleep(3000);

		}
		dr.close();
		dr.quit();

	}

	@DataProvider(name = "getdata")
	public Object[][] getdata() {
		// String zq,String money,int mylength, int myyear, int mymonth, int myday
		Object[][] value = { { "17409040302","1000",15177} };
		return value;
	}
}

package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MrsChenProject {
	public void other() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		dr.get("https://mans.limayq.com/system/user/imgCode/generate.htm");
		dr.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "t");// 在同一浏览器上打开下面的链接
		// String aaa = "请输入验证码：";
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入验证码");
		if (scan.hasNext()) {
			String str1 = scan.next();
			System.out.println("输入的数据为：" + str1);
			dr.get("https://mans.limayq.com/system/user/login.htm?username=system&password=123456&imgcode=" + str1);
		}

		// current_time = time.strftime("%Y-%m-%d-%H_%M_%S",
		// time.localtime(time.time()));
		String currenttime = new SimpleDateFormat("yyyy-MM-dd-hh_mm_ss").format(cc.getTime());
		System.out.println(currenttime);
		dr.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "t");
		dr.get("https://mans.limayq.com/");

		Thread.sleep(2000);
		dr.navigate().to("https://mans.limayq.com/usermanage/userinfo-list");
		Thread.sleep(2000);
		WebElement we = dr.findElement(By.className("ant-select-selection__placeholder"));

		Actions action = new Actions(dr);
		action.moveToElement(we).click();
		action.moveToElement(we).perform();
		// dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);	
		action.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		action.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER);
		action.perform();

	}

}

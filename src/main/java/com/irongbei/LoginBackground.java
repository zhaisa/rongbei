package com.irongbei;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBackground {

	public static void loginBackground() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		// Calendar c = new GregorianCalendar();
		// c.set(myyear, mymonth, myday);
		dr.get("https://www.baidu.com");
		dr.manage().window().maximize();
		GetCookies gc = new GetCookies();
		try {
			gc.getCookies(dr);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AddCookie ac = new AddCookie();
		ac.addCookie(dr);
		
		

		Thread.sleep(1000);

	}
}

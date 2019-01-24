package com.irongbei;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateDriver {
	public static WebDriver getDriver(String type) {
		return createDriver(type, null);
	}

	public static WebDriver getDriver(String type, Object parameter) {
		return createDriver(type, parameter);
	}
	private static WebDriver createDriver(String type, Object parameter) {
		WebDriver driver = null;
		if(type.toLowerCase()=="chrome") {
	
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			driver = createChromeDriver(parameter);
	
		}

		return driver;
	}
	private static WebDriver createChromeDriver(Object parameter) {
		WebDriver driver = null;
		if (parameter == null) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver((ChromeOptions) parameter);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 这行是让本driver的每个页面都加超时等待（页面加载最长等30秒，超30秒才报错）
		return driver;
	}

}

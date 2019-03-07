package com.rongbei.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NoGuiDriver {
	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// chromederiver存放位置
		System.setProperty("webdriver.chrome.bin", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");// chrome安装位置
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");// 无界面参数
		options.addArguments("no-sandbox");// 禁用沙盒 就是被这个参数搞了一天
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}

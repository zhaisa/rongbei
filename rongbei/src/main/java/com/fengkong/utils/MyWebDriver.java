package com.fengkong.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
private WebDriver driver;
public WebDriver getDr() {
	return driver;
}

public void setDr(WebDriver dr) {
	this.driver = dr;
}
public  void creatChromeDriver() {
	WebDriver driver = null;
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
	

	
}


}

package com.fengkong.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
private WebDriver dr;

public MyWebDriver(WebDriver dr) {
	super();
	this.dr = dr;
	
}

public MyWebDriver() {
	super();
	// TODO Auto-generated constructor stub
}

public WebDriver getDr() {
	return dr;
}

public void setDr(WebDriver dr) {
	this.dr = dr;
}



}

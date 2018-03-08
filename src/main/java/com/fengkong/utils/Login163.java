package com.fengkong.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login163 {
	public static void main(String[] args) {
		login163();
	}
public static void login163() {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://www.163.com");
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	dr.switchTo().defaultContent();
//	String loginon="$(#)"
	String loginclick ="$('.ntes-nav-login-title').click()";
	((JavascriptExecutor) dr).executeScript(loginclick);
//	dr.findElement(By.xpath("//*[@id=\"js_N_navHighlight\"]/a")).click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
//	dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//	dr.switchTo().frame("js_N_login_wrap");
	dr.switchTo().frame("x-URS-iframe1520406217366.834");
	dr.findElement(By.name("email")).clear();
	dr.findElement(By.name("email")).sendKeys("zhaisa21@163.com");
	
	dr.findElement(By.name("password")).clear();
	dr.findElement(By.name("password")).sendKeys("182049");
	dr.findElement(By.id("dologin")).click();
}
}

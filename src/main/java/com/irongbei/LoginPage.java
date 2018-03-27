package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebDriver dr;
WebElement username;
WebElement password;
WebElement loginclick;
public LoginPage(WebDriver dr) {
	super();
	this.dr = dr;
	username= dr.findElement(By.name("username"));
	password=dr.findElement(By.name("password"));
	loginclick=dr.findElement(By.className("login-btn"));

}
public void login(String username1,String password1) {
	username.sendKeys(username1);
	password.sendKeys(password1);
	loginclick.click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	WebElement element3 = dr.findElement(By.xpath(".//*[@id='right-box']/p"));
	String obj1 = element3.getText().trim();
	System.out.println(obj1);
	String obj = "欢迎登录融贝网管理后台";
	if (obj1.contains(obj)) {
		System.out.println("sucess!");
	} else {
		System.out.println("登录失败 " + "");
	}
	System.out.println("Page title is: " + dr.getTitle());
}



}
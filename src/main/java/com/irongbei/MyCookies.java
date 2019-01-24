package com.irongbei;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;



public class MyCookies {

	public static void addCookie(WebDriver driver,String username,String user_id,String cake,String csrf) {
		Cookie cookie_username = new Cookie("user_name", username);
		Cookie cookie_password = new Cookie("PHPSESSID", cake);
		Cookie cookie_userid = new Cookie("user_id", user_id);
		Cookie cookie_csrf = new Cookie("_csrf", csrf);
		driver.manage().addCookie(cookie_username);// 动态加载了这些cookie后，就能实现了自动登录的功能
		driver.manage().addCookie(cookie_password);
		driver.manage().addCookie(cookie_userid);		
		driver.manage().addCookie(cookie_csrf);
		driver.get("http://alpha_backend.api.irongbei.com/");
		System.out.println(driver.manage().getCookies());
	}

}

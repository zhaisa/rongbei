package com.irongbei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class AddCookie {
	WebDriver dr;
	
public WebDriver getDr() {
		return dr;
	}

	public void setDr(WebDriver dr) {
		this.dr = dr;
	}

public void addCookie(WebDriver dr) throws Exception {
	File file = new File("E:\\2.txt");
	FileReader fr = new FileReader(file);
	BufferedReader br = new BufferedReader(fr);
	String line;

	while ((line = br.readLine()) != null) {
		String[] arr = line.split(";");
		String name = "", value = "", domain = "", path = "";
		Date expiry = null;
		boolean isSecure = false;
		for (int i = 0; i < arr.length; i++) {
			name = arr[0];
			value = arr[1];
			domain = arr[2];
			path = arr[3];
			expiry = arr[4] != "null" ? new Date(arr[4]) : null;
			isSecure = Boolean.parseBoolean(arr[5]);
		}
		System.out.println(name +":"+ value + "/n" + domain + "/n" + path + "/n" + expiry + "/n" + isSecure);
		Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
		dr.manage().addCookie(cookie);

	}
	
}
}

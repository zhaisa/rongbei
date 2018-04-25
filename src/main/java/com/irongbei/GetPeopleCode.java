package com.irongbei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPeopleCode {
public void getCode() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	dr.get("http://www.95nw.com/daquan/");
	WebElement tbody = dr.findElement(By.xpath("//table/tbody"));
	List<WebElement> tr = tbody.findElements(By.tagName("tr"));
	Map<String, String> map = new HashMap();
	List<WebElement> listman=new ArrayList<WebElement>();
	List<WebElement> listwoman=new ArrayList<WebElement>();
	for (int q=0;q<tr.size();q++) {
		String trtext = tr.get(q).getText();
		List<WebElement> td = tr.get(q).findElements(By.tagName("td"));
		for (int z=0;z<td.size();z++) {
			String tdtext = td.get(z).getText();
		      
			listman.add(td.get(0));
			listwoman.add(td.get(1));

			
		}
	}
	for(int w=0;w<listman.size();w++) {}
	for(int i=0;i<listman.size();i++) {
		System.out.println("男性18岁以上真实身份证有："+listman.get(i).getText());
	}
	for(int j=0;j<listwoman.size();j++) {
		System.out.println("女性18岁以上真实身份证有："+listwoman.get(j).getText());
	}
	System.out.println("男性18岁以上真实身份证有："+listman.size()+"行");
	System.out.println("女性18岁以上真实身份证有："+listwoman.size()+"行");
}
}

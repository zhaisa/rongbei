package com.irongbei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetBankCode {
public void getCode() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	dr.get("http://jsrun.net/app/sfz");
	Thread.sleep(2000);
	dr.switchTo().frame(dr.findElement(By.xpath("//*[@id=\"result\"]/iframe")));
	Thread.sleep(2000);
	WebElement tbody = dr.findElement(By.xpath("//*[@id=\"list\"]/table/tbody"));
	List<WebElement> tr = tbody.findElements(By.tagName("tr"));
	Map<String, String> map = new HashMap();
	List<WebElement> listman=new ArrayList<WebElement>();
	for (int q=0;q<tr.size();q++) {
		String trtext = tr.get(q).getText();
		List<WebElement> td = tr.get(q).findElements(By.tagName("td"));
		for (int z=0;z<td.size();z++) {
			String tdtext = td.get(z).getText();
		 System.out.println(tdtext);

			
		}
	}
	
	
}
}

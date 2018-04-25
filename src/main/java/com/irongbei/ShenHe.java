package com.irongbei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.irongbeipages.LoginPage;

public class ShenHe {
public void shenHe() {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	dr.get("http://rongbeiadmin.51dmoz.com/admin/login");
	LoginPage lp = new LoginPage(dr);
	lp.login("测试专用管理员", "123456");
	dr.findElement(By.linkText("项目管理")).click();
	dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	dr.findElement(By.partialLinkText("项目列表")).click();
	dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Project/index");
	WebElement we=dr.findElement(By.xpath("table/tbody"));
	Map<String,String> map =new HashMap();
	List<WebElement> list=we.findElements(By.tagName("tr"));
	for(int i=0;i<list.size();i++) {
		String trtext=list.get(i).getText();
		List<WebElement> listtd=list.get(i).findElements(By.tagName("td"));
		
		
		
	}
	
	
}
}

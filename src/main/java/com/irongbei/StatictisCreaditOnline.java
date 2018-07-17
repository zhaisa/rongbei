package com.irongbei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StatictisCreaditOnline {
	
	public static void main(String[] args) {
		try {
			getMoney();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void getMoney() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.irongbei.com/Index/currentDetail?id=38");
		dr.findElement(By.partialLinkText("加入情况")).click();
		WebElement we= dr.findElement(By.xpath("//*[@id=\"i_pageHtml\"]/div/ul"));
		List<WebElement> list1=we.findElements(By.tagName("li"));
		for(int i=0;i<list1.size();i++) {
			System.out.println(list1.get(i).getText());
		}
		String pagenumber=(list1.get(list1.size()-1).getText()).substring(1, 2);
		System.out.println(pagenumber);
	//获取每页的金额数据
		WebElement we2=dr.findElement(By.id("invest_newList"));
		Map<String,String> map=new HashMap();
		List<WebElement> list2=we2.findElements(By.tagName("li"));
		for(int j=0;j<list2.size();j++) {
		//	System.out.println(list2.get(j).getText());
		  List<WebElement> rows=list2.get(j).findElements(By.tagName("span"));
		  for(int z=0;z<rows.size();z++) {
			 
			  map.put("成交时间", rows.get(0).getText());
			  map.put("出借人", rows.get(1).getText());
			  map.put("加入金额", rows.get(2).getText());
			  
			  
		  }
		  System.out.println(map.get("加入金额")); 
		}
		
		
		
		
		
		
		
		
}
}
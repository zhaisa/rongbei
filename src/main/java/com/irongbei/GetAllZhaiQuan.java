package com.irongbei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllZhaiQuan {
	public void getAllZhaiQuan() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");
		dr.findElement(By.id("user_name")).sendKeys("17409090044");
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.get("http://testhf.irongbei.com/Index/fpdetail?id=76");
		dr.findElement(By.linkText("债权组成")).click();
		WebElement we = dr.findElement(By.xpath("//table/tbody"));
		List<WebElement> tr = we.findElements(By.tagName("tr"));
		Map<String, String> map = new HashMap();
		List<String> list1 = new ArrayList();
		List<String> list2 = new ArrayList();
		List<String> list3 = new ArrayList();
		for (int i = 0; i < tr.size(); i++) {
			String trtext = tr.get(i).getText();
			List<WebElement> td = tr.get(i).findElements(By.tagName("td"));
			for (int z = 0; z < td.size(); z++) {
				map.put("项目编号", td.get(0).getText());
				map.put("项目名称", td.get(1).getText());
				map.put("借款金额(元）", td.get(4).getText());
				map.put("期限（天）", td.get(5).getText());

			}
			String pro = map.get("项目名称");
			list1.add(pro);
			String mon = map.get("借款金额(元）");
			list2.add(mon);
			String day = map.get("期限（天）");
			list3.add(day);
		}
		List all = new LinkedList();
		all.add(list1);
		all.add(list2);
		all.add(list3);
		for (int j = 0; j < all.size(); j++) {
			System.out.println("第一页的债权数为："+all.get(j));
		}
	List<WebElement> list=dr.findElement(By.xpath("//div/ul")).findElements(By.tagName("li"));
	for(int i=0;i<list.size();i++) {
		System.out.println(list.size());
		
	}

	}
}

package com.rongbei.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.irongbei.CreateDriver;

import KaiHu.KaiHuTest;

public class GetTableContent {
public Object[][] getdata(){
	Logger logger = Logger.getLogger(KaiHuTest.class);
	BasicConfigurator.configure();
	logger.setLevel(Level.INFO);
	WebDriver dr=CreateDriver.getDriver("chrome");
	WebElement eee = dr.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/div[2]/div/ul"));
	//html/body/div[1]/div[3]/div[1]/div/div[1]/div[2]/div/ul
	// 有多少列
	List<WebElement> li = eee.findElements(By.tagName("li"));
	List<String> list1=new ArrayList();
	ArrayList<String> arrkey = new ArrayList<String>();
	HashMap<String, String>[][] map = new HashMap[li.size() - 1][1];
	if (li.size() > 1) {

		for (int i = 0; i < li.size() - 1; i++) {
			map[i][0] = new HashMap();
		}
	} else {
		logger.error("列表中没有数据");
	}
	 for (int c = 0; c < li.size(); c++) {
		 @SuppressWarnings("unchecked")
		ArrayList<WebElement> row = (ArrayList<WebElement>) li.get(c).findElement(By.tagName("span"));
		 for (int j = 0; j < row.size(); j++) {
			 @SuppressWarnings("unchecked")
			ArrayList<WebElement> td=(ArrayList<WebElement>) row.get(j).findElement(By.tagName("span"));
			 if(c==0) {
            String cellvalue =td.get(j).getText();
            arrkey.add(cellvalue);
        }
	 }}
	for (int c = 0; c < li.size(); c++) {
		String trtext = li.get(c).getText();
		List<WebElement> td = li.get(c).findElements(By.tagName("span"));
		for (int j = 0; j < td.size(); j++) {
			String tdtext = td.get(j).getText();
			map[c - 1][0].put(arrkey.get(j), tdtext);
					
			}

		}
	
	return map;

	}
	

	
}


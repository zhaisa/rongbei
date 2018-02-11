package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XiaoFeiDaiShenHe {
	public void luRu() {
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		 WebDriver dr= new ChromeDriver();
		 Calendar cc=new GregorianCalendar();
			String time=new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
	     dr.get("http://test-management.irongbei.com"); 
	     try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
        dr.findElement(By.id("username")).clear();
        dr.findElement(By.id("username")).sendKeys("hontest");
        dr.findElement(By.id("password")).clear();
        dr.findElement(By.id("password")).sendKeys("123456");
        dr.findElement(By.id("login")).click();
        dr.navigate().to("http://test-management.irongbei.com/index/main.html");
        
        dr.switchTo().frame("leftmenu");
		 dr.findElement(By.cssSelector("dt")).click();
        
        dr.navigate().to("http://test-management.irongbei.com/honloan/index.html");
        
         try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        dr.findElement(By.xpath("//a[@href=/honloan/add.html?id=30&pro=1099\"]")).click();
        
        dr.navigate().to("http://test-management.irongbei.com/honloan/add.html?id=30&pro=1099");
        dr.findElement(By.xpath("//a[@href=\"/honloan/results.html?loanid=30&carloanid=24&hzcooperid=3\"]")).click();
        
        dr.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[1]/td[2]/div/label[1]/input")).click();
        dr.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[2]/td[2]/div/label[2]/input")).click();
        dr.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[3]/td[2]/div/label[1]/input")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        dr.findElement(By.xpath("")).click();
        
        
        
        
        
        
        
        
        
        
        
}
}
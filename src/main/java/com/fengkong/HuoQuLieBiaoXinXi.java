package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HuoQuLieBiaoXinXi {
	public void shenHe() {
		
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
       dr.findElement(By.id("username")).sendKeys("hontest2");
       dr.findElement(By.id("password")).clear();
       dr.findElement(By.id("password")).sendKeys("123456");
       dr.findElement(By.id("login")).click();
       dr.navigate().to("http://test-management.irongbei.com/index/main.html");
       dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       dr.switchTo().frame("leftmenu");
		 dr.findElement(By.cssSelector("dt")).click();
       
       dr.navigate().to("http://test-management.irongbei.com/honloan/index.html");
       dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       
       List<WebElement> trlist=dr.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/dl/dd/div/table/tbody/tr"));  
       List<String> url1=new ArrayList<String>();
       for(int r=0;r<trlist.size();r++){  
           String trText=trlist.get(r).getText();  
         
           if(trText.contains("牧云")) {  
        	   String[] myname=trText.split(" ");
               String myname1=myname[1];
            url1.add(myname1);
           
    
           }  
           System.out.println(url1.get(r));
       }  
      
     
       
     
       dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       dr.close();
       dr.quit();
	}}

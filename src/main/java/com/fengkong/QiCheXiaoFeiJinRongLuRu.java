package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QiCheXiaoFeiJinRongLuRu {
	public void luRu(){
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		 WebDriver dr= new ChromeDriver();
		 Calendar cc=new GregorianCalendar();
			String time=new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
	     dr.get("http://test-risk.irongbei.com/"); 
	     try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
       dr.findElement(By.id("username")).clear();
       dr.findElement(By.id("username")).sendKeys("yctest");
       dr.findElement(By.id("password")).clear();
       dr.findElement(By.id("password")).sendKeys("123456");
       dr.findElement(By.id("login")).click();
       dr.navigate().to("http://test-risk.irongbei.com/lonloan/add.html");
       try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       dr.findElement(By.name("name")).sendKeys("牧云"+time);
       dr.findElement(By.name("idcard")).sendKeys("110221198001019390");
       dr.findElement(By.name("phone")).sendKeys("17409090010");
       dr.findElement(By.name("age")).sendKeys("24");
       dr.findElement(By.name("hunyin1")).click();
       Select s1=new Select(dr.findElement(By.name("hunyin1")));
       
       s1.selectByValue("未婚");
       
       dr.findElement(By.name("stand1")).click();
       Select s2=new Select(dr.findElement(By.name("stand1")));
       
       s2.selectByValue("博士");
       
       dr.findElement(By.id("province")).click();
		 Select s3=new Select(dr.findElement(By.id("province")));
		 s3.selectByValue("110000");
		 dr.findElement(By.id("city")).click();
			Select city=new Select(dr.findElement(By.id("city")));
			city.selectByValue("110100");
			dr.findElement(By.id("area")).click();
			Select area=new Select(dr.findElement(By.id("area")));
			area.selectByValue("110111");	
       dr.findElement(By.name("beixzhu2")).sendKeys("无业流民街");
       
       dr.findElement(By.name("gzdwe1")).sendKeys("云车有限公司");
       dr.findElement(By.name("gzszw2")).sendKeys("高级工程师");
       
       dr.findElement(By.name("dabtabd")).click();
       Select s4=new Select(dr.findElement(By.name("dabtabd")));
       
       s2.selectByValue("9、信息传输、软件和信息技术服务业");
       dr.findElement(By.name("zname")).sendKeys("娟娟");
       dr.findElement(By.name("zname1")).sendKeys("萌萌");
       dr.findElement(By.name("zwokes32name")).sendKeys("姐姐");
       dr.findElement(By.name("zwokesd332name")).sendKeys("妹妹");
       dr.findElement(By.name("teach")).sendKeys("010-89789878");
       dr.findElement(By.name("teach1")).sendKeys("010-89789879");
       dr.findElement(By.name("ppxih3")).sendKeys("奥迪A7");
       dr.findElement(By.name("carxin3")).sendKeys("A7-001");
       dr.findElement(By.name("colorled2")).sendKeys("yellow");
       dr.findElement(By.name("carjia3")).sendKeys("AXSJHJD-001");
       dr.findElement(By.name("fdrtew3")).sendKeys("15马力选螺旋");
       dr.findElement(By.name("datrre3")).sendKeys(time);
       dr.findElement(By.name("amountd")).sendKeys("80万");
       dr.findElement(By.name("termd")).sendKeys("24");
       dr.findElement(By.name("dabtabd")).click();
       
  Select s5=new Select(dr.findElement(By.name("dabtabd")));
       
       s2.selectByValue("保留车辆所有权");
       
       dr.findElement(By.name("savetype")).click();
		
		
		
		dr.close();
		dr.quit();
	 
	 
       
       
       
       
       
       
       
       
}
}
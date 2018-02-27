package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FangDiDaiLuRu {
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
        dr.findElement(By.id("username")).sendKeys("hometest");
        dr.findElement(By.id("password")).clear();
        dr.findElement(By.id("password")).sendKeys("123456");
        dr.findElement(By.id("login")).click();
        try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
		 dr.navigate().to("http://test-risk.irongbei.com//homeloan/add.html");
	   dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 dr.findElement(By.name("amountd")).sendKeys("100万");
		 dr.findElement(By.name("termd")).sendKeys("24");
		 dr.findElement(By.name("fkzyll")).sendKeys("18%");
		 dr.findElement(By.name("source")).sendKeys("牧云小小"+time);
		 dr.findElement(By.id("province")).click();
		 Select s1=new Select(dr.findElement(By.id("province")));
		 s1.selectByValue("110000");
		 try {
		 		Thread.sleep(2000);
		 	} catch (InterruptedException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
		 dr.findElement(By.id("city")).click();
			Select city=new Select(dr.findElement(By.id("city")));
			city.selectByValue("110100");
			try {
		 		Thread.sleep(2000);
		 	} catch (InterruptedException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
			dr.findElement(By.id("area")).click();
			Select area=new Select(dr.findElement(By.id("area")));
			area.selectByValue("110111");	
		 dr.findElement(By.name("usaged")).sendKeys("资金周转");
		 dr.findElement(By.name("hkly")).sendKeys("抵押还款");
		 dr.findElement(By.name("Subsector")).click();
		 Select ss=new Select(dr.findElement(By.name("Subsector")));
		 
		 ss.selectByValue("15、居民服务、修理和其他服务业");
		 
		 dr.findElement(By.name("name")).sendKeys("牧云"+time);
		 dr.findElement(By.name("idcard")).sendKeys("110221198001019411");
		 dr.findElement(By.name("hunyin")).click();
		 Select s2=new Select(dr.findElement(By.name("hunyin")));
		 s2.selectByValue("未婚");
		 
		 dr.findElement(By.name("loantype")).click();
		 Select s3=new Select(dr.findElement(By.name("loantype")));
		 s3.selectByValue("企业贷");
		 dr.findElement(By.name("iphone")).sendKeys("17409090094");
		 
		 dr.findElement(By.name("corporatename")).sendKeys("融泰浩元有限公司");
		 dr.findElement(By.name("bossname")).sendKeys("吴晓晖、司书甲、陈晨");
		 dr.findElement(By.name("registeredcapital")).sendKeys("2亿");
		 dr.findElement(By.name("registeredarea")).sendKeys("朝阳门SOHO");
		 
		 dr.findElement(By.name("gjrname")).sendKeys("无");
		 dr.findElement(By.name("fqzh")).sendKeys("FCZ2018022008908X");
		 dr.findElement(By.name("fcxx")).sendKeys("92年老房子");
		 dr.findElement(By.name("fwmj")).sendKeys("180m2");
		 dr.findElement(By.name("lfjs")).sendKeys("三室两厅");
		 dr.findElement(By.name("fwsymj")).sendKeys("160m2");
		 dr.findElement(By.name("lflx")).sendKeys("独幢别墅");
		 dr.findElement(By.name("lcgd")).sendKeys("160m");
		 
		 dr.findElement(By.name("zcgd")).sendKeys("16层");
		 dr.findElement(By.name("fwjznd")).sendKeys("90年代");
		 
		 dr.findElement(By.name("zjpg")).sendKeys("1600万");
		 dr.findElement(By.name("dycshgc")).click();
		 Select s4=new Select(dr.findElement(By.name("dycshgc")));
		 s4.selectByValue("二抵");
		 dr.findElement(By.name("dyje")).sendKeys("1200万");
		 
		 dr.findElement(By.name("savetype")).click();
			
			
			
			dr.close();
			dr.quit();
		 
		 
		 
		 
		 
		 
		 
}
}
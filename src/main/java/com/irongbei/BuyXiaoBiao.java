package com.irongbei;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyXiaoBiao {
	 public  void testPlan(int lineNo) throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//这一步必不可少  
			 WebDriver dr= new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index"); 
		
		 
//	    File file = new File("D:/users/user.txt");
//        String s = null;
//        try {
//            s = FileHandler.readAsString(file);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//   
		ReadTxt rt=new ReadTxt();
		String a=rt.readFS("D:/users/usertext1.txt", lineNo);
		 
		dr.findElement(By.id("user_name")).sendKeys(a);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
		dr.findElement(By.xpath("//*[@id=\"irb-header\"]/div[2]/div/div[2]/ul/li[2]/a")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/fplist");
		dr.findElement(By.linkText("直投项目")).click();
		dr.navigate().to("http://testhf.irongbei.com/Index/plist");
//		Select sl=new Select(dr.findElement(By.className("filter-condition")));
//		sl.selectByVisibleText("投标中");
		dr.findElement(By.xpath("//*[@id=\"statuschoose\"]/li[3]")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/plist?type=0&status=1&income=0&cycle=0&condition=close&payment=0");
		dr.findElement(By.linkText("测试小标底层（新手）-翟0318")).click();
		dr.findElement(By.linkText("立即出借")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/pdetail?id=7532");
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys("1000");
		dr.findElement(By.id("investSubmit")).click();
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/confirm?program=7532&account=1000&uvId=0&key=1b812458c6f75577f99a9e211854587a");
		dr.findElement(By.className("fzz_btn")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		
		  String currentWindow = dr.getWindowHandle();  
	        //得到所有窗口的句柄  
	        Set<String> handles = dr.getWindowHandles();  
	        Iterator<String> it = handles.iterator();  
	        while(it.hasNext()){  
	            String handle = it.next();  
	            if(currentWindow.equals(handle)) continue;  
	            WebDriver   window = dr.switchTo().window(handle);  
	            System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());  
	          String sss=window.getCurrentUrl();
             dr.navigate().to(sss);
	

		dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("123456");
		dr.findElement(By.id("sub")).click();
		Thread.sleep(3000);
	 }
		dr.quit();
		
		
}
	
}
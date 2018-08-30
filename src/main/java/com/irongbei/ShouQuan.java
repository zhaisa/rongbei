package com.irongbei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShouQuan {
	
public void shouQuan(String phone) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
	dr.get("http://testhf.irongbei.com/UserLogin/index");
	dr.findElement(By.id("user_name")).sendKeys(phone);
	dr.findElement(By.id("user_password")).sendKeys("123456");
	dr.findElement(By.id("qianlogin")).click();
	Thread.sleep(1000);
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
//	dr.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div/div[1]/div[2]/ul/li[5]/dt/a")).click();
	dr.navigate().to("http://testhf.irongbei.com/UserCenter/autoauth");
	dr.findElement(By.linkText("开通自动投标授权")).click();
	dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//	 System.out.println("请输入验证码：");
//	    Scanner scan=new Scanner(System.in);
//	    if (scan.hasNext()) {
//	    	
//			String str1 = scan.next();
//			System.out.println("输入的数据为：" + str1);
//}	
	    dr.findElement(By.id("captchapic")).sendKeys("vfgh");
	    Thread.sleep(3000);
	    dr.findElement(By.id("resend")).click();
	    Thread.sleep(1000);
	    dr.findElement(By.id("phoneCode")).sendKeys("111111");
	    dr.findElement(By.linkText("去开通")).click();
	    String currentWindow = dr.getWindowHandle();
	    Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = dr.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
			String sss = window.getCurrentUrl();
			dr.navigate().to(sss);}
	        Thread.sleep(1000);
			dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
			dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
			dr.findElement(By.id("sub")).click();
			Thread.sleep(4000);
			dr.navigate().to("http://testhf.irongbei.com/JxAuthorization/jxAutoAssignAuthBackstagePlus");
			dr.findElement(By.linkText("立即关闭")).click();
			Thread.sleep(1000);
			dr.navigate().to("http://testhf.irongbei.com/UserCenter/autoauth");
			dr.findElement(By.linkText("开通自动债转授权")).click();
//			 System.out.println("请输入验证码：");
//			    Scanner scan1=new Scanner(System.in);
//			    if (scan1.hasNext()) {
//			    	
//					String str2 = scan1.next();
//					System.out.println("输入的数据为：" + str2);
//				}	
			    dr.findElement(By.id("captchapic")).sendKeys("qwer");
			    Thread.sleep(3000);
			    dr.findElement(By.id("resend")).click();
			    Thread.sleep(1000);
			    dr.findElement(By.id("phoneCode")).sendKeys("111111");
			    dr.findElement(By.linkText("去开通")).click();
			    String currentWindow1 = dr.getWindowHandle();
			    Set<String> handles1 = dr.getWindowHandles();
				Iterator<String> it1= handles.iterator();
				while (it1.hasNext()) {
					String handle1 = it1.next();
					if (currentWindow1.equals(handle1))
						continue;
					WebDriver window1 = dr.switchTo().window(handle1);
					System.out.println("title,url = " + window1.getTitle() + "," + window1.getCurrentUrl());
					String sss1 = window1.getCurrentUrl();
					dr.navigate().to(sss1);}
			        Thread.sleep(1000);
					dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
					dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
					dr.findElement(By.id("sub")).click();
					Thread.sleep(3000);
					dr.navigate().to("http://testhf.irongbei.com/JxAuthorization/jxAutoAssignAuthBackstagePlus");
					dr.findElement(By.linkText("立即关闭")).click();
					Thread.sleep(1000);
					dr.navigate().to("http://testhf.irongbei.com/UserCenter/autoauth");
					dr.findElement(By.linkText("开通自动缴费授权")).click();
					   String currentWindow2 = dr.getWindowHandle();
					    Set<String> handles2 = dr.getWindowHandles();
						Iterator<String> it2 = handles.iterator();
						while (it2.hasNext()) {
							String handle2 = it2.next();
							if (currentWindow.equals(handle2))
								continue;
							WebDriver window2= dr.switchTo().window(handle2);
							System.out.println("title,url = " + window2.getTitle() + "," + window2.getCurrentUrl());
							String sss2 = window2.getCurrentUrl();
							dr.navigate().to(sss2);}
					        Thread.sleep(1000);
							dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
							dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
							dr.findElement(By.id("sub")).click();
							Thread.sleep(3000);
							dr.navigate().to("http://testhf.irongbei.com/JxAuthorization/jxAutoAssignAuthBackstagePlus");
							dr.findElement(By.linkText("立即关闭")).click();
							Thread.sleep(1000);
							dr.navigate().to("http://testhf.irongbei.com/UserCenter/autoauth");
							if(dr.findElement(By.linkText("已开通自动缴费授权")).isDisplayed()) {
								System.out.println(phone+":全部授权成功");
							}
							
						


dr.close();
dr.quit();

}}
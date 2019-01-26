package com.irongbei;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.irongbeipages.LoginPage;
import com.irongbeipages.ZhiTouPage;

public class NewCreateZhiTou {
	@Test
	public void createZhiTou() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");
		LoginPage lp = new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		dr.findElement(By.linkText("项目管理")).click();
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		dr.findElement(By.linkText("添加项目")).click();
		dr.findElement(By.id("project_type_pop")).findElement(By.id("Check2")).click();
		Thread.sleep(1000); // 停止1秒钟
		dr.findElement(By.id("project_type_pop")).findElement(By.id("pro_bottom_confirm")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Project/create");
		dr.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS );
		ZhiTouPage ztp=new ZhiTouPage(dr);
		ztp.addZhiTou();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

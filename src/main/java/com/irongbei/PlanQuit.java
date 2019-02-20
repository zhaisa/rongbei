package com.irongbei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import KaiHu.KaiHuTest;

public class PlanQuit {
	@Parameters({ "", "" })
	@Test
	public void planQuit(String user) throws InterruptedException {
		Logger logger = Logger.getLogger(KaiHuTest.class);
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
		CreateDriver cd = new CreateDriver();
		WebDriver dr = cd.getDriver("chrome");
		dr.get("http://testhf.irongbei.com/UserLogin/index");
		dr.findElement(By.id("user_name")).sendKeys(user);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.findElement(By.linkText("省心投")).click();
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/newfinplann?status=1&start=&end=&page=1");
		// dr.findElement(By.cssSelector("ul"));

		
		
		
		
		
	}	

	}

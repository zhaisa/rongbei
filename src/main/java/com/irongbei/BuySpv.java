package com.irongbei;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BuySpv {
	@Test(invocationCount =1)
	public void buySpv() throws InterruptedException {
		CreateDriver cd = new CreateDriver();
		WebDriver dr = CreateDriver.getDriver("chrome");
		String url = "http://irongbei20160107adrb.irongbei.com";
		Thread.sleep(1000);
		dr.get(url);
		
		// dr.get(url+"/admin/login");

		dr.manage().window().maximize();

		WebElement element = dr.findElement(By.name("username"));

		element.sendKeys("超级管理员_cxp");
		WebElement element1 = dr.findElement(By.name("password"));
		element1.sendKeys("chenxp123irb321_rb_dl_new");
		WebElement element2 = dr.findElement(By.className("login-btn"));
		element2.click();

		Thread.sleep(2000);
		dr.navigate().to(url + "/admin/Index/index");
		dr.findElement(By.linkText("省心投管理")).click();
		// dr.navigate().to(dr.findElement(By.linkText("省心投管理")).getAttribute("href"));
		Thread.sleep(300);
		dr.findElement(By.partialLinkText("债权列表")).click();
		dr.navigate().to(dr.findElement(By.linkText("债权列表")).getAttribute("href"));
		Thread.sleep(2000);
		Select ss1 = new Select(dr.findElement(By.name("matching_status")));
		ss1.selectByVisibleText("未开始匹配");
		Select ss2 = new Select(dr.findElement(By.name("is_push")));
		ss2.selectByVisibleText("否");
		Select ss3 = new Select(dr.findElement(By.name("is_user_quit")));
		ss3.selectByVisibleText("正常退出债转项目(大标)");
		dr.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div/p[4]/a")).click();
		Thread.sleep(2000);
		String pages = dr.findElement(By.id("total_page")).getText();
		System.out.println(pages);
		int allpage = Integer.parseInt(pages);

		List<String> list2 = new ArrayList<String>();
		
		for(int i=1;i<=allpage;i++) {
			String url22 = "/admin/FinancialPlan/financialClaimsPool?project_name=&plan_name=&start_time=&end_time=&matching_status=1&is_credit_end=1&creditor_type=0&username=&is_user_quit=0&hk_start_time=&hk_end_time=&is_lock=-1&short_name=0&project_ex_type=0&is_push=1&real_payment=0&page="
					+ 1 + "&page_size=30";
			String endurl=url+url22;
			list2.add(endurl);}
		
			// http://irongbei20160107adrb.irongbei.com/admin/FinancialPlan/financialClaimsPool?project_name=&plan_name=&start_time=&end_time=&matching_status=1&is_credit_end=1&creditor_type=0&username=&is_user_quit=0&hk_start_time=&hk_end_time=&is_lock=-1&short_name=0&project_ex_type=0&is_push=1&real_payment=0&page=2&page_size=30
			System.out.println(list2.size());
			
			for(int j=1;j<list2.size();j++) {
				dr.findElement(By.tagName("body")).sendKeys(Keys.COMMAND + "t");
				dr.get(list2.get(j));
				Thread.sleep(3000);
				dr.findElement(By.id("allChecked")).click();
				Thread.sleep(500);
				dr.findElement(By.linkText("批量购买")).click();
				Thread.sleep(500);
		//		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				dr.switchTo().alert().accept();
				Thread.sleep(1000);
			
				
			}
			
			
		
			
		
		dr.quit();
		dr.close();
	}
}

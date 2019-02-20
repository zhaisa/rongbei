package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreatNewDaBiaoPlanforTestNG {
	@Parameters({"year","month","date"})
//	 @Test(dataProvider="mydata1")
	@Test
	  public void createPlan(int myyear, int mymonth, int myday) throws InterruptedException {
		  WebDriver dr = CreateDriver.getDriver("chrome");
			dr.get("http://dev-admin.irongbei.com");
			dr.findElement(By.name("username")).sendKeys("测试专用管理员");
			dr.findElement(By.name("password")).sendKeys("123456");
			dr.findElement(By.linkText("登录")).click();
			Thread.sleep(3000);

			dr.get("http://dev_backend.api.irongbei.com");
			Calendar c = new GregorianCalendar();
			c.set(myyear, mymonth, myday);
			dr.findElement(By.linkText("省心投")).click();
			Thread.sleep(1000);
			dr.findElement(By.linkText("添加计划")).click();
			dr.navigate().to("http://dev_backend.api.irongbei.com/financialplan/create");
			String userunder = new SimpleDateFormat("yyMMddhhmmss").format(c.getTime());
			String name = "测试省心投计划-翟" + userunder;
			dr.findElement(By.id("product_info_name")).sendKeys(name);
			dr.findElement(By.id("product_info_number")).sendKeys(name);
			Select ss = new Select(dr.findElement(By.id("product_info_activity_name")));
			ss.selectByValue("3");
			Select ss1 = new Select(dr.findElement(By.id("product_lock_time")));
			ss1.selectByValue("3");
			dr.findElement(By.id("product_info_raised_amount")).sendKeys("1");// 融资金额
			dr.findElement(By.id("product_info_increase_interest_rate")).clear();
			dr.findElement(By.id("product_info_increase_interest_rate")).sendKeys("1");//平台加息
			String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());// 对日期进行格式化
			System.out.println(startDate);
			 JavascriptExecutor js= (JavascriptExecutor) dr;
	         //输入时间
	         js.executeScript("arguments[0].value=\""+startDate+"\"",dr.findElement(By.id("product_info_expect_online_datetime")));
			
	         dr.findElement(By.id("product_raise_time")).sendKeys("1");
	         dr.findElement(By.id("product_except_lock_time")).click();
	         dr.switchTo().defaultContent();
	         Thread.sleep(1000);
	         dr.findElement(By.xpath("//*[@id=\"createfrom\"]/div[2]/button")).click();
	         Thread.sleep(2000);
	         if(dr.switchTo().alert().getText().equals("添加成功")) {
	        	 System.out.println("添加成功");
	         }
	         dr.switchTo().alert().accept();
	         dr.close();
	         dr.quit();
	  }
	  @DataProvider(name="mydata1")
	  public Object[][] getdata(){
		  Object[][] value= {{2019,0,29}};
		  return value;
		  
	  }
}

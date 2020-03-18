package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateZZSPlan {
	@Parameters({"year","month","date","env"})
//	@Test(dataProvider="mydata")//从data获取数据，执行10次，3个线程同时跑，超时10000豪秒
	@Test
	public void createZzsPlan(int myyear, int mymonth, int myday,String env) throws InterruptedException {
		String url=null;
		WebDriver dr = CreateDriver.getDriver("chrome");
		dr.get("http://dev-admin.irongbei.com");
		dr.findElement(By.name("username")).sendKeys("研发专用管理员");
		dr.findElement(By.name("password")).sendKeys("123456");
		dr.findElement(By.linkText("登录")).click();
		// Actions action=new Actions(dr);
		// action.sendKeys(Keys.CONTROL+"t");
		// action.perform();
		Thread.sleep(3000);
//		MyEnviment me=new MyEnviment();
//		String url=me.getEvi("test", "test");
		MyEnviment me=new MyEnviment();
		String befororback=env+"admin";
		if(env.equals("test")) {
		url="http://alpha_backend.api.irongbei.com";
		}else {
			url="http://dev_backend.api.irongbei.com";
		}
		
		dr.get(url);
		Calendar c = new GregorianCalendar();
		c.set(myyear, mymonth, myday);
		dr.get(url+"/product/index");
		dr.navigate().to(url+"/product/create");
		
		String userunder = new SimpleDateFormat("yyMMddhhmmss").format(c.getTime());
		String name = "测试周周升计划-翟" + userunder;
		dr.findElement(By.id("product_info_name")).sendKeys(name);
		dr.findElement(By.id("product_info_number")).sendKeys(name);
		Select ss = new Select(dr.findElement(By.id("product_info_activity_name")));
		ss.selectByValue("3");
		dr.findElement(By.id("product_info_raised_amount")).sendKeys("1");// 融资金额
		dr.findElement(By.id("product_info_single_limit")).sendKeys("10000");// 限投

		String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);

		 JavascriptExecutor js= (JavascriptExecutor) dr;
         //输入时间
         js.executeScript("arguments[0].value=\""+startDate+"\"",dr.findElement(By.id("product_info_expect_online_datetime")));
		
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.findElement(By.id("product_info_increase_interest_rate")).sendKeys("1");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"createfrom\"]/div[2]/button")).click();
		Thread.sleep(3000);
//		dr.close();
		dr.quit();

	}
	@DataProvider(name="mydata")
	public 	Object[][] getdata(){
		Object[][] value= {{2019,0,29}};
		
		return value;
		
	}
}

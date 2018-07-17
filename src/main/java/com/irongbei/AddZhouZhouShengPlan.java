package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddZhouZhouShengPlan {
	public void createZzs(int i,int myyear,int mymonth,int myday) throws Exception {
		String number=null;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar c = new GregorianCalendar();
		c.set(myyear, mymonth, myday);
		dr.get("http://alpha_backend.api.irongbei.com/product/index");
		dr.navigate().to("http://alpha_backend.api.irongbei.com/product/create");
	
		String n="测试周周升-翟";
		if(i<=9) {
		number="00"+i;}
		if(i>9&&i<=99) {
		number="0"+i;
		}
	String name=n+number;
		dr.findElement(By.id("product_info_name")).sendKeys(name);
		dr.findElement(By.id("product_info_number")).sendKeys(name);
		Select ss=new Select(dr.findElement(By.id("product_info_activity_name")));
		ss.selectByValue("3");
		dr.findElement(By.id("product_info_raised_amount")).sendKeys("1");//融资金额
		dr.findElement(By.id("product_info_single_limit")).sendKeys("10000");//限投

		String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);
		String changereadonly = "$('input[id=product_info_expect_online_datetime]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly);
	//	dr.findElement(By.name("online_time")).click();
		dr.findElement(By.id("product_info_expect_online_datetime")).sendKeys(startDate);
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.findElement(By.id("product_info_increase_interest_rate")).sendKeys("1");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"createfrom\"]/div[2]/button")).click();
		
		dr.close();
		dr.quit();
		
		

}
}
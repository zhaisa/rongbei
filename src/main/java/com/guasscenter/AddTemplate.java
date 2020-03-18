package com.guasscenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.irongbei.CreateDriver;
import com.irongbei.GetNextHandle;

public class AddTemplate {
@Test(invocationCount=20,threadPoolSize=1)
public void addTemplate() throws InterruptedException {
	CreateDriver cd =new CreateDriver();
	WebDriver dr=CreateDriver.getDriver("chrome");
	dr.get("http://dev.gauss.irongbei.com");
	dr.findElement(By.name("user_name")).clear();
	dr.findElement(By.name("user_name")).sendKeys("研发专用管理员");
	dr.findElement(By.name("password")).sendKeys("123456");
	Thread.sleep(200);
	dr.findElement(By.xpath("/html/body/div/div/form/button")).click();
	dr.navigate().to("http://dev.gauss.irongbei.com/site/index");
	dr.findElement(By.linkText("模板管理")).click();
	Thread.sleep(300);
	dr.findElement(By.linkText("添加模板")).click();
	GetNextHandle gnh=new GetNextHandle();
	gnh.getNextHandle(dr);
	Calendar cc=new GregorianCalendar();
	String temname="模板"+new SimpleDateFormat("yyMMddhhmmss").format(cc.getTime());
	dr.findElement(By.id("exampleInputName2")).sendKeys(temname);
	dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/button")).click();
	Thread.sleep(2000);
	String runame="入参"+new SimpleDateFormat("mmss").format(cc.getTime());
	dr.findElement(By.xpath("//*[@id=\"layer-bounced\"]/div[1]/input")).sendKeys(runame);
	dr.findElement(By.xpath("//div[2]/input")).sendKeys("rucanone");
	Select s1=new Select(dr.findElement(By.xpath("//div[3]/select")));
	s1.selectByIndex(1);
	dr.findElement(By.id("checkbox1")).click();
	dr.findElement(By.id("closeIframe")).click();
	Thread.sleep(1000);
	dr.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/button")).click();
	Thread.sleep(2000);
	String chuname="出参"+new SimpleDateFormat("mmss").format(cc.getTime());
	dr.findElement(By.xpath("//*[@id=\"layer-bounced\"]/div[1]/input")).sendKeys(chuname);
	dr.findElement(By.xpath("//div[2]/input")).sendKeys("chucanone");
	dr.findElement(By.xpath("//div[3]/textarea")).sendKeys("SUM(borrowing_amount,total_income)");
	dr.findElement(By.id("checkbox1")).click();
	dr.findElement(By.id("closeIframe")).click();
	Thread.sleep(1000);
	dr.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div[4]/div/button[3]")).click();
	Thread.sleep(2000);
	dr.close();
	dr.quit();
	

}
}

package com.cunguan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.irongbei.CreateDriver;

public class GetInterface {
@Test
public void getInterface() throws InterruptedException {
	CreateDriver gd=new CreateDriver();
	WebDriver dr=gd.getDriver("chrome");
	dr.get("http://custody.irongbei.com/admin");
	dr.findElement(By.name("user_name")).clear();
	dr.findElement(By.name("user_name")).sendKeys("admin");
	dr.findElement(By.name("password")).clear();
	dr.findElement(By.name("password")).sendKeys("123456");
	dr.findElement(By.xpath("/html/body/div/div/form/button")).click();
//	String aaa="$('button:first').click";
//	((JavascriptExecutor) dr).executeScript(aaa);
	dr.navigate().to("http://custody.irongbei.com/admin/index");
	dr.wait(1000);
	dr.findElement(By.linkText("通信管理")).click();
	dr.wait(200);
	dr.navigate().to(dr.findElement(By.linkText("通信列表")).getAttribute("href"));
	dr.findElement(By.name("interface_name")).sendKeys("bidAutoApply");
	
	
}
}

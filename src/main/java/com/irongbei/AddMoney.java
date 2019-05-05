package com.irongbei;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rongbei.util.ReadTxtForOne;

import base.WebSingle;

public class AddMoney{
	@Test(invocationCount=20)
	public void addMoney() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		MyEnviment me=new MyEnviment();
		String url=me.getEvi("test", "testadmin");
		dr.get(url+"/admin/login");

		// dr.manage().window().maximize();

		WebElement element = dr.findElement(By.name("username"));

		element.sendKeys("测试专用管理员");
		WebElement element1 = dr.findElement(By.name("password"));
		element1.sendKeys("123456");
		WebElement element2 = dr.findElement(By.className("login-btn"));
		element2.click();
		Thread.sleep(2000);
		// dr.get("http://dev-admin.irongbei.com/admin/Index/index");
		WebElement element3 = dr.findElement(By.xpath(".//*[@id='right-box']/p"));

		String obj1 = element3.getText().trim();
		System.out.println(obj1);
		String obj = "欢迎登录融贝网管理后台";
		if (obj1.contains(obj)) {
			System.out.println("sucess!");
		} else {
			System.out.println("登录失败 " + "");
		}
		System.out.println("Page title is: " + dr.getTitle());
		dr.findElement(By.linkText("平台数据统计")).click();

		// dr.findElement(By.xpath("//*[@id=\"left-nav\"]/ul/li[11]/ul/li[6]/a")).click();
		dr.navigate().to(url+"/admin/Statistics/jxUserCapitalManage");
		dr.findElement(By.id("operatepwd")).sendKeys("123456");
		dr.findElement(By.linkText("确定")).click();
		dr.navigate().to(
				url+"/admin/Statistics/jxUserCapitalManage?sign=bf042569ae6d7d6bfeb78a2c4560d8af");
		Thread.sleep(2000);
		ReadTxtForOne rt = new ReadTxtForOne();
		String a = rt.readline();//("D:\\users\\user.txt");

		dr.findElement(By.id("username")).sendKeys(a);
		dr.findElement(By.id("userlistbutton")).click();
		Thread.sleep(2000);
		String url1 = url+"/admin/Statistics/jxUserCapitalManage?username=";
		String url2 = a;
		String url3 = "&mobile=&usercode=&orderStyle=1&sign=bf042569ae6d7d6bfeb78a2c4560d8af";
		dr.navigate().to(url1 + url2 + url3);
		Thread.sleep(1000);
	//dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[2]/table/tbody/tr[2]/td[13]/a[1]")).click();
		dr.findElement(By.linkText("[平台奖励]")).click();
		Thread.sleep(2000);

		dr.findElement(By.xpath("//*[@id=\"money\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"money\"]")).sendKeys("10000");
		dr.findElement(By.xpath("//*[@id=\"operaPwd\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"operaPwd\"]")).sendKeys("123456");
		dr.findElement(By.xpath("//*[@id=\"moneyBtn\"]")).click();

		Thread.sleep(3000);
		Assert.assertEquals("操作成功", dr.switchTo().alert().getText());
		dr.switchTo().alert().accept();
		Thread.sleep(2000);

		dr.close();
		dr.quit();

	}
}
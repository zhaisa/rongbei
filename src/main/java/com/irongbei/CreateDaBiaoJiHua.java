package com.irongbei;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateDaBiaoJiHua {
	public void createDaBiaoJiHua(String zq, int myyear, int mymonth, int myday) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		Calendar c = new GregorianCalendar();
		c.set(myyear, mymonth, myday);
		WebDriver dr = new ChromeDriver();
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");

		WebElement element = dr.findElement(By.name("username"));

		element.sendKeys("测试专用管理员");
		WebElement element1 = dr.findElement(By.name("password"));
		element1.sendKeys("123456");
		WebElement element2 = dr.findElement(By.className("login-btn"));
		element2.click();
		Thread.sleep(2000);

		WebElement element3 = dr.findElement(By.xpath(".//*[@id='right-box']/p"));

		String obj1 = element3.getText().trim();
		System.out.println(obj1);
		String obj = "欢迎登录融贝网管理后台";
		if (obj1.contains(obj)) {
			System.out.println("登录成功!");
		} else {
			System.out.println("登录失败 " + "");
		}
		System.out.println("Page title is: " + dr.getTitle());

		dr.findElement(By.linkText("省心投管理")).click();
		String aaa = "$('#计划列表').click";
		((JavascriptExecutor) dr).executeScript(aaa);
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/FinancialPlan/index");
		dr.findElement(By.linkText("添加计划")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/FinancialPlan/addFinancialPlan");

		String userunder = new SimpleDateFormat("yyMMddss").format(c.getTime());
		System.out.println(userunder);

		String user = "省心投债权组成" + userunder;//省心投理财计划-翟

		dr.findElement(By.name("plan_name")).sendKeys(user);
		dr.findElement(By.name("plan_num")).sendKeys(user);
		dr.findElement(By.name("financing_amount")).clear();
		dr.findElement(By.name("financing_amount")).sendKeys("1");// 融资金额
		dr.findElement(By.name("rate")).clear();
		dr.findElement(By.name("rate")).sendKeys("8");// 利率自带%

		JavascriptExecutor jse = (JavascriptExecutor) dr;
		Boolean loaded;
		try {
			loaded = (Boolean) jse.executeScript("return " + "jQuery()!=null");
		} catch (WebDriverException e) {
			loaded = false;
		}

		/*
		 * 
		 * 加载jquery清楚readonly熟悉，然后给输入框输入时间
		 */

		String startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);

		String sxsj = "$('input[name=predict_online_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(sxsj);

		dr.findElement(By.xpath("//*[@id=\"predict_online_time\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"predict_online_time\"]")).sendKeys(startDate);
		dr.findElement(By.xpath("//*[@id=\"full_time\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"full_time\"]")).sendKeys("1");// 募集期
		dr.findElement(By.xpath("//*[@id=\"lock_time\"]")).click();

		Select s1 = new Select(dr.findElement(By.id("lock_time")));

		s1.selectByValue(zq);// 选择省心投的期限1,3,6,9,12,锁定期

		dr.findElement(By.name("lock_end_time")).click();
		Thread.sleep(3000);
		String changereadonly2 = "$('#submit').click()";
		((JavascriptExecutor) dr).executeScript(changereadonly2);
		Thread.sleep(1000);
		dr.switchTo().alert().accept();

		// assertEquals("添加计划", dr.findElement(By.linkText("添加计划")));
		Thread.sleep(2000);
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
//		dr.switchTo().alert().accept();
//		Thread.sleep(2000);
		
		dr.quit();
	}
}
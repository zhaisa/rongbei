package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.irongbeipages.LoginPage;

public class AddNewShengxtPlan {
	public void createSst(int i, int myyear, int mymonth, int myday) throws Exception {
		String number = null;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar c = new GregorianCalendar();
		dr.manage().window().maximize();
		dr.get("http://dev-admin.irongbei.com//admin/login");
		Thread.sleep(1000);
		LoginPage lp = new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		Thread.sleep(2000);
		dr.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");// 在同一浏览器上打开下面的链接
		Thread.sleep(2000);
		c.set(myyear, mymonth, myday);
		dr.get("http://alpha_backend.api.irongbei.com");
		dr.navigate().to("http://alpha_backend.api.irongbei.com/financialplan/create");

		String n = "测试新省心投-翟";
		if (i <= 9) {
			number = "00" + i;
		}
		if (i > 9 && i <= 99) {
			number = "0" + i;
		}
		String name = n + number;
		dr.findElement(By.id("product_info_name")).sendKeys(name);
		dr.findElement(By.id("product_info_number")).sendKeys(name);
		Select ss = new Select(dr.findElement(By.id("product_info_activity_name")));
		ss.selectByValue("1");
		@SuppressWarnings("unchecked")
		List<WebElement> jianglijin = dr.findElements(By.name("product_info_is_bounty"));
		jianglijin.get(0).click();
		List<WebElement> youhuiquan = dr.findElements(By.name("product_info_is_bonus"));
		youhuiquan.get(0).click();
		Select s1 = new Select(dr.findElement(By.id("product_lock_time")));
		s1.selectByValue("6");// 3,6,9,12,18
		dr.findElement(By.id("product_info_annual_interest_rate")).sendKeys("11");
		dr.findElement(By.id("product_info_annual_interest_rate1")).sendKeys("8");
		dr.findElement(By.id("product_info_raised_amount")).sendKeys("1");// 融资金额
		dr.findElement(By.id("product_info_increase_interest_rate")).sendKeys("1");// 利率
		dr.findElement(By.id("product_info_single_limit")).sendKeys("10000");// 限投
        Thread.sleep(1000);
		String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);
		String changereadonly = "$('input[id=product_info_expect_online_datetime]').attr(\"readonly\",false)";
		String changehold="$('input[id=product_info_expect_online_datetime]').attr(\"placeholder\",false)";
		
		((JavascriptExecutor) dr).executeScript(changereadonly);
		((JavascriptExecutor) dr).executeScript(changehold);
		// dr.findElement(By.name("online_time")).click();
		dr.findElement(By.id("product_info_expect_online_datetime")).clear();
		dr.findElement(By.id("product_info_expect_online_datetime")).sendKeys(startDate);
//        WebElement we = dr.findElement(By.id("product_info_expect_online_datetime"));
//        WebElement we1=dr.findElement(By.linkText("今天"));
//		Actions action = new Actions(dr);
//		action.moveToElement(we).click();
//	
//		action.moveToElement(we).perform();
//		action.moveToElement(we1).click();
//		action.moveToElement(we1).perform();
		
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.findElement(By.id("product_raise_time")).sendKeys("2");// 募集期
		Thread.sleep(3000);
    //    dr.switchTo().defaultContent();
		dr.findElement(By.xpath("//*[@id=\"createfrom\"]/div[2]/button")).click();
	
		Thread.sleep(3000);
		dr.switchTo().alert().accept();
		Thread.sleep(3000);
		String ss1 = dr.switchTo().alert().getText();
		String ss2 = "添加成功!";
		if (ss1.contains(ss2)) {
			System.out.println("----->添加成功！");
		} else {
			System.out.println("----->添加失败！");
		}
		Thread.sleep(2000);

		dr.close();
		dr.quit();

	}
}
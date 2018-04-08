package com.irongbei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.irongbeipages.LoginPage;

@Test
public class AddYouHuiQuan {
	public void addYouHuiQuan() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");
		LoginPage lp = new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		dr.findElement(By.linkText("优惠券管理")).click();
		dr.findElement(By.partialLinkText("优惠券管理")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Voucher/index");
		dr.findElement(By.xpath("//input[@value=\"添加\"]")).click();
		Thread.sleep(1000);
		dr.findElement(By.name("vName")).sendKeys("优惠券-翟专用");
		Select ss = new Select(dr.findElement(By.id("vType")));
		List<WebElement> list = ss.getOptions();
		System.out.println(list.get(1).getText());
		ss.selectByVisibleText(list.get(1).getText());// 1为现金券，2为加息券，3为奖励金券4为现实加息券
		dr.findElement(By.name("availableDays")).sendKeys("10");// 优惠券天数
		Select ss1 = new Select(dr.findElement(By.name("vLimitType")));
		List<WebElement> list2 = ss1.getOptions();
		list.get(0).click();// 默认无限制，1为按固定金额限制2为按输入金额倍数限制
		dr.findElement(By.name("limitValue")).clear();
		dr.findElement(By.name("limitValue")).sendKeys("0");// 默认是0元
		List<WebElement> list3 = dr.findElements(By.name("is_remind"));
		list3.get(0).click();// 是否提醒？默认为否
		List<WebElement> list4 = dr.findElements(By.name("common_type"));
		list4.get(1).click();// 默认为直投、小标不可使用
		if (list4.get(1).isSelected()) {
			dr.findElement(By.name("select_common")).click();

		}
		List<WebElement> list7 = dr.findElements(By.name("finance_type"));
		list7.get(0).click();
		if (list7.get(1).isSelected()) {

			dr.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();

		}
		dr.findElement(By.id("submitEdit")).click();
		dr.switchTo().alert();
		dr.switchTo().alert().accept();
		System.out.println("加息券添加成功，进入审核流程=========>");
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Voucher/index");
		WebElement we = dr.findElement(By.xpath("//tbody"));
		List<WebElement> list8=dr.findElements(By.tagName("tr"));
		List<WebElement> list9=dr.findElements(By.tagName("td"));
		Map<String,String> map=new HashMap();
		for(WebElement row:list8) {
			
		}

		// dr.quit();
	}
}

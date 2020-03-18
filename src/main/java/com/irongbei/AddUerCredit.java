package com.irongbei;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.irongbeipages.LoginPage;

public class AddUerCredit {
	public void addUserCredit(String userp, String credit) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");
		LoginPage lp = new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		dr.findElement(By.linkText("优惠券管理")).click();
		Thread.sleep(2000);
		dr.findElement(By.partialLinkText("发放优惠券")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Voucher/userVoucherImport");
//		Thread.sleep(1000);
//		dr.findElement(By.id("give")).click();
		Thread.sleep(2000);
		dr.findElement(By.name("username1")).clear();
		dr.findElement(By.name("username1")).sendKeys(userp);
		Select ss1 = new Select(dr.findElement(By.name("vType")));
		List<WebElement> list1 = ss1.getOptions();
		for (int j = 0; j < list1.size(); j++) {
			System.out.println(list1.get(j).getText());
		}

		if (credit.equals(list1.get(1).getText())) {
			ss1.selectByVisibleText(credit);
			Select ss2 = new Select(dr.findElement(By.name("vId")));
			List<WebElement> list2 = ss2.getOptions();
			ss2.selectByVisibleText("2%加息券");
			dr.findElement(By.name("value")).clear();
			dr.findElement(By.name("value")).sendKeys("2");
			
		
		}
		if (credit.equals(list1.get(0).getText())) {
			ss1.selectByVisibleText(credit);
			Select ss2 = new Select(dr.findElement(By.name("vId")));
			List<WebElement> list2 = ss2.getOptions();
			ss2.selectByVisibleText("测试24月优惠券");
			dr.findElement(By.name("value")).clear();
			dr.findElement(By.name("value")).sendKeys("20");
		
		}
		if(credit.equals(list1.get(2).getText())) {
			ss1.selectByVisibleText(credit);
			Select ss3 = new Select(dr.findElement(By.name("vId")));
			List<WebElement> list3 = ss3.getOptions();
			ss3.selectByVisibleText("10天限时加息券");
			Thread.sleep(1000);
			dr.findElement(By.name("value")).clear();
			dr.findElement(By.name("value")).sendKeys("3");
		}

		dr.findElement(By.name("source")).clear();
		dr.findElement(By.name("source")).sendKeys("aaa");
		dr.findElement(By.id("operaPwd")).clear();
		dr.findElement(By.id("operaPwd")).sendKeys("123456");
		dr.findElement(By.id("addButton")).click();
		Thread.sleep(2000);
		dr.switchTo().alert();
		if (dr.switchTo().alert().getText().equals("操作成功！")) {
			System.out.println("添加成功！");
		}
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Voucher/checkUserVoucher");
		dr.findElement(By.partialLinkText("通过审核")).click();
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
	
		dr.quit();
	//	dr.close();
	}
}

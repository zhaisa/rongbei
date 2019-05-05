package com.rongbei.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.irongbei.MyEnviment;

public class GetKey {
	// @Parameters({"user","projectid","value","account","version"})
	// @Test
	// public static void main(String[] args) throws InterruptedException {
	// getKey("17409040300",176,"3","200",1);
	// }
	public String getKey(String user, int projectid, String value, String account, int myversion)
			throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//
		// 这一步必不可少
		// WebDriver dr = new ChromeDriver();
		String key = null;

		NoGuiDriver ngd = new NoGuiDriver();
		WebDriver dr = ngd.getDriver();
		MyEnviment me = new MyEnviment();
		String url = me.getEvi("test", "test");
		dr.get(url + "/?version=" + myversion);
		dr.get(url + "/UserLogin/index");
		// ReadTxt rt = new ReadTxt();
		// String username = rt.readFS("D:\\users\\usertext1.txt", lineNo);
		dr.findElement(By.id("user_name")).sendKeys(user);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to(url + "/UserCenter/index");
		Thread.sleep(1000);
		dr.findElement(By.linkText("我要出借")).click();
		dr.navigate().to(url + "/index/fplist");

		dr.findElement(By.className("current")).click();
		int myid2 = projectid;
		dr.navigate().to(url + "/Index/fpdetail?id=" + projectid);
		Thread.sleep(1000);
		Select ss1 = new Select(dr.findElement(By.id("financial_plan")));
		ss1.selectByValue(value);
		Thread.sleep(1000);
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys(account);
		dr.findElement(By.xpath("//*[@id=\"irb-content\"]/div/div/div[1]/div/div[2]/div/div[7]/div/img")).click();
		dr.findElement(By.id("investSubmit")).click();
		Thread.sleep(2000);
		String currentWindow = dr.getWindowHandle();
		Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			// if (currentWindow.equals(handle))
			// continue;
			WebDriver window = dr.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
			String sss1 = window.getCurrentUrl();
			Thread.sleep(1000);
			System.out.println(sss1);
			String[] keys = sss1.split("&");
			String[] key1 = null;
			for (String arr : keys) {
				System.out.println(arr);
				key1 = keys[3].split("=");
				for (String arr1 : key1) {
					System.out.println(arr1);
					key = key1[1];
				}
				// System.out.println(account+"对应key的值为------------>"+key);
				break;
			}

		}
		dr.close();
		dr.quit();
		return key;

	}
}

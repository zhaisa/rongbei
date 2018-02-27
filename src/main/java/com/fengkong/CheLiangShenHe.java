package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheLiangShenHe {
	public void shenHe() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
		dr.get("http://test-management.irongbei.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		dr.findElement(By.id("username")).clear();
		dr.findElement(By.id("username")).sendKeys("rmstest2");
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("123456");
		dr.findElement(By.id("login")).click();
		dr.navigate().to("http://test-management.irongbei.com/index/main.html");
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.switchTo().frame("leftmenu");
		dr.findElement(By.cssSelector("dt")).click();

		dr.navigate().to("http://test-management.irongbei.com/carloan/index.html");
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		List<WebElement> trlist = dr
				.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/dl/dd/div/table/tbody/tr"));
		List<String> url1 = new ArrayList<String>();
		List<String> url2 = new ArrayList<String>();
		for (int r = 0; r < trlist.size(); r++) {
			String trText = trlist.get(r).getText();
			String[] myname = trText.split(" ");
			String myname1 = myname[3];
			if (trText.contains("牧云")) {
				url1.add(myname1);
			}

		}
		for (int z = 0; z < url1.size(); z++) {
			System.out.println(url1.get(z));
		}
		String name = url1.get(0);
		for (int r = 0; r < trlist.size(); r++) {
			String trText1 = trlist.get(r).getText();
			if (trText1.contains(name)) {
				String url = trlist.get(r).findElement(By.linkText("查看详情")).getAttribute("href");
				url2.add(url);

				break;
			}

		}
		System.out.println(url2.get(0));
		dr.navigate().to(url2.get(0));

		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		dr.findElement(By.linkText("风控初审")).click();

		dr.navigate().to(dr.findElement(By.linkText("风控初审")).getAttribute("href"));

		List<WebElement> trlist1 = dr
				.findElements(By.xpath("/html/body/div/div/div[2]/form/div/dl[1]/dd/div[1]/table/tbody/tr"));

		for (int r = 0; r < trlist1.size(); r++) {
			String trtext = trlist1.get(r).getText();
			System.out.println(trtext);
			if (trtext.contains("否")) {
				String name1 = dr.findElement(By.linkText("否")).getTagName();
				System.out.println(name1);
			}
		}

		// dr.close();
		// dr.quit();
	}
}

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
	public void shenHe(int num) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
		dr.get("http://test-management.irongbei.com");
		dr.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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
			String myname1 = myname[2];
			if (trText.contains("牧云")) {
				url1.add(myname1);
			}

		}
		for (int z = 0; z < url1.size(); z++) {
			System.out.println(url1.get(z));

		}
		System.out.println(url1.size());
		String name = url1.get(num);
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
		

		

		List<WebElement> radio1 = dr.findElements(By.name("sfz"));
		radio1.get(0).click();
		List<WebElement> radio2 = dr.findElements(By.name("businesslicenser"));
		radio2.get(1).click();
		List<WebElement> radio3 = dr.findElements(By.name("lxfs"));
		radio3.get(0).click();
		List<WebElement> radio4 = dr.findElements(By.name("blacklistindustryr"));
		radio4.get(1).click();
		List<WebElement> radio5 = dr.findElements(By.name("registrationr"));
		radio5.get(0).click();
		List<WebElement> radio6 = dr.findElements(By.name("carbookr"));
		radio6.get(1).click();
		List<WebElement> radio7 = dr.findElements(By.name("carphoner"));
		radio7.get(0).click();
		List<WebElement> radio8 = dr.findElements(By.name("situationr"));
		radio8.get(1).click();

		dr.findElement(By.name("sfzr")).sendKeys("门前大桥下");
		dr.findElement(By.name("businesslicense")).sendKeys("游过一群鸭");
		dr.findElement(By.name("lxfsr")).sendKeys("快来快来数一数");
		dr.findElement(By.name("blacklistindustry")).sendKeys("二四六七八");
		dr.findElement(By.name("registration")).sendKeys("小丫小二郎");
		dr.findElement(By.name("carbook")).sendKeys("背着书包尚学堂");
		dr.findElement(By.name("carphoner7")).sendKeys("不怕太阳晒");
		dr.findElement(By.name("situation")).sendKeys("只怕先生说我懒压");
		dr.findElement(By.name("zlshjlvalue")).sendKeys("this is a first!!");

		dr.findElement(By.name("fkzyll_zy")).sendKeys("28%");
		dr.findElement(By.name("fkzyvalue_zy")).sendKeys("this is a second!!!");

		dr.findElement(By.name("button")).click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dr.close();
		dr.quit();
	}

	private void conRadio() {
		// TODO Auto-generated method stub
		
	}
}

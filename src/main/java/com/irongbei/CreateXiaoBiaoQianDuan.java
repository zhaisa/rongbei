package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateXiaoBiaoQianDuan {
	public void createXiaoBiaoQianDuan(int myyear, int mymonth, int mydate, int mylen) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar c = new GregorianCalendar();
		// c.set(myyear, mymonth, myday);
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");

		// dr.manage().window().maximize();

		WebElement element = dr.findElement(By.name("username"));

		element.sendKeys("测试专用管理员");
		WebElement element1 = dr.findElement(By.name("password"));
		element1.sendKeys("123456");
		WebElement element2 = dr.findElement(By.className("login-btn"));
		element2.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.findElement(By.linkText("标准化项目管理")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Standardproject/index");
		dr.findElement(By.linkText("添加标准项目")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Standardproject/standardpadd");
		dr.findElement(By.name("bottom_project_id")).click();
		Select s1 = new Select(dr.findElement(By.name("bottom_project_id")));
		List<WebElement> list = s1.getOptions();
		List list1 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			String arr = list.get(i).getText();
			if (arr.contains("测试小标项目-翟20180307")) {
				list1.add(arr);
			}
		}

		for (int z = 0; z < list1.size(); z++) {
			System.out.println(list1.get(z));
		}
		String sa = (String) list1.get(0);
		s1.selectByVisibleText(sa);
		dr.switchTo().defaultContent();
		// Random r = new Random();
		// int start = (int) (Math.random() *list1.size());
		// if(start<list1.size()) {
		// int index = r.nextInt(list1.size() -start
		// );//生成一个随机数，范围是list的个数
		// System.out.println(index);
		// s1.selectByIndex(index);// 根据上面随机生成的下拉选项的index，点击这个选项
		//
		// }
		dr.findElement(By.name("rate")).clear();
		dr.findElement(By.name("rate")).sendKeys("7");
		dr.findElement(By.name("cycle")).sendKeys("3");

		String deltime = "$('#end_time').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(deltime);

		Calendar cc = new GregorianCalendar();
		cc.set(myyear, mymonth, mydate);
		cc.add(Calendar.MONTH, mylen);
		String endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(cc.getTime());

		dr.findElement(By.id("end_time")).sendKeys(endDate);
		// dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		dr.switchTo().defaultContent();

		dr.findElement(By.linkText("确认无误，提交")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dr.switchTo().alert().accept();
		String ss1 = dr.switchTo().alert().getText();
		String ss2 = "添加成功!";
		if (ss1.contains(ss2)) {
			System.out.println("----->添加成功！");
		} else if (ss1.isEmpty()) {
			System.out.println("----->添加失败！");
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dr.close();
		dr.quit();
	}
}

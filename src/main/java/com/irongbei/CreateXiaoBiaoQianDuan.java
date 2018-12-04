package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateXiaoBiaoQianDuan {
	public void createXiaoBiaoQianDuan(int myyear, int mymonth, int mydate, int mylen,String project) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		Calendar c = new GregorianCalendar();
		
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");
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
		dr.findElement(By.linkText("小标项目管理")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Standardproject/index");
		dr.findElement(By.linkText("添加小标项目")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Standardproject/standardpadd");
		dr.findElement(By.name("bottom_project_id")).click();
		Select s1 = new Select(dr.findElement(By.name("bottom_project_id")));
		List<WebElement> list = s1.getOptions();
		List list1 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			String arr = list.get(i).getText();
			if (arr.contains(project)) {
				list1.add(arr);
			}
		}

		for (int z = 0; z < list1.size(); z++) {
			System.out.println(list1.get(z));
		}
		String sa = (String) list1.get(0);
		s1.selectByVisibleText(sa);
		Thread.sleep(5000);
		dr.switchTo().defaultContent();
		dr.findElement(By.name("cycle")).sendKeys("3");
		String deltime = "$('#end_time').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(deltime);

		Calendar cc = new GregorianCalendar();
		cc.set(myyear, mymonth, mydate);
		cc.add(Calendar.MONTH, mylen);
		String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cc.getTime());
         Thread.sleep(2000);
        dr.findElement(By.id("end_time")).clear();
		dr.findElement(By.id("end_time")).sendKeys(endDate);
		dr.findElement(By.linkText("确认无误，提交")).click();
		Thread.sleep(3000);
		dr.switchTo().alert().accept();
		Thread.sleep(3000);
		String ss1 = dr.switchTo().alert().getText();
		String ss2 = "添加成功!";
		if (ss1.contains(ss2)) {
			System.out.println("----->添加成功！");
		} else if (ss1.isEmpty()) {
			System.out.println("----->添加失败！");
		}
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
		// dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Standardproject/index");
		WebElement tbody = dr.findElement(By.xpath("//table/tbody"));
		List<WebElement> tr = tbody.findElements(By.tagName("tr"));
		Map<String, String> map = new HashMap();
		for (WebElement row : tr) {
			String trtext = row.getText();
			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				String tdtext = col.getText();
				System.out.println(tdtext);
				if (trtext.contains(project) && tdtext.equals("未审核")) {
					map.put("项目名称", td.get(0).getText());
					map.put("审核是否通过", td.get(7).getText());
					map.put("操作", td.get(9).getText());
				
			
				}

			}
		}
	
		for (WebElement row : tr) {
			if(row.getText().contains(project)&&map.get("操作").equals("未审核"))  {
				dr.findElement(By.linkText("[审核]")).click();
				//			Thread.sleep(2000);
							dr.switchTo().alert().accept();
							Thread.sleep(2000);
							dr.switchTo().alert().accept();
							Thread.sleep(1000);
							break;
				
			}
		}

		 dr.quit();
		
	}
}

	

package com.irongbeipages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ZhiTouPage {
	WebDriver dr;
	WebElement projectname;
	WebElement projectcode;
	WebElement jionproject;
	WebElement projecttype;
	WebElement paytype;
	WebElement borrower;
	WebElement contractmodel;
	WebElement selectmodel;
	WebElement psum;
	WebElement historyrate;
	WebElement creditrate;
	WebElement fixedinvest;
	WebElement circle;
	WebElement starttime;
	WebElement endtime;
	WebElement sub;
	WebElement tmplate;

	public ZhiTouPage(WebDriver dr) {
		super();
		this.dr = dr;
		Calendar c = new GregorianCalendar();
		String userunder = new SimpleDateFormat("yyyyMMddhhmmss").format(c.getTime());
		System.out.println(userunder);

		String user = "测试直投项目-翟" + userunder;

		System.out.println(user);

		projectname = dr.findElement(By.name("project_name"));
		projectcode = dr.findElement(By.name("project_num"));
		jionproject = dr.findElement(By.name("activity_name"));
		projecttype = dr.findElement(By.id("xuanzh"));
		paytype = dr.findElement(By.name("real_payment"));
		borrower = dr.findElement(By.name("company_user_id"));
		contractmodel = dr.findElement(By.name("contract_type"));
		selectmodel = dr.findElement(By.id("template_id"));
		psum = dr.findElement(By.id("p_sum"));
		historyrate = dr.findElement(By.id("rate"));
		creditrate = dr.findElement(By.id("cre_rate"));
		fixedinvest = dr.findElement(By.name("fixed_invest"));
		circle = dr.findElement(By.name("cycle"));
		tmplate = dr.findElement(By.className("tanchu")).findElement(By.id("template_data"));
		starttime = dr.findElement(By.name("online_time"));
		endtime = dr.findElement(By.name("end_time"));

	}

	public void addZhiTou() throws InterruptedException {
		Calendar c = new GregorianCalendar();
		String userunder = new SimpleDateFormat("yyyyMMddhhmmss").format(c.getTime());
		System.out.println(userunder);

		String user = "测试直投项目-翟" + userunder;

		System.out.println(user);
		projectname.sendKeys(user);
		projectcode.sendKeys(user);
		select(jionproject, 0);// 加入活动，非活动size=3
		select("3", projecttype);// 项目类型选择房抵贷,size=9/房抵贷
		select(paytype, "等额本息");// size=3,选择等额本息
		select(borrower, "uat测试账户壹18010123036");// 选择最后一个
		dr.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		select(contractmodel, 1);
		select("295", selectmodel);// size-8
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> list = dr.findElements(By.xpath("//input[@class='tc-name text-style']"));
		list.get(0).sendKeys("东风北桥");
		list.get(1).sendKeys("三室两厅");
		list.get(2).sendKeys("160平米");
		list.get(3).sendKeys("3000000元");
		dr.findElement(By.linkText("确定")).click();
		psum.sendKeys("1");// 金额1万
		historyrate.sendKeys("8");// 历史年化利率
		creditrate.clear();
		creditrate.sendKeys("10");
		fixedinvest.clear();
		fixedinvest.sendKeys("0");
		circle.sendKeys("3");
		String startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);
		String changereadonly = "$('input[name=online_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly);
		starttime.sendKeys(startDate);
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		c.add(Calendar.MONTH, 3);

		String endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(c.getTime());
		System.out.println(endDate);
		String endattr = "$('input[name=end_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(endattr);
		endtime.click();
		endtime.sendKeys(endDate);
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String changereadonly2 = "$('#sub').click()";
		((JavascriptExecutor) dr).executeScript(changereadonly2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
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

	public void select(WebElement w, int index) {
		Select ss = new Select(w);
		List<WebElement> list = ss.getOptions();
		ss.selectByIndex(index);
		String text = list.get(index).getText();
		System.out.println(list.size());
	//	System.out.println(text);
	}

	public void select(WebElement w, String text) {
		Select ss = new Select(w);
		List<WebElement> list = ss.getOptions();
		ss.selectByVisibleText(text);
		for (int i = 0; i < list.size(); i++) {
			String text1 = list.get(i).getText();
	//		System.out.println(text1);
		}
	}

	public void select(String value, WebElement w) {
		Select ss = new Select(w);
		List<WebElement> list = ss.getOptions();
		ss.selectByValue(value);
	}

}

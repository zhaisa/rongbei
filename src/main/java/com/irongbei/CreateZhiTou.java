package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

@Test
public class CreateZhiTou {

	public void createZhiTou(String zq, int mylengh, int myyear, int mymonth, int myday, int usernum) throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();

		Calendar c = new GregorianCalendar();
		c.set(myyear, mymonth, myday);
		dr.get("http://rongbeiadmin.51dmoz.com/admin/login");

		// dr.manage().window().maximize();

		WebElement element = dr.findElement(By.name("username"));

		element.sendKeys("测试专用管理员");
		WebElement element1 = dr.findElement(By.name("password"));
		element1.sendKeys("123456");
		WebElement element2 = dr.findElement(By.className("login-btn"));
		element2.click();
		Thread.sleep(2000);
		// dr.get("http://rongbeiadmin.51dmoz.com/admin/Index/index");
		WebElement element3 = dr.findElement(By.xpath(".//*[@id='right-box']/p"));
		// WebElement
		// element3=dr.findElement(By.xpath(".//*[@id='header']/div[2]/div[2]/div/span[5]/a/b[1]"));
		// JavascriptExecutor js = (JavascriptExecutor) dr;
		// String value = (String)js.executeScript("return $('element3').val();");
		String obj1 = element3.getText().trim();
		System.out.println(obj1);
		String obj = "欢迎登录融贝网管理后台";
		if (obj1.contains(obj)) {
			System.out.println("sucess!");
		} else {
			System.out.println("登录失败 " + "");
		}
		System.out.println("Page title is: " + dr.getTitle());

		dr.findElement(By.xpath("//*[@id=\"left-nav\"]/ul/li[3]/span/a")).click();
		dr.findElement(By.xpath(".//*[@id='left-nav']/ul/li[3]/ul/li[1]/a")).click();
		dr.findElement(By.xpath(".//*[@id='right-box']/div[1]/span/a[1]")).click();
		/**
		 * 
		 * 尝试alert
		 */
		// Alert alert = dr.switchTo().alert();//定位altert弹出的提示的
		// alert.getText();

		/**
		 * 
		 * 尝试句柄
		 */
		// Set<String> handles = dr.getWindowHandles();
		// handles.remove(dr.getWindowHandle());//去掉当前句柄
		// dr.switchTo().window(handles.iterator().next());
		// WebDriver popup = null;
		// popup.findElement(By.id("Check2")).click();
		// popup.findElement(By.id("pro_bottom_confirm")).click();
		/**
		 * 
		 * 添加小标或者直投
		 */
		dr.findElement(By.id("project_type_pop")).findElement(By.id("Check2")).click();
		/**
		 * 添加大标
		 */
		// dr.findElement(By.id("project_type_pop")).findElement(By.id("Check1")).click();//
		Thread.sleep(1000); // 停止1秒钟
		dr.findElement(By.id("project_type_pop")).findElement(By.id("pro_bottom_confirm")).click();
		String userunder = new SimpleDateFormat("yyyyMMddhhmmss").format(c.getTime());
		System.out.println(userunder);

		String user = "测试直投项目-翟" + userunder;

		System.out.println(user);

		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Project/create");
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[1]/div[1]/input")).sendKeys(user);
		dr.findElement(By.id("project_num")).sendKeys(user);
		// UUID uuid = UUID.randomUUID();
		// System.out.println(uuid);
//		String s = UUID.randomUUID().toString();
//		dr.findElement(By.name("project_description")).sendKeys(s);
//		dr.findElement(By.name("repayment")).sendKeys(s);
//		dr.findElement(By.name("project_riskcontrol")).sendKeys(s);

		Select sn = new Select(dr.findElement(By.id("xuanzh")));
		sn.selectByValue("3");// 3为房抵贷
		Select sl = new Select(dr.findElement(By.name("real_payment")));

		sl.selectByValue("2");// 选择等额本息1为先息后本2为等额本息3为一次性还本付息

		Select s2 = new Select(dr.findElement(By.name("company_user_id")));

		s2.selectByValue("14036#6212461560001004902#1#13710");// 选择测试授权的value--13861#6212461560000255356#1#13710，目前只有他能用，增加一个企业-sit翟企业成功14025#6212461560001005032#1#12827

		Select s3 = new Select(dr.findElement(By.name("contract_type")));

		s3.selectByValue("9");// 直融——车贷(消费金融)——等额本息
//		dr.findElement(By.xpath("//*[@id=\"template_id\"]/option[16]")).click();
		Select s4 = new Select(dr.findElement(By.id("template_id")));
		// s4.selectByVisibleText("模板6");//选择模板6
		s4.selectByValue("295");// 选择acai测试模板—房抵贷
		Thread.sleep(3000);
		// dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/**
		 * 使用相对路径获取弹框的XPATH
		 */
		// String att="hello my world!!!!!";
		// dr.findElement(By.xpath("//textarea[@value='']")).click();
		// dr.findElement(By.xpath("//textarea[@value='']")).clear();
		// dr.findElement(By.xpath("//textarea[@value='']")).sendKeys(att+userunder);
		dr.findElement(By.className("tanchu"))
				.findElement(By.xpath("//*[@id=\"template_data\"]/div[2]/div/div[1]/p/input")).sendKeys("东风北桥北路");
		dr.findElement(By.className("tanchu"))
				.findElement(By.xpath("//*[@id=\"template_data\"]/div[2]/div/div[2]/p/input")).sendKeys("三室两厅");
		dr.findElement(By.className("tanchu"))
				.findElement(By.xpath("//*[@id=\"template_data\"]/div[2]/div/div[3]/p/input")).sendKeys("160平米");
		dr.findElement(By.className("tanchu"))
				.findElement(By.xpath("//*[@id=\"template_data\"]/div[2]/div/div[4]/p/input")).sendKeys("3000000元");

		dr.findElement(By.linkText("确定")).click();

		dr.findElement(By.id("p_sum")).sendKeys("1");// 输入金额1万
		dr.findElement(By.id("rate")).sendKeys("8");// 年利率8%
		dr.findElement(By.id("cre_rate")).clear();
		dr.findElement(By.id("cre_rate")).sendKeys("9");
		dr.findElement(By.name("fixed_invest")).clear();
		dr.findElement(By.name("fixed_invest")).sendKeys("0");// 输入定投金额
		dr.findElement(By.name("cycle")).sendKeys(zq);// 还款周期月

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

		String startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);
		String changereadonly = "$('input[name=online_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly);
		dr.findElement(By.name("online_time")).click();
		dr.findElement(By.name("online_time")).sendKeys(startDate);

		// Calendar cd = Calendar.getInstance();
		c.add(Calendar.MONTH, mylengh);

		String endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(c.getTime());
		System.out.println(endDate);
		dr.findElement(By.name("end_time")).click();
		dr.findElement(By.name("end_time")).sendKeys(endDate);

		// dr.findElement(By.xpath("//id[@value='']")).click();
		// dr.findElement(By.id("wrap")).findElement(By.className("qyzj-bm-btn")).click();
		// dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
		/*
		 * 无法通过页面获取点击状态，通过jquery获取到指定位置，点击
		 */
		String changereadonly2 = "$('#sub').click()";
		((JavascriptExecutor) dr).executeScript(changereadonly2);
		// dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(5000);
		dr.switchTo().alert().accept();
		Thread.sleep(3000);
		String ss1 = dr.switchTo().alert().getText();
		String ss2 = "添加成功!";
		if (ss1.contains(ss2)) {
			System.out.println("----->添加成功！");
		} else {
			System.out.println("----->添加失败！");
		}
		Thread.sleep(3000);

		dr.close();
		dr.quit();
	}

	private static void jQueryLoaded() {
		// TODO Auto-generated method stub

	}

	@BeforeMethod

	public void beforeMethod() throws Throwable {

	}

	@AfterMethod

	public void afterMethod() {

	}

}

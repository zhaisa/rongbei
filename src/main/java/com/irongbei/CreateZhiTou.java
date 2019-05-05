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
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rongbei.util.ReadFromTable;

@Test
public class CreateZhiTou {

	public void createZhiTou(String zq, int mylengh, int myyear, int mymonth, int myday) throws Exception {

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
		WebElement element3 = dr.findElement(By.xpath(".//*[@id='right-box']/p"));
		String obj1 = element3.getText().trim();
		System.out.println(obj1);
		String obj = "欢迎登录融贝网管理后台";
		if (obj1.contains(obj)) {
			System.out.println("sucess!");
		} else {
			System.out.println("登录失败 " + "");
		}
		System.out.println("Page title is: " + dr.getTitle());
		dr.findElement(By.linkText("项目管理")).click();
		Thread.sleep(1000);
		dr.findElement(By.partialLinkText("添加项目")).click();
		dr.findElement(By.id("project_type_pop")).findElement(By.id("Check2")).click();
		Thread.sleep(1000); // 停止1秒钟
		dr.findElement(By.id("project_type_pop")).findElement(By.id("pro_bottom_confirm")).click();
		String userunder = new SimpleDateFormat("yyyyMMddhhmmss").format(c.getTime());
		System.out.println(userunder);

		String user = "直投埋点-翟" + userunder;

		System.out.println(user);

		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Project/create");
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[1]/div[1]/input")).sendKeys(user);
		dr.findElement(By.id("project_num")).sendKeys(user);
		Select sn = new Select(dr.findElement(By.id("xuanzh")));
		sn.selectByValue("3");// 3为房抵贷
		Select sl = new Select(dr.findElement(By.name("real_payment")));

		sl.selectByValue("1");// 选择等额本息1为先息后本2为等额本息3为一次性还本付息
         Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[6]/div[7]/span/span[1]/span/span[2]")).click();
		
		//*[@id="right-box"]/div[2]/div[6]/div[7]/span/span[1]/span/span[2]/b
		//*[@id="right-box"]/div[2]/div[4]/div[19]/span/span[1]/span/span[2]
		//*[@id="right-box"]/div[2]/div[6]/div[6]/span/span[1]/span/span[2]
		Thread.sleep(2000);
		WebElement we = dr.findElement(By.className("select2-search__field"));

		Actions action = new Actions(dr);
		action.moveToElement(we).click();
		
		action.sendKeys("30428");
		action.moveToElement(we).perform();

		Thread.sleep(3000);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.ENTER);
		action.perform();

		Thread.sleep(5000);
		Select s3 = new Select(dr.findElement(By.name("contract_type")));
		Thread.sleep(2000);
		s3.selectByValue("31");// 直融——房贷(消费金融)——等额本息
		// dr.findElement(By.xpath("//*[@id=\"template_id\"]/option[16]")).click();
		Select s4 = new Select(dr.findElement(By.id("template_id")));
		// s4.selectByVisibleText("模板6");//选择模板6
		s4.selectByValue("295");// 选择acai测试模板—房抵贷
		Thread.sleep(3000);
		List<WebElement> list = dr.findElements(By.xpath("//input[@class='tc-name text-style']"));
		list.get(0).sendKeys("东风北桥");
		list.get(1).sendKeys("三室两厅");
		list.get(2).sendKeys("160平米");
		list.get(3).sendKeys("3000000元");
		dr.findElement(By.linkText("确定")).click();
		Thread.sleep(1000);
         dr.findElement(By.id("cycle")).sendKeys(zq);
		dr.findElement(By.id("p_sum")).sendKeys("0.1");// 输入金额1万
	//	dr.findElement(By.id("rate")).clear();
		Thread.sleep(1000);
	//	dr.findElement(By.id("rate")).sendKeys("8");// 年利率8%
		dr.findElement(By.id("cre_rate")).clear();
		dr.findElement(By.id("cre_rate")).sendKeys("12");
		dr.findElement(By.name("fixed_invest")).clear();
		dr.findElement(By.name("fixed_invest")).sendKeys("0");// 输入定投金额

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

		String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c.getTime());// 对日期进行格式化
		System.out.println(startDate);
		String changereadonly = "$('input[name=online_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly);
		dr.findElement(By.name("online_time")).click();
		dr.findElement(By.name("online_time")).clear();
		dr.findElement(By.name("online_time")).sendKeys(startDate);
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		c.add(Calendar.MONTH, mylengh);

		String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(c.getTime());
		System.out.println(endDate);
		String endattr = "$('input[name=end_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(endattr);
		dr.findElement(By.name("end_time")).clear();
		dr.findElement(By.name("end_time")).sendKeys(endDate);
		dr.findElement(By.name("credit_number")).sendKeys(startDate);
		Thread.sleep(1000);
		String changereadonly2 = "$('#sub').click()";
		((JavascriptExecutor) dr).executeScript(changereadonly2);
		// dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
		dr.switchTo().alert().accept();
		Thread.sleep(2000);
		   dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/project/index");
	        ReadFromTable rft=new ReadFromTable();
	        rft.readFromTable(dr, "//table/tbody", user);
	        Thread.sleep(3000);
		dr.close();
		dr.quit();
	}

	private static void jQueryLoaded() {

	}

	@BeforeMethod

	public void beforeMethod() throws Throwable {

	}

	@AfterMethod

	public void afterMethod() {

	}

}

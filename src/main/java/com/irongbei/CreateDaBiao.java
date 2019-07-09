package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CreateDaBiao {
	@Parameters({"zq","mylength","myyear","mymonth","myday","money","env","jiekuanren"})
	@Test
	public void createDaBiao(String zq, int mylength, int myyear, int mymonth, int myday,String money,String env,String jiekuanren) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar c = new GregorianCalendar();
		c.set(myyear, mymonth, myday);
		MyEnviment me=new MyEnviment();
		String beorback=env+"admin";
		String url=me.getEvi(env, beorback);
		
		dr.get(url+"/admin/login");

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
			System.out.println("登录成功!");
		} else {
			System.out.println("登录失败 " + "");
		}
		System.out.println("Page title is: " + dr.getTitle());
//		dr.findElement(By.xpath("//*[@id=\"left-nav\"]/ul/li[3]/span/a")).click();
//		dr.findElement(By.xpath(".//*[@id='left-nav']/ul/li[3]/ul/li[1]/a")).click();
//		dr.findElement(By.xpath(".//*[@id='right-box']/div[1]/span/a[1]")).click();
		dr.findElement(By.linkText("项目管理")).click();
		Thread.sleep(1000);
//		dr.findElement(By.partialLinkText("添加项目")).click();
//		dr.findElement(By.id("project_type_pop")).findElement(By.id("Check3")).click();
//		Thread.sleep(1000); // 停止1秒钟
//		dr.findElement(By.id("project_type_pop")).findElement(By.id("pro_bottom_confirm")).click();
        dr.navigate().to(url+"/admin/Project/editProject");
		String userunder = new SimpleDateFormat("yyMMddhhmmss").format(c.getTime());
		System.out.println(userunder);

		String user = "1.0省心投底层-翟" + userunder;//测试大标底层-翟

		System.out.println(user);
		dr.navigate().to(url+"/admin/Project/editProject");
		Thread.sleep(2000);
		dr.findElement(By.name("project_name")).sendKeys(user);
		dr.findElement(By.id("project_num")).sendKeys(user);
        Select s1=new Select(dr.findElement(By.name("real_payment")));
        s1.selectByValue("2");
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[3]/div[12]/span/span[1]/span/span[2]")).click();
		Thread.sleep(2000);
		WebElement we = dr.findElement(By.className("select2-search__field"));

		Actions action = new Actions(dr);
		action.moveToElement(we).click();
		if(env.equals("dev")) {action.sendKeys("21620");}
		else {
			action.sendKeys(jiekuanren);
		}
		
		action.moveToElement(we).perform();

		Thread.sleep(3000);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.ENTER);
		action.perform();

		Thread.sleep(2000);
		Select s3 = new Select(dr.findElement(By.name("contract_type")));

		s3.selectByValue("31");// 直融——车贷(消费金融)——等额本息

		Select s4 = new Select(dr.findElement(By.id("template_id")));
		// s4.selectByVisibleText("模板6");//选择模板6
		s4.selectByValue("295");// 房抵贷
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> list = dr.findElements(By.xpath("//input[@class='tc-name text-style']"));
		list.get(0).sendKeys("东风北桥");
		list.get(1).sendKeys("三室两厅");
		list.get(2).sendKeys("160平米");
		list.get(3).sendKeys("3000000元");
		dr.findElement(By.linkText("确定")).click();
		dr.findElement(By.name("cycle")).sendKeys(zq);// 还款周期月
		dr.findElement(By.id("p_sum")).sendKeys(money);// 输入金额1万
		Thread.sleep(1000);
//		dr.findElement(By.id("rate")).sendKeys("8");// 年利率8%
		dr.findElement(By.id("cre_rate")).clear();
		dr.findElement(By.id("cre_rate")).sendKeys("15");
		/**
		 * 大标没有定投
		 */
		// dr.findElement(By.name("fixed_invest")).clear();
		// dr.findElement(By.name("fixed_invest")).sendKeys("0");//输入定投金额
	

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
		dr.findElement(By.name("online_time")).clear();
		dr.findElement(By.name("online_time")).sendKeys(startDate);
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dr.switchTo().defaultContent();
		c.add(Calendar.MONTH, mylength);

		Date dt = c.getTime();// date就是你需要的时间

		String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dt);
		System.out.println(endDate);
		String changereadonly1 = "$('input[name=end_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly1);
		dr.findElement(By.name("end_time")).clear();
		dr.findElement(By.name("end_time")).sendKeys(endDate);
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.switchTo().defaultContent();
		dr.findElement(By.name("credit_number")).sendKeys(startDate);
		Thread.sleep(1000);
		// dr.findElement(By.xpath("//id[@value='']")).click();
		// dr.findElement(By.id("wrap")).findElement(By.className("qyzj-bm-btn")).click();
		// dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
		/*
		 * 无法通过页面获取点击状态，通过jquery获取到指定位置，点击
		 */
		String changereadonly2 = "$('#sub').click()";
		((JavascriptExecutor) dr).executeScript(changereadonly2);

//		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		dr.switchTo().alert().accept();

		// assertEaquls("添加成功";dr.findElement(By));
		Thread.sleep(5000);

		dr.close();
		dr.quit();

	}

	@BeforeMethod

	public void beforeMethod() throws Throwable {

	}

	@AfterMethod

	public void afterMethod() {

	}

}

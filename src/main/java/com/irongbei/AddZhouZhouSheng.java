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

import com.irongbeipages.LoginPage;

public class AddZhouZhouSheng {
	public void addZhouZhouSheng(String zq,String money,int mylength, int myyear, int mymonth, int myday) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		Calendar cc=new GregorianCalendar();
		cc.set(myyear, mymonth, myday);
		dr.get("http://dev-admin.irongbei.com/admin/login");
		LoginPage lp = new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		dr.findElement(By.linkText("项目管理")).click();
		Thread.sleep(1000);
		dr.findElement(By.partialLinkText("添加项目")).click();
		Thread.sleep(2000);
		dr.findElement(By.id("Check1")).click();
		dr.findElement(By.id("pro_bottom_confirm")).click();
		dr.navigate().to("http://dev-admin.irongbei.com/admin/Project/editProject?pjType=weekrise");
		String time=new SimpleDateFormat("HHmmss").format(cc.getTime());
		
		String name="测试周周升项目-"+time;
		System.out.println(name);
		dr.findElement(By.name("project_name")).sendKeys(name);
		dr.findElement(By.name("project_num")).sendKeys(name);
		Select ss1=new Select(dr.findElement(By.id("xuanzh")));//项目类型
		List<WebElement> list=ss1.getOptions();
		ss1.selectByVisibleText(list.get(0).getText());
		Select ss2=new Select(dr.findElement(By.name("real_payment")));//还款方式
		List<WebElement> list2=ss2.getOptions();
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[3]/div[10]/span/span[1]/span/span[2]")).click();
		Thread.sleep(2000);
		WebElement we = dr.findElement(By.className("select2-search__field"));

		Actions action = new Actions(dr);
		action.moveToElement(we).click();
		
		action.sendKeys("uat测试账户壹");
		action.moveToElement(we).perform();

		Thread.sleep(3000);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.ENTER);
		action.perform();
		Select s3 = new Select(dr.findElement(By.name("contract_type")));

		s3.selectByValue("31");// 直融——车贷(消费金融)——等额本息

		Select s4 = new Select(dr.findElement(By.id("template_id")));
		// s4.selectByVisibleText("模板6");//选择模板6
		s4.selectByValue("295");// 房抵贷
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> list3 = dr.findElements(By.xpath("//input[@class='tc-name text-style']"));
		list3.get(0).sendKeys("东风北桥");
		list3.get(1).sendKeys("三室两厅");
		list3.get(2).sendKeys("160平米");
		list3.get(3).sendKeys("3000000元");
		dr.findElement(By.linkText("确定")).click();
		dr.findElement(By.name("cycle")).sendKeys(zq);// 还款周期月
		dr.findElement(By.id("p_sum")).sendKeys(money);// 输入金额1万
		Thread.sleep(1000);
//		dr.findElement(By.id("rate")).sendKeys("8");// 年利率8%
		dr.findElement(By.id("cre_rate")).clear();
		dr.findElement(By.id("cre_rate")).sendKeys("15");
		JavascriptExecutor jse = (JavascriptExecutor) dr;
		Boolean loaded;
		try {
			loaded = (Boolean) jse.executeScript("return " + "jQuery()!=null");
		} catch (WebDriverException e) {
			loaded = false;
		}
		String startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(cc.getTime());// 对日期进行格式化
		System.out.println(startDate);
		String changereadonly = "$('input[name=online_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly);
	//	dr.findElement(By.name("online_time")).click();
		dr.findElement(By.name("online_time")).sendKeys(startDate);
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        dr.switchTo().defaultContent();
		cc.add(Calendar.MONTH, mylength);

		Date dt = cc.getTime();// date就是你需要的时间

		String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(dt);
		System.out.println(endDate);
		String changereadonly1 = "$('input[name=end_time]').attr(\"readonly\",false)";
		((JavascriptExecutor) dr).executeScript(changereadonly1);
//		dr.findElement(By.name("end_time")).click();
		dr.findElement(By.name("end_time")).sendKeys(endDate);
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.switchTo().defaultContent();
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
}

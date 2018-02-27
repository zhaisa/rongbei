package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheLiangDiZhiYaLuRu {

	public void luRu(String login) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
		dr.get("http://test-risk.irongbei.com/");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		dr.findElement(By.id("username")).clear();
		dr.findElement(By.id("username")).sendKeys(login);
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("123456");
		dr.findElement(By.id("login")).click();
		dr.navigate().to("http://test-risk.irongbei.com/index/main.html");
		dr.switchTo().frame("leftmenu");
		dr.findElement(By.cssSelector("dt")).click();
		// dr.findElement(By.xpath("//a[@href='http://test-risk.irongbei.com/carloan/add.html']")).click();
		dr.navigate().to("http://test-risk.irongbei.com/carloan/add.html");
		dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// dr.switchTo().defaultContent();

		dr.findElement(By.name("cooperid")).click();
		Select danbaogongsi = new Select(dr.findElement(By.name("cooperid")));
		danbaogongsi.selectByVisibleText("久鼎");
		// dr.findElement(By.id("province")).click();
		// Select pro = new Select(dr.findElement(By.id("province")));
		// pro.selectByValue("370000");
		// dr.findElement(By.id("city")).click();
		// Select city=new Select(dr.findElement(By.id("city")));
		// city.selectByValue("330500");
		// dr.findElement(By.id("area")).click();
		// Select area=new Select(dr.findElement(By.id("area")));
		// area.selectByValue("330523");
		dr.findElement(By.name("age")).sendKeys("45");
		dr.findElement(By.name("iphone")).sendKeys("17409090001");
		dr.findElement(By.name("businesstype")).click();
		Select yewuleixing = new Select(dr.findElement(By.name("businesstype")));
		yewuleixing.selectByValue("质押");
		dr.findElement(By.name("name")).sendKeys("牧云" + time);
		dr.findElement(By.name("idcard")).sendKeys("11022119800101491X");
		dr.findElement(By.id("province1")).click();
		Select pro1 = new Select(dr.findElement(By.id("province1")));
		pro1.selectByValue("370000");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		dr.findElement(By.id("city1")).click();
		Select city1 = new Select(dr.findElement(By.id("city1")));
		city1.selectByValue("370600");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		dr.findElement(By.id("area1")).click();
		Select area1 = new Select(dr.findElement(By.id("area1")));
		area1.selectByValue("370681");
		dr.findElement(By.name("pro2info")).sendKeys("都市大道，髡街");
		dr.findElement(By.id("province2")).click();
		Select lianxidizhi = new Select(dr.findElement(By.id("province2")));
		lianxidizhi.selectByValue("110000");
		dr.findElement(By.id("city2")).click();
		Select city2 = new Select(dr.findElement(By.id("city2")));
		city2.selectByValue("110100");
		dr.findElement(By.id("area2")).click();
		Select area2 = new Select(dr.findElement(By.id("area2")));
		area2.selectByValue("110109");
		dr.findElement(By.name("pro3info")).sendKeys("天桥大地下，住这一群鸭");
		dr.findElement(By.name("workname")).sendKeys("HongKong 九龙");
		dr.findElement(By.name("amountd")).sendKeys("100000");
		dr.findElement(By.name("termd")).sendKeys("16");
		dr.findElement(By.name("usaged")).sendKeys("花天酒地");
		dr.findElement(By.name("source")).sendKeys("打家劫舍");
		dr.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div/dl[1]/dd[17]/div[2]")).click();
		Select jiekuanstyle = new Select(dr.findElement(By.name("businesstypescx")));
		jiekuanstyle.selectByValue("企业贷");// 还有 个人贷
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dr.findElement(By.name("Subsector")).click();
		Select ss = new Select(dr.findElement(By.name("Subsector")));
		ss.selectByVisibleText("7、交通运输、仓储和邮政业");
		// if(dr.findElement(By.linkText("法人信息")).isDisplayed()) {
		dr.findElement(By.name("corporatename")).sendKeys("测试翟企业---" + time);
		dr.findElement(By.name("bossname")).sendKeys("MRzhai");
		dr.findElement(By.name("registeredcapital")).sendKeys("100000000000000000000000000000000");
		dr.findElement(By.name("registeredarea")).sendKeys("皇后大道");

		dr.findElement(By.id("carname_1")).sendKeys("路虎");
		dr.findElement(By.id("cartape_1")).sendKeys("RANGERIVER");
		dr.findElement(By.id("carcolor_1")).sendKeys("yellow");
		dr.findElement(By.id("carnumber_1")).sendKeys("1987900---1-11-1---1");
		dr.findElement(By.id("carengine_1")).sendKeys("LU---1----2----2---3---3--33-3-3-");

		dr.findElement(By.id("carbuydate_1")).sendKeys(time);
		dr.findElement(By.id("carkm_1")).sendKeys("10000");
		dr.findElement(By.id("cartransfer_1")).sendKeys("3");
		dr.findElement(By.id("carmoney_1")).sendKeys("832492");
		// dr.findElement(By.id("ossupppp")).click();
		// dr.findElement(By.id("selectfiles")).click();

		// dr.findElement(By.name("savetype")).click(); //保存

		dr.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div/div/div/button[2]")).click();// 提交
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
   
    		  
		dr.close();
		dr.quit();

	}

}

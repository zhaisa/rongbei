package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FangDiDaiShenHe {
	public void shenHe() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
		dr.get("http://test-management.irongbei.com");
		dr.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		dr.findElement(By.id("username")).clear();
		dr.findElement(By.id("username")).sendKeys("hometest2");
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("123456");
		dr.findElement(By.id("login")).click();
		dr.navigate().to("http://test-management.irongbei.com/index/main.html");
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.switchTo().frame("leftmenu");
		dr.findElement(By.cssSelector("dt")).click();
		dr.navigate().to(dr.findElement(By.linkText("审核列表")).getAttribute("href"));
		WebElement we = dr.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/dl/dd/div/table/tbody"));
		List<WebElement> trlist = we.findElements(By.tagName("tr"));
		List<String> url2 = new ArrayList<String>();
		Map<String, String> listmap = new HashMap();
		for (WebElement row : trlist) {
			String trText = row.getText();
			System.out.println(trText);
			List<WebElement> td = row.findElements(By.tagName("td"));
			System.out.println(td.get(0).getText());
			for (WebElement col : td) {
				if (trText.contains("牧云20180309") && col.getText().equals("初审待审")) {

					listmap.put("借款编号", td.get(0).getText());
					listmap.put("合作机构", td.get(1).getText());
					listmap.put("地区", td.get(2).getText());
					listmap.put("利率", td.get(3).getText());
					listmap.put("姓名", td.get(4).getText());
					listmap.put("身份证号", td.get(5).getText());
					listmap.put("项目类型", td.get(6).getText());
					listmap.put("订单类型", td.get(7).getText());
					listmap.put("融资金额", td.get(8).getText());
					listmap.put("借款期限", td.get(9).getText());
					listmap.put("申请时间", td.get(10).getText());
					listmap.put("审核时间", td.get(11).getText());
					listmap.put("放款时间", td.get(12).getText());
					listmap.put("项目状态", td.get(13).getText());
					listmap.put("资料补充", td.get(14).getText());
					listmap.put("操作", td.get(15).getText());
				}

			}

		}
		System.out.println(listmap.values());
		for (WebElement row : trlist) {
			String trText1 = row.getText();
			if (trText1.contains((CharSequence) listmap.get("姓名"))) {
				String url = row.findElement(By.linkText("查看详情")).getAttribute("href");
				url2.add(url);

				break;
			}

		}
		System.out.println(url2.get(0));
		dr.navigate().to(url2.get(0));
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.findElement(By.linkText("风控初审")).click();

		dr.navigate().to(dr.findElement(By.linkText("风控初审")).getAttribute("href"));
		List<WebElement> radio1 = dr.findElements(By.name("loan_com_info"));
		radio1.get(0).click();
		boolean isSelected1 = radio1.get(0).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected1);
		List<WebElement> radio2 = dr.findElements(By.name("businesslicenser"));
		radio2.get(1).click();
		boolean isSelected2 = radio2.get(1).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected2);
		List<WebElement> radio3 = dr.findElements(By.name("hkbxx"));
		radio3.get(0).click();
		boolean isSelected3 = radio3.get(0).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected3);
		List<WebElement> radio4 = dr.findElements(By.name("blacklistindustryr"));
		radio4.get(1).click();
		boolean isSelected4 = radio4.get(1).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected4);
		List<WebElement> radio5 = dr.findElements(By.name("registrationr"));
		radio5.get(0).click();
		boolean isSelected5 = radio5.get(0).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected5);
		List<WebElement> radio6 = dr.findElements(By.name("carbookr"));
		radio6.get(1).click();
		boolean isSelected6 = radio6.get(1).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected6);
		List<WebElement> radio7 = dr.findElements(By.name("carphoner"));
		radio7.get(0).click();
		boolean isSelected7 = radio7.get(0).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected7);
		List<WebElement> radio8 = dr.findElements(By.name("fscxdtr"));
		radio8.get(1).click();
		boolean isSelected8 = radio8.get(1).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected8);
		List<WebElement> radio9 = dr.findElements(By.name("dsfcxr"));
		radio9.get(1).click();
		boolean isSelected9 = radio9.get(0).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected9);
		List<WebElement> radio10 = dr.findElements(By.name("xhzpr"));
		radio10.get(0).click();
		boolean isSelected10 = radio10.get(0).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected10);
		List<WebElement> radio11 = dr.findElements(By.name("zxbgr"));
		radio11.get(1).click();
		boolean isSelected11 = radio11.get(1).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected11);

		dr.findElement(By.name("loan_com_info_bz")).sendKeys("借款企业信息");
		dr.findElement(By.name("businesslicense")).sendKeys("身份证信息");
		dr.findElement(By.name("hkbxxr")).sendKeys("户口本信息");
		dr.findElement(By.name("blacklistindustry")).sendKeys("婚姻证明");
		dr.findElement(By.name("registration")).sendKeys("人法执行/犯罪记录");
		dr.findElement(By.name("carbook")).sendKeys("房本信息");
		dr.findElement(By.name("carphoner7")).sendKeys("房屋现场勘查记录表");
		dr.findElement(By.name("fscxdt")).sendKeys("房产评估信息");
		dr.findElement(By.name("dsfcx")).sendKeys("第三方查询表");
		dr.findElement(By.name("xhzp")).sendKeys("下户照片");
		dr.findElement(By.name("zxbg")).sendKeys("征信报告");
		dr.findElement(By.name("zlshjlvalue")).sendKeys("the last news");
		dr.findElement(By.name("fkzydyl_zy")).sendKeys("38%");
		dr.findElement(By.name("fkzgvalue_zy")).sendKeys("the lastest news");
		dr.findElement(By.xpath("/html/body/div/div/div[2]/form/div/dl[2]/div[2]/div/input[5]")).click();
		
		
		dr.close();
		dr.quit();
	}
}
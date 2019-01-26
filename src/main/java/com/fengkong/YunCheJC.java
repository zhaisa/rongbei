package com.fengkong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YunCheJC {
	public static void main(String[] args) throws InterruptedException {
		testJC();
	}
public static void testJC() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	WebDriver dr = new ChromeDriver();
	dr.get("http://riskbusiness.irongbei.com");
	dr.findElement(By.id("username")).clear();
	dr.findElement(By.id("username")).sendKeys("yctestlgt");
	dr.findElement(By.id("password")).clear();
	dr.findElement(By.id("password")).sendKeys("123456");
	
//	dr.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
//	dr.get("http://riskbusiness.irongbei.com/index/verify.html");
	System.out.println("请输入验证码：");
	Scanner scan = new Scanner(System.in);
	if (scan.hasNext()) {

		String str1 = scan.next();
	//	System.out.println("输入的数据为：" + str1);
		dr.findElement(By.id("verify")).sendKeys(str1);
		dr.findElement(By.id("login")).click();
	}
	Thread.sleep(200);
	
	
//	dr.navigate().to("http://riskbusiness.irongbei.com/lonloan/index.html");
	dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	dr.switchTo().frame("leftmenu");
	dr.findElement(By.cssSelector("dt")).click();
	dr.navigate().to(dr.findElement(By.linkText("审核列表")).getAttribute("href"));
	Thread.sleep(200);
	
	
	WebElement we = dr.findElement(By.xpath("/html/body/div[1]/div/form/div/div/dl[2]/dd/div/table/tbody"));
	List list1=new ArrayList();
	List<WebElement> trlist = we.findElements(By.tagName("tr"));
	List<String> url2 = new ArrayList<String>();
	Map<String, String> listmap = new HashMap();
	
	for (WebElement row : trlist) {
		String trText = row.getText();
//		System.out.println(trText);
		List<WebElement> td = row.findElements(By.tagName("td"));
		System.out.println(td.get(0).getText());
		list1.add(td.get(0).getText());
		for (WebElement col : td) {
		if(td.get(13).getText().equals("放款")||td.get(13).getText().equals("还款")||td.get(13).getText().equals("终审完成")||td.get(13).getText().equals("结清")) {
				listmap.put("借款编号", td.get(0).getText());
				listmap.put("姓名", td.get(1).getText());
				listmap.put("身份证号", td.get(2).getText());
				listmap.put("项目状态", td.get(13).getText());
				listmap.put("资料补充", td.get(14).getText());
				listmap.put("操作", td.get(15).getText());
		}

		}
	
	
	}
	

	for(int j=0;j<232;j++) {
		
		dr.findElement(By.linkText("下一页")).click();
		Thread.sleep(200);
		 String currentWindow = dr.getWindowHandle();
		    Set<String> handles = dr.getWindowHandles();
			Iterator<String> it= handles.iterator();
			while (it.hasNext()) {
				String handle = it.next();
				if (currentWindow.equals(handle))
					continue;
				WebDriver window = dr.switchTo().window(handle);
				System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
				String sss1 = window.getCurrentUrl();
				dr.navigate().to(sss1);
				}
		   
	
	
		Thread.sleep(1000);
		WebElement we2 = dr.findElement(By.xpath("/html/body/div[1]/div/form/div/div/dl[2]/dd/div/table/tbody"));
		List<WebElement> trlist2 = we2.findElements(By.tagName("tr"));
		for (WebElement row : trlist2) {
			String trText = row.getText();
//			System.out.println(trText);
			List<WebElement> td = row.findElements(By.tagName("td"));
			System.out.println(td.get(0).getText());
			list1.add(td.get(0).getText());
//			dr.findElement(By.linkText("查看详情")).click();
//			dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			for (WebElement col : td) {
			if(td.get(13).getText().equals("放款")||td.get(13).getText().equals("还款")||td.get(13).getText().equals("终审完成")||td.get(13).getText().equals("结清")) {
					listmap.put("借款编号", td.get(0).getText());
					listmap.put("姓名", td.get(1).getText());
					listmap.put("身份证号", td.get(2).getText());
					listmap.put("项目状态", td.get(13).getText());
					listmap.put("资料补充", td.get(14).getText());
					listmap.put("操作", td.get(15).getText());
			}

			}
			
		}		
	
	}
	
	for(int i=0;i<list1.size();i++) {
//	System.out.println(list1.get(i));
	String id=(String)list1.get(i);
	String url5="http://riskbusiness.irongbei.com/lonloan/add.html?id=";
	String url51="&pro=1";
	System.out.println(id);
	dr.get(url5+id+url51);
	dr.get("http://riskbusiness.irongbei.com/lonloan/results.html?id="+id+"&pro=1");
	dr.get("http://riskbusiness.irongbei.com/lonloan/finald.html?id="+id+"&pro=3011");
	dr.get("http://riskbusiness.irongbei.com/lonloan/fresults.html?id="+id+"&pro=3019");
	dr.get("http://riskbusiness.irongbei.com/lonloan/finalded.html?id="+id+"&pro=5011");
	dr.get("http://riskbusiness.irongbei.com/lonloan/fresultsed.html?id="+id+"&pro=5019");
}
}
}

package com.irongbei;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class SitAndUat {
public void sit(int varzhai) throws IOException {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
	WebDriver dr = new ChromeDriver();
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
	// dr.get("http://rongbeiadmin.51dmoz.com/admin/Index/index");
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
	dr.findElement(By.linkText("平台数据统计")).click();

	// dr.findElement(By.xpath("//*[@id=\"left-nav\"]/ul/li[11]/ul/li[6]/a")).click();
	dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Statistics/jxUserCapitalManage");
	dr.findElement(By.id("operatepwd")).sendKeys("123456");
	dr.findElement(By.linkText("确定")).click();
	dr.navigate().to(
			"http://rongbeiadmin.51dmoz.com/admin/Statistics/jxUserCapitalManage?sign=bf042569ae6d7d6bfeb78a2c4560d8af");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	int lineNo = varzhai;
	ReadTxt rt = new ReadTxt();
	String a = rt.readFS("D:/users/allusers.txt", lineNo);
	

	dr.findElement(By.id("username")).sendKeys(a);
	dr.findElement(By.id("userlistbutton")).click();
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	WebElement we = dr.findElement(By.xpath(".//*[@id='right-box']/div[2]/div[2]/table/tbody"));
	List<WebElement> trlist = we.findElements(By.tagName("tr"));
	List<String> url2 = new ArrayList<String>();
	Map<String,String> listmap = new HashMap();
	for (WebElement row : trlist) {
		String trText = row.getText();
//		System.out.println(trText);
		List<WebElement> td = row.findElements(By.tagName("td"));
		System.out.println(td.get(7).getText());
		for (WebElement col : td) {
			listmap.put("用户ID", td.get(0).getText());
			listmap.put("用户名", td.get(1).getText());  
			listmap.put("江西账户可用余额", td.get(7).getText());	          
	}

	}
	System.out.println("============放入map的数据========");
	System.out.println(listmap.values());
//	System.out.println(listmap.keySet());
	List<String> sit =new ArrayList();
	List<String> uat =new ArrayList();
	File ff=new File("D:\\users\\situser.txt");
	FileWriter fw=new FileWriter(ff,true);
	BufferedWriter bw = new BufferedWriter(fw);
	File ff1=new File("D:\\users\\uatuser.txt");
	FileWriter fw1=new FileWriter(ff1,true);
	BufferedWriter bw1 = new BufferedWriter(fw1);
	
	
	if(listmap.get("江西账户可用余额").contains("--")) {
		sit.add(a);
		
		
	}else{
		uat.add(a);
	}
	for(int j=0;j<sit.size();j++) {
		System.out.println("===================>我要的sit结果<===========");
		System.out.println(sit.get(j));
		bw.write("\r\n"+sit.get(j));
	}
	for(int z=0;z<uat.size();z++) {
		System.out.println("===================>我要的uat结果<===========");
		System.out.println(uat.get(z));
		bw1.write("\r\n"+uat.get(z));
	}
bw1.flush();
bw.flush();
	dr.quit();
	bw1.close();
	fw1.close();
	bw.close();
	fw.close();
}
}

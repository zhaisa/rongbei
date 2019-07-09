package com.irongbei;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyXiaoBiao {
	public void testPlan(String name,int id,String money) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");


//		ReadTxt rt = new ReadTxt();
//		String a = rt.readFS("D:/users/usertext1.txt", lineNo);

		dr.findElement(By.id("user_name")).sendKeys(name);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
for(int i=0;i<10;i++) {
		String aaa="http://testhf.irongbei.com/index/pdetail?id=";
		dr.navigate().to(aaa+id);
		
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys(money);
		dr.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[1]/div/div/div[2]/div/div[5]/div/img")).click();
		dr.findElement(By.id("investSubmit")).click();
		GetNextHandle gn=new GetNextHandle();
		gn.getNextHandle(dr);
		Thread.sleep(2000);
		dr.findElement(By.className("magBtn")).click();
		Thread.sleep(1000);
		String currentWindow = dr.getWindowHandle();
		// 得到所有窗口的句柄
		Set<String> handles = dr.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = dr.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
			String sss = window.getCurrentUrl();
			dr.navigate().to(sss);
            Thread.sleep(3000);
			dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
			dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
			dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
			Thread.sleep(3000);
		}
}
		dr.close();
		dr.quit();

	}

}
package com.irongbei;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ZZSTuiChu {

	@Parameters({"user","env"})
	@Test(threadPoolSize=2)
	public void zzsTuiChu(String user, String env) throws InterruptedException {
		CreateDriver cd = new CreateDriver();
		WebDriver dr = CreateDriver.getDriver("chrome");
		MyEnviment me = new MyEnviment();

		String url = me.getEvi(env, env);
		dr.get(url + "/?version=2");
		dr.get(url + "/UserLogin/index");
		// ReadTxt rt = new ReadTxt();
		// String username = rt.readFS("D:\\users\\usertext1.txt", lineNo);
		dr.findElement(By.id("user_name")).sendKeys(user);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to(url + "/UserCenter/index");
		Thread.sleep(2000);
		dr.findElement(By.linkText("周周升")).click();
		String url1 = dr.findElement(By.linkText("周周升")).getAttribute("href");
		dr.navigate().to(url1);
		Thread.sleep(100);
//		dr.navigate().to("http://testhf.irongbei.com/UserCenter/weekjoinlist?page=11");
		for(int i=0;i<2000;i++) {
			if(dr.findElement(By.linkText("申请退出")).isDisplayed()) {
			dr.findElement(By.linkText("申请退出")).click();
			Thread.sleep(100);
			dr.findElement(By.linkText("确认退出")).click();
			Thread.sleep(1000);
		
			dr.findElement(By.linkText("确定")).click();
			Thread.sleep(1000);
		}else {
			System.out.println("沒有可退出的週週升数据了！！！");
			break;
		}
		}
		dr.close();
		dr.quit();

	}
}

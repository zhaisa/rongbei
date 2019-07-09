package com.irongbei;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShengXinTouTuiChu {
	@Parameters({ "user", "env", "datetime" })
	@Test(invocationCount = 1)
	public void sxttc(String user, String env, String datetime) throws InterruptedException {
		CreateDriver cd = new CreateDriver();
		WebDriver dr = cd.getDriver("chrome");
		MyEnviment me = new MyEnviment();

		String url = me.getEvi(env, env);
		dr.get(url + "/?version=1");
		dr.get(url + "/UserLogin/index");
		dr.findElement(By.id("user_name")).sendKeys(user);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to(url + "/UserCenter/index");
		Thread.sleep(2000);
		dr.findElement(By.linkText("省心投")).click();
		String url1 = dr.findElement(By.linkText("省心投")).getAttribute("href");
		System.out.println(url1);
		dr.navigate().to(url1);
		Thread.sleep(1000);
		String url11 = dr.findElement(By.linkText("尾页")).getAttribute("href");
		String[] page = url11.split("page=");
		String pages = page[1];
		System.out.println(pages);
		int allpage = Integer.parseInt(pages);

		List<String> list2 = new ArrayList<String>();
		for (int i = 1; i <= allpage; i++) {
			String url22="http://testhf.irongbei.com/UserCenter/finplann?page="+i;
			dr.navigate().to(url22);
			List<WebElement> list1 = dr.findElements(By.linkText("退出"));
			for (WebElement webele : list1) {
				String url2 = webele.getAttribute("href");
				System.out.println(url2);
				if (url2.contains("UserCenter/mixSetDebt?plan_id")) {
					list2.add(url2);
				}
			}
		}
		 for(String myurl:list2) {
		 System.out.println(myurl);
		 dr.navigate().to(myurl);
		 Thread.sleep(100);
		 dr.findElement(By.name("phoneCode")).clear();
		 dr.findElement(By.name("phoneCode")).sendKeys(datetime);
		 Thread.sleep(200);
		 dr.findElement(By.id("next_step")).click();
		
		 GetNextHandle2 gnh1=new GetNextHandle2();
		 gnh1.getNextHandle(dr);
		 Thread.sleep(1000);
		 }

		dr.close();
		dr.quit();

	}
}

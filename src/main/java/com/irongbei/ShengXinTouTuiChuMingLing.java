package com.irongbei;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShengXinTouTuiChuMingLing {
	@Parameters({ "user", "env", "datetime" })
	@Test(invocationCount = 1)
	public void sxttcml(String user, String env, String datetime) throws InterruptedException {
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
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
		Thread.sleep(100);
		dr.findElement(By.linkText("退出中")).click();
		Thread.sleep(100);
		String url11 = dr.findElement(By.linkText("尾页")).getAttribute("href");
		String[] page = url11.split("page=");
		String pages = page[1];
		int allpage = Integer.parseInt(pages);
		for (int i = 1; i <= allpage; i++) {
			String url22 = url + "/UserCenter/finplann?status=2&page=";
			String url33 = url22 + i;
			dr.get(url33);
			List<WebElement> list1 = dr.findElements(By.linkText("查看"));

			for (WebElement webele : list1) {
				String url2 = webele.getAttribute("href");
				System.out.println(url2);
				if (url2.contains("UserCenter/listofclaims")) {
					list2.add(url2);
				}
			}

		}

		// WebElement
		// we=dr.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/div[2]/div/div[3]/ul"));
		// List<WebElement> list4=we.findElements(By.tagName("li"));
		// List<String> list5=new ArrayList<String>();
		// for(int i=0;i<list4.size();i++) {
		//
		// String url7=list4.get(i).findElement(By.xpath("//a")).getAttribute("href");
		// System.out.println("------------------>"+url7);
		// }

		for (String myurl : list2) {
			// System.out.println(myurl);
			String[] pid = myurl.split("pid=");

			list3.add(pid[1]);

			// System.out.println(pid[1]);

		}

		System.out.println(list3.size());
		for (String bb : list3) {
			String url44 = null;
			if (env.equals("test")) {
				url44 = "http://rongbeiadmin.51dmoz.com";
			} else {
				url44 = "http://dev-admin.irongbei.com";
			}
			String url3 = url44 + "/FinancialQuitTask/pushClaimsData?join_id=";

			String url4 = url3 + bb;
			System.out.println(url4);
			dr.get(url4);
			Thread.sleep(2000);

		}

		dr.close();
		dr.quit();

	}
}

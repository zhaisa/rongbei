package com.irongbei;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KaiTongCunGan {
	public static void testPlan(int varzhai) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 这一步必不可少
		WebDriver dr = new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index");

		// File file = new File("D:\\users\\usertext.txt");
		//
		// FileReader fr=new FileReader(file);
		// BufferedReader br = new BufferedReader (fr);
		// String s=br.readLine();

		int lineNo = varzhai;
		int i = 0;
		int j = 0;
		String a = "";
		String b = "";
		FileReader fr = null;
		try {
			fr = new FileReader("D:\\users\\usertext1.txt");// 读取用户名文件
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				if (lineNo == i) {
					a = line;
				}
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(a);

		dr.findElement(By.id("user_name")).sendKeys(a);
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");

		// if(linkText("开通江西银行存管账户").isDisplayed()) {
		// dr.close();
		// }
		dr.findElement(By.linkText("开通江西银行存管账户")).click();
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/jxaccount");
		dr.findElement(By.id("realname")).clear();
		dr.findElement(By.id("realname")).sendKeys("测试刘");
		dr.findElement(By.id("usercode")).clear();

		try {
			fr = new FileReader("D:\\users\\usercard.txt");// 读取身份证号码文件
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br1 = new BufferedReader(fr);
		String line1 = "";
		try {
			while ((line1 = br1.readLine()) != null) {
				if (lineNo == j) {
					b = line1;
				}
				j++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b);

		dr.findElement(By.id("usercode")).sendKeys(b);
		dr.findElement(By.id("bankcard")).clear();
		dr.findElement(By.id("bankcard")).sendKeys("6228481234567890001");

		String changereadonly2 = "$('#resend').click()";
		((JavascriptExecutor) dr).executeScript(changereadonly2);
		Thread.sleep(2000);
		dr.findElement(By.id("phoneyz")).clear();
		dr.findElement(By.id("phoneyz")).sendKeys("111111");
		dr.findElement(By.linkText("同意并开通银行存管账户")).click();

		dr.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

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
			Thread.sleep(2000);
			dr.findElement(By.xpath("//*[@id=\"encPin1\"]")).clear();
			dr.findElement(By.xpath("//*[@id=\"encPin1\"]")).sendKeys("123456");
			dr.findElement(By.xpath("//*[@id=\"encPin2\"]")).clear();
			dr.findElement(By.xpath("//*[@id=\"encPin2\"]")).sendKeys("123456");
			dr.findElement(By.id("sub")).click();
			Thread.sleep(3000);

			fr.close();
			dr.close();

			dr.quit();
		}
	}

	private static WebElement linkText(String string) {

		return null;
	}
}
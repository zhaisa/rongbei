package com.rongbei.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.DriverFactory;

/**
 * 本类是实现截图功能的工具，可被别的类调用进行截图，例如在用例失败时就可以进行截图
 * 
 * @author Administrator
 *
 */
public class Screenshot {
	public static WebDriver driver = null;

	public static void main(String[] args) {

		driver = DriverFactory.getDriver("firefox");
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		if (waitForPageLoad()) {// 如果页面加载完成就截图
			Screenshot.takeScreenshot(driver);
		}
	}

	// 判断页面是否加载完成
	public static boolean waitForPageLoad() {
		return new WebDriverWait(driver, 100).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	public static String takeScreenshot(WebDriver driver) {
		// 第一种方法：使用new Date().getTime()，得出的日期是一串看不懂的数字
		// String screenname=String.valueOf(new Date().getTime()+".jpg");
		// 第二种方法：使用封装好的获取指定格式时间的方法，得出的日期是一眼即识的日期
		String screenname = DateHandler_shijianchuli.getTimeStamp() + ".jpg";

		File dir = new File("test-output/snapshot");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String screenpath = dir.getAbsolutePath() + "/" + screenname;
		takeScreenshot(driver, screenpath);
		return screenname;
	}

	private static void takeScreenshot(WebDriver driver, String screenPath) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);// 得到截图文件
			FileUtils.copyFile(srcFile, new File(screenPath));// 将文件放到上面设置的路径里
			System.out.println(srcFile);// 打印出来是：C:\Users\ADMINI~1\AppData\Local\Temp\screenshot161571127235950789.png
		} catch (IOException e) {
			System.out.println("截图异常！");
		}
	}

}

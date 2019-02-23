package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 本类是封装的驱动工厂，根据传进来的浏览器类型得到相应的driver
 * @author Administrator
 *
 */
public class DriverFactory {
	// private static WebDriver driver = null;

	/*
	 * public static synchronized WebDriver getDriver(String type) { if (driver
	 * == null) { driver = createDriver(type); } return driver; }
	 */

	// getDriver方法重载1
	public static WebDriver getDriver(String type) {
		return createDriver(type, null);
	}

	// getDriver方法重载2
	public static WebDriver getDriver(String type, Object parameter) {
		return createDriver(type, parameter);
	}

	private static WebDriver createDriver(String type, Object parameter) {
		WebDriver driver = null;
		switch (type.toLowerCase()) {
		case "firefox":
			driver = createFirefoxDriver(parameter);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "source/chromedriver.exe");
			driver = createChromeDriver(parameter);
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "source/IEDriverServer.exe");
			driver = createInternetExplorerDriver();
			break;
		default:
			System.out.println("Error: Invalid Browser Type!");
			break;
		}

		return driver;
	}

	private static WebDriver createInternetExplorerDriver() {
		return new InternetExplorerDriver();
	}

	private static WebDriver createChromeDriver(Object parameter) {
		WebDriver driver = null;
		if (parameter == null) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver((ChromeOptions) parameter);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 这行是让本driver的每个页面都加超时等待（页面加载最长等30秒，超30秒才报错）
		return driver;
	}

	private static WebDriver createFirefoxDriver(Object parameter) {
		WebDriver driver = null;
		if (parameter == null) {
			driver = new FirefoxDriver();
		} else {
			driver = new FirefoxDriver((Capabilities) parameter);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// 这行是让本driver的每个页面都加超时等待（页面加载最长等30秒，超30秒才报错）
		return driver;
	}
}

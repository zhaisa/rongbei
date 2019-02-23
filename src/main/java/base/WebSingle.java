package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * 本类是单个用例调试运行的模板，case继承于本类后，就可以跑单个用例
 * 
 * @author Administrator
 *
 */
public class WebSingle extends TestBase {
	protected Locator locator;
	protected CheckPoint cp;
	protected static WebDriver driver;
	protected static API api = null;

	// Class开始之前，创建driver、checkPoint、locator、api对象
	@BeforeClass
	public synchronized void beforeCase() {
		driver = DriverFactory.getDriver("firefox");
		cp = new CheckPoint(this.getClass().getSimpleName(), driver);// 反射，谁调用就是谁的名字
		locator = new Locator(driver, "object_yuansuduixiangku.xml", 30, 30);
		api = new API(driver);
	}

	// class结束之后，关闭、退出driver
	@AfterClass
	public void afterCase() {
		driver.close();
		driver.quit();
	}
}

package base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

/**
 * 本类是case的父类，实现定制测试执行流程的功能
 * 本类是批量正式测试的模板，指定了Test开始之前、Class开始之前和Test结束之后的一些操作
 * @author Administrator
 *
 */
public class WebSuite extends TestBase {
	protected static Locator locator = null;
	
	protected static WebDriver driver = null;
	protected static API api = null;
	protected CheckPoint cp = null;
	
	public static List<String> resultLog = new ArrayList<String>();// 各case中调用此方法，会将测试结果信息存入这个list中，方便测试报告、测试邮件等使用

	@BeforeTest  //所有测试（suite.xml文件里的那个test）开始之前执行，new一个浏览器，new一个api，new一个locator
	@Parameters({ "browserType" })  //启什么浏览器就配置在suite.xml文件里（使用@Parameters注解）
	public void setup(String browserType) {
		driver = DriverFactory.getDriver(browserType);
		api = new API(driver);
		locator = new Locator(driver, "object_yuansuduixiangku.xml", 30, 30);
	}

	// 每个.java测试脚本开始之前new一个CheckPoint，用完就没了，所以cp不用设成静态成员变量
	@BeforeClass
	public void beforeClass() {
		cp = new CheckPoint(this.getClass().getName(), driver);
	}

	// 在suite.xml文件里的那个test跑完之后，执行下面的方法，关掉driver及窗口
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}
}

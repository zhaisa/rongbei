package base;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 本类是封装的登录、获取订单信息的方法
 * 
 * @author Administrator
 *
 */
public class Actions {

	private WebDriver driver;
	private Locator locator;

	public Actions(WebDriver driver) {
		this.driver = driver;
		this.locator = new Locator(driver, "object_yuansuduixiangku.xml", 30, 30);
	}

	public void loginAction(String name, String pwd) {
		locator.linkTo("http://www.huicewang.com/ecshop/user.php");// 打开登录页面
		locator.element("登录页", "用户名").sendKeys(name);
		locator.element("登录页", "密码").sendKeys(pwd);
		locator.element("登录页", "立即登录").click();
		locator.wait(2);
	}

	public Map<String, String> searchOrderInfo(String oderID) {
		locator.linkTo("http://www.huicewang.com/ecshop/user.php?act=order_list");
		locator.wait(2);
		List<WebElement> orders = locator.elements("订单页", "订单");
		Map<String, String> results = new LinkedHashMap<>();
		if (orders.size() > 0) {
			for (int i = 2; i <= orders.size(); i++) {
				List<WebElement> orderInfos = driver.findElements(
						By.xpath("//div[@class='userCenterBox boxCenterList clearfix']/table//tr[" + i + "]//td"));
				if (orderInfos.get(0).getText().trim().equals(oderID)) {
					results.put("订单号", orderInfos.get(0).getText());
					results.put("下单时间", orderInfos.get(1).getText());
					results.put("订单总金额", orderInfos.get(2).getText());
					results.put("订单状态", orderInfos.get(3).getText());
					results.put("操作", orderInfos.get(4).getText());
					return results;
				}
			}
		} else {
			System.out.println("无任何订单信息");
			return null;
		}
		System.out.println("订单号不存在：" + oderID);
		return null;
	}
}

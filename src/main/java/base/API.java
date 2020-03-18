package base;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;

/**
 * 自己封装的工具类，包含了一些公共的多数页面都可通用的方法
 * 
 * @author Administrator
 *
 */
public class API {
	private /*static*/ WebDriver driver;

	public API(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 1.针对Select功能方法的封装，随机选择下拉框内的选项
	 * 
	 * @param e
	 * @param start
	 */
	public void doRandomSelect(WebElement e, int start) {
		Select s = new Select(e);
		List<WebElement> list = s.getOptions();// 获得下拉框内的所有选项
		System.out.println(list.size());

		if (start > list.size()) {
			start = list.size() - 1;
		}

		// 1.产生随机数的第一种方法
		// Random r = new Random();
		// int index = start + r.nextInt(list.size() -
		// start);//生成一个随机数，范围是list的个数
		// System.out.println(index);
		// s.selectByIndex(index);// 根据上面随机生成的下拉选项的index，点击这个选项

		// 2..产生随机数的第二种方法
		int index2 = start + (int) (Math.random() * (list.size() - start));
		System.out.println(index2);
		s.selectByIndex(index2);
	}

	/**
	 * 2.通过页面内页签名进行点击的方法的封装
	 * 
	 * @param driver
	 * @param linkName
	 */
	public void clickTab(String linkName) {
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='mainNav']/a"));
		System.out.println(list.size());
		for (WebElement e : list) {
			if (e.getText().equals(linkName)) {
				e.click();
				break;
			}
		}
	}

	/**
	 * 3.切换到最后打开的那个窗口
	 * 
	 * @param driver
	 */
	public void switchLastWindow() {
		Set<String> handles = driver.getWindowHandles();
		if (handles.size() > 0) {
			Object[] handleArray = handles.toArray();
			String lastHandle = String.valueOf(handleArray[handleArray.length - 1]);
			driver.switchTo().window(lastHandle);
		}
	}

	/**
	 * 4.根据窗口的title切换
	 * 
	 * @param driver
	 * @param title
	 * @return
	 */
	public boolean switchWindowByTitle(String title) {
		Set<String> handles = driver.getWindowHandles();// 拿到所有窗口的句柄
		for (String h : handles) {// 遍历句柄的集合
			driver.switchTo().window(h);// 每遍历一个，就切到这个窗口，并拿到这个窗口的title
			if (driver.getTitle().contains(title)) {// 将遍历到的这个窗口的title和传进来的title进行比较
				return true;// 如果一致就返回true
			}
		}
		System.out.println("没有匹配的title");
		return false;// 如果不一致就返回false
	}

	/**
	 * 5.添加js脚本
	 * 
	 * @param driver
	 * @param jsCodes
	 */
	private void addJS(String jsCodes) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript(jsCodes);
	}

	// 执行JS脚本，滚屏到页面中间，或底部
	public void srollToMiddle() {
		addJS("scrollTo(0, 300)");
	}
	public void scrollToBottom() {
		addJS("scrollTo(0, 10000);");
	}

	/**
	 * 6.执行JS脚本，移除元素的只读属性
	 * 
	 * @param driver
	 * @param id
	 */
	public void removeReadOnly(String id) {
		String jsCodes = "document.getElementById(\"" + id + "\").removeAttribute(\"readonly\");";// document.getElementById("id").removeAttribute("readonly");
		addJS(jsCodes);
	}

	/**
	 * 7.普通线程等待，传进来的是一个秒数
	 * 
	 * @param seconds
	 */
	public void wait(int seconds) {
		int millis = seconds * 1000;
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("当前线程正处于等待状态！");
		}
	}

	/**
	 * 8.通过selectByValue选择下拉框选项的方法
	 * 
	 * @param by
	 * @param value
	 */
	public void selectByValue(By by, String value) {
		Select s = new Select(driver.findElement(by));
		s.selectByValue(value);
	}
	// 通过VisibleText选择下拉框选项的方法
	public void selectByVisibleText(By by, String value) {
		Select s = new Select(driver.findElement(by));// 通过by（条件）定位到某个下拉列表
		s.selectByVisibleText(value);// 然后通过value参数选中下拉列表中的某个值
	}
	// 通过Index选择下拉框选项的方法
	public void selectByIndex(By by, int index) {
		Select s = new Select(driver.findElement(by));
		s.selectByIndex(index);
	}

	/**
	 * 9.自定义ExpectedConditions，实现判断多对象是否存在
	 * 
	 * @param driver
	 * @param by
	 * @return
	 */
	public boolean elementsIsPresent(By by) {
		return elementsIs(by).apply(driver);
	}

	private ExpectedCondition<Boolean> elementsIs(final By by) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				if (driver.findElements(by).size() > 0) {
					return true;
				}
				return false;
			}
		};
	}

	/**
	 * 10.获取订单号信息的方法，传进来一个订单号，通过循环遍历订单列表页内的所有订单进行比较，一致的就返回该订单的信息
	 * 
	 * @param orderID
	 * @return
	 */
	public Map<String, String> searchOrderInfo(String orderID) {
		driver.get("http://www.huicewang.com/ecshop/user.php?act=order_list");// 进入订单列表页面
		List<WebElement> orders = driver
				.findElements(By.xpath("//div[@class='userCenterBox boxCenterList clearfix']/table//tr"));// 获取到所有的订单行，放进list中
		Map<String, String> results = new LinkedHashMap<String, String>();// 创建一个Map容器，用来存放匹配到的订单的各项信息
		if (orders.size() > 0) {
			for (int i = 1; i < orders.size(); i++) {// 遍历所有的订单，
				String str = "//div[@class='userCenterBox boxCenterList clearfix']/table//tr[";
				List<WebElement> orderInfos = driver.findElements(By.xpath(str + i + "]//td"));// 将每行订单的5个信息找到放进list中
				if (orderInfos.get(0).getText().equals(orderID)) {// 如果遍历到的这个订单的订单号与传进来的订单号一致
					results.put("订单号", orderInfos.get(0).getText());
					results.put("下单时间", orderInfos.get(1).getText());
					results.put("订单总金额", orderInfos.get(2).getText());
					results.put("订单状态", orderInfos.get(3).getText());
					results.put("操作", orderInfos.get(4).getText());
					return results;
				}
			}
		} else {
			System.out.println("无任何订单信息！");
			return null;
		}
		System.out.println("订单号" + orderID + "不存在！");
		return null;
	}

	/**
	 * 11.找到指定元素，并将元素的字符串放进列表中
	 * @param by
	 * @return
	 */
	public List<String> getElementsText(By by) {
		List<String> textsList = new ArrayList<String>();
		for (WebElement e : driver.findElements(by)) {
			textsList.add(e.getText().trim());
		}
		return textsList;
	}

}

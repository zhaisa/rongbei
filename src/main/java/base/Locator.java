package base;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rongbei.util.XmlParser_zhengshi;

/**
 * 本类是封装的最大的工具，将元素放进对象库文件中，然后通过本类进行元素的获取、select选择、执行JS脚本等等操作
 * 另外还有检查连接有效性、连接url并获取text等方法，以及定位元素用的getBy等方法
 * @author Administrator
 *
 */
public class Locator {

	private WebDriver driver;
	private XmlParser_zhengshi xp;
	private int objectWaitTime;
	private int pageWaitTime;
	private String filePath;
	private boolean existFlag;

	public Locator(WebDriver driver, String filePath, int objectWaitTime, int pageWaitTime) {
		this.driver = driver;
		this.filePath = filePath;
		this.objectWaitTime = objectWaitTime;
		this.pageWaitTime = pageWaitTime;
		xp = new XmlParser_zhengshi(filePath);
	}

	// 1.linkTo（本方法封装了页面加载（即driver.get方法），回参是boolean类型）
	public boolean linkTo(String Url) {
		try {
			driver.get(Url);
		} catch (TimeoutException e) {
			System.out.println("页面加载失败:" + Url);
			return false;
		}
		return true;
	}

	// 2_1.element（本方法的作用是获得元素，调用了getElement方法）
	public WebElement element(String page, String object) {
		return getElement(page, object, true);// 所调用的getElement方法既使用了智能等待，又判断了元素是否可见
	}

	// 3_1.elementText（和上一个方法类似，调用了getElement方法，只不过本方法获取的是元素的text）
	public String elementText(String page, String object) {
		return getElement(page, object, true).getText().trim();
	}

	// 4_1.elements（本方法是获得多个元素，调用了getElements方法）
	public List<WebElement> elements(String pageKey, String objKey) {
		return getElements(pageKey, objKey);
	}

	// 5.elementNoWait（本方法的作用是不等，无论找到与否都不等，往下执行）
	public WebElement elementNoWait(String pageKey, String objKey) {
		return getElement(pageKey, objKey, false);
	}

	// 6.elementExist（本方法作用是判断元素是否存在，回参是布尔类型）
	public boolean elementExist(String pageKey, String objKey) {
		getElement(pageKey, objKey, true);// 如果元素存在，getElement方法中会把existFlag置成true，如果不存在，existFlag还是false
		return existFlag;
	}

	// 7.elementExistNoWait（本方法的作用是如果元素存在就不等）
	public boolean elementExistNoWait(String pageKey, String objKey) {
		boolean flag = false;
		String type = xp.getSingleElementText("对象/" + pageKey + "/" + objKey + "/type");
		String value = xp.getSingleElementText("对象/" + pageKey + "/" + objKey + "/value").trim();
		By by = getBy(type, value);
		try {
			driver.findElement(by);
			existFlag = true;
		} catch (Exception e) {
		}
		return flag;
	}

	// 8.theFirstElement（获得某些元素的第一个）
	public WebElement theFirstElement(String pageKey, String objKey) {
		List<WebElement> elements = getElements(pageKey, objKey);
		return elements.get(0);
	}

	// 9.theLastElement（获得某些元素的最后一个）
	public WebElement theLastElement(String pageKey, String objKey) {
		List<WebElement> elements = getElements(pageKey, objKey);
		return elements.get(elements.size() - 1);
	}

	// 10.theRandomElement（随机取一个元素）
	public WebElement theRandomElement(String pageKey, String objKey) {
		List<WebElement> elements = getElements(pageKey, objKey);
		int index = (int) (Math.random() * elements.size());
		return elements.get(index);
	}

	// 11.elementsAttribute（得到多个元素的属性）
	public List<String> elementsAttribute(String pageKey, String objKey, String attribute) {
		List<String> list = new ArrayList<String>();
		List<WebElement> elements = elements(pageKey, objKey);
		for (WebElement e : elements) {
			list.add(e.getAttribute(attribute));
		}
		return list;
	}

	// 12.elementsText（得到多个元素的text值）
	public List<String> elementsText(String pageKey, String objKey) {
		List<String> list = new ArrayList<String>();
		List<WebElement> elements = elements(pageKey, objKey);
		for (WebElement e : elements) {
			list.add(e.getText());
		}
		return list;
	}

	// 13.select（选择下拉列表的方法）
	public Select select(String pageKey, String objKey) {
		return new Select(this.getElement(pageKey, objKey, true));
	}

	// 14.selectByValue（通过value选择）
	public void selectByValue(String pageKey, String objKey, String value) {
		Select select = select(pageKey, objKey);
		select.selectByValue(value);
	}

	// 15.selectByIndex（通过Index选择）
	public void selectByIndex(String pageKey, String objKey, int index) {
		Select select = select(pageKey, objKey);
		select.selectByIndex(index);
	}

	// 16.selectByVisibleText（通过VisibleText选择）
	public void selectByVisibleText(String pageKey, String objKey, String text) {
		Select select = select(pageKey, objKey);
		select.selectByVisibleText(text);
	}

	// 17.addJS（本方法的作用是执行JS脚本，传进来的参数是什么就执行什么JS代码）
	public void addJS(String jsCodes) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(jsCodes);
	}

	// 18.removeReadonly（去除元素的只读属性）
	public void removeReadonly(WebDriver driver, String id) {
		String jsString = "document.getElementById(\"" + id + "\").removeAttribute(\"readonly\");";
		addJS(jsString);
	}

	// 19.scrollToBottom（滚屏至底部）
	public void scrollToBottom() {
		String jsString = "scrollTo(0,10000);";
		addJS(jsString);
	}

	// 20.scrollToMiddle（滚屏至中间）
	public void scrollToMiddle() {
		String jsString = "scrollTo(0,450);";
		addJS(jsString);
	}

	// 21.elementsToBeDisplayed（执行JS，使隐藏的元素可见）
	public void elementsToBeDisplayed(String typeName, String typeValue) {
		StringBuffer sb = new StringBuffer();
//		typeName = typeName.toLowerCase();
		switch (typeName.toLowerCase()) {
		case "classname":
			sb.append("var all = document.getElementsByClassName('" + typeValue + "'); ");
			break;
		case "id":
			sb.append("var all = document.getElementsById('" + typeValue + "'); ");
			break;
		case "tagname":
			sb.append("var all = document.getElementsByTagName('" + typeValue + "'); ");
			break;
		default:
			System.out.println("document对象的getElements方法不支持此查找类型：" + typeName);
		}
		sb.append("for(var i=0;i<all.length;i++){all[i].style.display='block';}");
		addJS(sb.toString());
	}

	// 22.linkedAndGet（判断所有的url是否连接上了，并返回连接的text）
	public List<String> linkedAndGet(List<String> url, String pageKey, String objKey, String attribute) {
		List<String> texts = new ArrayList<String>();
		int size = url.size();
		for (int i = 0; i < size; i++) {
			boolean isLinked = linkTo(url.get(i));
			if (isLinked) {
				if (attribute.equalsIgnoreCase("text")) {
					texts.add(element(pageKey, objKey).getText().trim());
				} else
					texts.add(element(pageKey, objKey).getAttribute(attribute));
			} else
				texts.add("-1");
		}
		return texts;
	}

	// 23.linkedAndCheck（检查连接有效性）
	public boolean linkedAndCheck(List<String> Url, String pageKey, String objKey) {
		boolean flag = false;
		for (String url : Url) {
			boolean isLinked = linkTo(url);
			if (isLinked) {
				waitForPageLoad();// 如果连接上了，等待页面加载完成
				if (!elementExist(pageKey, objKey)) {
					System.out.println("页面:" + url + " 元素  " + pageKey + "-" + objKey + " 不存在!");
					flag = false;
				} else
					flag = true;
			}
		}
		return flag;
	}

	// 24.waitForPageLoad（等待页面加载，判断页面加载是否完成）
	public boolean waitForPageLoad() {
		return new WebDriverWait(driver, pageWaitTime)
				.until(new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor) driver).executeScript("return document.readyState")
								.equals("complete");
					}
				});
	}

	// 25.wait（封装的Thread.sleep方法，参数传进来秒数即可，不用再写毫秒数）
	public void wait(int seconds) {
		try {
			int millis = seconds * 1000;
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("当前线程正处于等待状态!");
		}
	}

	// 4_2.getElements（对象库文件中得到多个元素）
	private List<WebElement> getElements(String pageKey, String objKey) {
		List<WebElement> elements = new ArrayList<WebElement>();
		if (xp.isExist("/对象/" + pageKey + "/" + objKey)) {
			String type = xp.getSingleElementText("/对象/" + pageKey + "/" + objKey + "/type");
			String value = xp.getSingleElementText("/对象/" + pageKey + "/" + objKey + "/value");
			By by = getBy(type, value);
			elements = driver.findElements(by);// findElements不会抛出异常，因此下方需要对element做检查
			if (elements.size() == 0) {
				String message = "未查找到页面元素：" + pageKey + "-" + objKey;
				System.out.println(message);
			}
			for (WebElement e : elements) {
				if (e.equals("") || e == null) {
					String message = pageKey + "-" + objKey + "返回多个对象，其中存在空值";
					System.out.println(message);
				}
			}
		} else {
			String message = pageKey + "-" + objKey + "未在对象库文件中存在：" + filePath;
			System.out.println(message);
		}
		return elements;
	}

	// 2_2(3_2)getElement（本方法封装的是从对象库文件中get元素，参数page和object是object.xml对象库文件中的一、二级节点）
	private WebElement getElement(String page, String object, boolean wait) {
		WebElement element = null;
		existFlag = false;
		if (xp.isExist("对象/" + page + "/" + object)) {
			String type = xp.getSingleElementText("对象/" + page + "/" + object + "/type");
			String value = xp.getSingleElementText("对象/" + page + "/" + object + "/value").trim();
			final By by = getBy(type, value);
			if (wait) {// 这里面写的是智能等待，且判断了是否可见
				try {
					element = new WebDriverWait(driver, objectWaitTime).until(new ExpectedCondition<WebElement>() {// 智能等待，在规定的时间内直到元素被找到
						@Override
						public WebElement apply(WebDriver d) {// 重写了apply方法
							existFlag = true;
							return d.findElement(by);
						}
					});
					if (!waitElementToBeDisplayed(element, page, object)) {// 判断了找到的元素是否可见
						System.out.println(page + "-" + object + "未在页面显示!");
					}
				} catch (Exception e) {
					System.out.println("未查找到页面元素：" + page + "-" + object);
				}
			} else {
				return driver.findElement(by);// 如果不用等，直接返回找到的元素
			}
		} else {
			System.out.println(page + "-" + object + "未在对象库文件中存在：object.xml");
		}
		return element;
	}

	// 等到元素可见
	public boolean waitElementToBeDisplayed(final WebElement element, String pageKey, String objKey) {
		boolean wait = false;
		if (element == null)
			return wait;
		try {
			wait = new WebDriverWait(driver, objectWaitTime).until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver d) {
					return element.isDisplayed();// 元素可见
					// return element.isEnabled();// 或元素可用
				}
			});
		} catch (Exception e) {
			System.out.println(pageKey + "-" + objKey + " 未在页面显示!");
		}
		return wait;
	}

	// 本方法是封装的元素定位的工具，根据传入的类型（包括id、name、className等等）和值得到对应元素
	private By getBy(String type, String value) {
		By by = null;
		switch (type.trim()) {// type.toLowerCase().trim()老师的代码是这么写的，经测试不行，因为有的类型中带大写字母（如linkText），运行会报“不存在此类型”
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "className":
			by = By.className(value);
			break;
		case "tagName":
			by = By.tagName(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);// 这个是可通过linktext的一部分进行元素定位
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "cssSelector":
			by = By.cssSelector(value);
			break;
		default:
			System.out.println("元素定位错误! By." + type + "不存在此类型！");
			break;
		}
		return by;
	}
}

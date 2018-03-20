package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XiaoFeiDaiShenHe {

	public void shenHe(String name) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver dr = new ChromeDriver();
		Calendar cc = new GregorianCalendar();
		String time = new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
		dr.get("http://test-management.irongbei.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		dr.findElement(By.id("username")).clear();
		dr.findElement(By.id("username")).sendKeys("hontest2");
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("123456");
		dr.findElement(By.id("login")).click();
		dr.navigate().to("http://test-management.irongbei.com/index/main.html");
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.switchTo().frame("leftmenu");
		dr.findElement(By.cssSelector("dt")).click();

		dr.navigate().to("http://test-management.irongbei.com/honloan/index.html");
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		List<WebElement> trlist = dr
				.findElements(By.xpath("/html/body/div[1]/div/div[2]/div/dl/dd/div/table/tbody/tr"));
		List<String> url1 = new ArrayList<String>();
		for (int r = 0; r < trlist.size(); r++) {
			String trText = trlist.get(r).getText();
			if (trText.contains(name)) {

				// trlist.get(r).findElement(By.linkText("查看详情")).click();
				String url = trlist.get(r).findElement(By.linkText("查看详情")).getAttribute("href");
				url1.add(url);

				break;
			}

		}
		System.out.println(url1.get(0));
		dr.navigate().to(url1.get(0));
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		dr.findElement(By.linkText("风控初审")).click();

		dr.navigate().to(dr.findElement(By.linkText("风控初审")).getAttribute("href"));

		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[1]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[2]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[3]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[4]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[5]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[6]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[7]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[8]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[1]/div[1]/table/tbody/tr[9]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.name("crter12")).sendKeys("这是第一次");
		dr.findElement(By.name("inpone12")).sendKeys("这是第二次");
		dr.findElement(By.name("renedr12")).sendKeys("这是第三次");
		dr.findElement(By.name("hymed12")).sendKeys("这是第四次");
		dr.findElement(By.name("zxinrewd12")).sendKeys("这是第五次");
		dr.findElement(By.name("tkhwp12")).sendKeys("这是第六次");
		dr.findElement(By.name("uyli12")).sendKeys("这是第七次");
		dr.findElement(By.name("rdfiud12")).sendKeys("这是第八次");
		dr.findElement(By.name("sixierh12")).sendKeys("这是第九次");

		dr.findElement(By.name("sixierh2")).sendKeys("审核通过");
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[2]/div[1]/table/tbody/tr[1]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[2]/div[1]/table/tbody/tr[2]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[1]/dd[2]/div[1]/table/tbody/tr[3]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.name("dert32")).sendKeys("门前大桥下");
		dr.findElement(By.name("dwphnoe21")).sendKeys("游过一群鸭");
		dr.findElement(By.name("khiowd21")).sendKeys("快来数一数");
		dr.findElement(By.name("khiowd22")).sendKeys("二四六七八");
		dr.findElement(By.name("gzmouth1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gzmouth2")).sendKeys("雪花那个飘啊");
		dr.findElement(By.name("gzmouth3")).sendKeys("养老白呀");
		dr.findElement(By.name("gzmouth4")).sendKeys("叶叶黄呀");
		dr.findElement(By.name("gzmouth5")).sendKeys("小白菜呀");
		dr.findElement(By.name("gzmouth6")).sendKeys("心里苦呀");
		dr.findElement(By.name("gzmouth7")).sendKeys("黄世仁呀");
		dr.findElement(By.name("gzmouth8")).sendKeys("给黄鼠狼拜年");
		dr.findElement(By.name("sbxin1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("sbxin2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("sbxin3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("sbxin4")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("sbxin5")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("sbxin6")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin4")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin5")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gjin6")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fwxin1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fwxin2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fwxin3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fwxin4")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname4")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname5")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname6")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("gsname63")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("numlog1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("numzhej1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fgnum1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("niehw1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("niwH1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("numlog2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("numlog3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("numzhej2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("numzhej3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fgnum2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("fgnum3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("niehw2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("niehw3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("niwH2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("niwH3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("xinkw1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("xinkw2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("xinkw3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("xinkw4")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("xinkw5")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("jiedir1")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("jiedir2")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("jiedir3")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("jiedir4")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("jiedir5")).sendKeys("北风那个吹啊");
		dr.findElement(By.name("frewsd1e2")).sendKeys("北风那个吹啊");

		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[1]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[2]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[3]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[4]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[5]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[6]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[7]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[8]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[1]/div[1]/table/tbody/tr[9]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.name("jk13")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("qwe23q")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("znqko22")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("judft22")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("gxfrde22")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("sirul22")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("fizair22")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("qwmoth23")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("moutgrn22")).sendKeys("咿呀咿呀呦");

		dr.findElement(By.name("trjk5")).sendKeys("咿呀咿呀呦");

		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[1]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[2]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[3]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[4]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[5]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[6]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[2]/div[1]/table/tbody/tr[7]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.name("senfrd22")).sendKeys("冷冷的北风吹过");
		dr.findElement(By.name("huntong12")).sendKeys("吹透单薄的衣衫");
		dr.findElement(By.name("poerg32")).sendKeys("大漠的落日下");
		dr.findElement(By.name("jsedr32")).sendKeys("大漠孤烟直");
		dr.findElement(By.name("klogon32")).sendKeys("长河落日圆");
		dr.findElement(By.name("huuhfed32")).sendKeys("欲穷千里目");
		dr.findElement(By.name("shrotd23")).sendKeys("更上一层楼");

		dr.findElement(By.name("shrotd234")).sendKeys("我是一匹来自北方的狼");
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[1]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[2]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[3]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[4]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[5]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[6]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[7]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr[8]/td[2]/div/label[1]/input"))
				.click();
		// List<WebElement> trlist2=(List<WebElement>)
		// dr.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr"));
		// List<WebElement> attr=new ArrayList<WebElement>();
		// for(int r=0;r<trlist.size();r++){
		// String trText=trlist2.get(r).getText();
		// if(trText.contains("name")) {
		// String
		// aa=dr.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[3]/div[1]/table/tbody/tr")).getAttribute("name");
		// attr.add(aa);
		//
		// }
		// }
		// for(int z=0;z<attr.size();z++) {
		// System.out.println(attr.get(z));
		// }
		dr.findElement(By.name("rfttd43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("ddreset43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("defrong43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("sroklit43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("edrfd43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("jiyed43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("koloed43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("redswd432")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.name("redswd43")).sendKeys("独自走在荒凉的风中");
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[4]/div[1]/table/tbody/tr[1]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[4]/div[1]/table/tbody/tr[2]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[4]/div[1]/table/tbody/tr[3]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[4]/div[1]/table/tbody/tr[4]/td[2]/div/label[1]/input"))
				.click();
		dr.findElement(By.xpath(
				"/html/body/div/div/div[2]/div[2]/form/dl[2]/dd[4]/div[1]/table/tbody/tr[5]/td[2]/div/label[2]/input"))
				.click();
		dr.findElement(By.name("tredoi43")).sendKeys("I have a dream!");
		dr.findElement(By.name("tredoi44")).sendKeys("门前大桥下");
		dr.findElement(By.name("frdresh43")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("kiedtd43")).sendKeys("咿呀咿呀呦");

		dr.findElement(By.name("lzuhred43")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("frdresh43")).sendKeys("咿呀咿呀呦");
		dr.findElement(By.name("oklerd43")).sendKeys("咿呀咿呀呦");

		Select ss = new Select(dr.findElement(By.name("leveltype_zy")));
		ss.selectByValue("B");
		dr.findElement(By.name("cs_res_zy")).sendKeys("最后的备注");
		dr.findElement(By.name("fkzyvalue_zy")).sendKeys("审核通过");
		// dr.findElement(By.linkText("审批通过")).click();

		dr.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/form/dl[3]/div[2]/div/input[5]")).click();
		dr.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		dr.close();
		dr.quit();

	}
}
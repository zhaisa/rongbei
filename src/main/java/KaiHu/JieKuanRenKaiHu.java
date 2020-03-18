package KaiHu;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.fengkong.NewUserCardAndBankCard;
import com.irongbei.CreateDriver;
import com.irongbei.GetNextHandle;
import com.irongbeipages.LoginPage;
import com.rongbei.util.ConectMysql;

public class JieKuanRenKaiHu {
	
	@Test(invocationCount=1)
	public void jieKuanKaiHu() throws InterruptedException {
		WebDriver dr = CreateDriver.getDriver("chrome");
		Logger logger = Logger.getLogger(JieKuanRenKaiHu.class);
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
		String username=null;
		int id;
		String sss1=null;
		String usercard = NewUserCardAndBankCard.Calculate();
		String bankcard = NewUserCardAndBankCard.getBankAccount();
	
		dr.get("http://corporateadmin.irongbei.com");
		dr.findElement(By.id("user_name")).clear();
		dr.findElement(By.id("user_name")).sendKeys("uatdc01");
		dr.findElement(By.id("user_password")).clear();
		dr.findElement(By.id("user_password")).sendKeys("111111");
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入验证码：");
		while (scan.hasNext()) {
			
			String aaa = scan.next();
			System.out.println(aaa);
			dr.findElement(By.id("user_captcha")).sendKeys(aaa);
			Thread.sleep(1000);
			dr.findElement(By.id("qianlogin")).click();
			Thread.sleep(1000);
			break;
		}
	
		dr.navigate().to("http://corporateadmin.irongbei.com/Index/account");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"accountOpenPage\"]/div[1]/ul/li/span/span[1]/span/span[2]")).click();
		Actions action = new Actions(dr);
		WebElement we = dr.findElement(By.className("select2-search__field"));
		action.moveToElement(we).click();

		action.sendKeys("北京");
		action.moveToElement(we).perform();

		Thread.sleep(3000);
		action.sendKeys(Keys.DOWN);
		action.sendKeys(Keys.ENTER);
		action.perform();
		Calendar c = new GregorianCalendar();
//		c.set(myyear, mymonth, myday);
		
		String nameparam=new SimpleDateFormat("yyMMddhhmmss").format(c.getTime());
		username="testzhai"+nameparam;
		logger.info(username);
		logger.info(bankcard);
		logger.info(usercard);
		dr.findElement(By.name("name")).sendKeys(username);
		dr.findElement(By.name("userCode")).sendKeys(usercard);
		dr.findElement(By.name("mobile")).sendKeys("18701473018");
		dr.findElement(By.id("agreement")).click();
		Thread.sleep(1000);
		dr.findElement(By.id("getplans")).click();
		Thread.sleep(2000);
		  String currentWindow = dr.getWindowHandle();
		    Set<String> handles = dr.getWindowHandles();
			Iterator<String> it= handles.iterator();
			while (it.hasNext()) {
				String handle = it.next();
				if (currentWindow.equals(handle))
					continue;
				Thread.sleep(5000);
	//			dr.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				WebDriver window = dr.switchTo().window(handle);
				System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
			    sss1 = window.getCurrentUrl();
				
				
			}
	
		Thread.sleep(1000);
		dr.navigate().to(sss1);
		dr.findElement(By.id("BIND_CARD_NO")).clear();
		dr.findElement(By.id("BIND_CARD_NO")).sendKeys(bankcard);
		dr.findElement(By.id("IDNO")).clear();
		dr.findElement(By.id("IDNO")).sendKeys(usercard);
		dr.findElement(By.id("encPin1")).clear();
		dr.findElement(By.id("encPin1")).sendKeys("121121");
		dr.findElement(By.id("encPin2")).clear();
		dr.findElement(By.id("encPin2")).sendKeys("121121");

		dr.findElement(By.id("smsBtn")).click();
		System.out.println("请输入验证码：");
		Scanner scan1 = new Scanner(System.in);
		if (scan1.hasNext()) {

			String str1 = scan1.next();
			System.out.println("输入的数据为：" + str1);

			dr.findElement(By.id("smsInput")).sendKeys(str1);
			Thread.sleep(3000);
			dr.findElement(By.id("mainAcceptIpt")).click();
			dr.findElement(By.id("sub")).click();
			Thread.sleep(3000);
			
		}
		String url1="http://corporateadmin.irongbei.com/Index/index?charger="+username;
		dr.navigate().to(url1);
		Thread.sleep(2000);
		dr.navigate().refresh();
//		dr.findElement(By.id("userlistbutton")).click();
		Thread.sleep(1000);
		dr.findElement(By.linkText("［授权］")).click();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GetNextHandle gnh1 = new GetNextHandle();
		gnh1.getNextHandle(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
		Thread.sleep(3000);
		dr.get("http://rongbeiadmin.51dmoz.com");
		LoginPage lp=new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		Thread.sleep(1000);
		dr.findElement(By.linkText("借款人管理")).click();
		Thread.sleep(1000);
		dr.findElement(By.partialLinkText("借款人列表")).click();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Company/index");
		dr.findElement(By.name("charger")).sendKeys(username);
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[1]/div/form/p[3]/a/input")).click();
		//*[@id="right-box"]/div[2]/div[1]/div/form/p[3]/a/input
//		dr.findElement(By.linkText("[补充资料]")).click();
		Thread.sleep(1000);
		String url2 =dr.findElement(By.linkText("[补充资料]")).getAttribute("href");
		System.out.println(url2);
		dr.navigate().to(url2);
		Thread.sleep(2000);
		dr.findElement(By.name("industry")).sendKeys("AAAAAAAA");
		dr.findElement(By.name("fuzhai_situation")).sendKeys("AAAAAAAA");
		dr.findElement(By.name("address")).sendKeys("AAAAAAAA");
		dr.findElement(By.name("charemail")).sendKeys("aaaaa@163.com");
		dr.findElement(By.id("sub")).click();
		Thread.sleep(2000);
		dr.switchTo().alert();
		Thread.sleep(1000);
		dr.switchTo().alert().accept();
		dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Company/index");
		dr.findElement(By.name("charger")).sendKeys(username);
//		dr.findElement(By.linkText("查找")).click();
		dr.findElement(By.linkText("[审核]")).click();
		Thread.sleep(1000);
		dr.switchTo().alert().accept();
		Thread.sleep(1000);
		dr.close();
		dr.quit();
		

	}
	@Test
	public void updateSql() throws ClassNotFoundException, SQLException {
		
		ConectMysql cq=new ConectMysql();
		cq.updateMysql();
		
	}
	
	
	
	
	
	
	
}

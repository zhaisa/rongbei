package KaiHu;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
	WebDriver dr = CreateDriver.getDriver("chrome");
	@Test
	public void jieKuanKaiHu() throws InterruptedException {
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
		String username=new SimpleDateFormat("hhmmss").format(c.getTime());
		dr.findElement(By.name("name")).sendKeys(username);
		dr.findElement(By.name("userCode")).sendKeys(usercard);
		dr.findElement(By.name("mobile")).sendKeys("18701473018");
		dr.findElement(By.id("agreement")).click();
		Thread.sleep(1000);
		dr.findElement(By.id("getplans")).click();
		Thread.sleep(2000);
		GetNextHandle gnh = new GetNextHandle();
		gnh.getNextHandle(dr);
		Thread.sleep(3000);
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
		dr.findElement(By.linkText("［授权］")).click();
		Thread.sleep(1000);
		GetNextHandle gnh1 = new GetNextHandle();
		gnh1.getNextHandle(dr);
		Thread.sleep(3000);
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("121121");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
		Thread.sleep(2000);
		dr.get("http://2rongbeiadmin.irongbei.com");
		LoginPage lp=new LoginPage(dr);
		lp.login("测试专用管理员", "123456");
		Thread.sleep(1000);
		dr.findElement(By.linkText("借款人管理")).click();
		Thread.sleep(1000);
		dr.findElement(By.partialLinkText("借款人列表")).click();
		dr.navigate().to("http://2rongbeiadmin.irongbei.com/admin/Company/index");
		dr.findElement(By.name("charger")).sendKeys(username);
		Thread.sleep(1000);
		dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[1]/div/form/p[3]/a/input")).click();
		//*[@id="right-box"]/div[2]/div[1]/div/form/p[3]/a/input
//		dr.findElement(By.linkText("[补充资料]")).click();
		
		String url2 =dr.findElement(By.linkText("[补充资料]")).getAttribute("href");
		System.out.println(url2);
		dr.navigate().to(url2);
		Thread.sleep(2000);
		dr.findElement(By.name("industry")).sendKeys("AAAAAAAA");
		dr.findElement(By.name("fuzhai_situation")).sendKeys("AAAAAAAA");
		dr.findElement(By.name("address")).sendKeys("AAAAAAAA");
		dr.findElement(By.name("charemail")).sendKeys("aaaaa@163.com");
		dr.findElement(By.id("sub")).click();
		Thread.sleep(1000);
		dr.switchTo().alert().accept();
		Thread.sleep(1000);
		dr.navigate().to("http://2rongbeiadmin.irongbei.com/admin/Company/index");
		dr.findElement(By.name("charger")).sendKeys(username);
//		dr.findElement(By.linkText("查找")).click();
//		dr.findElement(By.linkText("[审核]")).click();
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

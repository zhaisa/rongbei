package com.irongbei;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fengkong.NewUserCardAndBankCard;
import com.irongbeipages.LoginPage;

public class JiekuanrenFromRongBei {
@SuppressWarnings("static-access")
@Test(dataProvider="getdata")
public void crteateJKR(String env) throws InterruptedException {
	String usercard = NewUserCardAndBankCard.Calculate();
	String bankcard = NewUserCardAndBankCard.getBankAccount();

	CreateDriver cd=new CreateDriver();
	WebDriver dr=cd.getDriver("chrome");
	MyEnviment me=new MyEnviment();
	String beorba=env+"admin";
	String url=me.getEvi(env, beorba);
	dr.get(url+"/admin/login");
	LoginPage lp=new LoginPage(dr);
	lp.login("测试专用管理员", "123456");
	Thread.sleep(1000);
	dr.findElement(By.linkText("借款人管理")).click();
	Thread.sleep(1000);
	String url2=dr.findElement(By.partialLinkText("借款人列表")).getAttribute("href");
	dr.navigate().to(url2);
	Thread.sleep(1000);
	dr.navigate().to(dr.findElement(By.linkText("借款方添加")).getAttribute("href"));
	String username;
	Calendar cc=new GregorianCalendar();
	String nameparam=new SimpleDateFormat("hhmmss").format(cc.getTime());
	username="testzhai"+nameparam;
	dr.findElement(By.name("username")).sendKeys(username);
	dr.findElement(By.name("password")).sendKeys("123456");
	dr.findElement(By.name("repassword")).sendKeys("123456");
	dr.findElement(By.name("company_name")).sendKeys("测试专用系列");
	dr.findElement(By.name("charger")).sendKeys("测试翟系列");
	dr.findElement(By.name("id_num")).sendKeys(usercard);
	dr.findElement(By.name("chartelphone")).sendKeys("18701473018");
	dr.findElement(By.name("industry")).sendKeys("互联网金融行业");
	dr.findElement(By.name("fuzhai_situation")).sendKeys("wu");
	dr.findElement(By.name("address")).sendKeys("北京市");
	dr.findElement(By.name("charemail")).sendKeys("123@qq.com");
	Select ss1=new Select(dr.findElement(By.name("cautioner_id")));
	ss1.selectByValue("13815");
	dr.findElement(By.id("sub")).click();
	dr.switchTo().alert();
	Thread.sleep(1000);
	dr.switchTo().alert().accept();
}
@DataProvider(name="getdata")
public Object[][] getdata(){
	Object[][] mydata= {{"test"}};
	return mydata;
	
}
}

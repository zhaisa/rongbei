package addpackage;

import org.openqa.jetty.start.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyDaBiao {

	 public static void testPlan(int lineNo) throws Exception {

	System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//这一步必不可少  
	 WebDriver dr= new ChromeDriver();
dr.get("http://asset.irongbei.com/UserLogin/index"); 
ReadTxt rt=new ReadTxt();
String username=rt.readFS(lineNo);
dr.findElement(By.id("user_name")).sendKeys(username);
dr.findElement(By.id("user_password")).sendKeys("123456");
dr.findElement(By.id("qianlogin")).click();
Thread.sleep(1000);
dr.navigate().to("http://asset.irongbei.com/UserCenter/index");
dr.findElement(By.xpath("//*[@id=\"irb-header\"]/div[2]/div/div[2]/ul/li[2]/a")).click();
dr.navigate().to("http://asset.irongbei.com/index/fplist");
dr.findElement(By.className("mai-btn")).click();
dr.navigate().to("http://asset.irongbei.com/Index/fpdetail?id=26");
dr.findElement(By.id("invest_account")).clear();
dr.findElement(By.id("invest_account")).click();
dr.findElement(By.id("invest_account")).sendKeys("100");
dr.findElement(By.id("investSubmit")).click();
dr.navigate().to("http://asset.irongbei.com/UserCenter/fpconfirm?program=26&account=100&uvId=0&key=c5c0c27836f039d15cca446d53254ecf");
dr.findElement(By.className("fzz_btn")).click();
Thread.sleep(1000);

dr.quit();














}
}
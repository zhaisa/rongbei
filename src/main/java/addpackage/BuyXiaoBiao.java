package addpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyXiaoBiao {
	 public  void testPlan() throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//这一步必不可少  
			 WebDriver dr= new ChromeDriver();
		dr.get("http://testhf.irongbei.com/UserLogin/index"); 
		dr.findElement(By.id("user_name")).sendKeys("17409080002");
		dr.findElement(By.id("user_password")).sendKeys("123456");
		dr.findElement(By.id("qianlogin")).click();
		Thread.sleep(1000);
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/index");
		dr.findElement(By.xpath("//*[@id=\"irb-header\"]/div[2]/div/div[2]/ul/li[2]/a")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/fplist");
		dr.findElement(By.linkText("直投项目")).click();
		dr.navigate().to("http://testhf.irongbei.com/Index/plist");
//		Select sl=new Select(dr.findElement(By.className("filter-condition")));
//		sl.selectByVisibleText("投标中");
		dr.findElement(By.xpath("//*[@id=\"statuschoose\"]/li[3]")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/plist?type=0&status=1&income=0&cycle=0&condition=close&payment=0");
		dr.findElement(By.linkText("小标自动化购买-翟one")).click();
		dr.findElement(By.linkText("立即出借")).click();
		dr.navigate().to("http://testhf.irongbei.com/index/pdetail?id=7039");
		dr.findElement(By.id("invest_account")).clear();
		dr.findElement(By.id("invest_account")).click();
		dr.findElement(By.id("invest_account")).sendKeys("1000");
		dr.findElement(By.id("investSubmit")).click();
		dr.navigate().to("http://testhf.irongbei.com/UserCenter/confirm?program=7039&account=1000&uvId=0&key=7b49fb1a83961a568e09af18e4747938");
		dr.findElement(By.className("fzz_btn")).click();
		Thread.sleep(10000);
		
//		Set<String> set = dr.getWindowHandles(); //创建set集合，即句柄数组
//		Iterator<String> handles = set.iterator(); //迭代器取得所有set集合内容
//
//		while (handles.hasNext()) { //是否还存在句柄
//		String sonHandle = handles.next(); //循环取得各个元素值
//		System.out.print(sonHandle);
//		dr.navigate().to(sonHandle);
//	dr.switchTo().window(sonHandle); 
		
//		}
//		String url= "http://testhf.irongbei.com/UserCenter/jxdoInvest";
//		dr.navigate().to(url);
//		
//		String url2="https://test.credit2go.cn/escrow/p2p/page/bidapply";
//		dr.navigate().to(url2);
		dr.getCurrentUrl();
		 System.out.println(dr.getCurrentUrl());
		dr.navigate().to(dr.getCurrentUrl());	  
		String url3=dr.getCurrentUrl();
		System.out.println(url3);
		dr.navigate().to(url3);
//		dr.navigate().to("http://testhf.irongbei.com/UserCenter/jxdoInvest");
	

		dr.findElement(By.linkText("请输入6位数字交易密码")).clear();
		dr.findElement(By.linkText("请输入6位数字交易密码")).sendKeys("123456");
		dr.findElement(By.linkText("确 认")).click();
		Thread.sleep(3000);

		dr.quit();
		
		
}
	
}
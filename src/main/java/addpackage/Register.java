package addpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
	 public static void testPlan() throws Exception {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//这一步必不可少  
			 WebDriver dr= new ChromeDriver();
			 dr.get("http://testhf.irongbei.com");
			 dr.findElement(By.linkText("注册")).click();
			 dr.navigate().to("http://testhf.irongbei.com/userRegister/index");
			 dr.findElement(By.id("user_name")).sendKeys("17409100002");
			 dr.findElement(By.id("user_password")).sendKeys("123456");
			 dr.findElement(By.id("conform_password")).sendKeys("123456");
			 dr.findElement(By.id("mobile")).sendKeys("11100910002");
			 dr.findElement(By.id("captchapic")).sendKeys("2222");
	//		 dr.findElement(By.linkText("点击获取验证码")).click();
			 dr.findElement(By.xpath("//*[@id=\"phoneyzcode\"]")).click();
			 dr.findElement(By.xpath("//*[@id=\"phoneyzcode\"]")).clear();
			 dr.findElement(By.xpath("//*[@id=\"phoneyzcode\"]")).sendKeys("041018");
			 dr.findElement(By.id("qianregister")).click();
			 
			 dr.close();
}
}
package addpackage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class CreateXiaoBiao {
	 
		
	
public  void createXiaoBiao(String zq,int mylength,int myyear,int mymonth,int myday) throws Exception {
	
	 System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//这一步必不可少  
	 WebDriver dr= new ChromeDriver();
dr.get("http://rongbeiadmin.51dmoz.com/admin/login"); 

//dr.manage().window().maximize();

	   WebElement element = dr.findElement(By.name("username"));

	   element.sendKeys("测试专用管理员");
	   WebElement element1 = dr.findElement(By.name("password"));
	   element1.sendKeys("123456");
	   WebElement element2=dr.findElement(By.className("login-btn"));
    element2.click();  
  Thread.sleep(2000);
//  dr.get("http://rongbeiadmin.51dmoz.com/admin/Index/index");
 WebElement element3=dr.findElement(By.xpath(".//*[@id='right-box']/p"));  
 // WebElement element3=dr.findElement(By.xpath(".//*[@id='header']/div[2]/div[2]/div/span[5]/a/b[1]"));
//  JavascriptExecutor js = (JavascriptExecutor) dr;
//  String value = (String)js.executeScript("return $('element3').val();");
String obj1=element3.getText().trim();
System.out.println(obj1);
   String obj = "欢迎登录融贝网管理后台";
if(obj1.contains(obj)) {
 	  System.out.println("登录成功!"); 
 	  }
   else {
	  System.out.println("登录失败 "+"");
   }
System.out.println("Page title is: " + dr.getTitle());

dr.findElement(By.xpath("//*[@id=\"left-nav\"]/ul/li[3]/span/a")).click();
dr.findElement(By.xpath(".//*[@id='left-nav']/ul/li[3]/ul/li[1]/a")).click();
dr.findElement(By.xpath(".//*[@id='right-box']/div[1]/span/a[1]")).click();
/**
 * 
 * 尝试alert
 */
//Alert alert = dr.switchTo().alert();//定位altert弹出的提示的
//alert.getText();

/**
 * 
 * 尝试句柄
 */
//Set<String> handles = dr.getWindowHandles();
//handles.remove(dr.getWindowHandle());//去掉当前句柄
//dr.switchTo().window(handles.iterator().next());
//WebDriver popup = null;
//popup.findElement(By.id("Check2")).click();
//popup.findElement(By.id("pro_bottom_confirm")).click();
/**
 * 
 * 添加小标或者直投
 */
dr.findElement(By.id("project_type_pop")).findElement(By.id("Check2")).click();
/**
 * 添加大标
 */
//dr.findElement(By.id("project_type_pop")).findElement(By.id("Check1")).click();//
Thread.sleep(1000); //停止1秒钟
dr.findElement(By.id("project_type_pop")).findElement(By.id("pro_bottom_confirm")).click();
int a=(int) (1000* Math.random());


	String para="asset测试小标底层-翟"+a;
	System.out.println(para);
	
dr.navigate().to("http://rongbeiadmin.51dmoz.com/admin/Project/create");
dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[1]/div[1]/input")).sendKeys(para);
dr.findElement(By.id("project_num")).sendKeys(para+1);
//UUID uuid = UUID.randomUUID();
//System.out.println(uuid);
String s = UUID.randomUUID().toString();
dr.findElement(By.name("project_description")).sendKeys(s);
dr.findElement(By.name("repayment")).sendKeys(s);
dr.findElement(By.name("project_riskcontrol")).sendKeys(s);
dr.findElement(By.xpath("//*[@id=\"right-box\"]/div[2]/div[5]/div[1]/input[2]")).click();
 Select sl= new Select(dr.findElement(By.name("real_payment")));

sl.selectByValue("2");//选择等额本息1为先息后本2为等额本息3为一次性还本付息

Select s2= new Select(dr.findElement(By.name("company_user_id")));

s2.selectByValue("11546#6212461560000555037#1#11492");//选择翟测试账户的value

Select s3= new Select(dr.findElement(By.name("contract_type")));


s3.selectByValue("9");//直融——车贷(消费金融)——等额本息					        

Select s4= new Select(dr.findElement(By.id("template_id")));
s4.selectByVisibleText("模板6");//选择模板6
dr.findElement(By.xpath("//*[@id=\"template_id\"]/option[16]")).click();

Thread.sleep(1000);
/**
 * 使用相对路径获取弹框的XPATH
 */
String att="hello my world!!!!!";
dr.findElement(By.xpath("//textarea[@value='']")).click();
dr.findElement(By.xpath("//textarea[@value='']")).clear();
dr.findElement(By.xpath("//textarea[@value='']")).sendKeys(att+a);
dr.findElement(By.linkText("确定")).click();

dr.findElement(By.id("p_sum")).sendKeys("1");//输入金额1万
dr.findElement(By.id("rate")).sendKeys("8");//年利率8%
dr.findElement(By.id("cre_rate")).clear();
dr.findElement(By.id("cre_rate")).sendKeys("9");
dr.findElement(By.name("fixed_invest")).clear();
dr.findElement(By.name("fixed_invest")).sendKeys("0");//输入定投金额
dr.findElement(By.name("cycle")).sendKeys(zq);//还款周期月

JavascriptExecutor jse = (JavascriptExecutor) dr; 
        Boolean loaded;        
 try{       
		loaded = (Boolean) jse.executeScript("return "+ "jQuery()!=null"); 
        } catch(WebDriverException e) { 
           loaded = false; 
        } 

    /*
     * 
     * 加载jquery清楚readonly熟悉，然后给输入框输入时间
     */

Date date = new Date();//先获取当前日期
Calendar  c = new GregorianCalendar();
c.set(myyear, mymonth, myday);
String startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").format(c.getTime());//对日期进行格式化
System.out.println(startDate);
String changereadonly= "$('input[name=online_time]').attr(\"readonly\",false)";
((JavascriptExecutor) dr).executeScript(changereadonly);
dr.findElement(By.name("online_time")).click();
dr.findElement(By.name("online_time")).sendKeys(startDate);

//Calendar cd = Calendar.getInstance();  
c.add(Calendar.MONTH, mylength);  

Date dt=c.getTime();//date就是你需要的时间
System.out.println(dt);
String endDate= new SimpleDateFormat("yyyy-MM-dd hh:mm").format(c.getTime());
dr.findElement(By.name("end_time")).click();
dr.findElement(By.name("end_time")).sendKeys(endDate);

//dr.findElement(By.xpath("//id[@value='']")).click();
//dr.findElement(By.id("wrap")).findElement(By.className("qyzj-bm-btn")).click();
//dr.findElement(By.xpath("//*[@id=\"sub\"]")).click();
/*
 * 无法通过页面获取点击状态，通过jquery获取到指定位置，点击
 */
String changereadonly2= "$('#sub').click()";
((JavascriptExecutor) dr).executeScript(changereadonly2);
dr.switchTo().alert().accept();



Thread.sleep(1000);

dr.quit();
  }



@BeforeMethod

public void beforeMethod() throws Throwable {
	  
}

@AfterMethod

public void afterMethod() {



}	

}

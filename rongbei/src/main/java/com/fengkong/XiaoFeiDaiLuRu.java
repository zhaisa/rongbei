package com.fengkong;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XiaoFeiDaiLuRu {
	public void luRu(String login){
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		 WebDriver dr= new ChromeDriver();
		 Calendar cc=new GregorianCalendar();
			String time=new SimpleDateFormat("yyyyMMddhhmmss").format(cc.getTime());
	     dr.get("http://test-risk.irongbei.com/"); 
	     try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
       dr.findElement(By.id("username")).clear();
       dr.findElement(By.id("username")).sendKeys(login);
       dr.findElement(By.id("password")).clear();
       dr.findElement(By.id("password")).sendKeys("123456");
       dr.findElement(By.id("login")).click();
       try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
       dr.navigate().to("http://test-risk.irongbei.com/honloan/add.html");
       dr.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
       dr.findElement(By.id("province")).click();
		 Select s1=new Select(dr.findElement(By.id("province")));
		 s1.selectByValue("110000");
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 dr.findElement(By.id("city")).click();
			Select city=new Select(dr.findElement(By.id("city")));
			city.selectByValue("110100");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			dr.findElement(By.id("area")).click();
			Select area=new Select(dr.findElement(By.id("area")));
			area.selectByValue("110111");	
			 
		dr.findElement(By.name("name")).sendKeys("牧云"+time);	
		dr.findElement(By.name("applystarttime")).sendKeys(time);	
		dr.findElement(By.name("usaged")).sendKeys("资金周转");	
		dr.findElement(By.name("typed")).click();	
		 Select s2=new Select(dr.findElement(By.name("typed")));
		 s2.selectByValue("慧丽贷");
		dr.findElement(By.name("amountd")).sendKeys("100万");	
		dr.findElement(By.name("termd")).sendKeys("12");	
		dr.findElement(By.name("fmoeny")).sendKeys("10万");	
		dr.findElement(By.name("idcard")).sendKeys("110221198001019390");	
		dr.findElement(By.name("age")).sendKeys("26");	
		dr.findElement(By.name("iphone")).sendKeys("17409090010");	
		dr.findElement(By.name("phonetime")).sendKeys("3年");	
		dr.findElement(By.name("marrystare")).click();
		Select s3=new Select(dr.findElement(By.name("marrystare")));
		 s3.selectByValue("未婚");
		
		
		dr.findElement(By.name("sonnum")).sendKeys("暂无");	
		dr.findElement(By.name("gong")).sendKeys("暂无");	
		dr.findElement(By.name("xuli")).click();
		Select s4=new Select(dr.findElement(By.name("xuli")));
		 s4.selectByValue("博士");
		
		dr.findElement(By.name("regisd")).click();	
		Select s5=new Select(dr.findElement(By.name("regisd")));
		 s5.selectByValue("是");
		
		dr.findElement(By.name("chuzu")).click();	
		Select s6=new Select(dr.findElement(By.name("chuzu")));
		 s6.selectByValue("与父母同住");
		
		
		dr.findElement(By.name("qtime")).sendKeys(time);	
		dr.findElement(By.name("wtime")).sendKeys(time);
		dr.findElement(By.id("province1")).click();
		Select pro1= new Select(dr.findElement(By.id("province1")));
		pro1.selectByValue("370000");
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dr.findElement(By.id("city1")).click();
		Select city1=new Select(dr.findElement(By.id("city1")));
		city1.selectByValue("370600");
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dr.findElement(By.id("area1")).click();
		Select area1=new Select(dr.findElement(By.id("area1")));
		area1.selectByValue("370681");	
		dr.findElement(By.name("pro2info")).sendKeys("门前大桥下");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dr.findElement(By.id("province2")).click();
		Select lianxidizhi =new Select(dr.findElement(By.id("province2")));
		lianxidizhi.selectByValue("110000");
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dr.findElement(By.id("city2")).click();
		Select city2=new Select(dr.findElement(By.id("city2")));
		city2.selectByValue("110100");
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		dr.findElement(By.id("area2")).click();
		Select area2=new Select(dr.findElement(By.id("area2")));
		area2.selectByValue("110109");
		dr.findElement(By.name("pro3info")).sendKeys("游过一群鸭");	
		dr.findElement(By.name("email")).sendKeys("zhai@163.com");	
		dr.findElement(By.name("moeny")).sendKeys("10万");	
		dr.findElement(By.name("creditnum")).sendKeys("WX-000000000");	
		dr.findElement(By.name("provide")).sendKeys("622209787897897");	
		dr.findElement(By.name("social")).sendKeys("622209787897898");	
		dr.findElement(By.name("payrollcard")).sendKeys("622209787897899");	
		dr.findElement(By.name("provide_info")).sendKeys("咿呀咿呀呦！");
		dr.findElement(By.name("wokename")).sendKeys("中盛普惠有限公司");	
		dr.findElement(By.name("unitprop")).sendKeys("私营");	
		dr.findElement(By.name("position")).sendKeys("高级工程师");	
		dr.findElement(By.name("department")).sendKeys("研发部");	
		dr.findElement(By.name("posit")).sendKeys("中层领导");	
		dr.findElement(By.name("positime")).sendKeys(time);	
		dr.findElement(By.name("com_phone")).sendKeys("010-89789876");	
		dr.findElement(By.name("Presentunit")).sendKeys("朝阳门建外大街");	
		dr.findElement(By.name("wagedis")).sendKeys("银行代发");	
		
		dr.findElement(By.name("Subsector")).click();
		Select ss=new Select(dr.findElement(By.name("Subsector")));
		ss.selectByValue("14、水利、环境和公共设施管理业");
		dr.findElement(By.name("work_jt_zname_1")).sendKeys("牧云娟娟");	
		dr.findElement(By.name("work_jt_relationship_1")).sendKeys("姐姐");	
		dr.findElement(By.name("work_jt_zwokename_1")).sendKeys("融泰浩元有限公司");	
		dr.findElement(By.name("work_jt_zshocll_1")).sendKeys("朝阳门soho");	
		dr.findElement(By.name("work_jt_zposit_1")).sendKeys("总经理");	
		dr.findElement(By.name("work_jt_teach_1")).sendKeys("17409090011");	
//		String sss="$('添加').click";
//		 ((JavascriptExecutor) dr).executeScript(sss);
//		 dr.findElement(By.name("work_jt_zname_2")).sendKeys("牧云萌萌");	
//			dr.findElement(By.name("work_jt_relationship_2")).sendKeys("妹妹");	
//			dr.findElement(By.name("work_jt_zwokename_2")).sendKeys("融泰浩元有限公司");	
//			dr.findElement(By.name("work_jt_zshocll_2")).sendKeys("朝阳门soho");	
//			dr.findElement(By.name("work_jt_zposit_2")).sendKeys("总经理");	
//			dr.findElement(By.name("work_jt_teach_2")).sendKeys("17409090012");	
		dr.findElement(By.name("family_jt_zname_1")).sendKeys("牧云大爷");	
		dr.findElement(By.name("family_jt_relationship_1")).sendKeys("大爷");	
		dr.findElement(By.name("family_jt_zwokename_1")).sendKeys("在家");	
		dr.findElement(By.name("family_jt_zshocll_1")).sendKeys("河北省保定市");	
		dr.findElement(By.name("family_jt_zposit_1")).sendKeys("家里的大爷");	
		dr.findElement(By.name("family_jt_teach_1")).sendKeys("17409090011");	
		dr.findElement(By.name("emergency_jt_zname_1")).sendKeys("牧云蜜蜜");	
		dr.findElement(By.name("emergency_jt_relationship_1")).sendKeys("大姐");	
		dr.findElement(By.name("emergency_jt_zwokename_1")).sendKeys("牧云翟氏集团");	
		dr.findElement(By.name("emergency_jt_zshocll_1")).sendKeys("国贸CBD");	
		dr.findElement(By.name("emergency_jt_zposit_1")).sendKeys("国际总裁");	
		dr.findElement(By.name("emergency_jt_teach_1")).sendKeys("17409090012");	
		
	//	  dr.findElement(By.name("savetype")).click();
			
		dr.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div/div/div/button[2]")).click();	
			
			dr.close();
			dr.quit();
		 
		 
	       	
			
			
			
			
}
}
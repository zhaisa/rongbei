package com.irongbei;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.irongbeipages.LoginPage;

public class GetCookies {
	static WebDriver dr;

			
public WebDriver getDr() {
		return dr;
	}
	public void setDr(WebDriver dr) {
		this.dr = dr;
	}
public  void getCookies(WebDriver dr) throws InterruptedException, IOException {
	
	
	 Set<Cookie> cookies = dr.manage().getCookies();
	 File file=new File("E:\\2.txt");
	 if(file.exists()) {
		 file.delete();
		 file.createNewFile();
	 }
	 FileWriter fw=new FileWriter(file);
	 BufferedWriter bw = new BufferedWriter(fw);
	 Map<String,String> map =new HashMap();
     for (Cookie ck:cookies) {
		System.out.println("name :" + ck.getName() + "\n" + "value :" + ck.getValue()+ "\n" + "Domain:" + ck.getDomain());
     
         bw.write(ck.getName() + ";" + ck.getValue() + ";"
                 + ck.getDomain() + ";" + ck.getPath() + ";"
                 + ck.getExpiry() + ";" + ck.isSecure());
         bw.newLine();
      
     }
     bw.flush();
     bw.close();
     fw.close();
}


}

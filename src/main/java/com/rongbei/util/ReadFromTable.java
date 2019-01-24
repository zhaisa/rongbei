package com.rongbei.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadFromTable {
public void readFromTable(WebDriver dr,String xpath,String projectname) throws InterruptedException {
	Thread.sleep(1000);
	WebElement tbody = dr.findElement(By.xpath(xpath));
	List<WebElement> tr = tbody.findElements(By.tagName("tr"));
	Map<String, String> map = new HashMap();
	for (WebElement row : tr) {
		String trtext = row.getText();
		List<WebElement> td = row.findElements(By.tagName("td"));
		for (WebElement col : td) {
			String tdtext = col.getText();
//			System.out.println(tdtext);
			if (trtext.contains(projectname) && tdtext.contains("审核进行中")) {
				map.put("项目名称", td.get(0).getText());
				map.put("审核是否通过", td.get(9).getText());
				map.put("操作", td.get(12).getText());
			
		
			}

		}
	}

	for (WebElement row : tr) {
		if(row.getText().contains(projectname))  {
			dr.findElement(By.linkText("［标的注册］")).click();
						Thread.sleep(2000);
					
						dr.findElement(By.linkText("确认")).click();
						Thread.sleep(1000);
						dr.navigate().refresh();
						Thread.sleep(2000);
						dr.findElement(By.partialLinkText("上线")).click();
						dr.switchTo().alert().accept();
						Thread.sleep(2000);
						break;
			
		}
	}
}
}

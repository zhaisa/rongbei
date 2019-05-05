package com.irongbei;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GetNextHandle2 {
public void getNextHandle(WebDriver dr) throws InterruptedException {
	  String currentWindow = dr.getWindowHandle();
	    Set<String> handles = dr.getWindowHandles();
		Iterator<String> it= handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = dr.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + "," + window.getCurrentUrl());
			String sss1 = window.getCurrentUrl();
			Thread.sleep(1000);
			dr.navigate().to(sss1);}
	        Thread.sleep(2000);
}
}

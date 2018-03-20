package com.fengkong;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GetOpions {
private WebDriver dr;
private String para;
public static void doRandomSelect(WebElement e, int start) {
	Select s = new Select(e);
	List<WebElement> list = s.getOptions();// 获得下拉框内的所有选项
	System.out.println(list.size());

	if (start > list.size()) {
		start = list.size() - 1;
	}
}
}
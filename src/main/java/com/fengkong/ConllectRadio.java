package com.fengkong;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConllectRadio {
public String conllectRadio(String name) {
WebDriver dr=new ChromeDriver();
	List<WebElement> radio = dr.findElements(By.name(name));
	radio.get(0).click();
	return null;}
}

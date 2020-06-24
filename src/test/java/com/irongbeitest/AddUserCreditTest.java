package com.irongbeitest;

import org.testng.annotations.Test;

import com.irongbei.AddUerCredit;

public class AddUserCreditTest {
//@Test(dataProvider="myphone")
public static void main(String[] args) throws InterruptedException {
String phone="17409240066";
int j=2;
AddUerCredit ac=new AddUerCredit();
	for(int i=0;i<j;i++) {
	
	ac.addUserCredit(phone,"抵现券");
	/*
	 * 现金券 加息券 限时加息券 减免券
	 */
}
	for(int i=0;i<j;i++) {
	
	ac.addUserCredit(phone,"加息券");
	/*
	 * 现金券 加息券 限时加息券 减免券
	 */
}
	for(int i=0;i<j;i++) {
	
	ac.addUserCredit(phone,"限时加息券");
	/*
	 * 现金券 加息券 限时加息券 减免券
	 */
}
}
}
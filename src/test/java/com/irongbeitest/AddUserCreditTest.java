package com.irongbeitest;

import com.irongbei.AddUerCredit;

public class AddUserCreditTest {
public static void main(String[] args) throws InterruptedException {
String phone="17409040045";
int j=10;
	
//	for(int i=0;i<j;i++) {
//	AddUerCredit ac=new AddUerCredit();
//	ac.addUserCredit(phone,"现金券");
//	/*
//	 * 现金券 加息券 限时加息券 减免券
//	 */
//}
	for(int i=0;i<j;i++) {
	AddUerCredit ac=new AddUerCredit();
	ac.addUserCredit(phone,"加息券");
	/*
	 * 现金券 加息券 限时加息券 减免券
	 */
}
	for(int i=0;i<j;i++) {
	AddUerCredit ac=new AddUerCredit();
	ac.addUserCredit(phone,"限时加息券");
	/*
	 * 现金券 加息券 限时加息券 减免券
	 */
}
}
}
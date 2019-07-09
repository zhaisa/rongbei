package com.irongbeitest;

import com.irongbei.ChangePhone;

public class ChangePhoneTest {

 public static void main(String[] args) {
	 ChangePhone cp=new ChangePhone();
	 for(int i=0;i<1;i++) {
	 try {
		cp.changePhone("17409040014","18701473018","test");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
}
}
}
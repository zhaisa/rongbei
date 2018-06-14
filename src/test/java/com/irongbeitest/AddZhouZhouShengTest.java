package com.irongbeitest;

import com.irongbei.AddZhouZhouSheng;

public class AddZhouZhouShengTest {
public static void main(String[] args) throws InterruptedException {
	AddZhouZhouSheng azz=new AddZhouZhouSheng();
	for(int i=0;i<10;i++) {
		azz.addZhouZhouSheng("3", "1", 3, 2018, 6, 3);//zq, money, mylength, myyear, mymonth, myday
	}
}
}

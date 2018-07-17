package com.irongbeitest;

import com.irongbei.AddZhouZhouSheng;

public class AddZhouZhouShengTest {
public static void main(String[] args) throws InterruptedException {
	AddZhouZhouSheng azz=new AddZhouZhouSheng();
	for(int i=0;i<2;i++) {
		azz.addZhouZhouSheng("3", "2", 3, 2018, 6,16);//zq, money, mylength, myyear, mymonth, myday
	}
}
}

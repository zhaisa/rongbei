package com.irongbeitest;

import com.irongbei.AddZhouZhouShengPlan;

public class AddZzsPlanTest {
public static void main(String[] args) {
	AddZhouZhouShengPlan azz=new AddZhouZhouShengPlan();
	for(int i=10;i<19;i++) {
		try {
			azz.createZzs(i,2018,05,28);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
}

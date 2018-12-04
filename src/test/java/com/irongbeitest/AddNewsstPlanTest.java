package com.irongbeitest;

import com.irongbei.AddNewShengxtPlan;

public class AddNewsstPlanTest {
public static void main(String[] args) {
	AddNewShengxtPlan sst=new AddNewShengxtPlan();
	for(int i=3;i<6;i++) {
		try {
			sst.createSst(i, 2018, 8, 13);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
}

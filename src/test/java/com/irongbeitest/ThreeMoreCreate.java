package com.irongbeitest;

import com.irongbei.CreateDaBiao;
import com.irongbei.CreateXiaoBiao;
import com.irongbei.CreateZhiTou;

public class ThreeMoreCreate {
public static void main(String[] args) {
	CreateDaBiao cdb=new CreateDaBiao();
	CreateXiaoBiao cxb=new CreateXiaoBiao();
	CreateZhiTou czt=new CreateZhiTou();
	for (int i=0;i<2;i++) {
		
		try {
			cdb.createDaBiao("3", 3, 2018, 3, 25);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			cxb.createXiaoBiao("3", 3, 2018, 3, 25);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			czt.createZhiTou("3", 3, 2018, 3, 25);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
}
}

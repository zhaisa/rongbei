package com.irongbeitest;

import com.irongbei.CreateDaBiaoJiHua;

public class CreateDaBiaoJiHuaTest {
	public static void main(String[] args) {
		CreateDaBiaoJiHua cdbjh=new  CreateDaBiaoJiHua();
		
		try {
			cdbjh.createDaBiaoJiHua("3", 2018, 2, 24);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}

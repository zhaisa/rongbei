package com.irongbeitest;

import com.irongbei.BuyXiaoBiao;

public class BuyXiaoBiaoTest {
	public static void main(String[] args) {
		BuyXiaoBiao bt = new BuyXiaoBiao();
		for (int i = 0; i < 1; i++) {
			try {
				bt.testPlan("17409040107",11698,"1000");//String name,int id,String money
				bt.testPlan("17409040107", 11698,"3000");
				bt.testPlan("17409040107", 11698,"6000");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

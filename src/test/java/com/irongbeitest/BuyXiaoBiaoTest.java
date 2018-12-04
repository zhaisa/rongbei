package com.irongbeitest;

import com.irongbei.BuyXiaoBiao;

public class BuyXiaoBiaoTest {
	public static void main(String[] args) {
		BuyXiaoBiao bt = new BuyXiaoBiao();
		String phone="17409040125";
		int projectid=11780;
		String price1="3000";
		String price2="3000";
		String price3="4000";		
		for (int i = 0; i < 1; i++) {
			try {
//				bt.testPlan(phone, projectid, price1);// String name,int id,String money
//				bt.testPlan(phone, projectid, price2);
				 bt.testPlan(phone, projectid,price3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

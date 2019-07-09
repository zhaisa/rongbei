package com.irongbeitest;

import com.irongbei.BuyXiaoBiao;

public class BuyXiaoBiaoTest {
	public static void main(String[] args) {
		BuyXiaoBiao bt = new BuyXiaoBiao();
		String phone="17409040754";
		int projectid=15334;
		String price1="1000";
//		String price2="3000";
//		String price3="5000";
		
		for (int i = 0; i < 10; i++) {
			try {
				bt.testPlan(phone, projectid, price1);// String name,int id,String money
//				bt.testPlan(phone, projectid, price2);
//				 bt.testPlan(phone, projectid,price3);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

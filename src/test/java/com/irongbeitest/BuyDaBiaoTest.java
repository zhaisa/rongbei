package com.irongbeitest;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoTest {

	public static void main(String[] args) {
		int Projectid=176;
		String user="17409040300";
		String price1="100";
//		String price2="3000";
//		String price3="5000";
		String leixing="3";//先息后本
		for (int i = 1; i < 2; i++) {
			try {
				BuyDaBiao.testPlan(Projectid,price1,leixing,user);//id,account,key,3为本息复投，4为先息后本
//				BuyDaBiao.testPlan(Projectid,price2,leixing,user);
//				BuyDaBiao.testPlan(Projectid,price3,leixing,user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

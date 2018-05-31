package com.irongbeitest;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoTest {

	public static void main(String[] args) {
		for (int i = 1; i < 3; i++) {
			try {
				BuyDaBiao.testPlan(160,"1000","b3871efb44927ef9b0dd1e953206ff7a");//id,account,key
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

package com.irongbeitest;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoTest {

	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			try {
				BuyDaBiao.testPlan(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

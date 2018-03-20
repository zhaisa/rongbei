package com.irongbeitest;

import com.irongbei.AddMoney;

public class AddMoneyTest {
	public static void main(String[] args) {
		AddMoney am = new AddMoney();
		for (int i = 0; i < 12; i++) {
			try {
				am.addMoney(i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

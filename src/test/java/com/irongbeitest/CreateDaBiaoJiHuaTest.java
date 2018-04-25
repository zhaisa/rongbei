package com.irongbeitest;

import com.irongbei.CreateDaBiaoJiHua;

public class CreateDaBiaoJiHuaTest {
	public static void main(String[] args) {
		CreateDaBiaoJiHua cdbjh = new CreateDaBiaoJiHua();
		for (int i = 0; i < 1; i++) {
			try {
				cdbjh.createDaBiaoJiHua("3", 2018, 4, 25);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}
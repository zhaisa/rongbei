package com.irongbeitest;

import com.irongbei.CreateDaBiaoJiHua;

public class CreateDaBiaoJiHuaTest {
	public static void main(String[] args) {
		CreateDaBiaoJiHua cdbjh = new CreateDaBiaoJiHua();
		for (int i = 0; i < 2; i++) {
			try {
				cdbjh.createDaBiaoJiHua("3", 2018, 1, 27);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
}
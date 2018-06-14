package com.irongbeitest;

import com.irongbei.KaiTongCunGan;

public class KaiTongCunGuanTest {
	public static void main(String[] args) {
		KaiTongCunGan kt = new KaiTongCunGan();
		for (int i = 0; i < 1; i++) {
			try {
				KaiTongCunGan.testPlan("17409040014","420101198101015655","6222023843472885962");//String userphone,String usercard,String bankcard
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
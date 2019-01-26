package com.fengkongtest;

import com.fengkong.XiaoFeiDaiTongShanLuRu;

public class XiaoFeiDaiTongShanLuRuTest {
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
		XiaoFeiDaiTongShanLuRu xfdlr=new XiaoFeiDaiTongShanLuRu();
		xfdlr.luRu();//
		
		System.out.println(i);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	}
}

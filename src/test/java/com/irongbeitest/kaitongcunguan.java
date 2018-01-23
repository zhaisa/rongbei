package com.irongbeitest;

import com.irongbei.KaiTongCunGan;

public class kaitongcunguan {
public static void main(String[] args) {
	KaiTongCunGan kt=new KaiTongCunGan();
	for(int i=0;i<99;i++) {
	try {
		KaiTongCunGan.testPlan(i);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
}
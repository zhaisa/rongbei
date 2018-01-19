package com.irongbei;

import com.irongbei.KaiTongCunGan;

public class kaitongcunguan {
public static void main(String[] args) {
	KaiTongCunGan kt=new KaiTongCunGan();
	for(int i=0;i<99;i++) {
	try {
		kt.testPlan(i);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
}
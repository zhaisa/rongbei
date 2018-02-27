package com.fengkongtest;

import com.fengkong.XiaoFeiDaiLuRu;

public class XiaoFeiDaiTest {
public static void main(String[] args) {
	for(int i=0;i<5;i++) {
	XiaoFeiDaiLuRu xfdlr=new XiaoFeiDaiLuRu();
	xfdlr.luRu("zsphtest");//zsphtest,tstest
	
	System.out.println(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
}
}
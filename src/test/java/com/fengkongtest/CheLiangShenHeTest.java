package com.fengkongtest;

import com.fengkong.CheLiangShenHe;

public class CheLiangShenHeTest {
public static void main(String[] args) {
	CheLiangShenHe clsh=new CheLiangShenHe();
	for(int i=0;i<6;i++) {
	clsh.shenHe(i);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
}
}
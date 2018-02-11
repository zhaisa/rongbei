package com.fengkongtest;

import com.fengkong.FangDiDaiLuRu;

public class FangDiDaiTest {
	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
	
	FangDiDaiLuRu fdd=new FangDiDaiLuRu();
	fdd.luRu();
	System.out.println(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}}
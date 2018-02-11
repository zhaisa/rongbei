package com.fengkongtest;

import com.fengkong.CheLiangDiZhiYaLuRu;

public class CheLiangDiZhiYaLuRuTest {
public static void main(String[] args) {
	for(int i=0;i<20;i++) {
	CheLiangDiZhiYaLuRu lr=new CheLiangDiZhiYaLuRu();
	lr.luRu("lbtest");//lbtest,yctest1
	System.out.println(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
}
}
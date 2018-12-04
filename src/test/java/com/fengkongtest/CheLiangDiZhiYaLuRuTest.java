package com.fengkongtest;

import com.fengkong.CheLiangDiZhiYaLuRu;

public class CheLiangDiZhiYaLuRuTest {
public static void main(String[] args) throws InterruptedException {
	for(int i=0;i<1;i++) {
	CheLiangDiZhiYaLuRu lr=new CheLiangDiZhiYaLuRu();
	lr.luRu("lbtestlgt");//lbtest,yctest1
	System.out.println(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
}
}
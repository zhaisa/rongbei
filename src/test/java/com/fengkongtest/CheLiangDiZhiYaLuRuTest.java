package com.fengkongtest;

import com.fengkong.CheLiangDiZhiYaLuRu;

public class CheLiangDiZhiYaLuRuTest {
public static void main(String[] args) throws InterruptedException {
	for(int i=0;i<1;i++) {
	CheLiangDiZhiYaLuRu lr=new CheLiangDiZhiYaLuRu();
	lr.luRu("lbtestlgt",50000,100000);//lbtest,yctest1，借款金额，估价金额
	System.out.println(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
}
}
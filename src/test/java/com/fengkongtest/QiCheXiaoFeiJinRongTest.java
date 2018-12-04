package com.fengkongtest;

import com.fengkong.QiCheXiaoFeiJinRongLuRu;

public class QiCheXiaoFeiJinRongTest {
public static void main(String[] args) {
	for(int i=0;i<10;i++) {
	QiCheXiaoFeiJinRongLuRu qcxf=new QiCheXiaoFeiJinRongLuRu();
	qcxf.luRu("sccdktestlgt");//jrtest,ycwytest,yctestlgt
	System.out.println(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
}
}
}
package com.irongbeitest;

import com.irongbei.CreateZhiTou;

public class CreateZhiTouTest {
	public static void main(String[] args) {
		CreateZhiTou cz=new CreateZhiTou();
		for(int i=1;i<2;i++){
	try {
		cz.createZhiTou("3",3, 2018,1,27,i);//周期、间隔、开始日期
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
	}

}

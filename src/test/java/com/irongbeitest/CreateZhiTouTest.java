package com.irongbeitest;

public class CreateZhiTouTest {
	public static void main(String[] args) {
		com.irongbei.CreateZhiTou cz=new com.irongbei.CreateZhiTou();
		for(int i=1;i<3;i++){
	try {
		cz.createZhiTou("3",3, 2018,3,10);//周期、间隔、开始日期
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	}

}

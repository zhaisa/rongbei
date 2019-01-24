package com.fengkongtest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.fengkong.FangDiDaiLuRu;



public class FangDiDaiLuRuTest {
	
	public static void main(String[] args) throws InterruptedException {
	

		Logger logger = Logger.getLogger(FangDiDaiLuRuTest.class);
		BasicConfigurator.configure();
		// PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		logger.setLevel(Level.INFO);	
		
	for(int i=0;i<1;i++) {
	
	FangDiDaiLuRu fdd=new FangDiDaiLuRu();
	fdd.luRu("900000","1000000");//一低余额，总估价金额
	System.out.println(i);
//	logger.info(i);
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}}
package com.irongbeitest;

import java.io.IOException;

import com.irongbei.SitAndUat;

public class SitAndUatTest {

  public static void main(String[] args) {
	  SitAndUat sadd=new SitAndUat();
	 for(int i=0;i<1538;i++) {
	  try {
		sadd.sit(i);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
}
}
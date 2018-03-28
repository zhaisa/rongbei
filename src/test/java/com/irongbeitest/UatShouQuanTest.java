package com.irongbeitest;

import java.io.IOException;

import com.irongbei.UatShouQuan;

public class UatShouQuanTest {

	public static void main(String[] args) throws InterruptedException {
		UatShouQuan usq=new UatShouQuan();
		for(int i=0;i<110;i++) {
			try {
				usq.uatShouQuan(i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

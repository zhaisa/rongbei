package com.irongbeitest;

public class CeateXiaoBiaoTest {
public static void main(String[] args) throws Exception {
	com.irongbei.CreateXiaoBiao ct=new com.irongbei.CreateXiaoBiao();
			
		for(int i=1;i<2;i++){
			try {
				ct.createXiaoBiao("3", 3, 2018, 3, 10);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
}
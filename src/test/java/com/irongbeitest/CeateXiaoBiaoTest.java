package com.irongbeitest;

import com.irongbei.CreateXiaoBiao;

public class CeateXiaoBiaoTest {
public static void main(String[] args) throws Exception {
	CreateXiaoBiao ct=new CreateXiaoBiao();
			
		for(int i=1;i<3;i++){
			try {
				ct.createXiaoBiao("3", 3, 2018, 3, 24,i);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
}
}
}
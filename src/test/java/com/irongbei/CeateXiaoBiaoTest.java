package com.irongbei;

import com.irongbei.CreateXiaoBiao;

public class CeateXiaoBiaoTest {
public static void main(String[] args) throws Exception {
	CreateXiaoBiao ct=new CreateXiaoBiao();
			
		for(int i=1;i<2;i++){
			try {
				ct.createXiaoBiao("3", 3, 2018, 2, 18);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
}
}
package com.irongbei;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoJiHua {

	public static void main(String[] args) {
		for(int i=1;i<201;i++){
	try {
		BuyDaBiao.testPlan(i);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	}

}
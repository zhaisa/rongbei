package BuyXB;

import addpackage.BuyXiaoBiao;

public class BuyXiB {
	public static void main(String[] args) {
		BuyXiaoBiao bt= new BuyXiaoBiao();
	for(int i=0;i<11;i++) {
		try {
			bt.testPlan(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}
}

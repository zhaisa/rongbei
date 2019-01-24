package AboutNewDaBiao;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoTest {

	public static void main(String[] args) {
		int Projectid=1594;
		int Projectid2=1595;
		int Projectid3=1596;
		String user="17409040272";
		String user1="17409040273";
		String user2="17409040274";
		String price="1000";
		String price1="4000";
		String price2="3000";
		String price3="2000";
		String price4="2500";
		String price5="2500";
//		String price6="1500";
//		String price7="2400";
		String leixing="3";
		String leixing1="3";
		String leixing2="3";
		String leixing3="3";
		String leixing4="3";
		String leixing5="3";
//		String leixing6="3";
//		String leixing7="3";

		for (int i = 1; i < 2; i++) {
			try {
				BuyDaBiao.testPlan(Projectid,price,leixing,user);
				BuyDaBiao.testPlan(Projectid,price1,leixing1,user);//id,account,key,3为本息复投，4为先息后本
				BuyDaBiao.testPlan(Projectid2,price2,leixing2,user1);
				BuyDaBiao.testPlan(Projectid2,price3,leixing3,user1);
				BuyDaBiao.testPlan(Projectid3,price4,leixing4,user2);
				BuyDaBiao.testPlan(Projectid3,price5,leixing5,user2);
//				BuyDaBiao.testPlan(Projectid,price6,leixing6,user);
//				BuyDaBiao.testPlan(Projectid,price7,leixing7,user);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

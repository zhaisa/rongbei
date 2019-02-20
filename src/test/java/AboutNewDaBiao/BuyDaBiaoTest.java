package AboutNewDaBiao;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoTest {

	public static void main(String[] args) {
		int Projectid=5700;
//		int Projectid2=1595;
//		int Projectid3=1596;
//		String user="17409160006";
		String user1="17409160011";
//		String user2="17409040274";
		String price="300";
		String price1="400";
		String price2="500";
		String price3="600";
		String price4="700";
		String price5="800";
		String price6="900";
		String price7="1000";
		String price8="1100";
		String price9="1200";
		String price10="1300";
		String price11="100";
		String price12="200";
		String price13="300";
		String price14="600";
		
		String leixing="3";
		String leixing1="3";
		String leixing2="3";
		String leixing3="3";
		String leixing4="3";
		String leixing5="3";
		String leixing6="3";
		String leixing7="3";

		for (int i = 1; i < 2; i++) {
			try {
				BuyDaBiao.testPlan(Projectid,price,leixing,user1);
				BuyDaBiao.testPlan(Projectid,price1,leixing1,user1);//id,account,key,3为本息复投，4为先息后本
				BuyDaBiao.testPlan(Projectid,price2,leixing2,user1);
				BuyDaBiao.testPlan(Projectid,price3,leixing3,user1);
				BuyDaBiao.testPlan(Projectid,price4,leixing4,user1);
				BuyDaBiao.testPlan(Projectid,price5,leixing5,user1);
				BuyDaBiao.testPlan(Projectid,price6,leixing6,user1);
				BuyDaBiao.testPlan(Projectid,price7,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price8,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price9,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price10,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price11,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price12,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price13,leixing7,user1);
				BuyDaBiao.testPlan(Projectid,price14,leixing7,user1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

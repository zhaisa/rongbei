package AboutNewDaBiao;

import com.irongbei.BuyDaBiao;

public class BuyDaBiaoTest {

	public static void main(String[] args) {
		int Projectid=691;
		String user="17409040197";
		String price="100";
		String price1="1000";
		String price2="1100";
		String price3="1200";
		String price4="1300";
		String price5="1400";
		String price6="1500";
		String price7="2400";
		String leixing="4";
		String leixing1="3";
		String leixing2="4";
		String leixing3="4";
		String leixing4="4";
		String leixing5="3";
		String leixing6="3";
		String leixing7="3";

		for (int i = 1; i < 2; i++) {
			try {
				BuyDaBiao.testPlan(Projectid,price,leixing,user);
				BuyDaBiao.testPlan(Projectid,price1,leixing1,user);//id,account,key,3为本息复投，4为先息后本
				BuyDaBiao.testPlan(Projectid,price2,leixing2,user);
				BuyDaBiao.testPlan(Projectid,price3,leixing3,user);
				BuyDaBiao.testPlan(Projectid,price4,leixing4,user);
				BuyDaBiao.testPlan(Projectid,price5,leixing5,user);
				BuyDaBiao.testPlan(Projectid,price6,leixing6,user);
				BuyDaBiao.testPlan(Projectid,price7,leixing7,user);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

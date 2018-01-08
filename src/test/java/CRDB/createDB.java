package CRDB;

import addpackage.CreateDaBiao;

public class createDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDaBiao cdb=new CreateDaBiao();
		for(int i=1;i<2;i++) {
			try {
				cdb.createDaBiao("3", 3, 2018, 2, 5);//周期为3个月，时间间隔设置为3,2018年3月5号
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

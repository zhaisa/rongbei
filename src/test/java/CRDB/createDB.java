package CRDB;

import addpackage.CreateDaBiao;

public class createDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateDaBiao cdb=new CreateDaBiao();
		for(int i=1;i<2;i++) {
			try {
				cdb.createDaBiao();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

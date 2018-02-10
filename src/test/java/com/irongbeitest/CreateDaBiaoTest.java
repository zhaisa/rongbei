package com.irongbeitest;

import com.irongbei.CreateDaBiao;

public class CreateDaBiaoTest {

	public static void main(String[] args) {
			CreateDaBiao cdb=new CreateDaBiao();
		for(int i=1;i<2;i++) {
			try {
				cdb.createDaBiao("3", 3, 2018,4,26);//周期为3个月，时间间隔设置为3,2018年3月5号
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

package com.irongbeitest;

import com.irongbei.CreateNewDaBiao;

public class CreateNewDaBiaoTest {

	public static void main(String[] args) {

		for (int i = 0; i < 2; i++) {
			CreateNewDaBiao cdb = new CreateNewDaBiao();
			try {
				cdb.createNewDaBiao("3", 3, 2018, 10, 19,"1");// 周期为3个月，时间间隔设置为3,2018年3月5号 最后一位为万元一
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
	}

}

package com.irongbeitest;

import com.irongbei.CreateDaBiao;

public class CreateDaBiaoTest {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			CreateDaBiao cdb = new CreateDaBiao();
			try {
				cdb.createDaBiao("3", 3, 2018, 2, 8);// 周期为3个月，时间间隔设置为3,2018年3月5号
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

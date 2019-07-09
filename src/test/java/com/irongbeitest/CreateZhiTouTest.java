package com.irongbeitest;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.irongbei.CreateZhiTou;

public class CreateZhiTouTest {
	public static void main(String[] args) {
		CreateZhiTou cz = new CreateZhiTou();
		Calendar c = new GregorianCalendar();
		
		for (int i = 1; i < 2; i++) {
			try {
				cz.createZhiTou("6", 6, 2019, 6, 9,"test");// 周期、间隔、开始日期

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}

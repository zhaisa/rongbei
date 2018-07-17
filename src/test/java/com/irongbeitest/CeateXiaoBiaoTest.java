package com.irongbeitest;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.irongbei.CreateXiaoBiao;

public class CeateXiaoBiaoTest {
	public static void main(String[] args) throws Exception {
		CreateXiaoBiao ct = new CreateXiaoBiao();
Calendar cc =new GregorianCalendar();
cc.set(Calendar.MONTH, 0);
		for (int i = 0; i <1; i++) {
			try {
				ct.createXiaoBiao("3", 3, 2018, 5, 22);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}
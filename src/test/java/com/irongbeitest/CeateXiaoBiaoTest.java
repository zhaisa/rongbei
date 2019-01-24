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
				ct.createXiaoBiao("6", 6, 2019, 0, 14);//String zq, int mylength, int myyear, int mymonth, int myday
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
}
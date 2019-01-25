package com.irongbei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rongbei.util.Excel_reader;

import KaiHu.KaiHuTest;

public class KaiHuForTestNG {
	@Test(dataProvider = "mydata", invocationCount = 100)
	public void kaiHu(Map<String, String> map) throws Exception {
		String phone = map.get("phone");
		String usercard = map.get("usercard");
		String bankcard = map.get("bankcard");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());

		}

		Logger logger = Logger.getLogger(KaiHuForTestNG.class);
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
		ChangePhone cp = new ChangePhone();
		KaiTongCunGan kt = new KaiTongCunGan();
		SetSecret ss = new SetSecret();
		ChangePhoneBack cp1 = new ChangePhoneBack();
		CePing cp11 = new CePing();
		// 融贝后台修改成手机号
		cp.changePhone(phone, "18701473018");
		Thread.sleep(1000);
		// 开通存管
		KaiTongCunGan.testPlan(phone, usercard, bankcard);// 手机号，身份证，银行卡号j
		Thread.sleep(1000);
		// 解放原来的手机号
		ShouQuan sq = new ShouQuan();
		sq.shouQuan(phone);
		cp1.changePhoneBack(phone);
		System.out.println(phone);
		cp11.cePing(phone);
	}

	@DataProvider(name = "mydata")
	public Object[][] getmydata() throws IOException {
		Excel_reader er = new Excel_reader();
		ArrayList<ArrayList<String>> arr = er.xlsx_reader("D:\\users\\mydata.xlsx", 0, 1, 2);
		Map<String, String> map = new HashMap<String, String>();
		List<String> list=new ArrayList<String>();
		for (int i = 1; i < arr.size(); i++) {
			ArrayList<String> row = arr.get(i);
			for (int j = 0; j < row.size(); j++) {
				System.out.print(row.get(j) + " ");
			list.add(row.get(j));
			}
			System.out.println("");
			
		}

		return new Object[][] { { map } };
	}
}

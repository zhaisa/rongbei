package com.irongbei;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rongbei.util.Excel_reader;

public class KaiHuForTestNG {
	@Test(dataProvider = "mydata")
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
		cp.changePhone(phone, "18701473018","test");
		Thread.sleep(1000);
		// 开通存管
		KaiTongCunGan.testPlan(phone, usercard, bankcard,"test");// 手机号，身份证，银行卡号j
		Thread.sleep(1000);
		// 解放原来的手机号
		ShouQuan sq = new ShouQuan();
		sq.shouQuan(phone,"test");
		cp1.changePhoneBack(phone,phone,"test");
		System.out.println(phone);
		cp11.cePing(phone,"test");
	}


	public Object[][] getmydata() throws IOException {
		Logger logger = Logger.getLogger(KaiHuForTestNG.class);
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);
		Excel_reader er = new Excel_reader();
		ArrayList<ArrayList<String>> arr = er.xlsx_reader("D:\\users\\mydata.xlsx", 0, 1, 2);
		ArrayList<String> arrkey = new ArrayList<String>();
		HashMap<String, String>[][] map = new HashMap[arr.size() - 1][1];
		List<String> list = new ArrayList<String>();
		if (arr.size() > 1) {
			
			for (int i = 0; i < arr.size()-1 ; i++) {
				map[i][0] = new HashMap();
			}
		} else {
			logger.error("测试的Excel" + "D:\\users\\mydata.xlsx" + "中没有数据");
		}
		// 获得首行的列名，作为hashmap的key值
		 for (int c = 0; c < arr.size(); c++) {
			 ArrayList<String> row = arr.get(c);
			 for (int j = 0; j < row.size(); j++) {
	            String cellvalue =row.get(j);
	            arrkey.add(cellvalue);
	        }
		 }
		for (int i = 1; i < arr.size(); i++) {
			System.out.println(arr.size());
			ArrayList<String> row = arr.get(i);
			for (int j = 0; j < row.size(); j++) {
				System.out.print(row.get(j) + " ");
				String cellvalue = row.get(j);
				map[i - 1][0].put(arrkey.get(j), cellvalue);

			}
			System.out.println("");
			
		}

		return map;
	}
	@DataProvider(name = "mydata")
	public Object[][] getdata01() throws IOException {
		Object[][] map=getmydata();
		return map;

	}
}

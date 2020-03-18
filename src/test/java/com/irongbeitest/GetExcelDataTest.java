package com.irongbeitest;

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

import KaiHu.KaiHuTest;

public class GetExcelDataTest {
	 public static void main(String[] args) throws IOException {
	 getData();
	 }
	@DataProvider(name = "data01")
	public Object[][] getdata01() throws IOException {
		Object[][] map=getData();
		return map;

	}

	public static Object[][] getData() throws IOException {
		Logger logger = Logger.getLogger(KaiHuTest.class);
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

	@Test(dataProvider = "data01")
	public void testConnection(HashMap<String, String> data) {

		for (Map.Entry<String, String> entry : data.entrySet()) {
			System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
		}

	}
}

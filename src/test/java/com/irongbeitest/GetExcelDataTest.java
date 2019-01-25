package com.irongbeitest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rongbei.util.Excel_reader;

public class GetExcelDataTest {
//	public static void main(String[] args) throws IOException {
//		getdata();
//	}
@DataProvider(name="data01")
public Object[][] getdata01() throws IOException{
	 Map<String, String> map=getData();
	   return new Object[][] { { map } };
	
}
public  Map<String, String> getData() throws IOException {
	Excel_reader er=new Excel_reader();
	  ArrayList<ArrayList<String>> arr= er.xlsx_reader("D:\\users\\mydata.xlsx", 0,1,2);
	  Map<String,String> map=new HashMap();
	  for(int i=1;i<arr.size();i++){
			ArrayList<String> row=arr.get(i);
			for(int j=0;j<row.size();j++){
				System.out.print(row.get(j)+" ");
				map.put("phone", row.get(0));
				map.put("usercard", row.get(1));
				map.put("bankcard", row.get(2));
				
			}
			System.out.println("");
		
		}
	return map;
}

@Test(dataProvider = "data01",invocationCount=3)
public void testConnection(Map<String, String> map) {

    for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println("[Key] : " + entry.getKey() + " [Value] : " + entry.getValue());
    }

}
}

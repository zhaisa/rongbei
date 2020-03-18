package com.rongbei.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GetAllTxtContent {
	public static void main(String[] args) throws IOException {
		getTxt("E:\\allwrong\\");
	}

	// 读取txt内容
	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		BufferedWriter bufWriter = null;
		FileWriter fw = null;
		String ss =null;
		List list = new ArrayList();
		List list2 = new ArrayList();
		int[][] bb=null;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s = null;
			while ((s = br.readLine()) != null) {
				String aa[] = s.split(" ");
				list.add(aa[0]);

			}
			for (int j = 0; j < list.size(); j++) {
			
				if (j >= 2 & list.get(j) != " ") {
					result.append(list.get(j));				
					ss = list.get(j).toString();
									
						File ff = new File("E:\\neww\\aa.txt");
						fw = new FileWriter(ff, true);
						bufWriter = new BufferedWriter(fw);
						bufWriter.write(ss.substring(ss.length()-7));
						bufWriter.newLine();
//						System.out.println(ss.substring(ss.length()-7));	
						list2.add(ss.substring(ss.length()-7));
				}
				

			}
			int count=0;
			Map<String,Integer> map=new HashMap<String,Integer>();
			String[] news = new String[list2.size()];	
		for(int k=0;k<list2.size();k++) {
			System.out.println(list2.get(k).toString());
			news[k]=list2.get(k).toString();
		}			
		for(String temp:news) {
			if(!map.containsKey(temp)) {
				map.put(temp, 0);
			}
			map.put(temp, map.get(temp)+1);
		}
		Set<String> keys=map.keySet();
		for(String key:keys){
			int count1=map.get(key);
			System.out.println("该文件中编号："+key+",出现次数"+count1);
			
		}
//			System.out.println(list2.size());
			System.out.println(file+"文件有"+(list.size()-2)+"条数据");
			bufWriter.close();
			fw.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}


	public static void getTxt(String path) throws IOException {
		// path = "E:\\allwrong\\";

		File all = new File(path);
		List content = new ArrayList();
		File[] fff = null;
		// 将全部txt存到数组
		if (path != null) {
			fff = new File(path).listFiles();
		}
		System.out.println("一共有" + fff.length + "个文件");
		// 读取txt内容 并转换成List
		for (int i = 0; i < fff.length; i++) {
			txt2String((File) fff[i]);
			

		}

	}
}

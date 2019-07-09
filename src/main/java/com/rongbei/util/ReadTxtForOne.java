package com.rongbei.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTxtForOne {
	public String readline() throws IOException {

		// 获取路径
		String relativelyPath = System.getProperty("user.dir");
		String filed = relativelyPath + "\\user.txt";
		File file = new File(filed);
		System.out.println(file);
		String str = null;
		String mystr=null;
		// 将读取出来的数据存入list集合、一个备份、一个正常运行

		
			// 判断文件是否存在、并且有内容
			if (file.exists() && !(file.exists() && file.length() == 0)) {
				System.out.println("文件存在并且有内容");

				try {
					ArrayList<String> list = new ArrayList<String>();
					// BufferedReader是可以按行读取文件
					FileInputStream inputStream = new FileInputStream(filed);
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

					while ((str = bufferedReader.readLine()) != null) {
						// 如果有空格、去掉空格
						if (str.contains(" ")) {
							Pattern p = Pattern.compile("\\s*|\t|\r|\n");
							Matcher m = p.matcher(str);
							str = m.replaceAll("");
						}
						// 如果不是空串、添加到list、然后提交
						if (!str.equals("")) {
							System.out.println(str);
							list.add(str);
							/**
							 * 可以在添加到list后、根据需求操作文件中第一条数据
							 */
							System.out.println("提交");
						}
					}
					mystr=list.get(0);
					bufferedReader.close();
					inputStream.close();
					// 删除第一行、、写回到文本
					list.remove(0);
					FileOutputStream fileOutputStream = new FileOutputStream(filed);
					OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
					BufferedWriter bw = new BufferedWriter(outputStreamWriter);

					if (list.size() != 0)
						for (String string : list) {
							bw.write(string);
							bw.newLine();
							System.out.println(string);
						}
					else if (list.size() == 0) {
						bw.write("");
					}
					bw.flush();
					bw.close();
					// file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("文件不存在、或者文件无内容");
				
			}
		
		return mystr;

	}

}

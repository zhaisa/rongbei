package com.irongbei;

/*
 * 
 * 
 * 
 * 将流数据放到list集合后，读取
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadTxt {
	public static void main(String[] args) {
		ReadTxt rt = new ReadTxt();
		try {
			for (int i = 0; i < 47; i++) {
				rt.readFS("D:\\users\\usertext1.txt", i);

			}
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public String readFS(String path, int lineNo) throws IOException {

		FileReader fr = null;
		try {
			fr = new FileReader(path);// 读取用户名文件"D:\\users\\usertext1.txt"
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("流关闭失败！");
			}
		}

		if (lineNo < list.size()) {
			list.get(lineNo);
			System.out.println(list.get(lineNo));
		} else {

			int j = lineNo / list.size();
			for (int z = 1; z < lineNo; z++) {
				if (j >= z && j < z + 1) {
					lineNo = lineNo - z * list.size();
					list.get(lineNo);
					if(list.get(lineNo)==null) {
						break;
						
					}
					System.out.println(list.get(lineNo));
				}
			}

		}
		

		return list.get(lineNo);

	}

	public String readFS(String path) throws IOException {
		FileReader fr = null;
		int line=1;
		try {
			fr = new FileReader(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		List<String> list=new ArrayList();
		
		while (null != br.readLine()) {
		list.add(br.readLine());
		line++;
		}

		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		br.close();
		return line+">>>>>>>>>>>>>>>>>>>>>";
		
	}
}

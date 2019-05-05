package com.rongbei.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_reader {
	// *************xlsx文件读取函数************************
	// excel_name为文件名，arg为需要查询的列号
	// 返回二维字符串数组
	@SuppressWarnings({ "resource", "unused" })
	public ArrayList<ArrayList<String>> xlsx_reader(String excel_url, int... args) throws IOException {

		// 读取xlsx文件
		XSSFWorkbook xssfWorkbook = null;
		// 寻找目录读取文件
		File excelFile = new File(excel_url);
		InputStream is = new FileInputStream(excelFile);
		xssfWorkbook = new XSSFWorkbook(is);

		if (xssfWorkbook == null) {
			System.out.println("未读取到内容,请检查路径！");
			return null;
		}

		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		// 遍历xlsx中的sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// 对于每个sheet，读取其中的每一行
			for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow == null)
					continue;
				ArrayList<String> curarr = new ArrayList<String>();
				for (int columnNum = 0; columnNum < args.length; columnNum++) {
					XSSFCell cell = xssfRow.getCell(args[columnNum]);

					curarr.add(Trim_str(getValue(cell)));
				}
				ans.add(curarr);
			}
		}
		return ans;
	}

	// 判断后缀为xlsx的excel文件的数据类
	@SuppressWarnings("deprecation")
	private static String getValue(XSSFCell xssfRow) {
		Object value = "";
		if (xssfRow != null) {	switch (xssfRow.getCellTypeEnum()) {
		case NUMERIC:
			double cur = xssfRow.getNumericCellValue();
			long longVal = Math.round(cur);
			Object inputValue = null;
			if (Double.parseDouble(longVal + ".0") == cur)
				inputValue = longVal;
			else
				inputValue = cur;
			value = String.valueOf(inputValue);
			break;
		case STRING:
			value = String.valueOf(xssfRow.getStringCellValue());
			break;
		case FORMULA:
			value = String.valueOf(xssfRow.getCellFormula());
			break;
		case BLANK:
			value= "---";
			break;
		case BOOLEAN:
			value = String.valueOf(xssfRow.getBooleanCellValue());
			break;
		case ERROR:
			value= "---";
			break;
		default:
			value = String.valueOf(xssfRow.getStringCellValue());
			break;
		}
		}
		return value.toString();
		
	}

	// 判断后缀为xls的excel文件的数据类型
	@SuppressWarnings({ "deprecation", "unused" })
	private static String getValue(HSSFCell hssfCell) {
		Object value = "";
		switch(hssfCell.getCellTypeEnum()) {
		   case NUMERIC:
			   double cur = hssfCell.getNumericCellValue();
				long longVal = Math.round(cur);
				Object inputValue = null;
				if (Double.parseDouble(longVal + ".0") == cur)
					inputValue = longVal;
				else
					inputValue = cur;
				value= String.valueOf(inputValue);
               break;
           case STRING:
        	   value= String.valueOf(hssfCell.getStringCellValue());
               break;
           case FORMULA:
 //       	   value = String.valueOf(hssfCell.getCellFormula());
               break;
           case BLANK:
        	   value= "---";
               break;
           case BOOLEAN:
        	   value=String.valueOf(hssfCell.getBooleanCellValue());
               break;
           case ERROR:
        	   value= "---";
               break;
           default:
        	   value= String.valueOf(hssfCell.getStringCellValue());
              break;


		}
		return value.toString();
		
	}

	// 字符串修剪 去除所有空白符号 ， 问号 ， 中文空格
	static private String Trim_str(String str) {
		if (str == null)
			return null;
		return str.replaceAll("[\\s\\?]", "").replace("　", "");
	}

}

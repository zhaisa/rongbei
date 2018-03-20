package com.fengkong.utils;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * 本类是针对Select功能方法的封装
 * 
 * @author Administrator
 *
 */
public class RandomSelect {

	public static void doRandomSelect(WebElement e, int start) {
		Select s = new Select(e);
		List<WebElement> list = s.getOptions();// 获得下拉框内的所有选项
		System.out.println(list.size());

		if (start > list.size()) {
			start = list.size() - 1;
		}

		// 1.产生随机数的第一种方法
//		 Random r = new Random();
//		 int index = start + r.nextInt(list.size() - start);//生成一个随机数，范围是list的个数
//		 System.out.println(index);
//		 s.selectByIndex(index);// 根据上面随机生成的下拉选项的index，点击这个选项

		// 2..产生随机数的第二种方法
		int index2 = start + (int) (Math.random() * (list.size() - start));
		System.out.println(index2);
		s.selectByIndex(index2);
	}
}

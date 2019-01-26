package com.irongbei;

import java.util.ArrayList;
import java.util.List;

public class JiShuQi {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
		JiShuQi.jiShuQi();
	} }
	private static int count;
	private static int sum;
    boolean flag=false;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		JiShuQi.count = count;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		JiShuQi.sum = sum;
	}

	public static int jiShuQi() {
//初始化数据
		List<Integer> list=new ArrayList();
	for(int i=1;i<2<<32;i++) {
		list.add(i);
	}
		for(int z=1;z<list.size();z++) {
			count=list.get(z);
		}
		
	System.out.println(list.get(0));	
		return count;
		
	}

	public JiShuQi() {
		super();
		// TODO Auto-generated constructor stub
	}
}

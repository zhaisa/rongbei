package com.irongbei;

import java.util.ArrayList;
import java.util.List;

public class JiShuQi {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			jiShuQi(i);
		}
	}

	public static int jiShuQi(int number) {
		int j = 0;
		j++;
		List list = new ArrayList();
		for (int i = 0; i < j; i++) {
			list.add(i);
		}

		if (j < list.size()) {
			list.get(number);
			System.out.println(list.get(number));
			list.remove(number);
		}
		if (number > list.size()) {

		}

		return (Integer) list.get(number);

	}
}

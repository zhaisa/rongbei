package com.irongbeitest;

import com.irongbei.BuyXiaoBiao;

public class BuyXiaoBiaoTest {
	public static void main(String[] args) {

BuyXiaoBiao bxb=new BuyXiaoBiao();
Thread t1=new Thread(bxb);
Thread t2=new Thread(bxb);
Thread t3=new Thread(bxb);
//Thread t4=new Thread(bxb);
//Thread t5=new Thread(bxb);
//Thread t6=new Thread(bxb);
//Thread t7=new Thread(bxb);
//Thread t8=new Thread(bxb);
//Thread t3=new Thread(bxb);
t1.start();
t2.start();
t3.start();
//t4.start();
//t5.start();
//t6.start();
//t7.start();
//t8.start();

	}
}

package com.irongbeitest;

import com.irongbei.BuyZhiTou;

public class BuyZhiTouTest {
public static void main(String[] args) throws InterruptedException {
	BuyZhiTou bzt=new BuyZhiTou();
	for(int i=0;i<10;i++) {
	bzt.buyZhiTou("17409040329","200",15826);
	bzt.buyZhiTou("17409040329","200",15827);
}
}
}
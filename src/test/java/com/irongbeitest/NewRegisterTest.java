package com.irongbeitest;

import java.io.IOException;

import com.irongbei.NewRegister;

public class NewRegisterTest {
	public static void main(String[] args) {
		NewRegister ng = new NewRegister();
		for (int i = 0; i < 10; i++) {
			try {
				ng.register(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
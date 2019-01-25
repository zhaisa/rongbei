package com.rongbei.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fengkong.NewUserCardAndBankCard;

public class WriteBankCard {
	@Test(invocationCount=1000)
	public void writeUserCard() throws IOException {
		NewUserCardAndBankCard nc = new NewUserCardAndBankCard();
		String bankcard = nc.getBankAccount();
		File ff = new File("D:\\users\\bankcard.txt");
		FileWriter fw = new FileWriter(ff, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("\r\n" + bankcard);
		bw.close();
		fw.close();

	}
}

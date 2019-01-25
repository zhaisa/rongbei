package com.rongbei.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fengkong.NewUserCardAndBankCard;

public class WriteUserCard {
	@Test(invocationCount=1000)
	public void writeUserCard() throws IOException {
		NewUserCardAndBankCard nc = new NewUserCardAndBankCard();
		String usercard = nc.Calculate();
		File ff = new File("D:\\users\\usercard.txt");
		FileWriter fw = new FileWriter(ff, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("\r\n" + usercard);
		bw.close();
		fw.close();

	}
}

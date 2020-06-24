package com.irongbei;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rongbei.util.ExcelData;

import jxl.read.biff.BiffException;

public class DataForKaiHu {
@Test(dataProvider="mydata")
public void kaiHu(String phone,String usercard,String bankcard) throws Exception {
	ChangePhone cp = new ChangePhone();
	KaiTongCunGan kt = new KaiTongCunGan();
	SetSecret ss = new SetSecret();
	ChangePhoneBack cp1 = new ChangePhoneBack();
	CePing cp11 = new CePing();
	// 融贝后台修改成手机号
	cp.changePhone(phone, "18701473018","test");
	Thread.sleep(1000);
	// 开通存管
	KaiTongCunGan.testPlan(phone, usercard, bankcard,"test");// 手机号，身份证，银行卡号j
	Thread.sleep(1000);
	// 解放原来的手机号
	ShouQuan sq = new ShouQuan();
	sq.shouQuan(phone,"test");
	cp1.changePhoneBack(phone,phone,"test");
	System.out.println(phone);
	cp11.cePing(phone,"test");

}
@DataProvider(name="mydata")
public 	Object[][] getMydata() throws BiffException, IOException{
	 ExcelData e=new ExcelData("testdata", "calculator");
     return e.getExcelData();
	
	
}
}

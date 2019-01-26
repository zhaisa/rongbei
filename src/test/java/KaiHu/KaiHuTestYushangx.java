package KaiHu;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.fengkong.NewUserCardAndBankCard;

import com.irongbei.CePingYushangx;


import com.irongbei.ChangePhoneBackYushangx;
import com.irongbei.ChangePhoneYushangx;
import com.irongbei.KaiTongCunGanYushangx;
import com.irongbei.ReadTxt;
import com.irongbei.SetSecretYushangx;
import com.irongbei.ShouQuanYushangx;

public class KaiHuTestYushangx {
	public static void main(String[] args) throws Exception {
		
		Logger logger = Logger.getLogger(KaiHuTestYushangx.class);
		BasicConfigurator.configure();
		// PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		logger.setLevel(Level.INFO);
	
		
		
		for (int i = 0; i < 10; i++) {
			NewUserCardAndBankCard nc = new NewUserCardAndBankCard();
			ReadTxt rt = new ReadTxt();
			String readname = rt.readFS("D:\\users\\useryushangx.txt", i);
			String phone = readname;
//			String phone="17409040081";
			String usercard = NewUserCardAndBankCard.Calculate();
			String bankcard = NewUserCardAndBankCard.getBankAccount();
			logger.info("手机号码：" + phone);
			logger.info("身份证号码：" + usercard);
			logger.info("银行卡号：" + bankcard);
			ChangePhoneYushangx cp = new ChangePhoneYushangx();
		KaiTongCunGanYushangx kt = new KaiTongCunGanYushangx();
			SetSecretYushangx ss = new SetSecretYushangx();
			ChangePhoneBackYushangx cp1 = new ChangePhoneBackYushangx();
			CePingYushangx cp11=new CePingYushangx();
			// 融贝后台修改成手机号
	    	cp.changePhone(phone, "18701473018");
			Thread.sleep(1000);
			// 开通存管
	    	KaiTongCunGanYushangx.testPlan(phone, usercard, bankcard);// 手机号，身份证，银行卡号j
			Thread.sleep(1000);
			// 解放原来的手机号
			ShouQuanYushangx sq=new ShouQuanYushangx();
			sq.shouQuan(phone);
			cp1.changePhoneBack(phone);
			System.out.println(phone);
			cp11.cePing(phone);

		}
	
	}
}

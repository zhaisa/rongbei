package KaiHu;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.fengkong.NewUserCardAndBankCard;
import com.irongbei.CePing;
import com.irongbei.ChangePhone;
import com.irongbei.ChangePhoneBack;
import com.irongbei.KaiTongCunGan;
import com.irongbei.ReadTxt;
import com.irongbei.SetSecret;
import com.irongbei.ShouQuan;

public class KaiHuTest {
	public static void main(String[] args) throws Exception {
		String env="test";
		Logger logger = Logger.getLogger(KaiHuTest.class);
		BasicConfigurator.configure();
		// PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		logger.setLevel(Level.INFO);

		for (int i = 0; i < 100; i++) {
			NewUserCardAndBankCard nc = new NewUserCardAndBankCard();
			ReadTxt rt = new ReadTxt();
			String readname = rt.readFS("E:\\users\\user.txt", i);
			String phone = readname;
//			String phone="17409240049";
			String usercard = NewUserCardAndBankCard.Calculate();
			String bankcard = NewUserCardAndBankCard.getBankAccount();
			logger.info("手机号码：" + phone);
			logger.info("身份证号码：" + usercard);
			logger.info("银行卡号：" + bankcard);
			ChangePhone cp = new ChangePhone();
			KaiTongCunGan kt = new KaiTongCunGan();
			SetSecret ss = new SetSecret();
			ChangePhoneBack cp1 = new ChangePhoneBack();
			CePing cp11 = new CePing();
			// 融贝后台修改成手机号
			cp.changePhone(phone, "18701473018",env);
			Thread.sleep(1000);
			// 开通存管
			KaiTongCunGan.testPlan(phone, usercard, bankcard,env);// 手机号，身份证，银行卡号j
			Thread.sleep(1000);
			// 解放原来的手机号
			
			
			cp1.changePhoneBack(phone,env);
			System.out.println(phone);
			cp11.cePing(phone,env);
//			ShouQuan sq = new ShouQuan();
//			sq.shouQuan(phone,env);
		}

	}
}

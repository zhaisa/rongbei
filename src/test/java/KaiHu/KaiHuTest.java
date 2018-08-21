package KaiHu;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fengkong.NewUserCardAndBankCard;
import com.irongbei.ChangePhone;
import com.irongbei.ChangePhoneBack;
import com.irongbei.KaiTongCunGan;
import com.irongbei.SetSecret;

public class KaiHuTest {
public static void main(String[] args) throws Exception {
	Logger logger=Logger.getLogger(KaiHuTest.class);
	BasicConfigurator.configure();
//	 PropertyConfigurator.configure("config/log4j.properties");
	logger.setLevel(Level.INFO);
	NewUserCardAndBankCard nc=new NewUserCardAndBankCard();
	String phone="17409040073";
	String usercard=nc.Calculate();
	String bankcard=nc.getBankAccount();
	logger.info("手机号码："+phone);
	logger.info("身份证号码："+nc.Calculate());
	logger.info("银行卡号："+nc.getBankAccount());
	System.out.println(usercard);
	System.out.println(bankcard);
	 ChangePhone cp=new ChangePhone();
	 KaiTongCunGan kt = new KaiTongCunGan();
	 SetSecret ss=new SetSecret();
	 ChangePhoneBack cp1=new ChangePhoneBack();
	 //融贝后台修改成手机号
	 cp.changePhone(phone,"18701473018");
	 Thread.sleep(1000);
	 //开通存管
	 KaiTongCunGan.testPlan(phone,usercard,bankcard);//手机号，身份证，银行卡号j
	 Thread.sleep(1000);
	 //设置交易密码
	 ss.setSecret(phone,usercard,"082118");
	 Thread.sleep(1000);
	 //解放原来的手机号
	 cp1.changePhoneBack(phone);
	 System.out.println(phone);

	 
}
}

package KaiHu;

import com.irongbei.ChangePhone;
import com.irongbei.ChangePhoneBack;
import com.irongbei.KaiTongCunGan;
import com.irongbei.SetSecret;

public class KaiHuTest {
public static void main(String[] args) throws Exception {
	String phone="17409040023";
	String usercard="420101198101016359";
	String bankcard="6222021128174336411";
	 ChangePhone cp=new ChangePhone();
	 KaiTongCunGan kt = new KaiTongCunGan();
	 SetSecret ss=new SetSecret();
	 ChangePhoneBack cp1=new ChangePhoneBack();
	 //融贝后台修改成手机号
	 cp.changePhone(phone,"18701473018");
	 Thread.sleep(1000);
	 //开通存管
	 KaiTongCunGan.testPlan(phone,usercard,bankcard);//手机号，身份证，银行卡号
	 Thread.sleep(1000);
	 //设置交易密码
	 ss.setSecret(phone,usercard);
	 Thread.sleep(1000);
	 //解放原来的手机号
	 cp1.changePhoneBack(phone);
	 System.out.println(phone);
	 
	 
}
}
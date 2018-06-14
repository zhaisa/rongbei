package KaiHu;

import com.irongbei.ChangePhone;

public class ChangePhoneTest {

 public static void main(String[] args) {
	 ChangePhone cp=new ChangePhone();
	 for(int i=0;i<1;i++) {
	 try {
		cp.changePhone("17409040015","18701473018");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
}
}
}
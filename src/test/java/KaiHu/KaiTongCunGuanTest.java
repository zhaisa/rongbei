package KaiHu;

import com.irongbei.KaiTongCunGan;

public class KaiTongCunGuanTest {
	public static void main(String[] args) {
		KaiTongCunGan kt = new KaiTongCunGan();
		for (int i = 0; i < 1; i++) {
			try {
				KaiTongCunGan.testPlan("17409040015","420101198101013019","6222028985997278477","test");//String userphone,String usercard,String bankcard
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
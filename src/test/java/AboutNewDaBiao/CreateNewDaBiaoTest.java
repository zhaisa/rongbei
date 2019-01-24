package AboutNewDaBiao;

import com.irongbei.CreateNewDaBiao;

public class CreateNewDaBiaoTest {

	public static void main(String[] args) {

		for (int i = 0; i < 1; i++) {
			CreateNewDaBiao cdb = new CreateNewDaBiao();
			try {
				cdb.createNewDaBiao("6", 6, 2019, 0, 24,"1");// 周期为3个月，时间间隔设置为3,2018年3月5号 最后一位为万元一
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
	}

}

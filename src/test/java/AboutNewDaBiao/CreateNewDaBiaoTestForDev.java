package AboutNewDaBiao;

import com.irongbei.CreateNewDaBiaoForDev;

public class CreateNewDaBiaoTestForDev {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			CreateNewDaBiaoForDev cdb = new CreateNewDaBiaoForDev();
			try {
				cdb.createNewDaBiao("6", 6, 2018, 11, 18,"1");// 周期为3个月，时间间隔设置为3,2018年3月5号 最后一位为万元一
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
	}

}

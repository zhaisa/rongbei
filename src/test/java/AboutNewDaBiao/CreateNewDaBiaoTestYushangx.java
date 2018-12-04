package AboutNewDaBiao;

import com.irongbei.CreateNewDaBiaoYuShangx;

public class CreateNewDaBiaoTestYushangx {

	public static void main(String[] args) {

		for (int i = 0; i < 1; i++) {
			CreateNewDaBiaoYuShangx cdb = new CreateNewDaBiaoYuShangx();
			try {
				cdb.createNewDaBiao("6", 6, 2019, 1, 22,"1");// 周期为3个月，时间间隔设置为3,2018年3月5号 最后一位为万元一
			} catch (Exception e) {
				e.printStackTrace();
			
			}
		}
	}

}

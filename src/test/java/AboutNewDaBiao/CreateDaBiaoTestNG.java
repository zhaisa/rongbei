package AboutNewDaBiao;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.irongbei.CreateNewDaBiao;

public class CreateDaBiaoTestNG{
 
  @Parameters({"zq","jiange","year","month","date","danw"})
  @Test
  public void createDb(String zq,int jiange,int year,int month,int date,String danw) {
	  CreateNewDaBiao cdb = new CreateNewDaBiao();
		try {
			cdb.createNewDaBiao(zq,jiange,year,month,date,danw);// 周期为3个月，时间间隔设置为3,2018年3月5号 最后一位为万元一
		} catch (Exception e) {
			e.printStackTrace();
		
		}
  }
//  @DataProvider(name="mydata")
//  public Object[][] getdata(){
//	  Object[][] value= {{"6", 6, 2019, 0, 24,"1"}};
//	  return value;
//  }
  
}

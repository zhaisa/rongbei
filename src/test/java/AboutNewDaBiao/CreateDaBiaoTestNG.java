package AboutNewDaBiao;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.irongbei.CreateNewDaBiao;

public class CreateDaBiaoTestNG{
 
  @Parameters({"zq","jiange","year","month","date","danw","way","env"})
  //@Test(dataProvider="mydata")
  @Test(invocationCount=1)
  public void createDb(String zq,int jiange,int year,int month,int date,String danw,String way,String env) {
	  CreateNewDaBiao cdb = new CreateNewDaBiao();
		try {
			cdb.createNewDaBiao(zq,jiange,year,month,date,danw,way,env);// 周期为3个月，时间间隔设置为3,2018年3月5号 最后一位为万元一
		} catch (Exception e) {
			e.printStackTrace();
		
		}
  }
  @DataProvider(name="mydata")
  public Object[][] getdata(){
	  Object[][] value= {{"6", 6, 2019, 1, 15,"0.5","1"},{"6", 6, 2019, 1, 15,"0.5","2"}};
	  return value;
  }
  
}

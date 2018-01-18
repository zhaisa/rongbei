package CreateZT;

import addpackage.CreateZhiTou;

public class CreateZT {
	public static void main(String[] args) {
		CreateZhiTou cz=new CreateZhiTou();
		for(int i=1;i<11;i++){
	try {
		cz.createZhiTou("3",3, 2018,2,17);//周期、间隔、开始日期
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	}

}

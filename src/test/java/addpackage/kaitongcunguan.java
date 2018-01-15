package addpackage;

public class kaitongcunguan {
public static void main(String[] args) {
	KaiTongCunGan kt=new KaiTongCunGan();
	for(int i=1;i<20;i++) {
	try {
		kt.testPlan(i);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
}
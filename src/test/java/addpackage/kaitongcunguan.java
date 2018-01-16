package addpackage;

public class kaitongcunguan {
public static void main(String[] args) {
	KaiTongCunGan kt=new KaiTongCunGan();
	for(int i=0;i<14;i++) {
	try {
		kt.testPlan(i);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
}
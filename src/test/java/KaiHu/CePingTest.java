package KaiHu;

import java.io.IOException;

import com.irongbei.CePing;
import com.irongbei.ReadTxt;

public class CePingTest {
public static void main(String[] args) throws InterruptedException, IOException {
	CePing cp=new CePing();
//	ReadTxt rt = new ReadTxt();
//	for (int i = 0; i < 50; i++) {
//	String readname = rt.readFS("D:\\users\\userphone.txt", i);
//	String phone = readname;
//	System.out.println(phone);
//	String phone="17409040084";
	cp.cePing("17409040302");
	
}
}

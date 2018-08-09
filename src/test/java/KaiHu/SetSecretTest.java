package KaiHu;

import com.irongbei.SetSecret;

public class SetSecretTest {
public static void main(String[] args) {
	SetSecret ss=new SetSecret();
	try {
		ss.setSecret("17409040015", "420101198101013019","072618" );
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}

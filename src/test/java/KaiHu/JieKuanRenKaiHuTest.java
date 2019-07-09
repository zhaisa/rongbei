package KaiHu;

import java.sql.SQLException;

public class JieKuanRenKaiHuTest {
public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
	JieKuanRenKaiHu jkrkh=new JieKuanRenKaiHu();
	
	for (int i=0;i<100;i++) {
		jkrkh.jieKuanKaiHu();
		jkrkh.updateSql();
	}
	
}
}

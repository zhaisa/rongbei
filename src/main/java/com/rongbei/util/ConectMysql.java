package com.rongbei.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConectMysql {
	PreparedStatement psql;
	// 声明Connection对象
	Connection con;
	// 驱动程序名
	String driver = "com.mysql.jdbc.Driver";
	// URL指向要访问的数据库名mydata
	String url = "jdbc:mysql://test-irongbei.mysql.rds.aliyuncs.com/vvt";
	// MySQL配置时的用户名
	String user = "test_vvt";
	// MySQL配置时的密码
	String password = "Rnj6grMCxJBHfhpEedbYeqk2";
	
	public void selectMysql() {
		
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			// 2.创建statement类对象，用来执行SQL语句！！
			Statement statement = con.createStatement();
			// 要执行的SQL语句
			String sql = "select * from vvt_company_property";
			// 3.ResultSet类，用来存放获取的结果集！！
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("-----------------");
			System.out.println("执行结果如下所示:");
			System.out.println("-----------------");
			System.out.println("姓名" + "\t" + "职称");
			System.out.println("-----------------");

			String chartelphone = null;
			String user_id = null;
			while (rs.next()) {
				// 获取stuname这列数据
				chartelphone = rs.getString("chartelphone");
				// 获取stuid这列数据
				user_id = rs.getString("user_id");

				// 输出结果
				System.out.println(user_id + "\t" + chartelphone);
			}
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("数据库数据成功获取！！");
		}
	}
	@Test
	public void updateMysql() throws SQLException, ClassNotFoundException {
		
		String aaa;
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
	
		// 预处理更新（修改）数据，将王刚的sal改为5000.0
		psql = con.prepareStatement("update vvt_company_property set chartelphone = ? where chartelphone = 18701473018");
//		psql.setFloat(1, (float) 5000.0);
		aaa="17409040001";
		psql.setString(1, aaa);
		
		psql.executeUpdate();}	
		finally {
			System.out.println("数据库修改成功------>!");
	}

}
}
package org.tea.utils;

import java.io.ObjectInputStream.GetField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/quest?useUnicode=true&characterEncoding=utf8";
	private String name="root";
	private String passwd="123123";
	private Connection conn=null;
	
	//连接数据库
	public Connection getCon() {
		try {
			//通过反射加载mysql驱动;
			Class.forName(driver);
			//获取到连接
			conn=DriverManager.getConnection(url,name,passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("mysql jdbc Connect success!");
		return conn;
	}
	
	
//	private void psvm() {
//		// TODO Auto-generated method stub
//		
//		Connect connect=new Connect();
//		connect.getCon();
//	}

}

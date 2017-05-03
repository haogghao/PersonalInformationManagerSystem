package com.dw.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.org.apache.commons.logging.Log;
public class DbConn {
	/**
	 * 数据库连接类
	 * @author DY1101shaoyuxian
	 */
	private static String username=null;
	private static String password=null;
	private static  String driver=null;
	private static String url=null;
	static{
		//取得连接的url,能访问MySQL数据库的用户名,密码；jsj：数据库名 
		url = "jdbc:mysql://localhost:3306/student"; 
		username = "test"; 
		password = "1234";
	}
	public static Connection getConn() {
		Connection con = null;
		try {
		   // Class.forName(driver);
			Class.forName("com.mysql.jdbc.Driver"); 
		    
			con = DriverManager.getConnection(url, username, password);
			 System.out.println(con+"哈哈哈哈哈哈哈哈哈啊哈哈Dbconn类");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public void closeCon(Connection con) {
		// TODO Auto-generated method stub
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		try {
			DbConn.getConn();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

}

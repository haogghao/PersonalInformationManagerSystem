package com.dw.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.sun.org.apache.commons.logging.Log;
public class DbConn {
	/**
	 * ���ݿ�������
	 * @author DY1101shaoyuxian
	 */
	private static String username=null;
	private static String password=null;
	private static  String driver=null;
	private static String url=null;
	static{
		//ȡ�����ӵ�url,�ܷ���MySQL���ݿ���û���,���룻jsj�����ݿ��� 
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
			 System.out.println(con+"������������������������Dbconn��");
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
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

}

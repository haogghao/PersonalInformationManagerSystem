package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dw.dao.UserDao;
import com.dw.model.User;
import com.dw.util.DbConn;

public class UserDaoImpl implements UserDao {
	private Connection conn = DbConn.getConn();
	public String findUserid(String username,String password,String status){
		String userId=null;
		 String sql="select * from t_manager where username=? and password=? and status=?";
		  try {
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, username);//对传过来的用户名和密码进行封装
			pmst.setString(2, password);
			pmst.setString(3, status);
			ResultSet rs=pmst.executeQuery();
			while (rs.next()) {
				userId= rs.getString("userid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return userId; 
	}
	
	
	
	
	
	
	
	//登陆用户验证
	  public boolean isLogin(User user){
		  boolean flag=false;
		  String sql="select * from t_manager where username=? and password=? and status=?";
		  try {
			PreparedStatement pmst=conn.prepareStatement(sql);
			pmst.setString(1, user.getUsername());//对传过来的用户名和密码进行封装
			pmst.setString(2, user.getPassword());
			pmst.setString(3, user.getStatus());
			ResultSet rs=pmst.executeQuery();
			if(rs.next()){
				flag=true;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	  
	  }

		 /**
		  * 修改用户的密码
		  * @param page
		  * @return
		  */
		
		public boolean updateUserPassWord(User  user) {
			boolean flag=false;
			int a=0;
			String sql = "update t_manager set password=? where username=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getPassword());
				pstmt.setString(2, user.getUsername());
				a= pstmt.executeUpdate();
				System.out.println("a的值值值值是:"+a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(a!=0){
				flag=true;
			}
			return flag;
		}
		
		public boolean addUser(User stu) {
			// Memo(stId,stName,stSex,stAge,stTel,stDept,stAddress)
			boolean flag = false;
			String sql = "insert into t_manager(userid,username,password,status) values(?,?,?,?)";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, stu.getUserid());
				psmt.setString(2, stu.getUsername());
				psmt.setString(3, stu.getPassword());
				psmt.setString(4, stu.getStatus());
				int i = psmt.executeUpdate();
				if (i == 1) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}

		public List<User> StSelect() {
			// TODO Auto-generated method stub
			List<User> userlist=new ArrayList<User>();
			User stu=null;
			String sql="select*from t_manager where status=?";
			try {
				PreparedStatement pmst=conn.prepareStatement(sql);
				pmst.setString(1, "person");
				ResultSet rs = pmst.executeQuery();
				while (rs.next()) {
					String userid = rs.getString("userid");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String status = rs.getString("status");
					stu = new User(userid,username,password,status);
					userlist.add(stu);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userlist;
		}
		
		public List<User> SelectByName(String username1) {
			// TODO Auto-generated method stub
			List<User> userlist=new ArrayList<User>();
			User stu=null;
			String sql="select*from t_manager where username=?";
			try {
				PreparedStatement pmst=conn.prepareStatement(sql);
				pmst.setString(1, username1);
				ResultSet rs = pmst.executeQuery();
				while (rs.next()) {
					String userid = rs.getString("userid");
					String username = rs.getString("username");
					String password = rs.getString("password");
					String status = rs.getString("status");
					stu = new User(userid,username,password,status);
					userlist.add(stu);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return userlist;
		}
		
		
		
		
		
		public boolean delUser(String userid) {
			boolean flag = false;
			String sql = "delete from t_manager where userid=?";
			try {
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, userid);
				if (psmt.executeUpdate() > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}







		public User findUserByUserId(String user_id) {
			// TODO Auto-generated method stub
			User u=null;
			//String sql="select userid,username,password from t_manager where userid=?";
			String sql="select*from t_manager where userid=?";
			try {
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, user_id);
				ResultSet rt=pst.executeQuery();
				while(rt.next()){
					String userid1=rt.getString("userid");
					String username1=rt.getString("username");
					String password1=rt.getString("password");
					String status1="person";
					u=new User(userid1,username1,password1,status1);
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return u;
		}


		public boolean updateByUserId(User newuser) {
			// TODO Auto-generated method stub
			boolean flag=false;
			int a=0;
			//String sql = "update t_manager set password=?,username=? where userid=?";
			String sql="update t_manager set password=?,username=? where userid=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, newuser.getPassword());
				pstmt.setString(2, newuser.getUsername());
				pstmt.setString(3, newuser.getUserid());
				a= pstmt.executeUpdate();
				System.out.println("a的值值值值是:"+a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(a!=0){
				flag=true;
			}
			return flag;
		}
}

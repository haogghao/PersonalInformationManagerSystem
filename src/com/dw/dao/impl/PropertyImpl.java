package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dw.dao.PropertyDao;
import com.dw.model.Property;
import com.dw.util.DbConn;

public class PropertyImpl implements PropertyDao {
	private Connection conn = DbConn.getConn();
	public Property findPropertyByid(String id) {
		Property stu = null;
		String sql = "select * from property where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");
				String income = rs.getString("income");
				String project = rs.getString("project");
				String money = rs.getString("money");
				String time = rs.getString("time");
				String left_money = rs.getString("left_money");
				stu = new Property(Id,income,project,money,time,left_money);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	public List<Property> findPropertyByProject(String userId, String project1) {
		// TODO Auto-generated method stub
		Property stu = null;
		List<Property> list=new ArrayList<Property>();
		
		String sql = "select * from property where userid=? and project=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, project1);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");
				String income = rs.getString("income");
				String project = rs.getString("project");
				String money = rs.getString("money");
				String time = rs.getString("time");
				String left_money = rs.getString("left_money");
				stu = new Property(Id,income,project,money,time,left_money);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean addProperty(Property stu) {
		// Property(id,stName,stSex,stAge,stTel,stDept,stAddress)
		boolean flag = false;
		String sql = "insert into Property(id,userid,income,project,money,time,left_money) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getId());
			psmt.setString(2, stu.getUserid());
			psmt.setString(3, stu.getIncome());
			psmt.setString(4, stu.getProject());
			psmt.setString(5, stu.getMoney());
			psmt.setString(6, stu.getTime());
			psmt.setString(7, stu.getLeft_money());
			int i = psmt.executeUpdate();
			System.out.println("property数据库插入返回；"+i);
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delProperty(String id) {
		boolean flag = false;
		String sql = "delete from property where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			if (psmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateProperty(Property stu) {
		boolean flag = false;
		String sql = "update Property set income=?,project=?,money=?,time=?,left_money=? where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stu.getIncome());
			psmt.setString(2, stu.getProject());
			psmt.setString(3, stu.getMoney());
			psmt.setString(4, stu.getTime());
			psmt.setString(5, stu.getLeft_money());
			psmt.setString(6, stu.getId());
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

	public List<Property> StSelect(String userId) {
		List<Property> list = new ArrayList<Property>();
		String sql = "select * from property";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			// Property(id,stName,stSex,stAge,stTel,stDept,stAddress)
			while (rs.next()) {
				if(userId.equals(rs.getString("userid"))){
				String Id = rs.getString("id");
				String income = rs.getString("income");
				String project = rs.getString("project");
				String money = rs.getString("money");
				String time = rs.getString("time");
				String left_money = rs.getString("left_money");
				
				Property stu = new Property(Id,income,project,money,time,left_money);
				list.add(stu);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


}

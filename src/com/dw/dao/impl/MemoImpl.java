package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dw.dao.MemoDao;
import com.dw.model.Memo;
import com.dw.util.DbConn;

public class MemoImpl implements MemoDao {
	private Connection conn = DbConn.getConn();
	public Memo findMemoById(String id) {
		Memo stu = null;
		String sql = "select * from memo where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");
				String time = rs.getString("time");
				String event = rs.getString("event");
				String addr = rs.getString("addr");
		
				stu = new Memo(Id, time, event, addr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	public List<Memo> findMemoByEvent(String userId, String event1) {
		// TODO Auto-generated method stub
		Memo stu = null;
		List<Memo> list=new ArrayList<Memo>();
		String sql = "select * from memo where userid=? and event=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, event1);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");
				String time = rs.getString("time");
				String event = rs.getString("event");
				String addr = rs.getString("addr");
		
				stu = new Memo(Id, time, event, addr);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean addMemo(Memo stu) {
		// Memo(stId,stName,stSex,stAge,stTel,stDept,stAddress)
		boolean flag = false;
		String sql = "insert into Memo(id,userid,time,event,addr) values(?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getId());
			psmt.setString(2, stu.getUserid());
			psmt.setString(3, stu.getTime());
			psmt.setString(4, stu.getEvent());
			psmt.setString(5, stu.getAddr());
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

	public boolean delMemo(String id) {
		boolean flag = false;
		String sql = "delete from memo where id=?";
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

	public boolean updateMemo(Memo stu) {
		boolean flag = false;
		String sql = "update memo set time=?,event=?,addr=? where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stu.getTime());
			psmt.setString(2, stu.getEvent());
			psmt.setString(3, stu.getAddr());
			psmt.setString(4, stu.getId());
			int i = psmt.executeUpdate();
			System.out.println("updatememo·µ»Øi:"+i);
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List StSelect(String userId) {
		List list = new ArrayList();
		String sql = "select * from Memo";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			// Memo(stId,stName,stSex,stAge,stTel,stDept,stAddress)
			while (rs.next()) {
				if(userId.equals(rs.getString("userid"))){
				String id = rs.getString("id");
				String time = rs.getString("time");
				String event = rs.getString("event");
				String addr = rs.getString("addr");
				
				Memo stu = new Memo(id, time, event, addr);
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

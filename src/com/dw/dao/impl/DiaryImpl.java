package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dw.dao.DiaryDao;
import com.dw.model.Diary;
import com.dw.util.DbConn;

public class DiaryImpl implements DiaryDao {
	private Connection conn = DbConn.getConn();
	public Diary findDiaryByid(String id){
		Diary stu = null;
		String sql = "select * from diary where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");
				String time = rs.getString("time");
				String addr = rs.getString("addr");
				String event = rs.getString("event");
				String characters = rs.getString("characters");

				stu = new Diary(Id, time,addr, event,characters);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	public List<Diary> findDiaryByEvent(String userId, String event1) {
		// TODO Auto-generated method stub
		List<Diary> list=new ArrayList<Diary>();
		Diary stu=null;
		String sql = "select * from diary where userid=? and event=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, event1);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				String Id = rs.getString("id");
				String time = rs.getString("time");
				String addr = rs.getString("addr");
				String event = rs.getString("event");
				String characters = rs.getString("characters");

				stu = new Diary(Id, time,addr, event,characters);
				list.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	
	public boolean addDiary(Diary stu) {
		boolean flag = false;
		String sql = "insert into diary(id,userid,time,addr,event,characters) values(?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getId());
			psmt.setString(2, stu.getUserid());
			psmt.setString(3, stu.getTime());
			psmt.setString(4, stu.getAddr());
			psmt.setString(5, stu.getEvent());
			psmt.setString(6, stu.getCharacters());

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

	public boolean delDiary(String id) {
		boolean flag = false;
		String sql = "delete from diary where id=?";
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

	public boolean updateDiary(Diary stu) {
		boolean flag = false;
		String sql = "update diary set time=?,addr=?,event=?,characters=? where id=?";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, stu.getTime());
			psmt.setString(2, stu.getAddr());
			psmt.setString(3, stu.getEvent());
			psmt.setString(4, stu.getCharacters());
			psmt.setString(5, stu.getId());
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

	public List<Diary> StSelect(String userId) {
		
		List<Diary> list = new ArrayList<Diary>();
		String sql = "select * from diary";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				if(userId.equals(rs.getString("userid"))){
				String id = rs.getString("id");
				String time = rs.getString("time");
				String addr = rs.getString("addr");
				String event = rs.getString("event");
				String characters = rs.getString("characters");

				Diary stu = new Diary(id, time, addr, event,characters);
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

package com.dw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Request;

import com.dw.dao.AddressBookDao;
import com.dw.model.AddressBook;
import com.dw.model.AddressBook;
import com.dw.model.AddressBook;
import com.dw.util.DbConn;

public class AddressBookImpl implements AddressBookDao {
	private Connection conn = DbConn.getConn();

	// Ôö
	public boolean addAddressBook(AddressBook stu) {
		boolean flag = false;
		String sql = "insert into address_book(id,userid,name,contact_way,work_addr, city ,beizhu) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getId());
			psmt.setString(2, stu.getUserid());
			psmt.setString(3, stu.getName());
			psmt.setString(4, stu.getContact_way());
			psmt.setString(5, stu.getWork_addr());
			psmt.setString(6, stu.getCity());
			psmt.setString(7, stu.getBeizhu());
			int i = psmt.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	};

	public boolean delAddressBook(String id) {

		boolean flag = false;
		String sql = "delete from address_book where id=?";
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
	};

	public boolean updateAddressBook(AddressBook stu) {
		boolean flag = false;
		String sql = "update address_book set name=?,contact_way=?,work_addr=?, city=? ,beizhu=? where id=? ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, stu.getName());
			psmt.setString(2, stu.getContact_way());
			psmt.setString(3, stu.getWork_addr());
			psmt.setString(4, stu.getCity());
			psmt.setString(5, stu.getBeizhu());
			psmt.setString(6, stu.getId());

			int i = psmt.executeUpdate();
			System.out.println("addressbook·µ»Øi:" + i);
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	};

	@SuppressWarnings("unchecked")
	public List<AddressBook> StSelect(String userId) {
		List<AddressBook> list = new ArrayList<AddressBook>();

		String sql = "select * from address_book";
		try {
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				if (userId.equals(rs.getString("userid"))) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					String contact_way = rs.getString("contact_way");
					String work_addr = rs.getString("work_addr");
					String city = rs.getString("city");
					String beizhu = rs.getString("beizhu");

					AddressBook stu = new AddressBook(id, name, contact_way,
							work_addr, city, beizhu);
					list.add(stu);

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	};	
	
	
	public AddressBook findAddressBookById(String Id) {
		AddressBook addressBook = null;		
		String sql = "select * from address_book where id=?" ;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Id);		
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				addressBook = new AddressBook();
				addressBook.setId(rs.getString("id"));
				addressBook.setName(rs.getString("name"));
				addressBook.setContact_way(rs.getString("contact_way"));
				addressBook.setWork_addr(rs.getString("work_addr"));
				addressBook.setCity(rs.getString("city"));
				addressBook.setBeizhu(rs.getString("beizhu"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addressBook;
	}
	
	
	
	public List<AddressBook> findAddressBookByName(String userId,String name) {
		AddressBook addressBook = null;
		List<AddressBook> list = new ArrayList<AddressBook>();
		String sql = "select * from address_book where userid=? and name=?" ;

		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				addressBook = new AddressBook();
				addressBook.setId(rs.getString("id"));
				addressBook.setName(rs.getString("name"));
				addressBook.setContact_way(rs.getString("contact_way"));
				addressBook.setWork_addr(rs.getString("work_addr"));
				addressBook.setCity(rs.getString("city"));
				addressBook.setBeizhu(rs.getString("beizhu"));
				list.add(addressBook);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}

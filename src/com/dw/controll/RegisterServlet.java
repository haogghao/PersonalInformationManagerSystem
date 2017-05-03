package com.dw.controll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.User;
import com.sun.java.swing.plaf.windows.resources.windows;

public class RegisterServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                 doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date=new Date();
		@SuppressWarnings("deprecation")
		String userId=""+date.getYear() + (date.getMonth() + 1) 
				+ date.getDate()  + date.getHours() 
				+ date.getMinutes() + date.getSeconds();	
		System.out.println("当前时间为：时间时间回家安:"+userId);
		
		
		String  username= request.getParameter("username");
		String  password= request.getParameter("password");
		String  status= request.getParameter("status");
		System.out.println(status);
		UserDaoImpl u=new UserDaoImpl();
		User d=new User(userId,username,password,status);
		boolean flag=u.addUser(d);
		if(flag){
			System.out.println("注册成功，注册成功");

			request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);			
		}
		
		
		
	}

}

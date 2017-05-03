package com.dw.controll;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.User;
import com.dw.util.DbConn;

public class ShowUserServlet extends HttpServlet {
	@SuppressWarnings("unused")
	private Connection conn = DbConn.getConn();
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		  
		   UserDaoImpl u=new UserDaoImpl();
		  List<User> userlist=u.StSelect();
		  request.setAttribute("userlist", userlist);
		  request.getRequestDispatcher("main_manager.jsp").forward(request, response);
	}

}

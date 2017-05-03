package com.dw.controll;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.AddressBookDao;
import com.dw.dao.impl.AddressBookImpl;
import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.AddressBook;
import com.dw.model.User;

/**
 * 控制层 -添加 逻辑处理
  @author DY1101shaoyuxian
 * 
 */
public class AddServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String add=request.getParameter("add");
		if("add_addressbook".equals(add)){
			 String mainPage = "add/AddAddressBook.jsp";
			 request.setAttribute("mainPage", mainPage);
			 request.getRequestDispatcher("main.jsp").forward(request, response);	
		}else if("add_diary".equals(add)){
			 String mainPage = "add/AddDiary.jsp";
			 request.setAttribute("mainPage", mainPage);	
			 request.getRequestDispatcher("main.jsp").forward(request, response);	
		}else if("add_memo".equals(add)){
			String mainPage = "add/AddMemo.jsp";
			 request.setAttribute("mainPage", mainPage);
			 request.getRequestDispatcher("main.jsp").forward(request, response);	
		}else if("add_property".equals(add)){
			String mainPage = "add/AddProperty.jsp";
			 request.setAttribute("mainPage", mainPage);	
			 request.getRequestDispatcher("main.jsp").forward(request, response);	
		}else if("add_user".equals(add)){
			Date date=new Date();
			@SuppressWarnings("deprecation")
			String userId2=""+date.getYear() + (date.getMonth() + 1) 
					+ date.getDate()  + date.getHours() 
					+ date.getMinutes() + date.getSeconds();				
			String username1=request.getParameter("username1");
			String password1=request.getParameter("password1");
			User stu=new User(userId2,username1,password1,"person");
			UserDaoImpl u=new UserDaoImpl();
			u.addUser(stu);
			List<User> userlist=u.StSelect();			
			request.setAttribute("userlist", userlist);
			request.getRequestDispatcher("ShowUserServlet").forward(request, response);
		}
			
	}
}

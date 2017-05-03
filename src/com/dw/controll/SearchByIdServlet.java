package com.dw.controll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.AddressBookImpl;
import com.dw.dao.impl.DiaryImpl;
import com.dw.dao.impl.MemoImpl;
import com.dw.dao.impl.PropertyImpl;
import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.AddressBook;
import com.dw.model.Diary;
import com.dw.model.Memo;
import com.dw.model.Property;
import com.dw.model.User;

public class SearchByIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    String userId=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		userId=(String) session.getAttribute("userId");
		
		String find = request.getParameter("find");
		
		if ("find_addressbook".equals(find)) {
			String name = request.getParameter("searchName");
			AddressBookImpl studao = new AddressBookImpl();
			List<AddressBook> list  = studao.findAddressBookByName(userId,name);		
			request.setAttribute("list", list);
			String mainPage = "displayAddressBook.jsp";
			request.setAttribute("mainPage", mainPage);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		} else if ("find_diary".equals(find)) {
			String event = request.getParameter("searchEvent");
			
			
			DiaryImpl userdao = new DiaryImpl();
			List<Diary> list = userdao.findDiaryByEvent(userId,event);
			
			request.setAttribute("list", list);
			String mainPage = "displayDiary.jsp";
			request.setAttribute("mainPage", mainPage);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		} else if ("find_memo".equals(find)) {
			String event = request.getParameter("searchEvent");
			
			
			MemoImpl userdao = new MemoImpl();
			List<Memo> list = userdao.findMemoByEvent(userId,event);
			
			request.setAttribute("list", list);
			String mainPage = "displayMemo.jsp";
			request.setAttribute("mainPage", mainPage);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		} else if ("find_property".equals(find)) {
			String project = request.getParameter("searchProject");
			
			PropertyImpl userdao = new PropertyImpl();
			List<Property> list = userdao.findPropertyByProject(userId,project);
		
			request.setAttribute("list", list);
			String mainPage = "displayProperty.jsp";
			request.setAttribute("mainPage", mainPage);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else if("find_user".equals(find)){
			UserDaoImpl u=new UserDaoImpl();
			String username=request.getParameter("username");
			List<User> list=u.SelectByName(username);
			request.setAttribute("userlist", list);
			request.getRequestDispatcher("main_manager.jsp").forward(request, response);
			
		}
		


	}

}

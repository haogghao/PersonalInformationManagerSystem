package com.dw.controll;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dw.dao.MemoDao;
import com.dw.dao.DiaryDao;
import com.dw.dao.AddressBookDao;
import com.dw.dao.PropertyDao;
import com.dw.dao.impl.AddressBookImpl;
import com.dw.dao.impl.DiaryImpl;
import com.dw.dao.impl.MemoImpl;
import com.dw.dao.impl.PropertyImpl;
import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.Memo;
import com.dw.model.Diary;
import com.dw.model.AddressBook;
import com.dw.model.Property;
import com.dw.model.User;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String updatetype = (String) request.getParameter("updatetype");
		if("UpdateMemo".equals(updatetype)){
			String id = request.getParameter("id");
			MemoDao studao = new MemoImpl();			
			Memo memo = studao.findMemoById(id);
			request.setAttribute("memo", memo);
			String mainPage = "UpdateMemo.jsp";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else if("UpdateDiary".equals(updatetype)){
			String id = request.getParameter("id");
			DiaryDao studao = new DiaryImpl();
			
			Diary Diary = studao.findDiaryByid(id);
			request.setAttribute("diary", Diary);
			String mainPage = "UpdateDiary.jsp";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else if("UpdateAddressBook".equals(updatetype)){
			String id = request.getParameter("id");
			AddressBookDao studao = new AddressBookImpl();			
			AddressBook AddressBook = studao.findAddressBookById(id);
			request.setAttribute("addressbook", AddressBook);
			String mainPage = "UpdateAddressBook.jsp";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else if("UpdateProperty".equals(updatetype)){
			String id = request.getParameter("id");
			PropertyDao studao = new PropertyImpl();		
			Property Property = studao.findPropertyByid(id);
			request.setAttribute("property", Property);
			String mainPage = "UpdateProperty.jsp";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else if("UpdatePassWord".equals(updatetype)){
			String mainPage = "updatepwd.jsp";
			request.setAttribute("mainPage", mainPage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}else if("UpdateUser".equals(updatetype)){
			String user_id=request.getParameter("user_id");
			System.out.println("user_id用户id用户id用户id；"+user_id);
			UserDaoImpl studao=new UserDaoImpl();
			User userObject = studao.findUserByUserId(user_id);
		     System.out.println("用户名：用户名："+userObject.getUsername());
			request.setAttribute("userObject",userObject );
			request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
			
		}
	}
	
	
	





	
	

}

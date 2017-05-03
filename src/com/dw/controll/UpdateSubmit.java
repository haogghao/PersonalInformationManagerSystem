package com.dw.controll;

import java.io.IOException;
import java.io.PrintWriter;
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

public class UpdateSubmit extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String userId=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request,response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session=request.getSession();
          userId=(String) session.getAttribute("userId");//新加的
            String submittype= request.getParameter("submittype");
		    if("submitpwd".equals(submittype)){
		    	updatetepwd(request,response);
		    }else if("submitaddressbook".equals(submittype)){
		    	updateAddressBook(request,response);
		    }else if("submitmemo".equals(submittype)){
		    	updateMemo(request,response);
		    }else if("submitdiary".equals(submittype)){
		    	updateDiary(request,response);
		    }else if("submitproperty".equals(submittype)){
		    	updateProperty(request,response);
		    }else if("submituser".equals(submittype)) {
		    	updateUser(request,response);
		    }
	}
	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userid2=request.getParameter("userid2");		
		String username2=request.getParameter("username2");
		String password2=request.getParameter("password2");	
		UserDaoImpl dao=new UserDaoImpl();
		User newuser=new User(userid2,username2,password2,"person");
		boolean flag=dao.updateByUserId(newuser);
		if(flag){
		request.getRequestDispatcher("ShowUserServlet").forward(request, response);
		}
		}
	public void updatetepwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 String username=(String)session.getAttribute("username");
		 String repassword=request.getParameter("repassword");
		 String userId=request.getParameter("userId");
		 String status=request.getParameter("status");
		 User user=new User(userId,username,repassword,status);
		 UserDaoImpl userdao=new UserDaoImpl();
		 boolean flag=userdao.updateUserPassWord(user);
		 if(flag){
			 String mainPage = "updatepwdSuccess.jsp";
			 request.setAttribute("mainPage", mainPage);
		 }else{
			 request.setAttribute("error", "更新失败");
		 }
		    RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
	}
	public void updateAddressBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id1");
		String name1=request.getParameter("name1");
		 String contact_way1=request.getParameter("contact_way1");
		 String work_addr1=request.getParameter("work_addr1");
		 String city1=request.getParameter("city1");
		 String beizhu1=request.getParameter("beizhu1");

		 AddressBook us=new AddressBook(id1,name1,contact_way1,work_addr1,city1,beizhu1);
		 AddressBookImpl update=new AddressBookImpl();
		 boolean flag=update.updateAddressBook(us);
		 if(flag){
			   
				List<AddressBook> list = update.StSelect(userId);
				String mainPage="displayAddressBook.jsp";
				request.setAttribute("list", list);
				request.setAttribute("mainPage", mainPage);
				
		 }else{
			 request.setAttribute("error", "更新失败");			 	 
		 }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);		
	}	

	public void updateMemo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id1");
		String time1=request.getParameter("time1");
		 String event1=request.getParameter("event1");
		 String addr1=request.getParameter("addr1");
		

		 Memo us=new Memo(id1,time1,event1,addr1);
		 MemoImpl update=new MemoImpl();
		 boolean flag=update.updateMemo(us);
		 if(flag){
			
				@SuppressWarnings("unchecked")
				List<Memo> list = update.StSelect(userId);
				String mainPage="displayMemo.jsp";
				request.setAttribute("list", list);
				request.setAttribute("mainPage", mainPage);
				
		 }else{
			 request.setAttribute("error", "更新失败");			 	 
		 }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);		
	}	


	public void updateDiary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id1");
		String time1=request.getParameter("time1");	
		 String addr1=request.getParameter("addr1");
		 String event1=request.getParameter("event1");
		 String characters1=request.getParameter("characters1");
		 Diary us=new Diary(id1,time1,addr1,event1,characters1);
		DiaryImpl update=new DiaryImpl();
		 boolean flag=update.updateDiary(us);
		 if(flag){
			
				List<Diary> list = update.StSelect(userId);
				String mainPage="displayDiary.jsp";
				request.setAttribute("list", list);
				request.setAttribute("mainPage", mainPage);
				
		 }else{
			 request.setAttribute("error", "更新失败");			 	 
		 }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);		
	}	
	
	
	
	
	public void updateProperty(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id1=request.getParameter("id1");
		String income1=request.getParameter("income1");	
		 String project1=request.getParameter("project1");
		 String money1=request.getParameter("money1");
		 String time1=request.getParameter("time1");
		 String left_money1=request.getParameter("left_money1");
		 Property us=new Property(id1,income1,project1,money1,time1,left_money1);
		 PropertyImpl update=new PropertyImpl();
		 boolean flag=update.updateProperty(us);
		 if(flag){
			
				List<Property> list = update.StSelect(userId);
				String mainPage="displayProperty.jsp";
				request.setAttribute("list", list);
				request.setAttribute("mainPage", mainPage);
				
		 }else{
			 request.setAttribute("error", "更新失败");			 	 
		 }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);		
	}	
	
	
	
}

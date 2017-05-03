package com.dw.controll;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.AddressBookDao;
import com.dw.dao.DiaryDao;
import com.dw.dao.MemoDao;
import com.dw.dao.PropertyDao;
import com.dw.dao.impl.AddressBookImpl;
import com.dw.dao.impl.DiaryImpl;
import com.dw.dao.impl.MemoImpl;
import com.dw.dao.impl.PropertyImpl;
import com.dw.model.AddressBook;
import com.dw.model.Diary;
import com.dw.model.Memo;
import com.dw.model.Property;

public class AddSubmit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date date=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            doPost(request,response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String addtype=request.getParameter("addtype");
		if("add_addressbook".equals(addtype)){
			addAddressBook(request,response);			
		}else if("add_diary".equals(addtype)){
			 addDiary(request,response);	
		}else if("add_memo".equals(addtype)){
			addMemo(request,response);		
		}else if("add_property".equals(addtype)){
			addProperty(request,response);		
		}	
	}	
	private void addProperty(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		date=new Date();
		@SuppressWarnings({ "deprecation" })
		String id1=""+date.getYear() + (date.getMonth() + 1) 
				+ date.getDate()  + date.getHours() 
				+ date.getMinutes() + date.getSeconds();	
		System.out.println("��ǰʱ��Ϊ��ʱ��ʱ��11111:"+id1);
		
		
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");		
	
		String  income1= request.getParameter("income1");
		String  project1= request.getParameter("project1");
		String  money1= request.getParameter("money1");
		String  time1= request.getParameter("time1");
		String  left_money1= request.getParameter("left_money1");
		Property stu = new Property(id1,userId,income1,project1,money1,time1,left_money1);
		PropertyDao studao = new PropertyImpl();
		boolean flag = studao.addProperty(stu);
		if (flag) {// && !(stTel == null) && !"".equals(stTel)
			request.setAttribute("msg", "��ӳɹ�!!");
			PropertyImpl dao = new PropertyImpl();			
			List<Property> list = dao.StSelect(userId);
			String mainPage="displayProperty.jsp";
			request.setAttribute("list", list);
			request.setAttribute("mainPage", mainPage);
		} else {
			
			System.out.println("���ʧ��!!");
		}
                 request.getRequestDispatcher("main.jsp").forward(request,
					response);
	}

	private void addMemo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		date=new Date();
		@SuppressWarnings({ "deprecation" })
		String id1=""+date.getYear() + (date.getMonth() + 1) 
				+ date.getDate()  + date.getHours() 
				+ date.getMinutes() + date.getSeconds();	

		String  time1= request.getParameter("time1");
		String  event1= request.getParameter("event1");
		String  addr1= request.getParameter("addr1");
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");//�¼�
		
		Memo stu = new Memo(id1,userId,time1,event1,addr1);
		MemoDao studao = new MemoImpl();
		boolean flag = studao.addMemo(stu);
		if (flag) {// && !(stTel == null) && !"".equals(stTel)
			request.setAttribute("msg", "��ӳɹ�!!");
			MemoImpl dao = new MemoImpl();
			
			@SuppressWarnings("unchecked")
			List<Memo> list = dao.StSelect(userId);
			String mainPage="displayMemo.jsp";
			request.setAttribute("list", list);
			request.setAttribute("mainPage", mainPage);
			
		} else {
			
			System.out.println("���ʧ��!!");
		}
                 request.getRequestDispatcher("main.jsp").forward(request,
					response);
		
		
	}

	private void addDiary(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		date=new Date();
		@SuppressWarnings({ "deprecation" })
		String id1=""+date.getYear() + (date.getMonth() + 1) 
				+ date.getDate()  + date.getHours() 
				+ date.getMinutes() + date.getSeconds();	
		
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");//�¼�
		
		String  time1= request.getParameter("time1");
		String addr1 = request.getParameter("addr1");
		String  event1= request.getParameter("event1");
		String  characters1= request.getParameter("characters1");
		Diary stu = new Diary(id1,userId,time1,addr1,event1,characters1);
		DiaryDao studao = new DiaryImpl();
		boolean flag = studao.addDiary(stu);
		if (flag) {// && !(stTel == null) && !"".equals(stTel)
			request.setAttribute("msg", "��ӳɹ�!!");
			DiaryImpl dao = new DiaryImpl();
		
			List<Diary> list = dao.StSelect(userId);
			String mainPage="displayDiary.jsp";
			request.setAttribute("list", list);
			request.setAttribute("mainPage", mainPage);
		} else {
			
			System.out.println("���ʧ��!!");
		}
		request.getRequestDispatcher("main.jsp").forward(request,
				response);		
		
	}

	private void addAddressBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		date=new Date();
		@SuppressWarnings({ "deprecation" })
		String id1=""+date.getYear() + (date.getMonth() + 1) 
				+ date.getDate()  + date.getHours() 
				+ date.getMinutes() + date.getSeconds();	
		
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");//�¼�
		
		String  name1= request.getParameter("name1");
		String  contact_way1= request.getParameter("contact_way1");
		String  work_addr1= request.getParameter("work_addr1");
		String  city1= request.getParameter("city1");
		String  beizhu1= request.getParameter("beizhu1");
		AddressBook stu = new AddressBook(id1,userId,name1,contact_way1,work_addr1,city1,beizhu1);
		AddressBookDao studao = new AddressBookImpl();
		boolean flag = studao.addAddressBook(stu);
		if (flag) {  // ������������֤&& !(stTel == null) && !"".equals(stTel)
			request.setAttribute("msg", "��ӳɹ�!!");			
			AddressBookImpl dao = new AddressBookImpl();
			
			List<AddressBook> list = dao.StSelect(userId);
			String mainPage="displayAddressBook.jsp";
			request.setAttribute("list", list);
			request.setAttribute("mainPage", mainPage);						
		} else {			
			System.out.println("���ʧ��!!");
		}
		request.getRequestDispatcher("main.jsp").forward(request,
				response);
		
			
	}

}

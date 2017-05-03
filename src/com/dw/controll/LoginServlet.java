package com.dw.controll;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.User;
import com.dw.util.StringUtil;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		req.setCharacterEncoding("utf-8");//�����������
	//	String userId=req.getParameter("userId");
		String username=req.getParameter("username").trim();//��ȡusername��ȥ���ո�
		String password=req.getParameter("password").trim();//��ȡpassword��ȥ���ո�
		String imageValue=req.getParameter("imageValue");
		String remember=req.getParameter("remember");
		String status=req.getParameter("status");
		System.out.println("��¼״̬�ǣ�"+status);
	//	req.setAttribute("userId", userId);	
		
		
	//	session.setAttribute("password", password);//�Լ�д��
		req.setAttribute("imageValue", imageValue);
	    String sRand=(String) session.getAttribute("sRand");
	 	 if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		 }
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "��������֤�룡");
	 		req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "��֤�����");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}
	 	//�������д��������
		User user=new User("",username,password,status);
		UserDaoImpl usersdao=new UserDaoImpl();
		session.setAttribute("username", username);	
		//session.setAttribute("password", password);//������Լ���ӵ�
		if(usersdao.isLogin(user)){//��¼�ɹ�
			
				rememberMe(username,resp);
				
			if(status.equals("person")){//����Ǹ����û�
			String userId=usersdao.findUserid(username,password,status);
			System.out.println("�û�IdΪ��"+userId);
			session.setAttribute("userId", userId);
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			req.setAttribute("status", status);
			
			resp.sendRedirect("main.jsp");
			}else if(status.equals("manager")){//����ǹ���Ա�û�
			//	req.setAttribute("status", "")
				UserDaoImpl dao=new UserDaoImpl();
				List<User> userlist=dao.StSelect();
				
				req.setAttribute("userlist", userlist);
				req.getRequestDispatcher("main_manager.jsp").forward(req, resp);
			}
			
			
		}
		else{
			req.setAttribute("error", "�û������������!");
			RequestDispatcher requestdispatcher=req.getRequestDispatcher("login.jsp");
			requestdispatcher.forward(req, resp);
		}
		
	}

	
	private void rememberMe(String userName,HttpServletResponse response){
		Cookie user;
		try {
			user = new Cookie("user",URLEncoder.encode(userName,"UTF-8"));
			user.setMaxAge(1*60*60*24*7);
			response.addCookie(user);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

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
		req.setCharacterEncoding("utf-8");//解决乱码问题
	//	String userId=req.getParameter("userId");
		String username=req.getParameter("username").trim();//获取username并去掉空格
		String password=req.getParameter("password").trim();//获取password并去掉空格
		String imageValue=req.getParameter("imageValue");
		String remember=req.getParameter("remember");
		String status=req.getParameter("status");
		System.out.println("登录状态是："+status);
	//	req.setAttribute("userId", userId);	
		
		
	//	session.setAttribute("password", password);//自己写的
		req.setAttribute("imageValue", imageValue);
	    String sRand=(String) session.getAttribute("sRand");
	 	 if(StringUtil.isEmpty(username)||StringUtil.isEmpty(password)){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		 }
	 	if(StringUtil.isEmpty(imageValue)){
	 		req.setAttribute("error", "请输入验证码！");
	 		req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}else if(!imageValue.equals(sRand)){
			req.setAttribute("error", "验证码错误！");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
			return;
		}
	 	//下面的乱写，测试用
		User user=new User("",username,password,status);
		UserDaoImpl usersdao=new UserDaoImpl();
		session.setAttribute("username", username);	
		//session.setAttribute("password", password);//这个是自己添加的
		if(usersdao.isLogin(user)){//登录成功
			
				rememberMe(username,resp);
				
			if(status.equals("person")){//如果是个人用户
			String userId=usersdao.findUserid(username,password,status);
			System.out.println("用户Id为："+userId);
			session.setAttribute("userId", userId);
			req.setAttribute("username", username);
			req.setAttribute("password", password);
			req.setAttribute("status", status);
			
			resp.sendRedirect("main.jsp");
			}else if(status.equals("manager")){//如果是管理员用户
			//	req.setAttribute("status", "")
				UserDaoImpl dao=new UserDaoImpl();
				List<User> userlist=dao.StSelect();
				
				req.setAttribute("userlist", userlist);
				req.getRequestDispatcher("main_manager.jsp").forward(req, resp);
			}
			
			
		}
		else{
			req.setAttribute("error", "用户名或密码错误!");
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

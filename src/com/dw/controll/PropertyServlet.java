package com.dw.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dw.dao.impl.PropertyImpl;
import com.dw.model.Property;

public class PropertyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PropertyImpl studao = new PropertyImpl();
		HttpSession session=request.getSession();
		String userId=(String) session.getAttribute("userId");//ÐÂ¼Ó
		List<Property> list = studao.StSelect(userId);
		String mainPage="displayProperty.jsp";
		request.setAttribute("list", list);
		request.setAttribute("mainPage", mainPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
		
	}

}

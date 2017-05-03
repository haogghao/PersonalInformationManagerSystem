package com.dw.controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dw.dao.AddressBookDao;
import com.dw.dao.DiaryDao;
import com.dw.dao.MemoDao;
import com.dw.dao.PropertyDao;
import com.dw.dao.impl.AddressBookImpl;
import com.dw.dao.impl.DiaryImpl;
import com.dw.dao.impl.MemoImpl;
import com.dw.dao.impl.PropertyImpl;
import com.dw.dao.impl.UserDaoImpl;
import com.dw.model.User;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		
		if(name.equals("AddressBook")){
			AddressBookDao studao = new AddressBookImpl();
			String id=request.getParameter("id");
			boolean flag=studao.delAddressBook(id);
			//如果删除成功，返回到displayAddressBook.jsp页面，如果不成功，给用户提示信息
			if(flag){
				RequestDispatcher dispatch=request.getRequestDispatcher("AddressBookServlet");
				dispatch.forward(request, response);
			}else{
				 System.out.println("删除失敗!!");
			}		
		}
		else if(name.equals("Diary")){
			DiaryDao studao = new DiaryImpl();
			String id=request.getParameter("id");
			boolean flag=studao.delDiary(id);
			if(flag){
				RequestDispatcher dispatch=request.getRequestDispatcher("DiaryServlet");
				dispatch.forward(request, response);
			}else{
				 System.out.println("删除失敗!!");
			}	
		}else if(name.equals("Memo")){
			MemoDao studao = new MemoImpl();
			String id=request.getParameter("id");
			boolean flag=studao.delMemo(id);
			if(flag){
				RequestDispatcher dispatch=request.getRequestDispatcher("MemoServlet");
				dispatch.forward(request, response);
			}else{
				 System.out.println("删除失敗!!");
			}	
		}else if(name.equals("Property")){ //删除Property
			PropertyDao studao = new PropertyImpl();
			String id=request.getParameter("id");
			boolean flag=studao.delProperty(id);
			if(flag){
				RequestDispatcher dispatch=request.getRequestDispatcher("PropertyServlet");
				dispatch.forward(request, response);
			}else{
				 System.out.println("删除失敗!!");
			}	
		}else if(name.equals("User")){
//			String user_id=request.getParameter("user_id");
//			System.out.println("userId为："+user_id.toString());
//			document.getElementsByName("selectFlag")[i].value;
			String[] select=request.getParameterValues("selectFlag");//选中的id都保存在数组中
			UserDaoImpl u=new UserDaoImpl();
			for(int i=0;i<select.length;i++){
				
				if(u.delUser(select[i])){
					continue;
				}else{
					System.out.println("删除失败");
					break;
				}
			}
			List<User> userlist=u.StSelect();			
			request.setAttribute("userlist", userlist);
			request.getRequestDispatcher("main_manager.jsp").forward(request, response);
			
			
			
		}
		
		
	}

}

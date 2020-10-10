package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserBeanBo;

public class Login1 extends HttpServlet {

	public Login1() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		
		UserBeanBo ubo=new UserBeanBo();
		
		try {
			if(ubo.checkUser(u,p)){
				
				ArrayList al=ubo.getUsersByPage(6,1);
				int pageCount=ubo.getPageCount(6);
				request.setAttribute("users",al);
				request.setAttribute("pageCount",pageCount+"");
				request.getRequestDispatcher("welcome.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("error.jsp").forward(request,response);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void init() throws ServletException {
		// Put your code here
	}

}

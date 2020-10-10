package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.UserBeanBo;

public class Fenye_w extends HttpServlet {


	public Fenye_w() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String gongneng=request.getParameter("gongneng");
		
		if(gongneng.equals("turn"))
		{
			String pageNow_s=request.getParameter("pageNow");
		    int pageNow=Integer.parseInt(pageNow_s);
		    UserBeanBo ubo=new UserBeanBo();
		    int pageCount=ubo.getPageCount(6);
		    ArrayList al=ubo.getUsersByPage(6, pageNow);
		    request.setAttribute("users",al);
		    request.setAttribute("pageCount",pageCount+"");
		    request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}
		
		if(gongneng.equals("delete"))
		{
			String id_s=request.getParameter("id");
			int id=Integer.parseInt(id_s);
			UserBeanBo ubo=new UserBeanBo();
			ubo.DeleteUser(id);
			ArrayList al=ubo.getUsersByPage(6, 1);
			int pageCount=ubo.getPageCount(6);
			request.setAttribute("users",al);
			request.setAttribute("pageCount",pageCount+"");
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}
		
		if(gongneng.equals("add"))
		{
			UserBeanBo ubo=new UserBeanBo();
			ubo.AddUsers();
			ArrayList al=ubo.getUsersByPage(6, 1);
			int pageCount=ubo.getPageCount(6);
			request.setAttribute("users",al);
			request.setAttribute("pageCount",pageCount+"");
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
			
		}
		
		if(gongneng.equals("update"))
		{
			String id_s=request.getParameter("id");
			int id=Integer.parseInt(id_s);
			UserBeanBo ubo=new UserBeanBo();
			ubo.UpdateUser(id);
			ArrayList al=ubo.getUsersByPage(6, 1);
			int pageCount=ubo.getPageCount(6);
			request.setAttribute("users",al);
			request.setAttribute("pageCount",pageCount+"");
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
			try {
				this.doGet(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

package com.jgzn.redis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jgzn.redis.service.StudentService;
import com.jgzn.redis.service.impl.StudentServiceImpl;

public class StudentAddServlet extends HttpServlet{
	StudentService studentService = new StudentServiceImpl();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		StudentService studentService = new StudentServiceImpl();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String avgscore = req.getParameter("avgscore");
		String birthday = req.getParameter("birthday");//提交过来的是String类型，直接获取
		String description = req.getParameter("description");
		//关于这个数据类型转换的问题，有点迷，redis的hash只能存String类型
		
		/*int avgscore02 = Integer.parseInt(avgscore);//把avgscore转成int型
		//把birthday转成日期型
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
		String s= birthday; 
		try {
			Date birthday02 =  formatter.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*System.out.println("id:" + id);
		System.out.println("name:" + name);
		System.out.println("avgscore:" + avgscore);
		System.out.println("birthday:" + birthday);
		System.out.println("description:" + description);*/
		
		studentService.add(id, name, avgscore, description, birthday);
		//System.out.println("key:王显军" + id);
		/* req.getRequestDispatcher("/servlet/StudentGetAllServlet")  
         .forward(req, resp);  */
		 resp.sendRedirect("StudentGetAllServlet");
	}
	}


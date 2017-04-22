package com.jgzn.redis.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;

import com.jgzn.redis.model.Student;
import com.jgzn.redis.service.StudentService;
import com.jgzn.redis.service.impl.StudentServiceImpl;
import com.sun.mail.iap.Response;

public class StudentUpdateServlet extends HttpServlet{
	StudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		StudentService studentService = new StudentServiceImpl();
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String avgscore = req.getParameter("avgscore");
		String birthday = req.getParameter("birthday");
		String description = req.getParameter("description");
		studentService.update(id, name, avgscore, description, birthday);
		//System.out.println("key:王显军" + id);
		 resp.sendRedirect("StudentGetAllServlet"); 
	}
	//现在更新功能有一个问题:点击更新链接之后，进入更新界面后，会在提交的表格中显示出更新之前的数据的值
	//但是现在日期显示格式不对，不管是哪一个学生，前4位都是0008
	//现在来捋一捋，点击修改之后，会直接链接到更新的jsp，而且为了初始化，还顺带传了许多参数过来，其他参数都没有问题，就是
	//传的birthday,传过去接收到是date类型，但是是
	}


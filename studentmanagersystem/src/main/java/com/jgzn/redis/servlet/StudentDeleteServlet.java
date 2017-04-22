package com.jgzn.redis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jgzn.redis.service.StudentService;
import com.jgzn.redis.service.impl.StudentServiceImpl;

public class StudentDeleteServlet extends HttpServlet{
	StudentService studentService = new StudentServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			String id = req.getParameter("id");
		//System.out.println("id:" + id);
			studentService.delete(id);
			req.getRequestDispatcher("/servlet/StudentGetAllServlet")  
            .forward(req, resp);  
			}
	}
	


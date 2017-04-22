package com.jgzn.redis.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
import com.jgzn.redis.util.ConnectToRedis;
import com.sun.mail.iap.Response;

public class StudentGetAllServlet extends HttpServlet{
	StudentService studentService = new StudentServiceImpl();
	
	
	Iterator<String> keys;
	private Jedis jedis = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	int avgscore02;
	Map<String,String> map = new HashMap<String, String>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			int countRecord = 0;
			int countPageRecord = 10;
			int countPage = 0;
			int pageNos;
			List<Student> students = new ArrayList<Student>();
			 Date birthday02 = null;
			jedis = ConnectToRedis.getJedis();
			keys = studentService.getAll();//我的getall
			//方法是拿到所有的key,并不是拿到所有的student
			 while(keys.hasNext()){   
	             Object obj1=keys.next();   
	             String id = obj1.toString(); //现在为了把id作为key,这里用的是hget(key,field)这种模式得到
	             //字段的值，但是这个obj1.toString()是key,应该
	             String name = jedis.hget(obj1.toString(),"name");
	             String avgscore = jedis.hget(obj1.toString(),"avgscore");
	             String description = jedis.hget(obj1.toString(),"description");
	             String birthday = jedis.hget(obj1.toString(),"birthday");
	             try {
					birthday02 = formatter.parse(birthday);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	     		int avgscore02 = Integer.parseInt(avgscore); 
	                Student student = new Student();
	                student.setId(id);
	                student.setAvgscore(avgscore02);
	                student.setDescription(description);
	                student.setName(name);
	                student.setBirthday(birthday02);
	                students.add(student);
	                countRecord ++;
	           }  
			 
			 Collections.sort(students, new Comparator<Student>() {
					@Override
					public int compare(Student s1, Student s2) {
		               if(s1.getAvgscore() < s2.getAvgscore())  { return 1; }  
		               if(s1.getAvgscore()==s2.getAvgscore())  { return 0; }  
		               return -1;  
					}
				});
			 	//System.out.println("总条数:" + countRecord);
	     		req.setAttribute("students", students);
	     		         if (req.getParameter("pageNos") == null||Integer.parseInt(req.getParameter("pageNos")) < 1) {
	     		             pageNos = 1;
	     		         } else {
	     		             pageNos = Integer.parseInt(req.getParameter("pageNos"));
	     		         }
	     		         req.setAttribute("pageNos", pageNos);
	     		         // 定义总页数并存到session中
	     		        if(countRecord%countPageRecord==0) {
	     		     	  countPage = countRecord/countPageRecord;
	     		       }
	     		       else countPage = countRecord/countPageRecord + 1;
	     		      // System.out.println("总条数:" + countRecord);
	     		      // System.out.println("总页数:" + countPage);    
	     		         req.setAttribute("countPage", countPage);
	     		         req.getRequestDispatcher("/query.jsp").forward(req, resp);  
	     		
	}
	}


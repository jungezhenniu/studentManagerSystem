<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String avgscore = request.getParameter("avgscore");
	String description = request.getParameter("description");
	String birthday = request.getParameter("birthday");//这个传过来的值到底是不是String类型,${student.birthday},是根据students来拿的，应该是
	//存进students这个list中的都是student对象，所以拿到的应该是一个Date类型，但是我用的是String类接收，是不是有一点问题
	
	//System.out.println("birthday:" + birthday);
	//先new一个simpleDateFormat,准备来把String类型
	
	//加这一段代码的原因是：传过来的日期类型不知道什么原因字符串少了一个+，多了一个空格,我使用
	//字符串的相关函数把把这个+加上，然后去掉空格
	StringBuilder sb = new StringBuilder(birthday);
	sb.insert(23, "+");
	birthday = sb.toString();
	StringBuffer strb = new StringBuffer(birthday);
	strb.deleteCharAt(24);
	birthday = strb.toString();
	
	SimpleDateFormat sdf=new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy",Locale.ENGLISH); 
	Date date = sdf.parse(birthday);
	
	SimpleDateFormat sdf02 = new SimpleDateFormat("yyyy-MM-dd");  
	
	String birthday02 = sdf02.format(date);
	//System.out.println("birthday02:" + birthday02);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改学生信息</title>
  </head>
  
  <body>
    <center>
     <form action="servlet/StudentUpdateServlet" method="post">
    	 <h2 align="center">修改学生信息</h2>
       <input type="hidden" name="id" value= <%=id %> /><!-- //提交一个隐藏域，传递id -->
            姓名:&nbsp&nbsp&nbsp&nbsp<input name="name" type="text" value=<%=name %>><br>
            生日:&nbsp&nbsp&nbsp&nbsp<input name="birthday" type="text" value=<%=birthday02 %>><br>
            平均分:<input name="avgscore" type="text" value=<%=avgscore %>><br>
            备注:&nbsp&nbsp&nbsp&nbsp<input name="description" type="text" value=<%=description %>><br>
            <input value="提交" type="submit"><br>
        </form>
         <a href="servlet/StudentGetAllServlet">点击退出修改</a>
         <h5>id以"0"开头，如01,02,033;日期的格式是yyyy-MM-dd,如1989-7-12</h5>
    </center>
  </body>
  
</html>

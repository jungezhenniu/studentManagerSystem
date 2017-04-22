<%@page import="com.jgzn.redis.model.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生信息</title>
  </head>
  
  <body>
	<center>
	<h1>学生信息</h1>
	<h4 align="center"> <a href="/studentmanagersystem/studentadd.jsp">添加学生</a></h4>
	<table border="1" width="400">
		<tr>
			<th> ID</th>
			<th> 姓名</th>
			<th> 生日 </th>
			<th>  平均分</th>
			<th>  备注</th>
			<th>删除</th>
			<th> 修改</th>
		</tr>
	<c:choose>
	    <c:when test="${empty students}">
	        <tr>
	            <td colspan="3">没有符合条件的数据</td>
	        </tr>
	    </c:when>
              
        <c:otherwise>
	        <c:forEach items="${students}" var="student" begin="${(pageNos-1)*10}"  end="${pageNos*10-1}">
	      		<tr>
	                <td>${student.id }</td>
	                <td>${student.name }</td>
	                <td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/> </td>
	                <%-- <td>${student.birthday} </td> --%>
	                <td>${student.avgscore }</td>
	                <td>${student.description }</td>
	                <td><a href="/studentmanagersystem/servlet/StudentDeleteServlet?id=${student.id}">删除</a></td>
	                <td><a href="/studentmanagersystem/studentupdate.jsp?id=${student.id}&name=${student.name}
	                														&avgscore=${student.avgscore}
	                														&description=${student.description}
	               														 &birthday=${student.birthday}">修改</a></td>
	                 <!-- 一开始我展示的时候，对于birthday，没有把date类型转换成String类型，
	                 所以得到的结果是一个详细的date类型，现在我在点击修改目录时，传过去的应该是一个date类型，那种详细格式的类型(Fri Jul 12 00:00:00 GMT+08:00 1963 )
	                 那么传进request的值应该是一个Date类型，那么reques能传Date类型的数据吗？
	                  -->
	            </tr>
	        </c:forEach>
        </c:otherwise>
 </c:choose>
	
	
	</table>
			<center>
				<c:if test="${pageNos>1 }">
			 		<a href="StudentGetAllServlet?pageNos=1" >首页</a>
					 <a href="StudentGetAllServlet?pageNos=${pageNos-1 }">上一页</a>
				</c:if>
			 	<c:if test="${pageNos <countPage }">
			 		<a href="StudentGetAllServlet?pageNos=${pageNos+1 }">下一页</a>
					 <a href="StudentGetAllServlet?pageNos=${countPage }">末页</a>
				</c:if>
			 </center>
			 <form action="StudentGetAllServlet">
			 	<h4 align="center">共${countPage}页  
			 		<input type="text" value="${pageNos}" name="pageNos" size="1">页
			  		<input type="submit" value="go">
			 	</h4>
			 </form>
	<br>
	</center>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加学生</title>
	<script type="text/JavaScript">
      function addSubmit(){
    	  
       var id=document.add.id.value;
       if(id==null||id=="")
       alert("请填写id");
       
       var name=document.add.name.value;
       if(name==null||name=="")
       alert("请填写姓名");
       
       var birthday=document.add.birthday.value;
       if(birthday==null||birthday=="")
       alert("请填写birthday");
       
       var avgscore=document.add.avgscore.value;
       if(avgscore==null||avgscore=="")
       alert("请填写平均分");
       
       var description=document.add.description.value;
       if(description==null||description=="")
       alert("请填写备注");
       
       else
        document.add.submit();
      }
    </script>
  </head>
  
  <body>
    <center>
     <form action="servlet/StudentAddServlet" method="post" name="add">
     	<h2>添加学生信息</h2>
     	
     		
       	      id:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input name="id" type="text" /><br>
           	姓名:&nbsp&nbsp&nbsp&nbsp<input name="name" type="text"><br>
           	生日:&nbsp&nbsp&nbsp&nbsp<input name="birthday" type="text"><br>
                      平均分:&nbsp<input name="avgscore" type="text"><br>
                      备注:&nbsp&nbsp&nbsp&nbsp<input name="description" type="text"><br>
             &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="提交" name="B1" onclick="addSubmit()"/>
      			<input type="reset" value="重置" name="B2"><br>
      </form>
        <a href="servlet/StudentGetAllServlet">点击退出添加</a>
        <h5>id以"0"开头，如01,02,033;日期的格式是yyyy-MM-dd,如1989-7-12</h5>
    </center>
    
    
    
    
   
    
  </body>
</html>

<%@page import="dao.StudentDao"%>
<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
div{
background-color:yellow
}
</style>
</head>
<body>
<% Student student=(Student)request.getAttribute("student"); %>
<div>
<table border='1px' style='color:red'>
<tr>
	  <th>Id</th>
	  <th>Name</th>
	  <th>Email</th>
	  <th>Number</th>
	  <th>Password</th>
	  <th>Edit</th>
	  <th>Delete</th>
</tr>
<tr>
	  <th><%=student.getId()%></th>
	  <th><%=student.getName()%></th>
	  <th><%=student.getEmail()%></th>
	  <th><%=student.getNumber()%></th>
	  <th><%=student.getPassword()%></th>
	   <th><a href="Edit.jsp?id=<%=student.getId()%>"><button>Edit</button></th>
	  <th><a href="delete?id=<%=student.getId()%>"><button>Delete</button></a></th>
 </tr>
</table>
</div>
<br>

<%List<Student> list=(List<Student>) request.getAttribute("list");%>
<table border='1px' style='color:green'>
<tr>
	  <th>Id</th>
	  <th>Name</th>
	  <th>Email</th>
	  <th>Number</th>
	  <th>Password</th>
	  <th>Edit</th>
	  <th>Delete</th>
</tr>
<%
for(Student student1:list){
%>
<tr>
      <th><%=student1.getId()%></th>
	  <th><%=student1.getName()%></th>
	  <th><%=student1.getEmail()%></th>
	  <th><%=student1.getNumber()%></th>
	  <th><%=student1.getPassword()%></th>
	  <th><a href="Edit.jsp?id=<%=student1.getId()%>"><button>Edit</button></a></th>
	  <th><a href="delete?id=<%=student1.getId()%>"><button>Delete</button></a></th>  
 </tr>
 <% } %>
 
</table>
</body>
</html>
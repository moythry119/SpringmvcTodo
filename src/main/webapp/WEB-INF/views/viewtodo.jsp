<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Todo List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Task</th><th>Description</th><th>Date</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="todo" items="${list}">   
   <tr>  
   <td>${todo.id}</td>  
   <td>${todo.task}</td>  
   <td>${todo.description}</td>  
   <td>${todo.date}</td>  
   <td><a href="editemp/${todo.id}">Edit</a></td>  
   <td><a href="deletetodo/${todo.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="todoform">Add New Todo</a>  

</body>
</html>
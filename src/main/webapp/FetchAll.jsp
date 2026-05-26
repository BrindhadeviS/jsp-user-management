<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="./FetchAll.css">
<body>

	<% List<User> list = (List<User>) request.getAttribute("list"); 
	if(list == null){
		return;
	}
	%>
	
    <h1>user details</h1>
	<table border="1px"  cellspacing="0">
		<tr>
			<th> ID </th>
			<th> FIRST NAME </th>
			<th> LAST NAME </th>
			<th> EMAIL </th>
			<th> PASSWORD </th>
			<th> PHONE </th>
            <th></th>
		</tr>
		
		<% for(User u : list) {  %>
			<tr>
				<td> <%= u.getId() %> </td>
				<td> <%= u.getFname() %> </td>
				<td> <%= u.getLname() %> </td>
				<td> <%= u.getEmail() %> </td>
				<td> <%= u.getPassword() %> </td>
				<td> <%= u.getPhone() %> </td>
				<td> <a href="delete?id=<%=u.getId()%>">delete</a>  </td>
			</tr>
		<% } %>
	</table>
	

</body>
</html>
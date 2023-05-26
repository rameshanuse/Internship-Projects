<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration Page</title>
</head>
<body bgcolor="lightblue">
<br/> <br/><br/>
<h1 style="color: rgb(128, 0, 0); text-align:center">STUDENT REGISTRATION </h1>
	<form method="post" action="./controller/regstudent"> 
		<table align='center'>
			<tr>
				<th>ENTER STUDENT ID</th>
				<td><input type='text' name='sid' /></td>
			</tr>
			<tr>
				<th>ENTER STUDENT FIRST NAME</th>
				<td><input type='text' name='sname' /></td>
			</tr>
			<tr>
				<th>ENTER STUDENT LAST NAME</th>
				<td><input type='text' name='slastname' /></td>
			</tr>
			<tr>
				<th>ENTER STUDENT AGE</th>
				<td><input type='text' name='sage' /></td>
			</tr>
			<tr>
				<th>ENTER STUDENT MAIL</th>
				<td><input type='text' name='smail' /></td>
			</tr>
			<tr>
				<th>ENTER STUDENT ADDRESS</th>
				<td><input type='text' name='saddress' /></td>
			</tr>
			<tr>
				<th>SET PASSWORD</th>
				<td><input type='text' name='spassword' /></td>
			</tr>
			<tr>
				<th></th>
				<td><input type='submit' value='save' />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="./index.jsp" target="_blank">|Home Page|</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
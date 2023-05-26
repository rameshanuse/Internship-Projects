<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Management Registration Page</title>
</head>
<body bgcolor="lightblue">
	<br />
	<br />
	<br />
	<h1 style="color: rgb(128, 0, 0); text-align:center">MANAGEMENT REGISTRATION </h1>
	<form action="./controller/mangregister" method="post">

		<table align="center">

			<tr>
				<th>ENTER MANAGEMENT ID</th>
				<td><input type="text" placholder="ManagementID" name="mid"></td>
			</tr>
			<tr>
				<th>ENTER MANAGEMENT NAME</th>
				<td><input type="text" placholder="ManagementName" name="mname"></td>
			</tr>
			<tr>
				<th>ENTER MANAGEMENT MAIL</th>
				<td><input type="text" placholder="ManagementMail"
					name="memail"></td>
			</tr>
			<tr>
				<th>ENTER PASSWORD</th>
				<td><input type="text" placholder="password" name="mpwd"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="register">&nbsp;&nbsp;&nbsp;
				<a href="./index.jsp" >|Home Page|</a></td>
			</tr>

		</table>
	</form>
</body>
</html>
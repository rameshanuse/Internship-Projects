<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>STUDENT BOOKS PAGE</title>
</head>
<body bgcolor="lightblue">
<br/> <br/><br/>
<h2 style="color: rgb(128, 0, 0); text-align:center">GET STUDENT ISSUED BOOKS </h2>
	<form method="post" action="./controller/studentmybooks"> 
		<table align='center'>
			<tr>
				<th>ENTER STUDEN ID</th>
				<td>
					<input type='text' placeholder="StudentId" name='sid' />
				</td>
			</tr>
			<tr>
				<th></th>
				<td><input type='submit' value='see books' /></td>
			</tr>
		</table>
	</form>
</body>
</html>
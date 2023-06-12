<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue Book Page</title>
</head>
<body bgcolor="lightblue">
<br/> <br/><br/>
	<h1 style="color: rgb(128, 0, 0); text-align: center">ISSUE BOOK TO STUDENT</h1>
	<form action="./controller/mangissuebookstud" method="post">

		<table align="center">
			<tr>
				<th>ENTER STUDENT ID</th>
				<td><input type="text" name="sid"></td>
			</tr>
			<tr>
				<th>ENTER BOOK ID</th>
				<td><input type="text" name="bid"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="issue"></td>
			</tr>
		</table>
	</form>
	${msg}
</body>
</html>
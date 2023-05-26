<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student My Fine Page</title>
</head>
<body bgcolor="lightblue">
		<br /><br />
	<center>
		<h1 style="color: rgb(128, 0, 0); text-align: center">STUDENT FINE DETAILS</h1>
		<form method="get" action="./controller/studentmyfines">
			<table>
				<tr>
					<th>STUDENT ID</th>
					<td><input type="text" placeholder="StudentId" name="sid" /></td>
				</tr>
				<tr>
					<th>BOOK ID</th>
					<td><input type="text" placeholder="BookId" name="bid" /></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="see fine" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Book Page</title>
</head>
<body bgcolor="lightblue">
<br/> <br/><br/>
<h1 style="color: rgb(128, 0, 0); text-align:center">BOOK DELETION PAGE </h1>
<form action="./controller/mangremovebooklib" method="post">
	<table align="center">
		<tr>
			<th>ENTER BOOK ID</th>
			<td><input type="text" name="bid"></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="remove"></td>
		</tr>
	</table>
</form>
</body>
</html>
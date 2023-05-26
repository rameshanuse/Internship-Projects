<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Books In Library Page</title>
</head>
<body bgcolor="lightblue">
<br/> <br/><br/>
<h1 style="color: rgb(128, 0, 0); text-align:center">ENTER BOOK DETAILS</h1>
<form action="./controller/mangaddbooklib" method="post">
	<table align="center">
		<tr>
			<th>ENTER BOOK ID</th>
			<td><input type="text" name="bid"></td>
		</tr>
		<tr>
			<th>ENTER BOOK TITLE</th>
			<td><input type="text" name="btitle"></td>
		</tr>
		<tr>
			<th>ENTER BOOK AUTHOR</th>
			<td><input type="text" name="bauthor"></td>
		</tr>
		<tr>
			<th>ENTER BOOK CATEGORY</th>
			<td><input type="text" name="bcategory"></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" value="addbook"></td>
		</tr>
	</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Book Page</title>
</head>
<body bgcolor="lightblue">
<br><br><br>
	<center>
	<h1 style="color: rgb(128, 0, 0); text-align:center">BOOK SEARCH </h1>
		<form action="./controller/mangsearchbooklib" method="post">
			<section> <select name="attribute">
				<option value="bid">bid</option>
				<option value="btitle">btitle</option>
				<option value="bauthor">bauthor</option>
				<option value="bcategory">bcategory</option>
			</select> <input type="text" name="value" /> </section>
			<button type="submit">search</button>
		</form>
	</center>
</body>
</html>
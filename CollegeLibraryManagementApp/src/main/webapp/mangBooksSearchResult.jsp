<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Books Page</title>
</head>
<body bgcolor='lightblue'>
<br><br><br>
	<c:choose>
		<c:when test="${book ne null || !empty book }">
			<table border='1' align="center">
				<tr>
				<th>BOOK ID</th>
				<th>BOOK TITLE</th>
				<th>BOOK AUTHOR</th>
				<th>BOOK CATEGORY</th>
			</tr>
			<tr>
				<td>${book.bid}</td>
				<td>${book.btitle}</td>
				<td>${book.bauthor}</td>
				<td>${book.bcategory}</td>
			</tr>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style='color:red; text-align:center;'>BOOK NOT AVAILABLE</h1>
		</c:otherwise>
	</c:choose>
	<br/><br/>
	<div style="text-align:center"><a href='../managSearchBookLib.jsp'>|Serch Page|</a></div>
	
</body>
</html>
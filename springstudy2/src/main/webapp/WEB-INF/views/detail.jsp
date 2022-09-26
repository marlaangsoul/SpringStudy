<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
</head>
<body>
<%@ include file="./include/menu.jsp" %>
<h1>책 상세</h1><hr>
<p>Title: ${data.title } </p>
<p>Category: ${data.category } </p>
<p>Price: <fmt:formatNumber type="number" 
				maxFractionDigits="3" value="${data.price }"/>  </p>
<p>Date: <tf:formatDateTime value="${data.insert_date }" pattern="yyyy-MM-dd"/></p>
<hr>
<p><a href="update?bookId=${data.book_id}">Book Update</a>
<a href="list">Book List</a></p>
<form method="post" action="delete">
<input type="hidden" name="bookId" value="${data.book_id}">
<input type="submit" value="Book Delete">
</form>

</body>
</html>
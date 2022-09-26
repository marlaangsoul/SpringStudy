<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detailVo.jsp</title>
</head>
<body>
<h1>책 상세 - BoookVo</h1><hr>
<p>Title: ${data.title } </p>
<p>Category: ${data.category } </p>
<p>Price: <fmt:formatNumber type="number" 
				maxFractionDigits="3" value="${data.price }"/>  </p>
<p>Date: 
<fmt:parseDate value="${data.insert_date}" pattern="yyyy-MM-dd HH:mm" var="myDate"/>
<fmt:formatDate value="${myDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
<hr>
<p>
<a href="updateVo?book_id=${data.book_id}">Book Update</a>
<a href="listVo">Book List</a></p>
<form method="post" action="deleteVo">
<input type="hidden" name="book_id" value="${data.book_id}">
<input type="submit" value="Book Delete">
</form>

</body>
</html>
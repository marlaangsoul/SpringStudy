<%@page import="com.springstudy.book.vo.BookVo"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
<%@ include file="./include/header.jsp" %>
</head>
<body>
<%@ include file="./include/menu.jsp" %>
<hr>
<h1>책 목록 - BookVo V</h1><hr>
<p>  
<form>  
<input type="text" placeholder="검색" name="keyword" value="${keyword}" />  
<input type="submit" value="검색" />  
</form>  
</p>  
<table border="1">
<tr><th>Title</th><th>Category</th><th>Price</th></tr>
<c:forEach var="b" items="${data}">
<tr><td><a href="detailVo?book_id=${b.book_id}">${b.title}</a></td>
<td>${b.category}</td>
<td>${b.price }</td></tr>
</c:forEach>
</table>
<hr>
</body>
</html>
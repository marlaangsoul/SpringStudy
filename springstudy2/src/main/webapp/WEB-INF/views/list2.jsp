<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<Map<String, Object>> data = (List<Map<String, Object>>)request.getAttribute("data");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<h1>책 목록</h1>
<table border="1">
<tr><th>Title</th><th>Category</th><th>Price</th></tr>
<%for(Map<String, Object> b:data){ %>
<tr><td><a href="detail?bookId=<%=b.get("book_id")%>"><%=b.get("title") %></a></td>
<td><%=b.get("category") %></td>
<td><%=b.get("price") %></td></tr>
<%} %>
</table>

</body>
</html>
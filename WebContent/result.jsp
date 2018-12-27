<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询结果</title>
</head>
<body>
	<% ArrayList<String> list=new ArrayList();
		list=(ArrayList)session.getAttribute("list");
		int column=Integer.parseInt(list.get(list.size()-1));
		int row=(list.size()-1)/column;
		
	%>
	
	<table align=center border=1 >
	<%for(int i=0;i<row;i++)
		{%>
	<tr>
	<%for (int j=0;j<column;j++){ %>
		<td><%=list.get(i*column+j) %> </td>
		<%} %>
	</tr>
	<%} %>
	</table>
</body>
</html>
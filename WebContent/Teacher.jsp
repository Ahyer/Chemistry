<%@page import="Servlet.Lianjie"%>
<%@page import="Servlet.StuMessage"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>教师界面</title>
</head>
<body>
		你好
	<%String s=(String) session.getAttribute("Value");
	String xue=(String) session.getAttribute("Xuehao");
	%>
	<%=s %>老师
	</p>
	<%
	
	ArrayList<StuMessage> stu=new ArrayList();
	Lianjie test=new Lianjie();
		stu=test.queryStu(xue);
		if(stu.size()>0)
		{
	%>
 <form id="login_id" name="login" method="post" action="TeaService">
      申请人<input type="text" readonly= "true" name="name"  value = <%=stu.get(0).getxuehao() %> > </p>
      <input type="hidden" name="zhigonghao" value=<%=xue %> >
      申请数量<input type="text" readonly= "true" name="shuliang"  value =<%=stu.get(0).getnum() %> > </p>
  	  药品编号<input type="text" readonly= "true" name="yaopinbianhao"  value =<%=stu.get(0).getyaopinbianhao() %> > </p>
  	  申请编号<input type="text" readonly= "true" name="bianhao"  value =<%=stu.get(0).getbianhao() %> > </p>
      <input type="radio" name= "choice" value="agree" checked="checked" > 同意
       <input type="radio" name= "choice" value="disagree" > 驳回
      <button type="submit" >提交</button>
    </form>
	<% }%>
	
	</p>
	<form id="search name="chaxun" method ="post" action="SuperQuery">
	<textarea name="sql" type="text" style= "width=:200px;height:200px;"></textarea>
	<button type="submit">查询</input>
	</form>
</html >
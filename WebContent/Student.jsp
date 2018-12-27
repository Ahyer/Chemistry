<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	你好
	<%String s=(String) session.getAttribute("Value");
	String xue=(String) session.getAttribute("Xuehao");
	%>
	<%=s %>
<%String b=(String)request.getAttribute("success"); 
try{if(b.equals("success"))
{  %>
<script>
window.alert("成功");
</script>
<%
}else
{
	%>
	<script>
	window.alert("请检查数据的正确性");
	</script>
	<%
}
}
catch(Exception e){}
finally{}
%>
	     <form id="tijiao" name="login" method="post" action="StuService">	   
	      	<input type="hidden" name="xuehao" value=<%=xue %> >
     		<input type="text" name="ID"  placeholder="药品标号"> </p>
     		<input type="text" name="nunmber"  placeholder="申请数量"> </p>
     		<button type="submit" >提交</button>
    </form>
    
    <form id="hello" name="search" method="post" action="SuperQuery">
    <input type="hidden" name="sql" value ="select * from apply where xuehao =<%=xue %>" >
    <button type="submit">查询我的状态</button>
    </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>登录界面</title>
</head>
<body>
     <form id="login_id" name="login" method="post" action="LoginModule">
      <input type="text" name="name"  placeholder="用户名"> </p>
      <input type="password" name="password"  placeholder="用户密码"> </p>
      <!-- student是学生的 value ，teacher是老师的 -->
      <input type="radio" name= "stutea" value="student" checked="checked" > 学生
       <input type="radio" name= "stutea" value="teacher" > 老师
      <button type="submit" >登录</button>
    </form>
</body>
</html>
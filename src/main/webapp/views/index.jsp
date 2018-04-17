<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>登录成功</title>  
</head>  
<body>  
  
  
欢迎你,<shiro:principal/>!<br>  
  
  
<shiro:hasRole name="admin">  
<span style="white-space:pre;"> </span>具备admin角色才能看到这句话<br>  
</shiro:hasRole>  
  
  
<shiro:hasRole name="teacher">  
<span style="white-space:pre;"> </span>具备teacher角色才能看到这句话<br>  
</shiro:hasRole>  
  

 
  
<shiro:hasPermission name="permissions1">  
<span style="white-space:pre;"> </span>具备permissions1权限才能看到这句话<br>  
</shiro:hasPermission>  
<br>  
  
  
<shiro:hasPermission name="permissions2">  
<span style="white-space:pre;"> </span>具备permissions2权限才能看到这句话<br>  
</shiro:hasPermission>  
  
<a href="logout.do">安全退出</a>  
</body>  
</html>
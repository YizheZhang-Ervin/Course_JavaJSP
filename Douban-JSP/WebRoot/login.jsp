<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/login.css"/>
	

  </head>
  
  <body>
  
   <table width="100%" height="225px" border="1" background="image/login.png"
   style="background-size:100% 100%;background-repeat:x-repeat;" >
  <tr>
    <td><img src="image/login_left.png"></td>
    <td align="center"><span class="bbb">豆瓣6.0</span><br>&nbsp;<br>&nbsp;<br><input type="button" class="button" value="下载豆瓣APP" /></td>
    <td>
    <form action="Login1" method="post">
     <table width="100%" height="200" border="1">
     <tr>
      <td colspan="2" align="left"><input type="text" size="30" name="username" value="邮箱、手机号" onclick="this.value=''"/></td>
     </tr>
     <tr>
      <td colspan="2" align="left"><input type="text" size="30" name="password" value="密码"/></td>
     </tr>
     <tr>
      <td align="center"><input type="submit" class="Login" value="用户登录"/></td>
     <td align="center"><input type="submit" class="register" value="注册账号"/></td>
     </tr>
    <tr>
     <td align="center"><input type="checkbox" name="记住我"/><label class="lll">记住我</label></td>
     <td align="center">&nbsp;</td>
    </tr>
    </table>
 
    </td>
  </tr>
</table>
</form>
  </body>
</html>

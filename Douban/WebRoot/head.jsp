<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="CSS/head.css"/>
	
  </head>
  
  <body>
    <table width="100%" height="115px" border="0">
  <tr>
    <td><img src="image/logo.png"/></td>
    <td align="center"><input type="text" value="Articles,Books,Films,Groups,..." size="30" /><input type="button" style="background:url(image/search.png);width:30;height:22;border:none;"/></td>
    <td><span class="abc1">读书</span></td>
    <td><span class="abc2">电影</span></td>
    <td><span class="abc3">音乐</span></td>
    <td><span class="abc4">小组</span></td>
    <td><span class="abc5">同城 </span></td>
    <td><span class="abc6">FM</span></td>
    <td><span class="abc7">时间 </span></td>
    <td><span class="abc8">豆品 </span></td>
  </tr>
</table>
  </body>
</html>

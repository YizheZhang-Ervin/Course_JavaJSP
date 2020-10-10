<%@ page language="java" import="java.util.*,com.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'welcome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    Successfully jump to welcome.jsp. 

    <br>
    <table width="80%" border="1">
  <tr>
    <td>用户ID</td>
    <td>用户名</td>
    <td>密码</td>
    <td>Email</td>
    <td>修改</td>
    <td>删除</td>
  </tr>
  <% ArrayList al=(ArrayList)request.getAttribute("users");
     String s_pageCount=(String)request.getAttribute("pageCount");
     int pageCount=Integer.parseInt(s_pageCount);
     for(int i=0;i<al.size();i++){
        UserBean ub=(UserBean)al.get(i);
  %>
  <tr>
    <td><%=ub.getUserid() %></td>
    <td><%=ub.getUsername() %></td>
    <td><%=ub.getPasswd() %></td>
    <td><%=ub.getEmail() %></td>
    <td><a href="Fenye_w?gongneng=update&id=<%=ub.getUserid() %>"/> </>修改</td>
    <td><a href="Fenye_w?gongneng=delete&id=<%=ub.getUserid() %>"/> </>删除</td>
  </tr>
  <% } %>
  <tr>
    <td colspan="6"><%for(int j=1;j<=pageCount;j++){ %>【<a href="Fenye_w?gongneng=turn&pageNow=<%=j %>"><%=j %></a>】<% }%></td>   
  </tr>
  <tr>
    <td colspan="6"><a href="Fenye_w?gongneng=add"/> </>ADD USERS</td>
  </tr>
</table>

  </body>
</html>

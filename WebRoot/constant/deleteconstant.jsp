<%@page import="com.artistic_exam.Constant.ConstantDateDAO"%>
<%@page import="com.artistic_exam.Constant.ConstantDate"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除常量</title>
    
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
  	<a href="constant/constant.jsp">返回</a>
  	<hr>
    <form action="deleteConstant.action" method="post">
		请选择要修改的数据： <select name="constant_name">
			<%
				ConstantDateDAO dao = new ConstantDateDAO();
				@SuppressWarnings("unchecked")
				List<ConstantDate> constants = dao.findAll();

				for (ConstantDate constat : constants) {
					out.println("<option value=\"" + constat.getConstantName()+"\">");
					out.println(constat.getConstantName());
					out.println("</option>");
				}
			%>
			<option value="all">清除全部</option>
		</select>
		<br> 
		<input type="submit" value="删除">
	</form>
  </body>
</html>

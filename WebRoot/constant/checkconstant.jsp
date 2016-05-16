<%@page import="com.artistic_exam.Constant.ConstantDateDAO"%>
<%@page import="com.artistic_exam.Constant.ConstantDate"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查看所有常量</title>

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
	<%
		ConstantDateDAO dao = new ConstantDateDAO();
		List<ConstantDate> constants = dao.findAll();
	%>
	<table border="6" style="width: 610px; " align="center">
		<tr>
			<th align=center>常量名</th>
			<th align=center>常量值</th>
			<th align=center>常量描述</th>
		</tr>

		<%
			if (!constants.isEmpty()) {
				for (ConstantDate constant : constants) {
					out.println("<tr align=center>");
					out.println("<td>" + constant.getConstantName() + "</td>");
					out.println("<td>" + constant.getConstantValue() + "</td>");
					out.println("<td>" + constant.getConstantDes() + "</td>");
					out.println("</tr>");
				}
			} else {
				out.println("<tr> <td colspan=3 align=center>未检索到任何数据</td> </tr>");
			}
		%>
	</table>
</body>
</html>

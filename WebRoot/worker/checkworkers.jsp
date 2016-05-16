<%@page import="com.artistic_exam.Workers.Workers"%>
<%@page import="com.artistic_exam.Workers.WorkersDAO"%>
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

<title>查看工作人员信息</title>

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
	<a href="worker/indexofworker.jsp">返回</a>
  	<hr>

	<%
		WorkersDAO dao = new WorkersDAO();
		@SuppressWarnings("unchecked")
		List<Workers> workers = dao.findAll();
	%>
	
	<table border="6" style="width: 610px; " align="center">
		<tr>
			<th align=center>姓名</th>
			<th align=center>职位</th>
			<th align=center>责任考场号</th>
		</tr>

		<%
			if (!workers.isEmpty()) {
				for (Workers worker : workers) {
					out.println("<tr align=center>");
					out.println("<td>" + worker.getName()+ "</td>");
					out.println("<td>" + worker.getIdenType() + "</td>");
					out.println("<td>" + worker.getQusType() + "</td>");
					out.println("</tr>");
				}
			} else {
				out.println("<tr> <td colspan=3 align=center>未检索到任何数据</td> </tr>");
			}
		%>
	</table>
</body>
</html>

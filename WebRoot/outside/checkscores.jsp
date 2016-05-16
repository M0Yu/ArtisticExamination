<%@page import="com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutside"%>
<%@page import="com.artistic_exam.ScoreSumma_Inside.ScoreSummaInsideDAO"%>
<%@page
	import="com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutsideDAO"%>
<%@page import="com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>省外学生分数查询</title>

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
	<script language="javascript">
		//提示窗口
		function printit(MyDiv) {
			if (confirm('确定打印吗？')) {
				var tit = document.title;
				var newstr = document.getElementById(MyDiv).innerHTML;
				var oldstr = document.body.innerHTML;
				document.body.innerHTML = newstr;
				document.title = "";

				window.print();
				document.body.innerHTML = oldstr;
				document.title = tit;

				return false;
			}
		}
	</script>
	
	<a href="outside/indexofoutside.jsp">返回</a>
  	<hr>
  	
	<form action="<%=basePath%>GetSumScore_Outside">
		<input type="submit" value="统计考生分数"> 
		<input type="button"
			value="打印成绩" onclick="javascript:printit('socres');">
	</form>
	<br>
	<hr>
	<%
		String currentPage = request.getParameter("Page");
		ScoreSummaOutsideDAO dao = new ScoreSummaOutsideDAO();
		List<ScoreSummaOutside> scores = dao.findAll();

		int MaxPageNum = scores.size() / 50 + 1;
	%>
	<div id="socres">
		<table border="3" style="width: 610px; " align="center">
			<tr>
				<th align=center>顺序号</th>
				<th align=center>总分</th>
				<th align=center>身高</th>
			</tr>

			<%
				if (!scores.isEmpty()) {
					for (ScoreSummaOutside ss : scores) {
						out.println("<tr align=center>");
						out.println("<td>" + ss.getRegNum() + "</td>");
						out.println("<td>" + ss.getSumScore() + "</td>");
						out.println("<td>" + ss.getHeight() + "</td>");
						out.println("</tr>");
					}
				} else {
					out.println("<tr> <td colspan=3 align=center>未检索到任何数据</td> </tr>");
				}
			%>
		</table>
	</div>
	<hr>
	<form>
		<select name="Page">
			<%
				for (int i = 1; i <= MaxPageNum; i++) {
					out.println("<option value = " + i +">");
					out.println(i + "</option>");
				}
			%>
		</select>
	</form>
</body>
</html>

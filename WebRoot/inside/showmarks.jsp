<%@page
	import="com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInside"%>
<%@page
	import="com.artistic_exam.ExaminationInfor_Inside.ExaminationInforInsideDAO"%>
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

<title>考官评分详情</title>

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
	
	<a href="inside/checkmarks.jsp">返回</a>
  	<hr>
	<input type="button"
			value="打印成绩" onclick="javascript:printit('marks');">
	<hr>
	<div id="marks">
		<%
			String WorkerName = request.getParameter("WorkerName");

			ExaminationInforInsideDAO dao = new ExaminationInforInsideDAO();
			List<ExaminationInforInside> scores = dao.findAll();
		%>
		<table border="4" style="width: 610px; " align="center">
			<tr>
				<td colspan="4" align="center">考官：<%=WorkerName%></td>
			</tr>
			<tr>
				<th align=center>顺序号</th>
				<th align=center>科目</th>
				<th align=center>题号</th>
				<th align=center>评分</th>
			</tr>
			<%
				boolean isShow = false;
				for (ExaminationInforInside ss : scores) {
					int score = 0;
					if (WorkerName.equals(ss.getExaminerName1()))
						score = ss.getExaminerScore1();
					else if (WorkerName.equals(ss.getExaminerName2()))
						score = ss.getExaminerScore2();
					else if (WorkerName.equals(ss.getExaminerName3()))
						score = ss.getExaminerScore3();
					else if (WorkerName.equals(ss.getExaminerName4()))
						score = ss.getExaminerScore4();
					else if (WorkerName.equals(ss.getExaminerName5()))
						score = ss.getExaminerScore5();
					else
						continue;

					out.println("<tr align=center>");
					out.println("<td>" + ss.getId().getSeqNum() + "</td>");
					out.println("<td>" + ss.getId().getQusType() + "</td>");
					out.println("<td>" + ss.getQusNum() + "</td>");
					out.println("<td>" + score + "</td>");
					out.println("</tr>");
					isShow = true;
				}

				if (!isShow)
					out.println("<tr> <td colspan=4 align=center>未检索到任何数据</td> </tr>");
			%>
		
	</div>
</body>
</html>

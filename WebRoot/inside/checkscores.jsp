<%@page import="com.artistic_exam.ScoreSumma_Inside.ScoreSummaInsideDAO"%>
<%@page import="com.artistic_exam.ScoreSumma_Outside.ScoreSummaOutsideDAO"%>
<%@page import="com.artistic_exam.ScoreSumma_Inside.ScoreSummaInside"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>省内学生分数查询</title>
    
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
  	<a href="inside/indexofinside.jsp">返回</a>
  	<hr>
  	<form action="<%=basePath%>GetSumScore_Inside">
  		<input type="submit" value="统计考生分数">
  	</form>
  	<br><hr>
  
  		<%
  			ScoreSummaInsideDAO dao = new ScoreSummaInsideDAO(); 
  			List<ScoreSummaInside> scores = dao.findAll();
  		 %>
  		 
  		 <table border="6" style="width: 610px; " align="center">
  		 	<tr>
  		 		<th align=center>顺序号</th>
  		 		<th align=center>科目一分数</th>
  		 		<th align=center>科目二分数</th>
  		 		<th align=center>科目三分数</th>
  		 		<th align=center>总分</th>
  		 		<th align=center>身高</th>
  		 	</tr>
  		 	
  		 	<%
  		 		if(!scores.isEmpty()){
  		 		//	ScoreSummaInside ss = null;
  		 			for(ScoreSummaInside ss : scores){
  		 				out.println("<tr align=center>");
  		 				out.println("<td>" + ss.getSeqNum() + "</td>");
  		 				out.println("<td>" + ss.getQusType1score() + "</td>");
  		 				out.println("<td>" + ss.getQusType2score() + "</td>");
  		 				out.println("<td>" + ss.getQusType3score() + "</td>");
  		 				out.println("<td>" + ss.getSumScore() + "</td>");
  		 				out.println("<td>" + ss.getHeight() + "</td>");				
  		 				out.println("</tr>");
  		 			}
  		 		} else {
  		 			out.println("<tr> <td colspan=6 align=center>未检索到任何数据</td> </tr>");
  		 		}
  		 	 %>
  		 </table>
  		 <hr>
  </body>
</html>

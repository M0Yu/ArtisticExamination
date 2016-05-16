<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta http-equiv=refresh content="3;url=<%=request.getParameter("url")%>">
  </head>  
  <body>
  		<b style=color:red>
  			执行成功，<span id=jump>3</span>秒后将自动返回前一页面...
  		</b>
  </body>
  <script type="text/javascript">
  		function countDown(secs){
  			jump.innerText = secs;
  			if(--secs > 0)
  				setTimeout("countDown(" + secs + ")",1000);
  		}
  		countDown(3);
  </script>
  
</html>

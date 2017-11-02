<%@page import="cn.jy.entity.Struckinfo"%>
<%@ page import="java.util.ArrayList,javax.servlet.*,javax.servlet.http.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<title>员工信息的详情</title>
</head>
<style type="text/css">
.font_word_title{
	font-family: 微软雅黑;
	font-size: 32px;
	font-weight: normal;
}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Struckinfo> list	=	(ArrayList<Struckinfo>) session.getAttribute("listStruck");
	
	//	每行信息;
	Struckinfo			  info	=	list.get(0);
	
%>
<%
// 	String message=(String)session.getAttribute("message");
// 	if(!message.equals("")){
%>
<!-- <script type="text/javascript"> -->
<%-- 		alert("<%=message%>"); --%>
<!-- </script> -->
<% 
//  	}
// 	else {
// 		session.setAttribute("message",null);
// 	}
%>

<form action="../../JYTest02/struck_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">用户详细信息</h4>
			  <div class="fields">
					    <div class="field">
					      <label>挂车编号</label>
					      <input type="text" placeholder="卡车编号"  name="sid" value="<%=info.getSid() %>">
					    </div>
					    <div class="field">
					      <label>挂车备注</label>
					      <input type="text" placeholder="卡车油量"  name="snote" value="<%=info.getSnote() %>">
					    </div> 
			    </div>
				<div class="fields">
						<div class="field">
					      <label>主车编号</label>
					      <input type="text" placeholder="员工编号"  name="tid" value="<%=info.getTid() %>">
					    </div>
					    <div class="field">
					      <label>业务编号</label>
					      <input type="text" placeholder="业务编号"  name="bid" value="<%=info.getBid() %>">
					    </div>
				</div>
			<div class="fields" >
				    <div class="field"  style="margin-top:30px" >
						<input type="submit" value="提交" class="small ui button" style="width:100px;margin-right:50px;" >
						<input type="reset" value="重置" class="small ui button" style="width:100px;margin-right:50px;" >
					    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  	</div>
		</div>
</form>
	</body>
</html>
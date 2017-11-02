<%@page import="cn.jy.entity.Truckinfo"%>
<%@ page import="java.util.ArrayList"%>
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
<title>卡车信息的详情</title>
</head>
<style type="text/css">
.font_word_title{
	font-family: 微软雅黑;
	font-size: 18px;
	font-weight: normal;
}
label{
	font-family: 微软雅黑;
	font-size: 13px;
	font-weight: normal;
}

</style>

<body>
<% 
	//	单个成员;
	ArrayList<Truckinfo> list	=	(ArrayList<Truckinfo>) session.getAttribute("listTruck");
	
	//	每行信息;
	Truckinfo	 info	=	list.get(0);
	
%>

	<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  <h4 class="ui dividing header">用户详细信息</h4>
	  	<div class="fields">
			    <div class="field">
			      <label>卡车编号</label>
			      <input type="text" disabled="disabled" value="<%=info.getTid() %>">
			    </div>
			    <div class="field">
			      <label>卡车油量</label>
			      <input type="text"  disabled="disabled" value="<%=info.getToil01() %>">
			    </div> 
	    </div>
		<div class="fields">
				<div class="field">
			      <label>员工编号</label>
			      <input type="text" disabled="disabled" value="<%=info.getWid() %>">
			    </div>
			    <div class="field">
			      <label>业务编号</label>
			      <input type="text" disabled="disabled" value="<%=info.getBid() %>">
			    </div>
		</div>
		<div class="fields" >
			    <div class="field" style="margin-top:30px" >
				    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
				</div>
	  	</div>
	</div>


<!-- <font class="font_word_title">用户信息的详情</font> -->
<!-- 	<hr> -->
<!-- 	<table> -->
<!-- 		<tr> -->
<!-- 			<td>用户编号:</td> -->
<%-- 			<td><input type="text" disabled="disabled" value="<%=info.getWid() %>"></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>用户名称:</td> -->
<%-- 			<td><input type="text" disabled="disabled" value="<%=info.getWname() %>"></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>员工昵称:</td> -->
<%-- 			<td><input type="text" disabled="disabled" value="<%=info.getWcall() %>"></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td>员工密码:</td> -->
<%-- 			<td><input type="text" disabled="disabled" value="<%=info.getWpwd() %>"></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td colspan="2">员工备注:</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<%-- 			<td colspan="2"><textarea name="wnote" rows="10" cols="50" disabled="disabled" style="resize:none;"><%=info.getWnote() %></textarea></td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td colspan="2"> -->
<!-- 			<input type="button" value="返回" onclick="javascript:history.go(-1)"> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
	</body>
</html>
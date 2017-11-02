<%@page import="cn.jy.entity.Editinfo"%>
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
<link rel="stylesheet" type="text/css" href="../css/imageShow.css" />

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<title>提货信息的详情</title>
</head>
<style type="text/css">
	.font_word_title{
		font-family: 微软雅黑;
		font-size: 18px;
		font-weight: normal;
	}
	input{
		width:120px;
		height:30px;
	}
	select{
		width:100px;
		height:30px;
	}
	.btn{
		width:60px;
	}
	label{
		font-family: 微软雅黑;
		font-size: 13px;
		font-weight: normal;
	}
	.part{
		border: 1px solid #ddd;
		padding:20px 0 15px 50px;
		margin:30px 0 20px 0;
	}
 	span{
 		position:absolute;
 		left:2%;
 		margin:5px 0 0 0;
 		padding:0 8px 0 8px;
 		text-align:center;
 		background:white;
 	}
 	#e_info input{
		width:140px;
		height:28px;
		margin:0 30px 0 10px;
	}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Editinfo> list	=	(ArrayList<Editinfo>) session.getAttribute("listLogs");
	//	每行信息;
	Editinfo	 info	=	list.get(0);
%>

	<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  	<h4 class="ui dividing header">日志信息详情</h4>
			<table id="e_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:0px 15px; ">
			<tr>
			   <td><label>ID</label></td>
			   <td><input type="text" placeholder="用户编号"  disabled="disabled" value="<%=info.getEid() %>"></td>
			   <td><label>用户ID</label></td>
			   <td><input type="text" placeholder="用户名称" disabled="disabled" value="<%=info.getWid() %>"></td>
			   <td><label>用户名称</label></td>
			   <td><input type="text" placeholder="员工昵称" disabled="disabled" value="<%=info.getWname() %>"></td>
			</tr>
			<tr>
			   <td><label>业务ID</label></td>
			   <td><input type="text" placeholder="员工密码" disabled="disabled" value="<%=info.getBid() %>"></td>
			   <td><label>货物ID</label></td>
			   <td><input type="text"  disabled="disabled" value="<%=info.getGid() %>"></td>
			   <td><label>操作类型</label></td>
			   <td><input type="text"  disabled="disabled" value="<%=info.getOperkind() %>"></td>
			</tr>
			<tr>
			   <td><label>修改类型</label></td>
			   <td colspan="2"><input type="text"  disabled="disabled" value="<%=info.getEditkind() %>" style="width:300px;"></td>
			   <td align="right"><label>操作时间</label></td>
			   <td colspan="2"><input type="text"  disabled="disabled" value="<%=info.getEdittime() %>" style="width:300px;"></td>
		    </tr>
		</table>
		<div class="fields" >
			    <div class="field" style="margin-top:30px" >
				    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="go_back();">
				</div>
	  	</div>
	</div>
	</body>
	<script type="text/javascript">
		function go_back(){
			location.href="../user_info?operid=2";
		}
	</script>
</html>
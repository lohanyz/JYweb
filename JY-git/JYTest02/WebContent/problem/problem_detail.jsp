<%@page import="cn.jy.entity.Probleminfo"%>
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
<title>油控信息的详情</title>
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
.left{
	width:200px;
	height:auto;
	float:left;
	margin-right:50px;
	padding-top:20px;
}
.right{
	width:700px;
	height:auto;
	float:left;
}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Probleminfo> list	=	(ArrayList<Probleminfo>) session.getAttribute("listProblem");
	
	//	每行信息;
	Probleminfo	 info	=	list.get(0);
%>

	<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  <h4 class="ui dividing header">追踪信息信息</h4>
		  <div class="left">
		  		<div class="field">
			      <img alt="" src="../<%=info.getPimg()%>" width="200px" height="120px">
			    </div>
			    <div class="field" align="center">
			      <label>编号：<%=info.getPid() %></label>
			    </div>
		  </div>
		  <div class="right">
				  <div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text" disabled="disabled" value="<%=info.getBid() %>">
						    </div>
							<div class="field">
						      <label>员工编号</label>
						      <input type="text" disabled="disabled" value="<%=info.getWid() %>">
						    </div>
						    <div class="field">
						      <label>员工名称</label>
						      <input type="text" disabled="disabled" value="<%=info.getWname() %>">
						    </div>
					</div>
			  		<div class="fields">
						    <div class="field">
						      <label>操作类型</label>
						      	<%
									String type=info.getPoper();
									if(type.equals("port")){
								%>
								<input type="text"  disabled="disabled" value="港口操作">
								<%
									}
									if(type.equals("sign")){
								%>
								<input type="text"  disabled="disabled" value="签收操作">
								<%
									}
								%>
						    </div>
							<div class="field">
						      <label>提交城市</label>
						      <input type="text" disabled="disabled" value="<%=info.getPcity() %>">
						    </div>
						    <div class="field">
						      <label>提交时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getPtime() %>" style="width:200px;">
						    </div>
					</div>
					
						<div class="fields">
						    <div class="field">
						      <label>事件状态</label>
						     	 <%
									String state=info.getPstate();
									if(state.equals("exception")){
								%>
									<input type="text"  disabled="disabled" value="异常" style="width:100px;">
								<%
									}
									if(state.equals("normal")){
								%>	
									<input type="text"  disabled="disabled" value="正常" style="width:100px;">
								<%
									}
								%>
						    </div>
							<div class="field">
						      <label>异常信息</label>
						      <textarea  name="wnote" disabled="disabled" style="width:400px;"><%=info.getPexception() %></textarea>
							</div>
						    </div>
						</div>
					
					
					<div class="fields" style="float:right">
					    <div class="field" style="margin-top:30px ;float:right;margin-right:100px;" >
						    <input type="button" value="返回" class="small ui button" style="width:100px; " onclick="javascript:history.go(-1)">
						</div>
			  		</div>
		</div>

	</body>
</html>
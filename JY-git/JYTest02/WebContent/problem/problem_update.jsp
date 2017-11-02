<%@page import="cn.jy.entity.Probleminfo"%>
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
.left{
	width:200px;
	height:auto;
	float:left;
	margin-right:40px;
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
 

<form action="../../JYTest02/problem_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  <h4 class="ui dividing header">追踪信息修改</h4>
		  <div class="left">
		  		<div class="field">
			      <img alt="" src="../<%=info.getPimg()%>" width="200px" height="120px">
			    </div>
			    <div class="field" align="center">
			      <label>编号：<%=info.getPid() %></label>
			      <input type="hidden" name="pid" value="<%=info.getPid() %>">
			    </div>
		  </div>
		  <div class="right">
				  <div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text" name="bid" value="<%=info.getBid() %>">
						    </div>
							<div class="field">
						      <label>员工编号</label>
						      <input type="text" name="wid" value="<%=info.getWid() %>">
						    </div>
						    <div class="field">
						      <label>员工名称</label>
						      <input type="text"  name="wname" value="<%=info.getWname() %>">
						    </div>
					</div>
			  		<div class="fields">
						    <div class="field">
						      <label>操作类型</label>
						      <select class="ui dropdown" style="width:180px" name="poper" id="poper">
								<option value="port" <%if(info.getPoper().equals("port")){%> selected="selected"<%}%>>港口操作</option>
								<option value="sign" <%if(info.getPoper().equals("sign")){%> selected="selected"<%}%>>签收操作</option>
						  	  </select>    
						    </div>
							<div class="field">
						      <label>提交城市</label>
						      <input type="text" name="pcity" value="<%=info.getPcity() %>">
						    </div>
						    <div class="field">
						      <label>提交时间</label>
						      <input type="text"  name="ptime" value="<%=info.getPtime() %>" style="width:200px;">
						    </div>
					</div>
					
						<div class="fields">
						    <div class="field">
						      <label>事件状态</label>
						  	<%
								String state=info.getPstate();
								if(state.equals("exception")){
							%>
								<input type="text" name="state" id="state" value="异常" style="width:100px;">
								<input type="hidden" name="pstate" value="exception" id="pstate">
								<input type="button" class="small ui button" id="toN" value="恢复正常" onclick="toNormal()">
						      	<script type="text/javascript">
						      		function toNormal(){
						      			var state=document.getElementById("state");
						      			var bstate=document.getElementById("pstate");
						      			state.value="正常";
						      			bstate.value="normal";
						      			var toN=document.getElementById("toN");
						      			toN.value="取消";
						      			toN.onclick=function() { cancel() }; 
						      		}
						      		function cancel(){
						      			var state=document.getElementById("state");
						      			var bstate=document.getElementById("pstate");
						      			state.value="异常";
						      			bstate.value="exception";
						      			var toN=document.getElementById("toN");
						      			toN.value="恢复正常";
						      			toN.onclick=function() { toNormal() }; 
						      		}
						      	</script>
						    <%
								}
								if(state.equals("normal")){
							%>
									<input type="text" name="state" value="正常" style="width:100px;">
									<input type="hidden" name="pstate" value="normal" id="pstate">
							<%
								}
							%>
						    </div>
							<div class="field">
						      <label>异常信息</label>
						      <textarea name="pexception" style="width:400px;"> <%=info.getPexception() %>  </textarea>
							</div>
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
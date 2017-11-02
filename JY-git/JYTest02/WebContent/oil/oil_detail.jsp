<%@page import="cn.jy.entity.Oilinfo"%>
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
	ArrayList<Oilinfo> list	=	(ArrayList<Oilinfo>) session.getAttribute("listOil");
	
	//	每行信息;
	Oilinfo	 info	=	list.get(0);
%>

	<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  <h4 class="ui dividing header">油控详细信息</h4>
		  <div class="left">
		  		<div class="field">
			      <img alt="" src="D:/java_dev/MyWorkSpace/JYTest02/WebContent/oil/images/1.jpg" width="200px" height="120px">
			    </div>
			    <div class="field" align="center">
			      <label>编号：<%=info.getId() %></label>
			    </div>
		  </div>
		  <div class="right">
			  <div class="fields">
			    	<div class="field">
				      <label>加油类型</label>
				      	<%
							String type=info.getOkind();
							if(type.equals("gas")){
						%>
						<input type="text"  disabled="disabled" value="汽油          <%=info.getOid() %>  #">
						<%
							}
							if(type.equals("diesel")){
						%>
						<input type="text"  disabled="disabled" value="柴油          <%=info.getOid() %>  #">
						<%
							}
						%>
				    </div> 
					<div class="field">
				      <label>油量</label>
				      <input type="text" disabled="disabled" value="<%=info.getOliter() %>">
				    </div>
				    <div class="field">
				      <label>金额</label>
				      <input type="text" disabled="disabled" value="<%=info.getOmoney() %>">
			    	</div>
				</div>
				<div class="fields">
						<div class="field">
				      <label>付款方式</label>
				       <%
							String way=info.getOpayway();
							if(way.equals("cash")){
						%>
						<input type="text"  disabled="disabled" value="现金">
						<%
							}
							if(way.equals("card")){
						%>
						<input type="text"  disabled="disabled" value="刷卡">
						<%
							}
						%>
					    </div>
					    <div class="field">
					      <label>加油城市</label>
					      <input type="text" disabled="disabled" value="<%=info.getOcity() %>">
					    </div>
					    <div class="field">
					      <label>加油时间</label>
					      <input type="text" disabled="disabled" value="<%=info.getOtime() %>">
					    </div>
				</div>
				<div class="fields">
					    <div class="field">
					      <label>油卡编号</label>
					      <input type="text" disabled="disabled" value="<%=info.getOcardid() %>">
					    </div>
						<div class="field">
					      <label>油卡余额</label>
					      <input type="text" disabled="disabled" value="<%=info.getOlmoney() %>">
					    </div>
					    <div class="field">
					      <label>行驶里程</label>
					      <input type="text" disabled="disabled" value="<%=info.getOmile() %>">
					    </div>
				</div>
				<div class="fields">
					    <div class="field">
					      <label>主车编号</label>
					      <input type="text" disabled="disabled" value="<%=info.getTid() %>">
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
				<div class="fields" style="float:right">
					    <div class="field" style="margin-top:30px ;float:right" >
						    <input type="button" value="返回" class="small ui button" style="width:100px; " onclick="javascript:history.go(-1)">
						</div>
			  	</div>
		  </div>
		  
		  
	  		
	</div>

	</body>
</html>
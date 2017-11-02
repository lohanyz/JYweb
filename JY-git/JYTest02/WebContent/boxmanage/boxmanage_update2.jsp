<%@page import="cn.jy.entity.Boxmanageinfo"%>
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
<title>提货信息的详情</title>
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
	ArrayList<Boxmanageinfo> list	=	(ArrayList<Boxmanageinfo>) session.getAttribute("listBoxmanage");
	String imgs[] =(String[])session.getAttribute("imgs");
	String path="../boxmanage/images/";
	//	每行信息;
	Boxmanageinfo	 info	=	list.get(0);
%>
 

<form action="../../JYTest02/boxmanage_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">提货信息修改</h4>
			<div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text"  placeholder="业务编号" name="bid" value="<%=info.getBid() %>">
						    </div>
							<div class="field">
						      <label>ID</label>
						      <input type="text" placeholder="箱管理ID" name="bmid" value="<%=info.getBmid() %>">
						    </div>
						    <div class="field">
						      <label>状态</label>
						      <input type="text" placeholder="状态信息" name="state" value="<%=info.getState() %>">
						    </div>
					</div>
					
			  		<div class="fields">
							<div class="field">
						      <label>提箱地</label>
						      <input type="text"  placeholder="提箱地" name="getboxspace" value="<%=info.getGetboxspace() %>">
						    </div>
						    <div class="field">
						      <label>提箱时间</label>
						      <input type="text" placeholder="提箱时间" name="getboxtime"  value="<%=info.getGetboxtime() %>" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>返回中方口岸时间</label>
							  <input type="text"  placeholder="返回中方口岸时间" name="backchnportime" value="<%=info.getBackchnportime() %>">
						    </div>
						     <div class="field">
						      <label>返回口岸库房时间</label>
						      <input type="text" placeholder="返回口岸库房时间" name="backportstorehoustime"  value="<%=info.getBackportstorehoustime() %>" > 
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>口岸换装时间</label>
								<input type="text"  placeholder="口岸换装时间" name="portranstime" value="<%=info.getPortranstime() %>"> 
						    </div>
							<div class="field">
						      <label>换装车号</label>
						      <input type="text" placeholder="换装车号" name="transtid" value="<%=info.getTranstid() %>"> 
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>下线结费时间</label>
								<input type="text"  placeholder="下线结费时间" name="downlineovertime" value="<%=info.getDownlineovertime() %>">
						    </div>
							<div class="field">
						      <label>铁路下线时间</label>
						      <input type="text" placeholder="铁路下线时间" name="railwaydownlinetime" value="<%=info.getRailwaydownlinetime() %>">
						    </div>
						    <div class="field">
						      <label>实际回空时间</label>
						      <input type="text" placeholder="实际回空时间" name="fbacknulltime" value="<%=info.getFbacknulltime() %>">
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
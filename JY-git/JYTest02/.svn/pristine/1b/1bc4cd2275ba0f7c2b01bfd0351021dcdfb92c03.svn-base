<%@page import="cn.jy.entity.Goodsinfo"%>
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
	ArrayList<Goodsinfo> list	=	(ArrayList<Goodsinfo>) session.getAttribute("listGoods");
	
	//	每行信息;
	Goodsinfo	 info	=	list.get(0);
	
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

<form action="../../JYTest02/goods_info" method="post">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">货物信息修改</h4>
		  <div class="fields">
	  			<div class="field">
			      <label>业务编号</label>
			      <input type="text" name="bid" disabled="disabled" value="<%=info.getBid() %>">
			      <input type="hidden" name="bid" value="<%=info.getBid() %>">
			    </div>
			    <div class="field">
			      <label>商品编号</label>
			      <input type="text" name="gid" disabled="disabled" value="<%=info.getGid() %>">
			      <input type="hidden" name="gid" value="<%=info.getGid() %>">
			    </div>
			    <div class="field">
			      <label>商品名称</label>
			      <input type="text"  name="gname" value="<%=info.getGname() %>">
			    </div> 
	    </div>
		<div class="fields">
				 <div class="field">
			      <label>箱号</label>
			      <input type="text" name="boxid" value="<%=info.getBoxid() %>">
			    </div>
			     <div class="field">
			      <label>箱型</label>
			      <input type="text" name="boxkind" value="<%=info.getBoxkind() %>">
			    </div>
			     <div class="field">
			      <label>尺寸</label>
			      <input type="text" name="boxsize" value="<%=info.getBoxsize() %>">
			    </div>
		</div>
		<div class="fields">
				 <div class="field">
			      <label>铅封号</label>
			      <input type="text" name="leadnumber" value="<%=info.getLeadnumber() %>">
			    </div>
			    <div class="field">
			      <label>件数</label>
			      <input type="text" name="gcount" value="<%=info.getGcount() %>">
			    </div>
			     <div class="field">
			      <label>单位</label>
			      <input type="text" name="gunit" value="<%=info.getGunit() %>">
			    </div>
			     <div class="field">
			      <label>总毛重</label>
			      <input type="text" name="gtotalweight" value="<%=info.getGtotalweight() %>">
			    </div>
		</div>
		<div class="inline fields">
				 <div class="field">
			      <label>长</label>
			      <input type="text" name="glength" id="length" value="<%=info.getGlength() %>" style="width:70px;" onchange="edit()">&nbsp;x
			    </div>
			    <div class="field">
			      <label>宽</label>
			      <input type="text" name="gwidth" id="width" value="<%=info.getGwidth() %>" style="width:70px;" onchange="edit()">&nbsp;x
			    </div>
			     <div class="field">
			      <label>高</label>
			      <input type="text" name="gheight" id="height" value="<%=info.getGheight() %>" style="width:70px;" onchange="edit()">&nbsp;=
			    </div>
			     <div class="field">
			      <label>体积</label>
			 	  <input type="text" id="volume1"  disabled="disabled" value="<%=info.getGvolume() %>" style="width:100px;">
			      <input type="hidden" name="gvolume" id="volume2">
			    </div>
		</div>
		<script type="text/javascript">
			function edit(){
				var length=document.getElementById("length").value;
				var width=document.getElementById("width").value;
				var height=document.getElementById("height").value;
				var volume=parseInt(length)*parseInt(width)*parseInt(height);
				document.getElementById("volume1").value=volume;
				document.getElementById("volume2").value=volume;
			}
		</script>
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
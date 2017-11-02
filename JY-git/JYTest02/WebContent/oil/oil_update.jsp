<%@page import="cn.jy.entity.Oilinfo"%>
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
ArrayList<Oilinfo> list	=	(ArrayList<Oilinfo>) session.getAttribute("listOil");

//	每行信息;
Oilinfo	 info	=	list.get(0);
	
%>
 

<form action="../../JYTest02/oil_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  <h4 class="ui dividing header">油控详细信息</h4>
		  <div class="left">
		  		<div class="field">
			      <img alt="" src="../<%=info.getOimg()%>" width="200px" height="120px" name="oimg">
			    </div>
			    <div class="field" align="center">
			      <label>编号：<%=info.getId() %></label>
			      <input type="hidden" name="id" value="<%=info.getId() %>">
			    </div>
		  </div>
		  <div class="right">
			  <div class="fields">
			    	<div class="field">
				      <label>加油类型</label>
				  	  <select class="ui dropdown" style="width:180px" name="okind" id="okind">
							<option value="gas" <%if(info.getOkind().equals("gas")){%> selected="selected"<%}%>>汽油</option>
							<option value="diesel" <%if(info.getOkind().equals("diesel")){%> selected="selected"<%}%>>柴油</option>
					  </select>
				    </div> 
				    <div class="field">
				      <label>加油编号</label>
				      <input type="text" value="<%=info.getOid() %>" name="oid">
				    </div>
					<div class="field">
				      <label>油量</label>
				      <input type="text" value="<%=info.getOliter() %>" name="oliter">
				    </div>
				    <div class="field">
				      <label>金额</label>
				      <input type="text"  value="<%=info.getOmoney() %>" name="omoney">
			    	</div>
				</div>
				<div class="fields">
						<div class="field">
					      <label>付款方式</label>
					   	  <select class="ui dropdown" style="width:180px" name="opayway" id="opayway">
								<option value="cash" <%if(info.getOkind().equals("cash")){%> selected="selected"<%}%>>现金</option>
								<option value="card" <%if(info.getOkind().equals("card")){%> selected="selected"<%}%>>刷卡</option>
						  </select>    
						</div>
					    <div class="field">
					      <label>加油城市</label>
					      <input type="text" value="<%=info.getOcity() %>" name="ocity">
					    </div>
					    <div class="field">
					      <label>加油时间</label>
					      <input type="text" value="<%=info.getOtime() %>" name="otime">
					    </div>
				</div>
				<div class="fields">
					    <div class="field">
					      <label>油卡编号</label>
					      <input type="text" value="<%=info.getOcardid() %>" name="ocardid">
					    </div>
						<div class="field">
					      <label>油卡余额</label>
					      <input type="text" value="<%=info.getOlmoney() %>" name="olmoney">
					    </div>
					    <div class="field">
					      <label>行驶里程</label>
					      <input type="text" value="<%=info.getOmile() %>" name="omile">
					    </div>
				</div>
				<div class="fields">
					    <div class="field">
					      <label>主车编号</label>
					      <input type="text" value="<%=info.getTid() %>" name="tid">
					    </div>
						<div class="field">
					      <label>员工编号</label>
					      <input type="text" value="<%=info.getWid() %>" name="wid">
					    </div>
					    <div class="field">
					      <label>员工名称</label>
					      <input type="text" value="<%=info.getWname() %>" name="wname">
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
		  
		  
	  		
	</div>
			
</form>
	</body>
</html>
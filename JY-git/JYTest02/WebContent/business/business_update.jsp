<%@page import="cn.jy.entity.Businessinfo"%>
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
	ArrayList<Businessinfo> list	=	(ArrayList<Businessinfo>) session.getAttribute("listBusiness");
	
	//	每行信息;
	Businessinfo info	=	list.get(0);
	
%>
 

<form action="../../JYTest02/business_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">业务修改</h4>
			  <div class="fields">
			    <div class="field">
			      <label>业务编号</label>
			      <input type="text" name="bid" value="<%=info.getBid()%>">
			    </div>
			    <div class="field">
			      <label>业务名称</label>
			      <input type="text" name="bname" value="<%=info.getBname() %>">
			    </div> 
			    <div class="field">
			      <label>业务类型</label>
			      <input type="text" name="bkind" value="<%=info.getBkind()%>">
			    </div>
			    <div class="field">
			      <label>建单人</label>
			      <input type="text" name="bcoman"  value="<%=info.getBcoman() %>">
			    </div> 
		    </div>
			<div class="fields">
				    <div class="field">
				      <label>提货地址</label>
				      <input type="text" name="bgaddress"  value="<%=info.getBgaddress() %>">
				    </div>
				    <div class="field">
				      <label>提单号</label>
				      <input type="text" name="bgoid" value="<%=info.getBgoid() %>">
				    </div>
				    <div class="field">
				      <label>船舶公司</label>
				      <input type="text" name="bshipcom"  value="<%=info.getBshipcom() %>">
				    </div>
				    <div class="field">
				      <label>预计到港日期 </label>
				      <input type="text" name="bpretoportday" value="<%=info.getBpretoportday() %>">
				    </div>
			</div>
			<div class="fields">
				    <div class="field">
				      <label>箱号</label>
				      <input type="text" name="boxid" value="<%=info.getBoxid() %>">
				    </div>
				    <div class="field">
				      <label>箱属性</label>
				      <input type="text" name="boxbelong" value="<%=info.getBoxbelong() %>">
				    </div>
				    <div class="field">
				      <label>箱尺寸</label>
				      <input type="text" name="boxsize" value="<%=info.getBoxsize() %>">
				    </div>
				    <div class="field">
				      <label>箱型 </label>
				      <input type="text" name="boxkind" value="<%=info.getBoxkind() %>">
				    </div>
			</div>
			<div class="inline fields">
				    <div class="field">
				      <label>回程运输方式</label>
				      <input type="text" name="retransway" value="<%=info.getRetransway() %>">
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
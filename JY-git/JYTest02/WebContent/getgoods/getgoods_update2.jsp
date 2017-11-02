<%@page import="cn.jy.entity.Getgoodsinfo"%>
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
	ArrayList<Getgoodsinfo> list	=	(ArrayList<Getgoodsinfo>) session.getAttribute("listGetgoods");
	
	//	每行信息;
	Getgoodsinfo info	=	list.get(0);
	
%>
 

<form action="../../JYTest02/getgoods_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">提货信息修改</h4>
			 <div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text"  placeholder="业务编号" name="bid"  value="<%=info.getBid() %>">
						    </div>
							<div class="field">
						      <label>提货编号</label>
						      <input type="text" placeholder="提货编号" name="ggid"  value="<%=info.getGgid() %>">
						    </div>
						    <div class="field">
						      <label>状态</label>
						      <input type="text" placeholder="状态" name="gstate"  value="<%=info.getGstate() %>">
						    </div>
					</div>
			  		<div class="fields">
						    <div class="field">
						      <label>运输方式</label>
						      <select class="ui dropdown" style="width:180px" name="lkind">
									<option value="railway" <%if(info.getLkind().equals("railway")){%> selected="selected"<%}%>>铁路</option>
									<option value="trunk" <%if(info.getLkind().equals("trunk")){%> selected="selected"<%}%>>汽运</option>
							  </select>
<%-- 								<input type="text"  placeholder="运输方式" name="lkind"   value="<%=info.getLkind() %>"> --%>
						    </div>
						     <div class="field">
						      <label>运输号</label>
						      <input type="text" placeholder="运输号" name="oid" value="<%=info.getOid() %>" >
						    </div>
					</div>
					<div class="fields">
							<div class="field">
						      <label>车号</label>
						      <input type="text" placeholder="车号" name="tid"   value="<%=info.getTid() %>">
						    </div>
						    <div class="field">
						      <label>车型</label>
						      <input type="text" placeholder="车型" name="tkind"   value="<%=info.getTkind() %>" >
						    </div>
						   <div class="field">
						      <label>车数</label>
						      <input type="text" placeholder="车数" name="tcount"    value="<%=info.getTcount() %>" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>单车件数</label>
								<input type="text" placeholder="单车件数" name="pertcount"  value="<%=info.getPercount() %>">
						    </div>
							<div class="field">
						      <label>单车吨数</label>
						      <input type="text" placeholder="单车吨数" name="pertweight"   value="<%=info.getPerweight() %>">
						    </div>
						    <div class="field">
						      <label>车皮标重</label>
						      <input type="text" placeholder="车皮标重" name="tformatweight"  value="<%=info.getTformatweight() %>" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>得时间</label>
								<input type="text"  placeholder="得时间" name="gtime"   value="<%=info.getGtime() %>">
						    </div>
							<div class="field">
						      <label>发时间</label>
						      <input type="text" placeholder="发时间" name="stime" value="<%=info.getStime() %>">
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
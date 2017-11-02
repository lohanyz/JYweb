<%@page import="cn.jy.entity.Portinfo"%>
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
	ArrayList<Portinfo> list	=	(ArrayList<Portinfo>) session.getAttribute("listPort");
	String imgs[] =(String[])session.getAttribute("imgs");
	String path="../port/images/";
	//	每行信息;
	Portinfo	 info	=	list.get(0);
%>

	<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  <h4 class="ui dividing header">港口信息</h4>
				  <div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text" disabled="disabled" value="<%=info.getBid() %>">
						    </div>
							<div class="field">
						      <label>港口ID</label>
						      <input type="text" disabled="disabled" value="<%=info.getPid() %>">
						    </div>
					</div>
					<div class="fields">
							<div class="field">
						      <label>到港时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getInporttime() %>">
						    </div>
						    <div class="field">
						      <label>换单时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getCtime() %>" >
						    </div>
						     <div class="field">
						      <label>进场时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getIntime() %>" >
						    </div>
						     <div class="field">
						      <label>装箱时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getPboxtime() %>" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>运输方式</label>
						      <%
						      	if(info.getLkind().equals("railway")){
						      %>
						      		<input type="text" disabled="disabled" value="铁路">
						      		<%
						      	}
						      	if(info.getLkind().equals("trunk")){
						      %>
						      		<input type="text" disabled="disabled" value="汽运">
							  <%
						      	}
						      %>
<%-- 								<input type="text"  disabled="disabled" value="<%=info.getLkind() %>"> --%>
						    </div>
						     <div class="field">
						      <label>报数时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getReporttime() %>" >
						    </div>
						     <div class="field">
						      <label>班列号</label>
						      <input type="text" disabled="disabled" value="<%=info.getClassorderid() %>" >
						    </div>
					</div>
			  		<div class="fields">
							<div class="field">
						      <label>车号</label>
						      <input type="text" disabled="disabled" value="<%=info.getTid() %>">
						    </div>
						    <div class="field">
						      <label>车型</label>
						      <input type="text" disabled="disabled" value="<%=info.getTkind() %>" >
						    </div>
						     <div class="field">
						      <label>运输号</label>
						      <input type="text" disabled="disabled" value="<%=info.getOid() %>" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>单车件数</label>
								<input type="text"  disabled="disabled" value="<%=info.getPercount() %>">
						    </div>
							<div class="field">
						      <label>单车吨数</label>
						      <input type="text" disabled="disabled" value="<%=info.getPerweight() %>">
						    </div>
						    <div class="field">
						      <label>车皮标重</label>
						      <input type="text" disabled="disabled" value="<%=info.getTformatweight() %>" >
						    </div>
						     <div class="field">
						      <label>车数</label>
						      <input type="text" disabled="disabled" value="<%=info.getTcount() %>" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>得时间</label>
								<input type="text"  disabled="disabled" value="<%=info.getGtime() %>">
						    </div>
							<div class="field">
						      <label>发时间</label>
						      <input type="text" disabled="disabled" value="<%=info.getStime() %>">
						    </div>
					</div>
					<div class="fields">
						  	<div class="field">
						      <label>状态</label>
						      <input type="text" disabled="disabled" value="<%=info.getState() %>">
						    </div>
						    <div class="field">
						      <label>是否偏离重心</label>
						      <%
						      	if(info.getIslean()){
						      %>
						      		<input type="text" disabled="disabled" value="是">
						      		<%
						      	}
						      	else{
						      %>
						      		<input type="text" disabled="disabled" value="否">
							  <%
						      	}
						      %>
						    </div>
						     <div class=" inline field">
						   	 <label> </label>
						      <input type="button" value="查看图片信息" src="<%=path+imgs[1]+".jpg" %>" id="imageShow" class="small ui button" >
						    </div>
					</div>
					<div class="demo" style="display:none">
						<ul>
							<%
								int length=imgs.length;
								for(int i=1;i<length;i++){
									String nPath=path+imgs[i]+".jpg";
							%>
								<li><img src="<%=nPath%>" width="100px" height="60px;"></li>
							<%
								}
							%>
						</ul>
					</div>
					<!-- 弹出框效果 -->
					<div class="photo-mask"></div>
					<div class="photo-panel">
						<div class="photo-div">
							<div class="photo-left">
								<div class="arrow-prv"></div>
							</div>
							<div class="photo-img">
								<div class="photo-bar">
									<div class="photo-close"></div>
								</div>
								<div class="photo-view-h">
									<img src="" />
								</div>
							</div>
							<div class="photo-right">
								<div class="arrow-next"></div>
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
	
	
	<script src="../js/jquery.min.js"></script>
	<script>
		var img_index = 0;
		var img_src ="";
		$(function() {
			//计算居中位置
			var mg_top = ((parseInt($(window).height()) - parseInt($(".photo-div").height())) / 2);
	
			$(".photo-div").css({
				"margin-top": "" + mg_top + "px"
			});
			//关闭
			$(".photo-close").click(function() {
				$(".photo-mask").hide();
				$(".photo-panel").hide();
			});
			//下一张
			$(".photo-panel .photo-div .arrow-next").click(function() {
				img_index++;
				if(img_index >= $(".demo li img").length) {
					img_index = 0;
				}
				img_src = $(".demo li img").eq(img_index).attr("src");
				photoView($(".demo li img"));
			});
			//上一张
			$(".photo-panel .photo-div .arrow-prv").click(function() {
				img_index--;
				if(img_index < 0) {
					img_index = $(".demo li img").length - 1;
				}
				img_src = $(".demo li img").eq(img_index).attr("src");
				photoView($(".demo li img"));
			});
			//如何调用？
			$("#imageShow").click(function() {
				$(".photo-mask").show();
				$(".photo-panel").show();
				img_src = $(this).attr("src");
				img_index = 1;
				photoView($(this));
			});
	
		});
		//自适应预览
		function photoView(obj) {
			if($(obj).width() >= $(obj).height()) {
				$(".photo-panel .photo-div .photo-img .photo-view-h").attr("class", "photo-view-w");
				$(".photo-panel .photo-div .photo-img .photo-view-w img").attr("src", img_src);
			} else {
				$(".photo-panel .photo-div .photo-img .photo-view-w").attr("class", "photo-view-h");
				$(".photo-panel .photo-div .photo-img .photo-view-h img").attr("src", img_src);
			}
			//此处写调试日志
			console.log(img_index);
		}
	</script>
</html>
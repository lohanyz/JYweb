<%@page import="cn.jy.entity.Harborinfo"%>
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
 		margin:20px 0 0 0;
 		padding:0 8px 0 8px;
 		text-align:center;
 		background:white;
 	}
	#b_info input{
		width:200px;
		height:28px;
		margin:0 30px 0 10px;
	}
 	#tkind input{
		width:140px;
		height:28px;
		margin:0 40px 0 0px;
	}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Harborinfo> list	=	(ArrayList<Harborinfo>) session.getAttribute("listHarbor");
	String imgs[] =(String[])session.getAttribute("imgs");
// 	String path="../harbor/images/"+imgs[0]+"_";
//   	String path="D:/java_dev/MyWorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/JYTest02/photo/"+imgs[0]+"/harbor/"+imgs[0]+"_"+imgs[1]+"_" ;
//   	String path="http:///localhost:8080/JYTest02/photo/"+imgs[0]+"/harbor/"+imgs[0]+"_"+imgs[1]+"_" ;
  	String path="http:///localhost:8080/JYTest02/photo/"+list.get(0).getBid()+"/harbor/";


	//	每行信息;
	Harborinfo	 info	=	list.get(0);
%>

	<div class="ui form" style="margin-left:30px;margin-top:20px;">
	  	<h4 class="ui dividing header">口岸货物信息</h4>
	  		<div id="b_info">
				<table style="margin: 0 0 0 0px; border-collapse: separate; border-spacing: 10px 15px;">
					<tr>
						<td><label>业务编号</label></td>
						<td class="ui input"><input type="text" disabled="disabled" value="<%=info.getBid() %>" style=" "></td>
						<td><label>货物编号：</label></td>
						<td class="ui input"><input type="text" disabled="disabled" value="<%=info.getGid() %>" name="bmid" id="bmid"></td>
						<td><label>实际到中方口岸日：</label></td>
						<td class="ui input"><input type="text" placeholder="实际到中方口岸日" disabled="disabled" value="<%=info.getFtochnharbortime() %>" id="ftochnharbortime" name="ftochnharbortime"></td>
					</tr>
					<tr>
						<td><label>装箱日：</label></td>
						<td class="ui input"><input type="text" placeholder="装箱日" disabled="disabled" value="<%=info.getPboxtime() %>" id="pboxtime" name="pboxtime"></td>
						<td><label>放行日：</label></td>
						<td class="ui input"><input type="text" placeholder="放行日" disabled="disabled" value="<%=info.getSenttime() %>" id="senttime" name="senttime"></td>
						<td><label>换装日：</label></td>
						<td class="ui input"><input type="text" placeholder="换装日" disabled="disabled" value="<%=info.getTranstime() %>" id="transtime" name="transtime"></td>
					</tr>
					<tr>
						<td><label>换装车号：</label></td>
						<td class="ui input"><input type="text" placeholder="换装车号" disabled="disabled" value="<%=info.getTranstid() %>" id="transtid" name="transtid"></td>
						<td><label>换装车数：</label></td>
						<td class="ui input"><input type="text" placeholder="换装车数" disabled="disabled" value="<%=info.getTranstcount()%>"  id="transtcount" name="transtcount"></td>
						<td><label>单车件数：</label></td>
						<td class="ui input"><input type="text" placeholder="单车件数" disabled="disabled" value="<%=info.getPercount() %>" id="percount" name="percount"></td>
					</tr>
					<tr>
						<td><label>单车吨数：</label></td>
						<td class="ui input"><input type="text" placeholder="单车吨数" disabled="disabled" value="<%=info.getPerweight() %>" id="perweight" name="perweight"></td>
						<td><label>发车日/出境日：</label></td>
						<td class="ui input"><input type="text" placeholder="发车日/出境日"  disabled="disabled" value="<%=info.getStime() %>" id="stime" name="stime"></td>
					</tr>
					<tr>
						<td><label>状态：</label></td>
					</tr>
					<tr>
						<td colspan="4">
							<textarea  name="state"  id="state"class="form-control" rows="3" style="width:500px;"  disabled="disabled" ><%=info.getState() %></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<input type="button" value="查看图片信息" src="<%=path+imgs[0]+".jpg" %>" id="imageShow" class="small ui button" >
						</td>
					</tr>
			</table>
					<div class="demo" style="display:none">
						<ul>
							<%
								int length=imgs.length;
								for(int i=0;i<length;i++){
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
						    <input type="button" value="返回" class="btn btn-default" style="width:100px; " onclick="javascript:history.go(-1)">
						</div>
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
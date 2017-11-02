<%@page import="cn.jy.entity.Boxmanageinfo"%>
<%@ page import="java.util.ArrayList,javax.servlet.*,javax.servlet.http.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.css" />
<link rel="stylesheet" type="text/css" href="../css/imageShow.css" />
<link rel="stylesheet" type="text/css" href="../css/WdatePicker.css" />
<script type="text/javascript" src="../js/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<title>港口信息修改</title>
</head>
<style type="text/css">
	.font_word_title{
		font-family: 微软雅黑;
		font-size: 32px;
		font-weight: normal;
	}
	input{
		width:120px;
		height:30px;
	}
 	#bm_info input{
		width:210px;
		height:28px;
		margin:0 30px 0 10px;
	}
 	#tkind input{
		width:140px;
		height:28px;
		margin:0 50px 0 0px;
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
 		margin:5px 0 0 0;
 		padding:0 8px 0 8px;
 		text-align:center;
 		background:white;
 	}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Boxmanageinfo> list	=	(ArrayList<Boxmanageinfo>) session.getAttribute("listBoxmanage");
	String imgs[] =(String[])session.getAttribute("imgs");
// 	String path="../boxmanage/images/"+imgs[0]+"_";
//   	String path="D:/java_dev/MyWorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/JYTest02/photo/"+imgs[0]+"/boxmanage/"+imgs[0]+"_"+imgs[1]+"_" ;
//   	String path="http:///localhost:8080/JYTest02/photo/"+imgs[0]+"/boxmanage/"+imgs[0]+"_"+imgs[1]+"_" ;
  	String path="http:///localhost:8080/JYTest02/photo/"+list.get(0).getBid()+"/boxmanage/";


	//	每行信息;
	Boxmanageinfo info	=	list.get(0);
%>

<form action="../../JYTest02/boxmanage_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  	<h4 class="ui dividing header">箱管信息修改</h4>
					<div id="bm_info">
						  <table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 15px; ">
		        		 		<tr> 
									<td><label>业务-货物编号</label></td>
								    <td class="ui input"><input type="text" disabled="disabled" value="<%=info.getBid() %>-<%=info.getGid() %>" style="width:200px;">
								    					 <input type="hidden" name="bid" id="bid" value="<%=info.getBid() %>">
								    					 <input type="hidden" name="gid" id="gid" value="<%=info.getGid() %>"></td>
								    <td><label>ID</label></td>
								    <td class="ui input"><input type="text" disabled="disabled" value="<%=info.getBmid() %>">
								    					 <input type="hidden" name="bmid" id="bmid" value="<%=info.getBmid() %>"></td>
								</tr>
								<tr>
								 	<td><label>提箱地</label></td>
									<td class="ui input"><input type="text" placeholder="提箱地" value="<%=info.getGetboxspace() %>" id="getboxspace" name="getboxspace"></td>
									<td><label>提箱时间：</label></td>
									<td class="ui input"><input type="text" placeholder="提箱时间" value="<%=info.getGetboxtime() %>" id="getboxtime" name="getboxtime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
								<tr>
									<td><label>返回中方口岸时间：</label></td>
									<td class="ui input"><input type="text" placeholder="返回中方口岸时间"  value="<%=info.getBackchnportime() %>" id="backchnportime" name="backchnportime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
									<td><label>返回口岸库房时间：</label></td>
									<td class="ui input"><input type="text" placeholder="返回口岸库房时间"  value="<%=info.getBackportstorehoustime() %>" id="backportstorehoustime" name="backportstorehoustime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
								<tr>
									<td><label>口岸换装时间：</label></td>
									<td class="ui input"><input type="text" placeholder="口岸换装时间"  value="<%=info.getPortranstime() %>" id="portranstime" name="portranstime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
									<td><label>换装车号：</label></td>
									<td class="ui input"><input type="text" placeholder="换装车号"  value="<%=info.getTranstid() %>" id="transtid" name="transtid"></td>
								</tr>
								<tr>
									<td><label>下线结费时间：</label></td>
									<td class="ui input"><input type="text" placeholder="下线结费时间"  value="<%=info.getDownlineovertime() %>" id="downlineovertime" name="downlineovertime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
									<td><label>铁路下线时间：</label></td>
									<td class="ui input"><input type="text" placeholder="铁路下线时间"  value="<%=info.getRailwaydownlinetime() %>" id="railwaydownlinetime" name="railwaydownlinetime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
								<tr>
									<td><label>实际回空时间：</label></td>
									<td class="ui input"><input type="text" placeholder="实际回空时间"  value="<%=info.getFbacknulltime() %>" id="fbacknulltime" name="fbacknulltime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
								<tr>
									<td><label>状态：</label></td>
								</tr>
								<tr>
									<td colspan="4">
						 	 			<textarea  name="state"  id="state" class="form-control" rows="3" style="width:500px;"><%=info.getState() %></textarea>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<input type="hidden" name="simg" id="simg" value="<%=info.getSimg() %>">
						     			<input type="button" value="查看图片信息" src="<%=path+imgs[0]+".jpg" %>" id="imageShow" class="small ui button" >
						     			<input type="button" value="重新上传图片" onclick="show_upload_form();" class="small ui button" >
									</td>
								</tr> 
							</table>
					</div>
			 		 
					<script type="text/javascript">
						function show_upload_form(){
							document.getElementById("reupload").style.display = "block";
						}
					</script>
					<!-- 重新上传模块  隐藏 -->
					<div class="part" id="reupload" style="display:none">
						<div class="ui form" >
							<div class="fields" >
								<div class="inline field" style="width:800px;">
									<div id="uploadForm"> 
										<label>上传照片：</label> 
										<table id="tb" style="margin:5px 0 0 40px;border-collapse:separate;border-spacing:10px 10px;">
											<tr><td>
												<input type="file" name="file"  id="inputfile" style="height:45px;width:260px;"  >
											</td><td>
												<button type="button" class="btn btn-default" onclick="doupload();">上传</button> 
											</td><td>
												<label id="showNum"></label>
											</td></tr>
										</table>
										<input type="button" class="btn btn-default" value="重传" onclick="reupload();" style="margin:5px 0 0 60px">
										<input type="button" class="btn btn-default" value="取消" onclick="hide_upload_form()" style="margin:5px 10px 0 30px;"/>
										<label>（注：最多上传5张照片）</label>
									</div>
								</div>	
							</div>
						</div>
					</div>
				<script type="text/javascript">
					var num=0;
					var img="";
					var tmp="";
					function doupload(){
						var bid = document.getElementById("bid").value;
						var gid = document.getElementById("gid").value;
						var formData = new FormData($("#uploadForm"));
						var inputfile = document.getElementById("inputfile").value;
						if(inputfile==""){
					    	 alert("请选择要上传的图片");
					    	 return false;
					     }
						if(num>=5){
				    		 alert("最多只能上传5张图片");
				    	 }
				    	 else{	
							formData.append("inputfile", inputfile);
							$.ajax({
										url : 'http://localhost:8080/JYTest02/upload_form?operid=1&bid=' + bid + '&gid=' + gid + '&spath=boxmanage',
										type : 'POST',
										data : formData,
										async : true,
										cache : false,
										contentType : false,
										processData : false,
										success : function(result) {
											alert("上传成功!");
											var obj=JSON.parse(result);
											document.getElementById("showNum").innerHTML="已上传："+(++num)+"/5";
											tmp+="_"+obj.img;
											img=tmp.substr(1);
											document.getElementById("simg").value=img;
										},
										error : function() {
											alert("上传失败!");
										}
								});
				    	 }
					}
					function reupload() {
						var bid = document.getElementById("bid").value;
						$.ajax({
									url : 'http://localhost:8080/JYTest02/upload_form?operid=2&bid=' + bid + '&gid=' + gid + '&spath=boxmanage',
									type : 'POST',
									async : true,
									cache : false,
									contentType : false,
									processData : false,
									success : function() {
										document.getElementById("inputfile").value = null;
										document.getElementById("showNum").innerHTML = "";
										document.getElementById("simg").value = "";
										num=0;
										tmp="";
										img="";
									},
									error : function() {
									}
							});
					}
					function hide_upload_form() {
						document.getElementById("simg").value = '<%=info.getSimg()%>';
						document.getElementById("reupload").style.display = "none";
						num=0;
						tmp="";
						img="";
					}
				</script>
			<!-- 查看图片隐藏的列表 -->
					<div class="demo" style="display:none">
						<ul>
							<%
								int length=imgs.length;
								for(int i=0;i<length;i++){
									String nPath=path+imgs[i]+".jpg";
									System.out.println(nPath);
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
			<div class="fields" >
				    <div class="field"  style="margin-top:30px" >
						<input type="submit" value="提交" class="btn btn-default" style="width:100px;margin-right:50px;margin-left:20px;" onclick="return _confirm();">
					    <input type="button" value="返回" class="btn btn-default" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  	</div>
		  			<script type="text/javascript">
						function _confirm() { 
							var mes="请确认信息：\n\n"
							var bid="业务编号："+document.getElementById("bid").value;
							var gid="货物编号："+document.getElementById("gid").value;
							var labels=document.getElementById("bm_info").getElementsByTagName("label");
							var inputs=document.getElementById("bm_info").getElementsByTagName("input");
							var state="状态："+document.getElementById("state").value;;
							var str="";
							for(var i=3;i<labels.length-1;i++){
								str+=labels[i].innerHTML+inputs[i+3].value+"\n";
							}
							if(confirm(mes+bid+"\n"+gid+"\n"+str+state))
								return true;
							else
								return false;
						}
					</script>
		</div>
</form>
</body>
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
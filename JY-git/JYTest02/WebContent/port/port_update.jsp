<%@page import="cn.jy.entity.Portinfo"%>
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
 	#p_info input{
		width:210px;
		height:28px;
		margin:0 30px 0 10px;
	}
 	#tkind input{
		width:210px;
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
 		margin:18px 0 0 0;
 		padding:0 8px 0 8px;
 		text-align:center;
 		background:white;
 	}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Portinfo> list	=	(ArrayList<Portinfo>) session.getAttribute("listPort");
	String imgs[] =(String[])session.getAttribute("imgs");
// 	String path="../port/images/"+imgs[0]+"_";
//   	String path="D:/java_dev/MyWorkSpace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/JYTest02/photo/"+imgs[0]+"/port/"+imgs[0]+"_"+imgs[1]+"_" ;
//   	String path="http:///localhost:8080/JYTest02/photo/"+imgs[0]+"/port/"+imgs[0]+"_"+imgs[1]+"_" ;
	String path="http:///localhost:8080/JYTest02/photo/"+list.get(0).getBid()+"/port/";

	//	每行信息;
	Portinfo info	=	list.get(0);
%>

<form action="../../JYTest02/port_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">港口货物信息修改</h4>
				  		<div id="p_info">
						  <table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:7px 15px; ">
		        		 		<tr> 
									<td><label>业务-货物编号：</label></td>
								    <td class="ui input"><input type="text" disabled="disabled" value="<%=info.getBid() %>-<%=info.getGid() %>" style="width:200px;">
								    					 <input type="hidden" name="bid"  id="bid"  value="<%=info.getBid() %>">
								    					 <input type="hidden" name="gid"  id="gid"  value="<%=info.getGid() %>"></td>
								    <td><label>ID：</label></td>
								    <td class="ui input"><input type="text" disabled="disabled" value="<%=info.getPid() %>">
								    					 <input type="hidden" name="pid" id="pid" value="<%=info.getPid() %>"></td>
									<td><label>到港时间：</label></td>
								    <td class="ui input"><input type="text" id="inporttime" name="inporttime" value="<%=info.getInporttime() %>"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
								<tr>
								    <td><label>换单时间：</label></td>
								    <td class="ui input"><input type="text" id="ctime" name="ctime" value="<%=info.getCtime() %>"   onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								    <td><label>进场时间：</label></td>
								    <td class="ui input"><input type="text" id="intime" name="intime" value="<%=info.getIntime() %>"   onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								    <td><label>装箱时间：</label></td>
								    <td class="ui input"><input type="text" id="pboxtime" name="pboxtime" value="<%=info.getPboxtime() %>"   onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
								<tr>
									<td><label>是否偏离重心：</label></td>
									<td ><select class="ui dropdown" style="width:100px" name="islean"id="islean">
											<option value="false" <%if(!info.getIslean()){%> selected="selected"<%}%>>否</option>
											<option value="true" <%if(info.getIslean()){%> selected="selected"<%}%>>是</option>
									 	 </select>
									 	 <input type="hidden" id="text_islean"  >
									</td>
								 </tr>
							</table>
						</div>
			 		 
						<input type="hidden" name="lkind" id="lkind" value="<%=info.getLkind() %>">
					  <%
						if(info.getLkind().equals("汽运")){
					 %>
					 	<span>汽运 运输</span>
        		 		<div class="part" id="lkind_trunk" >
							<table id="tkind" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:5px 15px; ">
        		 				<tr> 
									<td><label>拖车号：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getTid() %>" name="tid" id="tid" ></td>
									<td><label>车型：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getTkind() %>"  name="tkind" id="tkind" ></td>
									<td><label>铅封号：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getOid() %>"  name="oid" id="oid"></td>
								</tr>
								<tr> 
									<td><label>单车件数：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getPercount() %>" name="percount" id="percount"></td>
								    <td><label>单车吨数：</label></td>
								    <td class="ui input"><input type="text" value="<%=info.getPerweight() %>" name="perweight" id="perweight"></td>
								    <td><label>车数：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getTcount() %>" name="tcount" id="tcount"></td>
								</tr>
								<tr> 
								    <td><label>发车时间：</label></td>
								    <td class="ui input"><input type="text"  value="<%=info.getStime() %>" name="stime" id="stime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								</tr>
							</table>
        		 		</div>
        		 	<%
						}
						if(info.getLkind().equals("铁路")){
					 %>
					    <span>铁路 运输</span>
        		 		<div class="part" id="lkind_railway" >
							<table id="tkind" style="margin:0 0 0 0px;border-collapse:separate;border-spacing: 5px 15px; ">
        		 				<tr> 
									<td><label>报数时间：</label></td>
									<td class="ui input"><input type="text"  value="<%=info.getReporttime() %>" name="reporttime" id="reporttime" ></td>
									<td><label>班列号：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getClassorderid() %>" name="classorderid" id="classorderid" ></td>
									<td><label>车皮号：</label></td>
									<td class="ui input"><input type="text"  value="<%=info.getTid() %>" name="tid" id="tid" ></td>
								</tr>
								<tr> 
									<td><label>铁路车型：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getTkind() %>"  name="tkind" id="tkind" ></td>
									<td><label>运单号：</label></td>
									<td class="ui input"><input type="text" value="<%=info.getOid() %>"  name="oid" id="oid"></td>
									<td><label>单车件数：</label></td>
									<td class="ui input"><input type="text"  value="<%=info.getPercount() %>" name="percount" id="percount"></td>
								</tr>
								<tr> 
									<td><label>单车吨数：</label></td>
								    <td class="ui input"><input type="text" value="<%=info.getPerweight() %>" name="perweight" id="perweight"></td>
								    <td><label>车皮标重：</label></td>
									<td class="ui input"><input type="text"   value="<%=info.getTformatweight() %>" name="tformatweight" id="tformatweight"></td>
								    <td><label>铁路发运日：</label></td>
								    <td class="ui input"><input type="text" value="<%=info.getStime() %>" name="stime" id="stime"></td>
								</tr>
							</table>
        		 		</div>
        		 	 <%
						}
					 %>
						 <table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 15px; ">
		        		 		<tr>
									<td><label>状态：</label></td>
								</tr>
								<tr>
									<td colspan="4">
										<textarea  name="state"  id="state"class="form-control" rows="3" style="width:500px;"><%=info.getState() %></textarea>
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
										url : 'http://localhost:8080/JYTest02/upload_form?operid=1&bid=' + bid + '&gid=' + gid + '&spath=port',
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
									url : 'http://localhost:8080/JYTest02/upload_form?operid=2&bid=' + bid + '&gid=' + gid + '&spath=port',
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
										img="";
										tmp="";
									},
									error : function() {
									}
							});
					}
					function hide_upload_form() {
						document.getElementById("simg").value = '<%=info.getSimg()%>';
						document.getElementById("reupload").style.display = "none";
						num=0;
						img="";
						tmp="";
					}
				</script>
			<!-- 查看图片隐藏的列表 -->
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
			<div class="fields" >
				    <div class="field"  style="margin-top:30px" >
						<input type="submit" value="提交" class="btn btn-default" style="width:100px;margin-right:50px;margin-left:10px;" onclick="return _confirm();">
					    <input type="button" value="返回" class="btn btn-default" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  	</div>
		  		<script type="text/javascript">
						function _confirm() { 
							document.getElementById("text_islean").value=document.getElementById("islean").options[document.getElementById("islean").selectedIndex].text;
							var mes="请确认信息：\n\n"
							var pid="港口ID："+document.getElementById("pid").value;
							var bid="业务编号："+document.getElementById("bid").value;
							var gid="货物编号："+document.getElementById("gid").value;
							var lkind=document.getElementById("lkind");
							var labels;
							var inputs;
							labels=document.getElementById("p_info").getElementsByTagName("label");
							inputs=document.getElementById("p_info").getElementsByTagName("input");
							var str="";
							for(var i=1;i<labels.length-1;i++){
								str+=labels[i].innerHTML+inputs[i+3].value+"\n";
							}
							if(lkind.value=="trunk"){
								labels=document.getElementById("lkind_trunk").getElementsByTagName("label");
								inputs=document.getElementById("lkind_trunk").getElementsByTagName("input");
							}
							else{
								labels=document.getElementById("lkind_railway").getElementsByTagName("label");
								inputs=document.getElementById("lkind_railway").getElementsByTagName("input");
							}
							lkind="运输方式："+lkind.value;
							var state="状态："+document.getElementById("state").value;;
							for(var i=0;i<labels.length;i++){
								str+=labels[i].innerHTML+inputs[i].value+"\n";
							}
							if(confirm(mes+pid+"\n"+bid+"\n"+gid+"\n"+lkind+"\n"+str+state))
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
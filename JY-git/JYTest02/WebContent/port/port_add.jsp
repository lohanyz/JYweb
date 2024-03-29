<%@page import="cn.jy.entity.Workerinfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="../css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<title>信息新增</title>
<style>
	input{
		width:100px;
		height:28px;
		margin:0 30px 0 0px;
	}
 
	select{
		width:100px;
		height:30px;
	}
	.btn{
		width:80px;
	}
	.part{
		border: 1px solid #ddd;
		padding:15px 0 15px 50px;
		margin:10px 0 0 0;
	}
 	span{
 		position:absolute;
 		left:2%;
 		margin:-8px 0 0 0;
 		padding:0 5px 0 5px;
 		text-align:center;
 		background:white;
 	}
 	.span2{
 		position:absolute;
 		left:7%;
 		margin:-25px 0 0 0;
 		padding:0 5px 0 5px;
 		text-align:center;
 		background:white;
 	}
 	hr{
 		width:100%;
 		size:1px;
 		margin:5px 0 15px 0px;
 		color:#ccc;
 	}
  	#b_info input{
		width:140px;
		height:28px;
		margin:0 30px 0 10px;
	}
	#b_info	.btn{
		width:80px;
	}
 	#goods_info input{
		width:140px;
		height:28px;
		margin:0 20px 0 10px;
	}
 	#tkind input{
		width:200px;
		height:28px;
		margin:0 40px 0 0px;
	}
 	#port_info input{
		width:210px;
		height:28px;
		margin:0 40px 0 0px;
	}
</style>
</head>

<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
    	 <h4 class="ui dividing header">新增港口货物信息</h4>
        	<div class="search-box ue-clear">
        		 <form action="../../JYTest02/port_info?operid=8" method="post">
        		 <div id="pinfo"> 
        	 <!-- 输入业务编号 -->
        			<span>业务编号</span>
        		 	<div class="part" >
        		 		<table id="b_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:0px 15px;">
        		 			<tr> 
	        		 			<td><label>条码编号:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="条码编号" name="bid" id="bid" onblur="check_bid();"  style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td> 
								<td><label>业务类型:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="业务类型" name="bkind" id="bkind" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td><label>建单人:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="建单人" name="bcoman" id="bcoman" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td><label>提单号:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="提单号" name="bgoid" id="bgoid" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td><label>船舶公司:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="船舶公司" name="bshipcom" id="bshipcom" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td><label>预计到港日:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="预计到港日" name="bpretoportday" id="bpretoportday" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr> 
								<td colspan="2">
									<input type="button" class="btn btn-default" value="查货" onclick="check_gid();" style="margin:0px 10px 0 0;"/>
								</td>
								<td colspan="6">
									<input type="button" class="btn btn-default" value="收起信息" id="hide_info" style="display:none;margin:0 0px 0 -200px" onclick="hide_goods(this);" />
								</td>
							</tr>
						</table>
						<script type="text/javascript">
		                	//获取业务信息
		                	function check_bid(){
		                		var bid=document.getElementById("bid").value;
		                		if(bid!=""){
			                		var inputs = document.getElementById("b_info").getElementsByTagName("input");
	                				var len =inputs.length-2;
			                		$.ajax({  
			                			url: "../../JYTest02/business?operType=1&bid="+bid,  
			                			type: 'GET',  
			                		 	async: true,  
			                			cache: false,  
			                		 	processData: false,  
			                			success: function (returndata) {
			                				var obj=JSON.parse(returndata);
			                				if(obj!=null){
				                				for(var key in obj[0]){
				                					for(var i=1;i<len;i++){
				                						var id=inputs[i].id;
				                						if(key==id){
				                							document.getElementById(id).value=obj[0][key];
				                						}
				                					}
				                				}
			                				}
			                				else{
			                					alert("业务不存在！");
			                					for(var i=0;i<len;i++) 
			                						inputs[i].value="";
			                					document.getElementById("goods_info").style.display="none";
					                			document.getElementById("hide_info").style.display="none";
					                			document.getElementById("tkind").style.display="none";
					                			document.getElementById("port_info").style.display="none";
			                				}
			                		  	},  
			                			error: function (returndata) {  
			                		  	}  
			                		});  
		                		}
		                		else{
		                			var inputs = document.getElementById("b_info").getElementsByTagName("input");
	                				var len =inputs.length-2;
	                				for(var i=0;i<len;i++) 
                						inputs[i].value="";
		                		}
		                	}
		                	function hide_goods(btn){
		                		btn.value="显示信息";
		                		document.getElementById("goods_info").style.display="none";
		                		btn.onclick=function() { show_goods(btn) }; 
		                	}
		                	function show_goods(btn){
		                		btn.value="收起信息";
		                		document.getElementById("goods_info").style.display="block";
		                		btn.onclick=function() { hide_goods(btn) }; 
		                	}
		         	</script>
						
						
					<!-- 货物详情   -->
						<div class="part" id="goods_info" style="display:none">
							<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 15px; ">
        		 				<tr> 
									<td> <label>品名：</label></td>
									<td class="ui input"><input type="text"  disabled="disabled" value=" " id="gname"></td>
									<td><label>铅封号：</label></td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="leadnumber"></td>
									<td><label>件数：</label></td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="gcount"> </td>
									<td><label>单位：</label> </td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="gunit"> </td>
								</tr>
								<tr>
									<td><label>箱号：</label></td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="boxid"></td>
									<td><label>箱型：</label></td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="boxkind"></td>
									<td><label>尺寸：</label></td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="boxsize"></td>
									<td><label>总毛重：</label> </td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="gtotalweight"> </td>
								</tr>
								<tr>
									<td><label>长：</label> </td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="glength"> </td>
									<td><label>宽：</label> </td>
									<td class="ui input"><input type="text" disabled="disabled" value=" "  id="gwidth"> </td>
									<td><label>高：</label> </td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="gheight"> </td>
									<td><label>体积：</label> </td>
									<td class="ui input"><input type="text" disabled="disabled" value=" " id="gvolume"> </td>
								</tr>
							</table>
						</div>
        		 	</div>
        		 	<script type="text/javascript">
		                	//检测业务是否已经进行港口操作
		                	function check_gid(){
		                		var bid=document.getElementById("bid").value;
		                		if(bid!=null)
			                		$.ajax({  
			                			url: "../../JYTest02/port?operType=4&bid="+bid,  
			                			type: 'GET',  
			                		 	async: true,  
			                			cache: false,  
			                		 	processData: false,  
			                			success: function (returndata) {
			                				var obj=JSON.parse(returndata);
			                				if(obj!=null){
				                				alert("该业务已经完成港口操作，请输入其它业务编号进行港口操作！");
				                				document.getElementById("goods_info").style.display="none"; 
				                				document.getElementById("hide_info").style.display="none";
				                				document.getElementById("tkind").style.display="none";
				                				document.getElementById("harbor_info").style.display="none";
			                				}
			                				else{
			                					getGoods(bid);
			                				}
			                		  	},  
			                			error: function (returndata) {  
			                		  	}  
			                		});  
			                	else{
			                		alert("请录入条码编号！"); 
			                	}
		                	}
		                	function getGoods(bid) {  
		                		$.ajax({  
		                			url: "../../JYTest02/goods?operType=4&bid="+bid,  
		                			type: 'POST',  
		                			data: bid,  
		                		 	async: true,  
		                			cache: false,  
		                		 	processData: false,  
		                			success: function (returndata) {
		                				var obj=JSON.parse(returndata);
		                				if(obj==null){
		                					document.getElementById("goods_info").style.display="none";
		                					document.getElementById("hide_info").style.display="none";
			                				document.getElementById("tkind").style.display="none";
			                				document.getElementById("port_info").style.display="none";
			                				alert("货物不存在！");
		                				}
		                				else{
		                					document.getElementById("goods_info").style.display="block";
			                				document.getElementById("hide_info").style.display="block";
			                				document.getElementById("tkind").style.display="block";
			                				
			                				var inputs = document.getElementById("goods_info").getElementsByTagName("input");
			                				var len =inputs.length;
			                				for(var key in obj[0]){
			                					for(var i=0;i<len;i++){
			                						var id=inputs[i].id;
			                						if(key==id){
			                							document.getElementById(id).value=obj[0][key];
			                						}
			                					}
			                				}
		                				}
		                		  	},  
		                			error: function (returndata) {  
		                		    	alert("不存在");  
		                		  	}  
		                		});  
		                	}
		         	</script>
        		 	</div>
        		 	<!-- 选择运输方式 -->
        		 	<div id="tkind" style="display:none">
        		 	<hr>
        		 	<span>运输方式</span>
        		 	<div class="part" >
        		 		<label>运输方式:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
						<select class="ui dropdown" name="lkind" id="lkind" onchange="getLkind()">
							<option value="">请选择</option>
							<option value="汽运">汽运</option>
							<option value="铁路">铁路</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<!-- 输入运输详情 -->
						<!-- 输入汽运详情 -->
						<div class="part" id="lkind_trunk" style="display:none">
							<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 15px; ">
        		 				<tr> 
									<td><label>拖车号：</label></td>
									<td class="ui input"><input type="text" placeholder="拖车号" name="tid" id="tid"></td>
									<td><label>车型：</label></td>
									<td class="ui input"><input type="text" placeholder="车型" name="tkind" id="tkind" ></td>
									<td><label>铅封号：</label></td>
									<td class="ui input"><input type="text" placeholder="铅封号" name="oid" id="oid"></td>
								</tr>
								<tr>
									<td><label>单车件数：</label></td>
									<td class="ui input"><input type="text" placeholder="单车件数" name="percount" id="percount"></td>
								    <td><label>单车吨数：</label></td>
								    <td class="ui input"><input type="text" placeholder="单车吨数" name="perweight" id="perweight"></td>
								    <td><label>车数：</label></td>
									<td class="ui input"><input type="text" placeholder="车数" name="tcount" id="tcount"></td>
								</tr>
								<tr>
								    <td><label>发车时间：</label></td>
								    <td class="ui input"><input type="text" placeholder="发车时间" name="stime" id="stime"></td>
	        		 			</tr>
	        		 		</table>
        		 		</div>
        		 		<!-- 输入铁路详情 -->
        		 		<div class="part" id="lkind_railway" style="display:none">
	        		 		<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:5px 15px; ">
	        		 				<tr> 
										<td><label>报数时间：</label></td>
										<td class="ui input"><input type="text" placeholder="报数时间" id="reporttime" name="reporttime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
										<td><label>班列号：</label></td>
										<td class="ui input"><input type="text" placeholder="班列号" id="classorderid" name="classorderid"></td>
										<td><label>车皮号：</label></td>
										<td class="ui input"><input type="text" placeholder="车皮号" id="tid" name="tid"></td>
									</tr>
									<tr>
										<td><label>铁路车型：</label></td>
										<td class="ui input"><input type="text" placeholder="铁路车型" id="tkind" name="tkind"></td>
										<td><label>运单号：</label></td>
										<td class="ui input"><input type="text" placeholder="运单号" id="oid" name="oid" ></td>
										<td><label>单车件数：</label></td>
										<td class="ui input"><input type="text" placeholder="单车件数" id="percount" name="percount"></td>
									</tr>
									<tr>
										<td><label>单车吨数：</label></td>
										<td class="ui input"><input type="text" placeholder="单车吨数" id="perweight" name="perweight"></td>
									    <td><label>车皮标重：</label></td>
										<td class="ui input"><input type="text" placeholder="车皮标重" id="tformatweight" name="tformatweight" ></td>
									    <td><label>铁路发运日：</label></td>
									    <td class="ui input"><input type="text" placeholder="铁路发运日" id="stime" name="stime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
		        		 			</tr>
		        		 		</table>
        		 		</div>
        		 		</div>
        		 		<script type="text/javascript">
		                	function getLkind(){
		                		document.getElementById("port_info").style.display="block";
		                		var lkind=document.getElementById("lkind"); 
		                		if(lkind.value=="汽运"){
		                			document.getElementById("lkind_trunk").style.display="block";
		                			document.getElementById("lkind_railway").style.display="none";
		                			var inputs_t=document.getElementById("lkind_trunk").getElementsByTagName("input");
		                			var inputs_r=document.getElementById("lkind_railway").getElementsByTagName("input");
		                			for(var i=0;i<inputs_t.length;i++){
		                				inputs_r[i].name="";
		                				inputs_t[i].name=inputs_t[i].id;
		                			}
		                		} 
		                		if(lkind.value=="铁路"){
		                			document.getElementById("lkind_trunk").style.display="none";
		                			document.getElementById("lkind_railway").style.display="block";
		                			var inputs_t=document.getElementById("lkind_trunk").getElementsByTagName("input");
		                			var inputs_r=document.getElementById("lkind_railway").getElementsByTagName("input");
		                			for(var i=0;i<inputs_t.length;i++){
		                				inputs_t[i].name="";
		                				inputs_r[i].name=inputs_r[i].id;
		                			}	  
		                		}
		                		if(lkind.value==""){
		                			document.getElementById("lkind_trunk").style.display="none";
		                			document.getElementById("lkind_railway").style.display="none";
		                			document.getElementById("port_info").style.display="none";
		                		}
		                	}
		         		</script>
        		 	</div>
        			
        			<div id="port_info" style="display:none">
        			<hr>
        		<!-- 完善港口信息  -->
        			<span>港口信息</span>
        		 	<div class="part" >
        		 		<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:7px 15px; ">
        		 			<tr> 
								<td><label>ID：</label></td>
								<td class="ui input"><input type="text"  placeholder=" ID" name="pid" id="pid"></td>
								<td><label>到港时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="到港时间" id="inporttime" name="inporttime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								<td><label>换单时间：</label></td>
								<td class="ui input"><input type="text" placeholder="换单时间" id="ctime" name="ctime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
							</tr> 
							<tr>  
								<td><label>进场时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="进场时间" id="intime" name="intime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								<td><label>装箱时间：</label></td>
								<td class="ui input"><input type="text" placeholder="装箱时间" id="pboxtime" name="pboxtime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								<td><label>是否偏离重心：</label></td>
								<td ><select class="ui dropdown" style="width:100px" name="islean"id="islean">
											<option value="false">否</option>
											<option value="true">是</option>
									  </select>
									  <input type="hidden" id="text_islean"  >
								</td>
							</tr> 
						</table>
						<div class="ui form" >
							<div class="fields">
								<div class="field">
									<label>状态：</label> 
									<div class="eight wide field">
									    <textarea  name="state" id="state" class="form-control" rows="3" style="width:500px;"></textarea>
									</div>
								</div>
							</div>
							<div class="fields" >
								<div class="inline field" style="width:800px;">
								<div id="uploadForm" >
									<label>上传照片：</label> 
										<table id="tb" style="margin:5px 0 0 40px;border-collapse:separate;border-spacing:10px 10px;">
											<tr><td>
												<input type="file" name="file"  id="inputfile" style="height:45px;width:260px;"  >
												<input type="hidden" id="simg" name="simg">
											</td><td>
												<button type="button" class="btn btn-default" onclick="doupload();">上传</button> 
											</td><td>
												<label id="showNum"></label>
											</td></tr>
										</table>
<!-- 										<input type="button" class="btn btn-default" value="预览" onclick="_preview();" style="margin:5px 0 0 60px"> -->
										<input type="button" class="btn btn-default" value="重新上传" onclick="reupload()" style="margin:3px 10px 0 30px;"/>
										<label>（注：最多上传5张照片）</label>
								</div>
								</div>
							</div>
						</div>
					</div>
					</div>
						<script type="text/javascript">
							var num=0;
							var img="";
							var tmp="";
						   function doupload() {
							     var bid=document.getElementById("bid").value; 
							     var formData = new FormData($( "#uploadForm" ));  
								 var inputfile=document.getElementById("inputfile").value;
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
										          url: 'http://localhost:8080/JYTest02/upload_form?operid=1&bid='+bid+'&spath=port' ,  
										          type: 'POST',  
												  data: formData,
										          async: true,  
										          cache: false,  
										          contentType: false,  
										          processData: false,  
										          success: function (result) {  
														alert("上传成功!" );
														var obj=JSON.parse(result);
														document.getElementById("showNum").innerHTML="已上传："+(++num)+"/5";
														tmp+="_"+obj.img;
														img=tmp.substr(1);
														document.getElementById("simg").value=img;
										          },  
										          error: function () {  
														alert("上传失败!");
										          }  
									});  
								 }
							}
							function reupload() { 
							  var bid=document.getElementById("bid").value;
							     $.ajax({  
							          url: 'http://localhost:8080/JYTest02/upload_form?operid=2&bid='+bid+'&spath=port' ,  
							          type: 'POST',  
							          async: true,  
							          cache: false,  
							          contentType: false,  
							          processData: false,  
							          success: function () {  
											document.getElementById("inputfile").value=null;
											document.getElementById("showNum").innerHTML="";
											document.getElementById("simg").value="";
											num=0;
											img="";
											tmp="";
							          },  
							          error: function () {  
							          }  
							     });  
						  	 }
						</script>
					
					<hr>
        		 	<input type="submit" class="btn btn-default" value="提交" style="margin:0 40px 0 400px ;width:200px;" onclick="return _confirm();"/>
<!--         		 	<input type="reset" class="btn btn-default" value="全部重置" /> -->
        		 	<script type="text/javascript">
						function _confirm() { 
							document.getElementById("text_islean").value=document.getElementById("islean").options[document.getElementById("islean").selectedIndex].text;
							var mes="请确认信息：\n\n"
// 							var bid="业务编号："+document.getElementById("bid").value;
							var tmp=document.getElementById("bid").value;
							var bid="业务编号："+tmp.substr(0,tmp.indexOf("-"))+"\n";
							var gid="货物编号："+tmp.substr(tmp.indexOf("-")+1)+"\n";
							
							var lkind=document.getElementById("lkind");
							if(lkind.value==" "){
								alert("请选择运输方式");
								return false;
							}
							else
								lkind="运输方式："+lkind.value+"\n";
							
							var labels1;
							var inputs1;
							var str="";
							if(document.getElementById("lkind").value=="汽运"){
								labels1=document.getElementById("lkind_trunk").getElementsByTagName("label");
								inputs1= document.getElementById("lkind_trunk").getElementsByTagName("input");
							}
							if(document.getElementById("lkind").value=="铁路"){
								labels1=document.getElementById("lkind_railway").getElementsByTagName("label");
								inputs1= document.getElementById("lkind_railway").getElementsByTagName("input");
							}
							for(var i=0;i<labels1.length;i++){
								if(inputs1[i].value==""){
									alert("请输入"+labels1[i].innerHTML);
									inputs1[i].focus();
									return false;
								}
								str+=labels1[i].innerHTML+inputs1[i].value+"\n";
							}
							
							var labels2=document.getElementById("port_info").getElementsByTagName("label");
							var inputs2=document.getElementById("port_info").getElementsByTagName("input");
							for(var i=0;i<labels2.length-4;i++){
								if(inputs2[i].value==""){
									alert("请输入"+labels2[i].innerHTML);
									inputs2[i].focus();
									return false;
								}
								str+=labels2[i].innerHTML+inputs2[i].value+"\n";
							}
							
							var state=document.getElementById("state");
							if(state.value==""){
								alert("请输入货物状态信息");
								state.focus();
								return false;
							}
							else
								state="货物状态："+state.value+"\n";
							
							var simg=document.getElementById("simg");	
							if(simg.value==""){
								alert("请上传图片信息");
								return false;
							}
							else 
								simg="图片已上传数目："+num+"\n";
							
							if(confirm(mes+bid+gid+lkind+str+state+simg))
								return true;
							else
								return false;
						}
					</script>
				</form>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/jquery.select.js"></script>
<script type="text/javascript" src="../js/core.js"></script>
<script type="text/javascript" src="../js/jquery.pagination.js"></script>
<script type="text/javascript" src="../js/jquery.grid.js"></script>
<script type="text/javascript" src="../js/WdatePicker.js"></script>
 
</html>

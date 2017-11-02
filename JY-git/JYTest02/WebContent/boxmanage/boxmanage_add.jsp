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
		margin:0 40px 0 0px;
	}
 	#bm_info input{
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
    	<h4 class="ui dividing header">新增箱管信息</h4>
        	<div class="search-box ue-clear">
        		 <form action="../../JYTest02/boxmanage_info?operid=8" method="post">
        		 <div id="ginfo"> 
        	 <!-- 输入业务编号 -->
        			<span>业务信息</span>
        		 	<div class="part"  >
        		 		<table id="b_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:0px 15px; ">
        		 			<tr> 
	        		 			<td><label>条码编号:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="条码编号" name="bid" id="bid" onblur="check_bid();" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td> 
								<td><label>提单号:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="提单号" name="bgoid" id="bgoid" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td><label>箱号:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="箱号" name="boxid" id="boxid" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr> 
								<td><label>箱尺寸:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="箱尺寸" name="boxsize" id="boxsize" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
	        		 			<td><label>箱型:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="箱型" name="boxkind" id="boxkind" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td> 
								<td><label>箱属:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="箱属" name="boxbelong" id="boxbelong" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr> 
								<td><label>回程运输方式:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="回程运输方式" name="retransway" id="retransway" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr> 
								<td colspan="2">
									<input type="button" class="btn btn-default" value="查货" onclick="check_bmid();" style="margin:0px 10px 0 0;"/>
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
				                						if(key ==id){
				                							document.getElementById("b_info").getElementsByTagName("input")[i].value=obj[0][key];
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
				                				document.getElementById("bm_info").style.display="none";
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
		                	//检测业务是否已经提货
		                	function check_bmid(){
		                		var bid=document.getElementById("bid").value;
		                		if(bid!=null)
			                		$.ajax({  
			                			url: "../../JYTest02/boxmanage?operType=4&bid="+bid,  
			                			type: 'GET',  
			                		 	async: true,  
			                			cache: false,  
			                		 	processData: false,  
			                			success: function (returndata) {
			                				var obj=JSON.parse(returndata);
			                				if(obj!=null){
				                				alert("该业务已经完成箱管操作，请输入其它业务编号！");
				                				document.getElementById("goods_info").style.display="none"; 
				                				document.getElementById("hide_info").style.display="none";
				                				document.getElementById("bm_info").style.display="none";
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
			                				document.getElementById("bm_info").style.display="none";
			                				alert("货物不存在！");
			                				document.getElementById("bid").select(); 
		                				}
		                				else{
			                				var inputs = document.getElementById("goods_info").getElementsByTagName("input");
			                				var len =inputs.length;
			                				for(var key in obj[0]){
			                					for(var i=0;i<len;i++){
			                						var id=inputs[i].id;
			                						if(key==id){
			                							document.getElementById("goods_info").getElementsByTagName("input")[i].value=obj[0][key];
			                						}
			                					}
			                				}
		                					document.getElementById("goods_info").style.display="block";
			                				document.getElementById("hide_info").style.display="block";
			                				document.getElementById("bm_info").style.display="block";
		                				}
		                		  	},  
		                			error: function (returndata) {  
		                		    	alert("不存在");  
		                		  	}  
		                		});  
		                	}
		         	</script>
        		</div>
        		<div id="bm_info" style="display:none">
        		<hr>
        		<!-- 完善箱管信息  -->
        			<span>箱管信息</span>
        		 	<div class="part" >
        		 		<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 15px; ">
 		       				<tr> 
								<td><label>箱管ID：</label></td>
								<td class="ui input"><input type="text"  placeholder="箱管ID" name="bmid" id="bmid"></td>
								<td><label>提箱地：</label></td>
								<td class="ui input"><input type="text"  placeholder="提箱地" id="getboxspace" name="getboxspace"></td>
							</tr> 
							<tr>  
								<td><label>提箱时间：</label></td>
								<td class="ui input"><input type="text" placeholder="提箱时间" id="getboxtime" name="getboxtime"  onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								<td><label>返回中方口岸时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="返回中方口岸时间" id="backchnportime" name="backchnportime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
							</tr> 
							<tr>  
								<td><label>返回口岸库房时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="返回口岸库房时间" id="backportstorehoustime" name="backportstorehoustime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								<td><label>口岸换装时间：</label></td>
								<td class="ui input"><input type="text" placeholder="口岸换装时间" id="portranstime" name="portranstime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
							</tr>
							<tr>  
								<td><label>换装车号：</label></td>
								<td class="ui input"><input type="text"  placeholder="换装车号" id="transtid" name="transtid"></td>
								<td><label>下线结费时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="下线结费时间" id="downlineovertime" name="downlineovertime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
							</tr> 
							<tr>  
								<td><label>铁路下线时间：</label></td>
								<td class="ui input"><input type="text" placeholder="铁路下线时间" id="railwaydownlinetime" name="railwaydownlinetime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								<td><label>实际回空时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="实际回空时间" id="fbacknulltime" name="fbacknulltime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
							</tr>
	  
	   <!--   
							<tr> 
								<td><label>提箱地：</label></td>
								<td class="ui input"><input type="text"  placeholder="提箱地" id="getboxspace" name="getboxspace"></td>
								<td><label>提箱时间：</label></td>
								<td class="ui input"><input type="text" placeholder="提箱时间" id="getboxtime" name="getboxtime"></td>
								<td><label>返回中方口岸时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="返回中方口岸时间" id="backchnportime" name="backchnportime"></td>
							</tr> 
							<tr>  
								<td><label>返回口岸库房时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="返回口岸库房时间" id="backportstorehoustime" name="backportstorehoustime"></td>
								<td><label>口岸换装时间：</label></td>
								<td class="ui input"><input type="text" placeholder="口岸换装时间" id="portranstime" name="portranstime"></td>
								<td><label>换装车号：</label></td>
								<td class="ui input"><input type="text"  placeholder="换装车号" id="transtid" name="transtid"></td>
							</tr>
							<tr>  
								<td><label>下线结费时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="下线结费时间" id="downlineovertime" name="downlineovertime"></td>
								<td><label>铁路下线时间：</label></td>
								<td class="ui input"><input type="text" placeholder="铁路下线时间" id="railwaydownlinetime" name="railwaydownlinetime"></td>
								<td><label>实际回空时间：</label></td>
								<td class="ui input"><input type="text"  placeholder="实际回空时间" id="fbacknulltime" name="fbacknulltime"></td>
							</tr> 
 		-->
						</table>
        		 		<div class="ui form" >
							<div class="fields">
								<div class="field">
									<label>货物状态：</label> 
									<div class="eight wide field">
									    <textarea  name="state" id="state"class="form-control" rows="3" style="width:500px;"></textarea>
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
								          url: 'http://localhost:8080/JYTest02/upload_form?operid=1&bid='+bid+'&spath=boxmanage' ,  
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
							          url: 'http://localhost:8080/JYTest02/upload_form?operid=2&bid='+bid+'&spath=getgoods' ,  
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
        		 	<script type="text/javascript">
						function _confirm() { 
							var mes="请确认信息：\n\n"
							var tmp=document.getElementById("bid").value;
							var bid="业务编号："+tmp.substr(0,tmp.indexOf("-"))+"\n";
							var gid="货物编号："+tmp.substr(tmp.indexOf("-")+1)+"\n";
							var labels=document.getElementById("bm_info").getElementsByTagName("label");
							var inputs=document.getElementById("bm_info").getElementsByTagName("input");
							var str="";
							for(var i=0;i<labels.length-4;i++){
								if(inputs[i].value==""){
									alert("请输入"+labels[i].innerHTML);
									inputs[i].focus();
									return false;
								}
								str+=labels[i].innerHTML+inputs[i].value+"\n";
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
							
							if(confirm(mes+bid+gid+str+state+simg))
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

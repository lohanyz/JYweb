<%@page import="cn.jy.entity.Workerinfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="../css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery-ui.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery-ui.js"></script>
<script type="text/javascript" src="../js/WdatePicker.js"></script>

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
 	#tkind input{
		width:200px;
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
    	<h4 class="ui dividing header">新增提货信息</h4>
        	<div class="search-box ue-clear">
        		 <form action="../../JYTest02/getgoods_info?operid=8" method="post">
        		 <div id="ginfo"> 
        	 <!-- 输入业务编号 -->
        			<span>业务信息</span>
        		 	<div class="part" >
        		 		<table id="b_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:0px 15px; ">
        		 			<tr> 
	        		 			<td><label>条码编号:</label></td> 
								<td class="ui input">
									<input type="text" placeholder="条码编号" name="bid" id="bid" value="" onblur="check_bid();" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
								<td>
								<label>提货地址:</label></td> 
								<td class="ui input"  colspan="5">
									<input type="text" placeholder="提货地址" name="bgaddress" id="bgaddress" disabled="disabled" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
								<td>
								
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
				                				document.getElementById("gginfo").style.display="none";
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
		                	function check_gid(){
		                		var bid=document.getElementById("bid").value;
		                		if(bid!=null)
			                		$.ajax({  
			                			url: "../../JYTest02/getgoods?operType=4&bid="+bid,  
			                			type: 'GET',  
			                		 	async: true,  
			                			cache: false,  
			                		 	processData: false,  
			                			success: function (returndata) {
			                				var obj=JSON.parse(returndata);
			                				if(obj!=null){
				                				alert("该业务已经完成提货，请输入其它业务编号进行提货操作！");
				                				document.getElementById("goods_info").style.display="none"; 
				                				document.getElementById("hide_info").style.display="none";
				                				document.getElementById("tkind").style.display="none";
				                				document.getElementById("gginfo").style.display="none";
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
			                				document.getElementById("gginfo").style.display="none";
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
			                							document.getElementById(id).value=obj[0][key];
			                						}
			                					}
			                				}
		                					document.getElementById("goods_info").style.display="block";
			                				document.getElementById("hide_info").style.display="block";
			                				document.getElementById("tkind").style.display="block";
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
        		 		<label>运输方式:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label> 
						<select class="ui dropdown" name="lkind" id="lkind" onchange="getLkind()">
							<option value=" ">请选择</option>
							<option value="汽运">汽运</option>
							<option value="铁路">铁路</option>
						</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						
						<!-- 输入运输详情 -->
						<!-- 输入汽运详情 -->
						<div class="part" id="lkind_trunk" style="display:none">
							<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:7px 15px; ">
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
									<td><label>提货时间：</label></td>
									<td class="ui input"><input type="text" placeholder="提货时间" name="gtime" id="gtime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								    <td><label>发车时间：</label></td>
								    <td class="ui input"><input type="text" placeholder="发车时间" name="stime" id="stime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
	        		 			</tr>
	        		 		</table>
        		 		</div>
        		 		<!-- 输入铁路详情 -->
        		 		<div class="part" id="lkind_railway" style="display:none">
	        		 		<table style="margin:0 0 0 0px;border-collapse:separate;border-spacing:7px 15px; ">
        		 				<tr> 
									<td><label>车皮号：</label></td>
									<td class="ui input"><input type="text" placeholder="车皮号" id="tid" name="tid"></td>
									<td><label>铁路车型：</label></td>
									<td class="ui input"><input type="text" placeholder="铁路车型" id="tkind" name="tkind"></td>
									<td><label>运单号：</label></td>
									<td class="ui input"><input type="text" placeholder="运单号" id="oid" name="oid" ></td>
								</tr>
								<tr>
									<td><label>单车件数：</label></td>
									<td class="ui input"><input type="text" placeholder="单车件数" id="percount" name="percount"></td>
								    <td><label>单车吨数：</label></td>
									<td class="ui input"><input type="text" placeholder="单车吨数" id="perweight" name="perweight"></td>
								    <td><label>车皮标重：</label></td>
									<td class="ui input"><input type="text" placeholder="车皮标重" id="tformatweight" name="tformatweight" ></td>
								</tr>
								<tr>
									<td><label>装车时间：</label></td>
									<td class="ui input"><input type="text"  placeholder="装车时间" id="gtime" name="gtime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
								    <td><label>铁路发运日：</label></td>
								    <td class="ui input"><input type="text" placeholder="铁路发运日" id="stime" name="stime" onfocus="WdatePicker({dateFmt:'yyyy年MM月dd日HH时mm分'})"></td>
	        		 			</tr>
	        		 		</table>
        		 		</div>
        		 		</div>
        		 		<script type="text/javascript">
		                	function getLkind(){
		                		document.getElementById("gginfo").style.display="block";
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
		                		if(lkind.value==" "){
		                			document.getElementById("lkind_trunk").style.display="none";
		                			document.getElementById("lkind_railway").style.display="none";
		                			document.getElementById("gginfo").style.display="none";
		                		}
		                	}
		         		</script>
        		 	</div>
        			
        			<div id="gginfo" style="display:none">
        			<hr>
        		<!-- 完善提货信息  -->
        			<span>提货信息</span>
        		 	<div class="part" >
        		 		<div class="ui form" >
        		 			<div class="inline fields">
								    <div class="field">
								  		<label>提货ID：</label>
										<input type="text"  placeholder="提货ID" name="ggid" id="ggid" style="width:150px;" >
								    </div>
							</div> 
<!--        				<script type="text/javascript">
			                	//检测提货ID是否已经存在
			                	function if_ggid_exit(){
			                		var ggid=document.getElementById("ggid");
			                		if(ggid.value!=null)
				                		$.ajax({  
				                			url: "../../JYTest02/getgoods?operType=5&ggid="+ggid.value,  
				                			type: 'GET',  
				                		 	async: true,  
				                			cache: false,  
				                		 	processData: false,  
				                			success: function (returndata) {
				                				if(returndata!=null){
					                				alert("该ID已存在，请重新输入。");
					                				ggid.select();
				                				}
				                		  	},  
				                			error: function (returndata) {  
				                		  	}  
				                		});
			                		else{
			                			alert("请录入提货ID！"); 
			                		}
			                	}
			                </script>
  -->			      
							<div class="fields">
								<div class="field">
									<label>货物状态：</label> 
									<div class="eight wide field">
									    <textarea  name="gstate" id="gstate" class="form-control" rows="3" style="width:500px;"></textarea>
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
												<input type="hidden" id="gsimg" name="gsimg">
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
							var tmp="";
							var img="";
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
										          url: 'http://localhost:8080/JYTest02/upload_form?operid=1&bid='+bid+'&spath=getgoods',  
										          type: 'POST',  
												  data: formData,
										          async: true,  
										          cache: false,  
										          contentType: false,  
										          processData: false,  
										          success: function (returndata) {  
														alert("上传成功!" );
														var obj=JSON.parse(returndata);
														document.getElementById("showNum").innerHTML="已上传："+(++num)+"/5";
														tmp+="_"+obj.img;
														img=tmp.substr(1);
														document.getElementById("gsimg").value=img;
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
											document.getElementById("gsimg").value="";
											num=0;
											tmp="";
											img="";
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
							var labels;
							var inputs;
							var str="";
							if(document.getElementById("lkind").value=="汽运"){
								labels=document.getElementById("lkind_trunk").getElementsByTagName("label");
								inputs= document.getElementById("lkind_trunk").getElementsByTagName("input");
							}
							if(document.getElementById("lkind").value=="铁路"){
								labels=document.getElementById("lkind_railway").getElementsByTagName("label");
								inputs= document.getElementById("lkind_railway").getElementsByTagName("input");
							}
							for(var i=0;i<labels.length;i++){
								if(inputs[i].value==""){
									alert("请输入"+labels[i].innerHTML);
									inputs[i].focus();
									return false;
								}
								str+=labels[i].innerHTML+inputs[i].value+"\n";
							}
							
							var ggid=document.getElementById("ggid");	
							if(ggid.value==""){
								alert("请输入提货ID");
								ggid.focus();
								return false;
							}
							else
								ggid="提货ID："+ggid.value+"\n";
							
							var gstate=document.getElementById("gstate");	
							if(gstate.value==""){
								alert("请输入货物状态信息");
								gstate.focus();
								return false;
							}
							else
								gstate="货物状态："+gstate.value+"\n";
							
							
							var gsimg=document.getElementById("gsimg");	
							if(gsimg.value==""){
								alert("请上传图片信息");
								return false;
							}
							else 
								gsimg="图片已上传数目："+num+"\n";
							
							if(confirm(mes+bid+gid+lkind+str+gstate+gsimg))
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
<script type="text/javascript" src="../js/global.js"></script>
</html>

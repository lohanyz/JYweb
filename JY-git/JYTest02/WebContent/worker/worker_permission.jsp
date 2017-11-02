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
<title>权限管理</title>
<style>
	input{
		width:120px;
		height:30px;
	}
	select{
		width:100px;
		height:30px;
	}
	form{
		border: 1px solid #ddd;
		padding:15px 5px 40px 5px;
	}
 	span{
 		position:absolute;
 		left:2%;
 		margin:-8px 0 0 0;
 		padding:0 5px 0 5px;
 		text-align:center;
 		background:white;
 	}
	#w_info input{
		width:140px;
		height:28px;
		margin: 0px 30px 0 0px;
	}
	#w_info	.btn{
		width:80px;
	}
	th{
 		font-family: 黑体;
		font-size: 14px;
 		text-align:center;
 	}
 	#p_info tbody tr td input{
		text-align:center;
		left:40%;
	}
	#p_info .checkbox{
		width:12px;
		height:12px;
	}
</style>
</head>

<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">  
    	<div id="main">
    	<div class="ui form" style="margin-top:10px;">
		  <h4 class="ui dividing header">用户授权</h4>
        	<div class="search-box ue-clear" style="margin-top:20px;">
        		<span>用户信息</span>
        		 <form action="../../JYTest02/user_info?operid=13" method="post">
        		 	  <table id="w_info" style="margin:10px 0 0 50px;border-collapse:separate;border-spacing: 0px 15px; ">
	        		 	 <tr>
	        		 	   <td>
						   <label>用户编号：</label>&nbsp;&nbsp;&nbsp;
						   </td>
	        		 	   <td>
							<div class="ui input">
								<input type="text" placeholder="用户编号" name="wid" id="wid" onblur="check_wid();" >
							</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </td>
	        		 	   <td>
							<label>用户名称：</label>&nbsp;&nbsp;&nbsp;
						   </td>
	        		 	   <td>
							<div class="ui input">
								<input type="text" placeholder="用户名称" id="wname" disabled="disabled">
							</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   </td>
	        		 	   <td>
							<label>用户昵称：</label>&nbsp;&nbsp;&nbsp;
						   </td>
	        		 	   <td>
							<div class="ui input">
								<input type="text" placeholder="用户昵称" id="wcall" disabled="disabled">
							</div> 
						   </td>
						   <td>
						   	<label>用户类型：</label>
						   </td>
			  			   <td>
			  			    <div class="ui input">
			  			    	<input type="text"  placeholder="用户类型" id="wtype" disabled="disabled">
			  			    </div>
			  			   </td>
	        		 	  </tr>
						</table>
<!-- 				</form> -->
<!--                 <hr width="100%" size="1" color="#ccc" style="margin-top:5px;margin-bottom:20px;"> -->
<!--             </div> -->
<!--             <div> -->
<!--             	<span>选择权限</span> -->
<!--         		 <form style="width:100%;padding:40px 30px 20px 30px;text-align:center;"> -->
        		 	<table id="p_info"  class="table table-bordered" style="width:90%;margin:20px 0px 40px 50px;border-collapse:separate;border-spacing: 0px 0px; ">
	        		 	 <caption>选择权限</caption>
	        		 	 <thead align="center">
								<tr align="center" style="text-align:center;">
									<th>全选</th>
									<th>用户管理</th>
									<th>日志管理</th>
									<th>提货管理</th>
									<th>港口管理</th>
									<th>口岸管理</th>
									<th>箱管理</th>
									<th>签收管理</th>
								</tr>
							</thead>
							<tbody align="center">
								<tr align="center" style="text-align:center;">
									<td><input type="checkbox" class="checkbox" id="select_all" name="select_all" onclick="selectAll(this);"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission"/></td>
								</tr>
							</tbody>
					</table>
					<input type="hidden" id="wpermission" name="wpermission"/>
					<script type="text/javascript">
						//获取用户信息
	                	function check_wid(){
	                		var wid=document.getElementById("wid").value;
	                		var checkboxs = document.getElementsByName("permission");
	                		if(wid.trim()!=""){
		                		var inputs = document.getElementById("w_info").getElementsByTagName("input");
                				var len =inputs.length ;
		                		$.ajax({  
		                			url: "../../JYTest02/worker?operType=1&wid="+wid,  
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
			                				var permission=obj[0]['wpermission'];
			                				document.getElementById("wpermission").value=permission;
			                				for(var i=0;i<checkboxs.length;i++)
			                					if(permission.substring(i,i+1)=="1") 
			                						checkboxs[i].checked=true;
		                				}
		                				else{
		                					alert("用户不存在！");
		                					for(var i=0;i<len;i++) 
		                						inputs[i].value="";
		                					for(var i=0;i<checkboxs.length;i++) 
		                						checkboxs[i].checked=false;
		                					document.getElementById("select_all").checked=false;
		                					document.getElementById("wpermission").value="";
		                					document.getElementById("wid").clear();
		                					document.getElementById("wid").focus();
		                				}
		                		  	},  
		                			error: function (returndata) {  
		                		  	}  
		                		});  
	                		}
	                		else{
	                			var inputs = document.getElementById("w_info").getElementsByTagName("input");
                				var len =inputs.length ;
                				for(var i=0;i<len;i++) 
            						inputs[i].value="";
                				for(var i=0;i<checkboxs.length;i++)
                					checkboxs[i].checked=false;
                				document.getElementById("select_all").checked=false;
                				document.getElementById("wpermission").value="";
	                		}
	                	}
		                
						function selectAll(btn) {  
							  var checkboxs = document.getElementsByName("permission");  
							  var len=checkboxs.length;
							  if(btn.checked)
								  for ( var i = 0; i <  len  ; i+=1)
								  		checkboxs[i].checked =true;  
							  if(!btn.checked)
								  for ( var i = 0; i <  len  ; i+=1)
										checkboxs[i].checked =false;  
						}  
						function cancelAll(btn) {  
							  var checkboxs = document.getElementsByName("permission");  
							  var len=checkboxs.length;
							  if(!document.getElementById("select_all").checked)
								  for ( var i = 0; i <  len  ; i+=1)
								  		checkboxs[i].checked =false;  
							  btn.onclick=function() { selectAll(btn) }; 
						}  
						
		       		</script>
		       		<div class="fields" >
						    <div class="field"  style="margin-top:30px; left:50%;">
								<input type="submit" value="提交" class="btn btn-default" style="width:100px;margin-left:500px;"  onclick="return confirm_permission();">
<!-- 							    <input type="button" value="取消" class="btn btn-default" style="width:100px"> -->
							</div>
				  	</div>
				  	<script type="text/javascript">
						function confirm_permission() { 
							  var wid = document.getElementById("wid");  
							  if(wid.value.trim()==""){
								  alert("请先输入用户ID!");
								  wid.focus();
								  return false;
							  }
							  var wname = document.getElementById("wname").value;  
							  var mes="";
							  var permission="";
							  var wpermission="";
							  var tab = document.getElementById("p_info");  
							  var thead = document.getElementsByTagName("thead")[0];  
							  var checkboxs = document.getElementsByName("permission"); 
							  var len=checkboxs.length;
							  for ( var i = 0,j=1; i <  len  ; i+=1)
							  		if(checkboxs[i].checked){
							  			wpermission+="1";
							  			permission+=j+"、 "+thead.rows[0].cells[i+1].innerHTML+"\n" ;
							  			j++;
							  		}
							  		else
							  			wpermission+="0";
							  document.getElementById("wpermission").value=wpermission;
							  if(permission!="") 
								  mes="是否确定授予ID为 "+wid.value+" 的用户 "+wname+" 如下权限：\n\n"+permission+"\n";
							  else
								  mes="是否确定收回ID为 "+wid.value+" 的用户 "+wname+" 所有系统权限？\n\n";
							  
							  if(confirm(mes))
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

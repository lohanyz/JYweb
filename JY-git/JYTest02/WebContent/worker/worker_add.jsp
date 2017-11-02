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
<title>员工信息的添加</title>
</head>
<style type="text/css">
.font_word_title{
	font-family: 微软雅黑;
	font-size: 32px;
	font-weight: normal;
}
#w_info label{
		font-family: 微软雅黑;
		font-size: 13px;
		font-weight: normal;
}
#w_info span{
		font-family: 微软雅黑;
		font-size: 13px;
		font-weight: normal;
		color:#ddd;'
}
#w_info input{
		width:220px;
		height:28px;
		margin:0 30px 0 10px;
}
#w_info select{
		width:100px;
		height:35px;
		margin:0 0px 0 10px;
}
</style>

<body>
<form action="../../JYTest02/user_info" method="get" onsubmit="return validate()" id="form"	>
	<input type="hidden" name="operid" value="8">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">用户详细信息</h4>
		  	<table id="w_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 15px; ">
<!-- 				<tr> -->
<!-- 					<td><label>用户编号</label></td> -->
<!-- 				    <td><input type="text" placeholder="用户编号"  name="wid" id="wid"></td> -->
<!-- 				</tr> -->
				<tr>
				    <td><label>用户名称</label></td>
				    <td><input type="text" placeholder="用户名称"  name="wname" id="wname" maxlength="20" onblur="blur1(this)"></td>
				    <td><span>2~20位字符</span></td>
				</tr>
				<script language="JavaScript" type="text/javascript">
					function  blur1(btn){
    					if(btn.value.length<2||btn.value.length>20){
    						btn.select();
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
						}
    					else
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#ddd";
					}
				</script>
				<tr>
				    <td><label>员工昵称</label></td>
				    <td><input type="text" placeholder="员工昵称"  name="wcall" id="wcall" onblur="blur2(this)"></td>
				    <td><span>5~20位的数字、字母或下划线</span></td>
		    	</tr>
		    	<script language="JavaScript" type="text/javascript">
					function  blur2(btn){
    					if(btn.value.length<5||btn.value.length>20){
    						btn.select();
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
						}
    					else
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#ddd";
					}
				</script>
				<tr>
					<td><label>员工密码</label></td>
				    <td><input type="password" placeholder="员工密码"   name="wpwd" id="wpwd" maxlength="16" onblur="blur3(this)"></td>
				    <td><span>6~16位的任意字符</span></td>
				</tr>
				<script language="JavaScript" type="text/javascript">
					function  blur3(btn){
    					if(btn.value.length<6||btn.value.length>20){
    						btn.select();
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
						}
    					else
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#ddd";
					}
				</script>
				<tr>
				    <td><label>确认密码</label></td>
				    <td><input type="password" placeholder="确认密码"   name="wpwd1" id="wpwd1" maxlength="16" onblur="blur4(this)"></td>
					<td><span></span></td>
				</tr>
				<script language="JavaScript" type="text/javascript">
					function  blur4(btn){
    					if(btn.value!=document.getElementById("wpwd").value ){
    						btn.select();
    						btn.parentNode.parentNode.cells[2].childNodes[0].innerHTML="两次输入密码需要一致";
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
						}
    					else{
    						btn.parentNode.parentNode.cells[2].childNodes[0].innerHTML="";
    					}
					}
				</script>
				<tr>
				    <td><label>员工类型</label>
				    <td><select class="ui dropdown" name="wtype" id="wtype">
							<option value="临时">临时</option>
							<option value="永久">永久</option>
					  </select>
				    </td>
				</tr>
				<tr>
					<td><label>备注</label></td>
				</tr>
				<tr>
					<td colspan="3"><textarea name="wnote" id="wnote" ></textarea></td>
				</tr>
			</table>
			</div>
			<div class="fields" >
				    <div class="field"  style="margin:30px 0 0 30px" >
						<input type="submit" value="提交" class="small ui button" style="width:100px;margin-right:50px;" >
						<input type="reset" value="重置" class="small ui button" style="width:100px;margin-right:50px;" >
					    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  	</div>
		  	<script language="JavaScript" type="text/javascript">
					function validate(){
					   var wname=form.wname;
					   if(wname.value==""){
					   		alert("用户名称不能为空!");
					   		wname.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wname").focus();
							return false;
					   }
					   if(wname.value.length<2||wname.value.length>20){
					   		alert("用户名称必须在2-20个字符之间!");
					   		wname.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wname").select();
							return false;
					   }	
					   var wcall=form.wcall;
					   if(wcall.value==""){
					   		alert("员工昵称不能为空!");
					   		wcall.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wcall").focus();
							return false;
					   }
					   if(wcall.value.length<5||wname.value.length>20){
					   		alert("员工昵称必须在5-20个字符之间!");
					   		wcall.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wcall").select();
							return false;
					   }
					   var wpwd=form.wpwd;
					   if(wpwd.value==""){
					   		alert("密码不能为空!");	
					   		wpwd.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wpwd").focus();
							return false;
					   }
					   if(wpwd.value.length<6||wpwd.value.length>16){
					   		alert("密码必须是5-20个字符!");	
					   		wpwd.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wpwd").select();
							return false;
					   }
					   var wpwd1=form.wpwd1;
					   if(wpwd.value==""){
					   		alert("请输入确认密码!");	
					   		wpwd.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wpwd").focus();
							return false;
					   }
					   if(wpwd.value!=wpwd1.value){
					   		alert("两次输入密码不一致，请重新输入");	
					   		wpwd1.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
							document.getElementById("wpwd1").select();
							return false;
					   }
					   
					   var mes="请确认信息：\n\n";
					   var str="";
					   var tab=document.getElementById("w_info");
					   for(var i=0;i<tab.rows.length-2;i++){
					       str+=tab.rows[i].cells[0].childNodes[0].innerHTML+"："+tab.rows[i].cells[1].childNodes[0].value+"\n";
					   }
					   var wnote="备注："+document.getElementById("wnote").value+"\n";
					   
					   if(confirm(mes+str+wnote))
					   	   return true;
					   else
						   return false;
					}
                    
  			</script>
		</form>

	</body>
</html>
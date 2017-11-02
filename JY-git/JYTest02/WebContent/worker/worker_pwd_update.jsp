<%@page import="cn.jy.entity.Workerinfo"%>
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
<title>员工密码修改</title>
</head>
<style type="text/css">
.font_word_title{
	font-family: 微软雅黑;
	font-size: 32px;
	font-weight: normal;
}
#w_info input{
		width:200px;
		height:28px;
		margin:0 30px 0 10px;
}
#w_info span{
		font-family: 微软雅黑;
		font-size: 13px;
		font-weight: normal;
		color:#ddd;'
}
#w_info select{
		width:100px;
		height:30px;
		margin-left:10px;
}
label{
		font-family: 微软雅黑;
		font-size: 13px;
		font-weight: normal;
}
</style>

<body>
<% 
	Workerinfo		info	=	(Workerinfo ) session.getAttribute("user");
	session.setAttribute("user", info);  
%>

		<div class="ui form" style="margin-left:20px;margin-top:10px;">
		  <h4 class="ui dividing header">用户密码修改</h4>
		  	<table id="w_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:0px 15px; ">
				<tr>
				   <td><label>原始密码</label></td>
				   <td><input type="password" placeholder="原始密码" id="pwd" name="pwd" maxlength="16" onblur="blur1(this)"></td>
				   <td><span> </span></td>
				</tr>
				<script language="JavaScript" type="text/javascript">
					function  blur1(btn){
    					if(btn.value==""){
    						btn.focus();
    						btn.parentNode.parentNode.cells[2].childNodes[0].innerHTML="原始密码不能为空";
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
						}
    					else
    						btn.parentNode.parentNode.cells[2].childNodes[0].innerHTML="";
					}
				</script>
		    	<tr>
				   <td><label>新密码</label></td>
				   <td><input type="password" placeholder="新密码"  name="wpwd" id="wpwd1" maxlength="16" onblur="blur2(this)"></td>
				   <td><span>6~16位的任意字符</span></td>
				</tr>
				<script language="JavaScript" type="text/javascript">
					function  blur2(btn){
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
				   <td><input type="password" placeholder="确认密码"  id="wpwd2" maxlength="16" onblur="blur3(this)"></td>
				   <td><span></span></td>
				</tr>
				<script language="JavaScript" type="text/javascript">
					function  blur3(btn){
    					if(btn.value!=document.getElementById("wpwd1").value ){
    						btn.select();
    						btn.parentNode.parentNode.cells[2].childNodes[0].innerHTML="两次输入密码需要一致";
    						btn.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
						}
    					else{
    						btn.parentNode.parentNode.cells[2].childNodes[0].innerHTML="";
    					}
					}
				</script>
			</table>
			<div class="fields" >
				    <div class="field"  style="margin-top:30px" >
						<input type="button" value="提交" class="btn btn-default" style="width:100px;margin-right:50px;" onclick="return validate();">
						<input type="reset" value="重置" class="btn btn-default" style="width:100px;margin-right:50px;" >
					</div>
		  	</div>
		  	<script language="JavaScript" type="text/javascript">
					function validate(){
					   var pwd=document.getElementById("pwd");
					   if(pwd.value==""){
					   		alert("原始密码不能为空!");
					   		pwd.parentNode.parentNode.cells[2].childNodes[0].innerHTML="原始密码不能为空";
					   		pwd.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
					   		pwd.focus();
							return false;
					   }
					   var wpwd1=document.getElementById("wpwd1");
					   if(wpwd1.value==""){
					   		alert("新密码不能为空!");	
					   		wpwd1.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
					   		wpwd1.focus();
							return false;
					   }
					   if(wpwd1.value.length<6||wpwd1.value.length>16){
					   		alert("密码必须是5-20个字符!");	
					   		wpwd1.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
					   		wpwd1.select();
							return false;
					   }
					   var wpwd2=document.getElementById("wpwd2");
					   if(wpwd2.value==""){
					   		alert("请输入确认密码!");	
					   		wpwd2.focus();
							return false;
					   }
					   if(wpwd2.value!=wpwd1.value){
					   		alert("两次输入密码不一致，请重新输入");	
					   		wpwd2.select();
							return false;
					   }
					   
					   if(confirm("确认修改？")){
						   pwd_update();
					   }
					   else
						   return false;
					}
					function pwd_update(){
                		var wid='<%=info.getWid() %>';
                		var pwd = document.getElementById("pwd");
                		var wpwd = document.getElementById("wpwd1").value;
	                		$.ajax({  
	                			url: "../../JYTest02/worker?operType=2&wid="+wid+"&pwd="+pwd.value+"&wpwd="+wpwd,  
	                			type: 'GET',  
	                		 	async: true,  
	                			cache: false,  
	                		 	processData: false,  
	                			success: function (returndata) {
	                				var obj=JSON.parse(returndata);
	                				var message=obj[0]['message'];
	                				if(message=="原始密码错误！") {
	                					pwd.parentNode.parentNode.cells[2].childNodes[0].innerHTML=message;
	                					pwd.parentNode.parentNode.cells[2].childNodes[0].style.color="#CD0000";
	                					alert(message);
	                					pwd.select();
	                				}
	                				else{
	                					pwd.parentNode.parentNode.cells[2].childNodes[0].innerHTML="";
	                					alert(message);
	                				}
	                		  	},  
	                			error: function (returndata) {  
	                		  	}  
	                		});  
                	}
  			</script>
		</div>
	</body>
</html>
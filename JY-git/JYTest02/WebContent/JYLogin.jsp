﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/skin_/JYlogin.css">
	<link rel="stylesheet" type="text/css" href="css/semantic/icon.css">
	<link rel="stylesheet" type="text/css" href="css/semantic/semantic.min.css">
	<link rel="stylesheet" type="text/css" href="css/semantic/semantic.css">
	<script src="js/jquery-3.1.0.min.js"></script>
	<script src="js/semantic.min.js"></script>
  </head>
  	 <%
  			String message="";
  	 		if(session.getAttribute("message")!=null)
	  			message=(String)session.getAttribute("message");
  	 		System.out.println(message);
	 %>
  <script type="text/javascript">
	  	window.onload=function(){
		  	var message='<%=message %>';
		  	if(message!="")
		  		alert(message);
	  	}
  		function refreshCode() {
			var refreshIndex = Math.random();
			window.document.getElementById("imgCode").src="code.jhtml?" + refreshIndex;
	   }
  </script>
 	 <%
	  		session.setAttribute("message","");
	 %>
  <body>
  <div id="bg" >
 	 <div id="main"  style="z-index:100">
 	     
    	<form id="form"	 name="form" method="get" action="user_info" onsubmit="return validate()">
			  <img src="img/skin_/JY_logo.png"> 
			  <input type="hidden" name="operid" value="1">
		  <table > 
           	<tr align="center"><td>
	           	<div class="ui left icon input" style="margin-left:35px">
				  <input type="text" placeholder="请输入用户名" name="wid"  id="name" maxlength="20" onfocus="clearText()" onblur="blur1()" >
				  <i class="user icon"></i>
				</div>
			</td></tr>

				<script language="JavaScript" type="text/javascript">
					function clearText(){
					    var name=document.getElementById("name");
						if(name.value=="请输入用户名"){
							name.value="";
					  	}	
					}
					function  blur1(){
						var name=document.getElementById("name");
						var divID=document.getElementById("DivName");
   				 		divID.innerHTML="";
    					if(name.value==""){
							name.value="请输入用户名";
       					  	divID.innerHTML="用户名不能为空";
        					return false;
						}
					}
				</script>
			<tr height="20px"><td ><div id="DivName" class="error"></div></td></tr>
      		<tr align="center"><td>
	           	<div class="ui left icon input" style="margin-left:35px">
				  <input name="wpwd" type="password" id="psword" maxlength="20" onblur="blur2()"  >
				  <i class="privacy  icon"></i>
				</div>
			</td></tr>
      		
<!--       		<tr> -->
<!--         	 <td><span class="STYLE5"> -->
<!--                 <label> -->
<!--                 <div align="center">密码:</div> -->
<!--                 </label> -->
<!--               </span></td> -->
<!--               <td><input name="psword" type="password" id="psword" maxlength="20" onblur="blur2()" /></td> -->
<!-- 		    </tr> -->
				 <script language="JavaScript" type="text/javascript">
					function  blur2(){
						var pass=document.getElementById("psword");
						var divID=document.getElementById("DivPass");
   				 		divID.innerHTML="";
    					if(pass.value==""){
       					  	divID.innerHTML="密码不能为空";
        					return false;
						}
					}
				</script>
        
	 		<tr height="20px"><td><div id="DivPass" class="error"></div></td></tr>
	 		<tr align="center">
	 			<td>	
	 				<div class="code" style=" height:45px;width:auto">
	 					<img onclick="refreshCode();" id="imgCode" title="看不清楚?点我换一张" src="code.jhtml" style="width:150px;height:41px;margin:0 20 0 50px;"/>
		 				<input type="text" name="code" id="code" placeholder="验证码"  maxlength="4" style="width:100px;float:left" >
		 			</div>
				</td>
			</tr>
            <tr>
              <td> 
                <button type="submit" name="Submit" style="height:40px;width:300px;margin-left:38px;margin-top:20px" class="ui google plus button">登录</button>
<!--                   <input type="submit" name="Submit" value="登      录" style="border:2px double #aaa; height:30px;margin-top:5px"/> -->
				  <script language="JavaScript" type="text/javascript">
					function validate(){
					   var name=form.name;
					   if(name.value==""){
					   		alert("用户名不能为空!");
							name.style.borderColor="red";	
							document.getElementById("name").focus();
							return false;
					   }
					   if(name.value.length<3){
					   		alert("用户名必须在3-20个字符之间!");
							name.style.borderColor="red";	
							document.getElementById("name").select();
							return false;
					   }	
					   var password=form.psword;
					   if(password.value==""){
					   		alert("密码不能为空!");	
							password.style.borderColor="red";
							document.getElementById("psword").focus();
							return false;
					   }
					   if(password.value.length<5){
					   		alert("密码必须是5-20个字符!");	
							password.style.borderColor="red";
							document.getElementById("psword").select();
							return false;
					   }
					   var code=form.code;
					   if(code.value==""){
					   		alert("验证码不能为空!");	
					   		code.style.borderColor="red";
							document.getElementById("code").focus();
							return false;
					   }
					   return true;
					}
                    
  			</script>
              </td>
            </tr>
          </table>
		  </form>
	  </div>
	</div>
  </body>
</html>

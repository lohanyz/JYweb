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
<title>员工信息的详情</title>
</head>
<style type="text/css">
	.font_word_title{
		font-family: 微软雅黑;
		font-size: 32px;
		font-weight: normal;
	}
	#w_info input{
			width:140px;
			height:28px;
			margin:0 30px 0 10px;
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
	th{
 		font-family: 黑体;
		font-size: 14px;
 		text-align:center;
 	}
 	#p_info tbody tr td input{
		text-align:center;
		left:30%;
	}
	#p_info .checkbox{
		width:12px;
		height:12px;
	}
</style>

<body>
<% 
	//	单个成员;
	ArrayList<Workerinfo> list	=	(ArrayList<Workerinfo>) session.getAttribute("listWorker");
	
	//	每行信息;
	Workerinfo			  info	=	list.get(0);
	
%>
<%
// 	String message=(String)session.getAttribute("message");
// 	if(!message.equals("")){
%>
<!-- <script type="text/javascript"> -->
<%-- 		alert("<%=message%>"); --%>
<!-- </script> -->
<% 
//  	}
// 	else {
// 		session.setAttribute("message",null);
// 	}
%>

<form action="../../JYTest02/user_info" method="get">
	<input type="hidden" name="operid" value="9">
		<div class="ui form" style="margin-left:30px;margin-top:10px;">
		  <h4 class="ui dividing header">用户详细信息</h4>
		  	<table id="w_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 25px; ">
				<tr>
				   <td><label>用户编号</label></td>
				   <td><input type="text" placeholder="用户编号" value="<%=info.getWid() %>" disabled="disabled" >
				   <input type="hidden" name="wid" value="<%=info.getWid() %>"></td>
				   <td><label>用户名称</label></td>
				   <td><input type="text" placeholder="用户名称"  name="wname" value="<%=info.getWname() %>"></td>
				   <td><label>员工昵称</label></td>
				   <td><input type="text" placeholder="员工昵称"  name="wcall" value="<%=info.getWcall() %>"></td>
				</tr>
		    	<tr>
<!-- 			   <td><label>员工密码</label></td> 
 				   <td><input type="password" placeholder="员工密码"   name="wpwd" value="<%=info.getWpwd() %>"></td>   -->
<!-- 
				   <td><label>员工类型</label></td>
  				   <td><select class="ui dropdown"  name="wtype" id="wtype" disabled="disabled" >
							<option value="临时" <%if(info.getWtype().equals("临时")){%> selected="selected"<%}%>>临时</option>
							<option value="永久" <%if(info.getWtype().equals("永久")){%> selected="selected"<%}%>>永久</option>
					  </select>
				   </td>
				   -->
				   <td><label>员工类型</label></td>
  				   <td><input type="text" placeholder="员工类型"  name="wtype" value="<%=info.getWtype() %>" disabled="disabled" ></td>
				</tr>
				<tr>
			   <td><label style="width:100%;padding:10px 0px 0px  0px;">权限范围</label></td>
		    </tr>
			<tr>
			   <td colspan="8">
			   	<div style="width:100%;padding:0px 0px 10px 10px;border-collapse:separate;border-spacing: 0px 0px; ">
			  		<table id="p_info"  class="table table-bordered" style="width:100%;margin: 0px 0px  0px 0px;border-collapse:separate;border-spacing: 0px 0px; ">
	        		 	 <thead align="center">
								<tr align="center" style="text-align:center;">
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
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled" /></td>
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled"/></td>
									<td><input type="checkbox" class="checkbox"  name="permission" disabled="disabled"/></td>
								</tr>
							</tbody>
					</table>
					<script type="text/javascript">
				    	var checkboxs = document.getElementsByName("permission");
				    	var permission='<%=info.getWpermission()%>';
	    				for(var i=0;i<checkboxs.length;i++)
	    					if(permission.substring(i,i+1)=="1") 
	    						checkboxs[i].checked=true;
					</script>
				</div>
			   </td>
			</tr>
		    	<tr>
				   <td><label>备注</label></td>
				</tr>
		    	<tr>
				   <td colspan="4"><textarea  name="wnote" ><%=info.getWnote()%></textarea> </td>
				</tr>
			</table>
			<div class="fields" >
				    <div class="field"  style="margin-top:30px" >
						<input type="submit" value="修改" class="small ui button" style="width:100px;margin-right:50px;" >
						<input type="reset" value="重置" class="small ui button" style="width:100px;margin-right:50px;" >
					    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  	</div>
		</div>
</form>
	</body>
</html>
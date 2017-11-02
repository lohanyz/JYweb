<%@page import="cn.jy.entity.Workerinfo"%>
<%@ page import="java.util.ArrayList"%>
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
		font-size: 18px;
		font-weight: normal;
	}
	label{
			font-family: 微软雅黑;
			font-size: 13px;
			font-weight: normal;
		}
	#w_info input{
			width:140px;
			height:28px;
			margin:0 30px 0 10px;
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

	<div class="ui form" style="margin-left:20px;margin-top:10px;">
	  <h4 class="ui dividing header">用户详细信息</h4>
	  	<table id="w_info" style="margin:0 0 0 0px;border-collapse:separate;border-spacing:10px 25px; ">
			<tr>
			   <td><label>用户编号</label></td>
			   <td><input type="text" placeholder="用户编号"  disabled="disabled" value="<%=info.getWid() %>"></td>
			   <td><label>用户名称</label></td>
			   <td><input type="text" placeholder="用户名称" disabled="disabled" value="<%=info.getWname() %>"></td>
			   <td><label>员工昵称</label></td>
			   <td><input type="text" placeholder="员工昵称" disabled="disabled" value="<%=info.getWcall() %>"></td>
			</tr>
			<tr>
<!-- 			   <td><label>员工密码</label></td> -->
<%-- 			   <td><input type="password" placeholder="员工密码" disabled="disabled" value="<%=info.getWpwd() %>"></td> --%>
			   <td><label>员工类型</label></td>
			   <td><input type="text"  disabled="disabled" value="<%=info.getWtype() %>"></td>
			</tr>
			<tr>
			   <td><label style="width:100%;padding:20px 0px 0px  0px;">权限范围</label></td>
		    </tr>
			<tr>
			   <td colspan="8">
			   	<div style="width:100%;padding:0px 0px 0px 10px;border-collapse:separate;border-spacing: 0px 0px; ">
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
			   <td colspan="4"><textarea  name="wnote" disabled="disabled" ><%=info.getWnote() %></textarea></td>
			</tr>
			
		</table>
		<div class="fields" >
			    <div class="field" style="margin-top:30px" >
				    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="go_back();">
				</div>
	  	</div>
	</div>
	</body>
	<script type="text/javascript">
		function go_back(){
			location.href="../user_info?operid=2";
		}
	</script>
</html>
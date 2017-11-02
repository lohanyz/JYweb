<%@page contentType="text/html; charset=Utf-8"%>
<%@page import="java.util.*" %>
<%@page import="cn.jy.entity.Resigninfo"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE HTML PUBLIC "-//W3C//dtD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/skin_/index.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/jquery-ui-1.9.2.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="../css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<title>全部提货信息</title>
<%
	ArrayList<Resigninfo> list 			= 	(ArrayList<Resigninfo>) session.getAttribute("listResign");
	String 				  pageCurrent	=	(String)session.getAttribute("pageCurrent");
	String 				  searchvalue	=	(String)session.getAttribute("searchvalue");
	int 				  nPageCurrent	=	Integer.parseInt(pageCurrent)+1;
%>
</head>
<style type="text/css">  
	.loadpagediv{  
	    width:460px;  
	    height:400px;  
	    position: absolute;  
	    position: absolute;  
	    background-color: #aaa;  
	    z-index:9999;  
	}  
</style>
<script type="text/javascript">

	var id = setTimeout('loadPage()',1000);  
	function loadPage() {  
	 // 取得文档载入状态，如果载入完成，则readystate='complete'  
 	 // 根据这个可以定时去获取文档载入状态，来实现页面载入等待效果  
	 	var readystate = document.readyState.toLowerCase();  
            if (readystate == 'complete')  
            {  
                clearTimeout(id);  
                document.getElementById('loadpagediv').style.display =  "none";  
            }  
            else {  
                document.getElementById('loadpagediv').style.display =  "block";  
                id = setTimeout('loadPage()',1000);  
            }  
  
        }  
</script>
<body>
<div id="container">

    <div id="bd">
    	<div id="main">
    	  <div class="search-box ue-clear" >
	    	  	<div id="loadpagediv" class="loadpagediv" style="width:100%;height:500px;background-color: #fff;position: absolute;z-index:9999;"> 
					 	<div class="ui active centered inline loader" style="top:60px;">
					 		<div class="ui text loader"></div>
					 	</div>
				</div> 
                <div class="grid" id="grid"  style="margin:-10px 0 0 0;">
                		<input type="button" class="btn btn-default btn-sm " id="checkAll" style=" width:60px; margin-right:10px" value="全选" onclick="check_all();">
                		<input type="button" class="btn btn-default btn-sm " id="deleteChecked" style=" width:60px; " value="删除" onclick="delete_checked();">
						<table  class="table table-hover" style="margin:10px 0 0 0;">
							<thead align="center">
								<tr align="center">
									<th>&nbsp;&nbsp;</th>
									<th>签收ID</th>
									<th>业务编号</th>
									<th>货物编号</th>
									<th>状态</th>
									<th colspan="3">操作 </th>
								</tr>
							</thead>
							<tbody align="center">
								<%
									if (list!= null) {
										int nSize=list.size();
					
											for (int i = 0; i < nSize; i++) {
								%>
								<tr align="center">
									<td><input type="checkbox" id="cbItem" name="cbItem"
										value="<%=list.get(i).getRid()%>" /></td>
									<td ><%=list.get(i).getRid()%></td>
									<td ><%=list.get(i).getBid() %></td>
									<td ><%=list.get(i).getGid() %></td>
									<td ><%=list.get(i).getState()%></td>
   									<td ><a href="../../JYTest02/resign_info?operid=3&rid=<%=list.get(i).getRid()%>" title="查看">
										<i class="large grey content icon"></i>
									</a></td>
									<td ><a href="../../JYTest02/resign_info?operid=5&rid=<%=list.get(i).getRid()%>" title="修改">
										<i class="large grey edit icon"></i>
									</a></td>
									<td ><a href="javascript:if(confirm('确认删除吗?'))window.location='../../JYTest02/resign_info?operid=4&rid=<%=list.get(i).getRid()%>&bid=<%=list.get(i).getBid()%>&gid=<%=list.get(i).getGid()%>&pageCurrent=<%=pageCurrent %>&searchvalue=<%=searchvalue%>'" title="删除">
										<i class="large grey trash outline icon"></i>
									</a></td>
								</tr>
								<%
									}
								}
								%>
							</tbody>
						</table>
<%-- 							第<%=nPageCurrent%>页&nbsp;&nbsp;/共<%=nPageCurrent%>页&nbsp;&nbsp;&nbsp;&nbsp; --%>
								第<%=nPageCurrent%>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							跳转到第&nbsp;&nbsp;<input type="text" name="goto_page" id="goto_page" style="width:50px">&nbsp;&nbsp;页&nbsp;&nbsp;
							<input type="button" class="btn btn-default btn-sm " style=" width:60px; " value="跳转" onclick="goto_page();">
						<script type="text/javascript">
							function goto_page(){
								var goto_page=document.getElementById("goto_page");
								if(goto_page.value==""){
									alert("请输入跳转页码");
									goto_page.focus();
								}
								else{
									if(isNaN(goto_page.value)){
										alert("页码格式不正确，请重新输入！");
										goto_page.select();
									}
									else
										location.href="../../JYTest02/resign_info?operid=12&pageCurrent="+goto_page.value+"&searchvalue=<%=searchvalue%>";
								}
							}
						
						</script>
						
						<input type="button" class="btn btn-default btn-sm " style="float:right;width:100px;margin-right:40px" value="下页" onclick="javascript:location.href='../../JYTest02/resign_info?operid=11&pageCurrent=<%=pageCurrent %>&searchvalue=<%=searchvalue%>'">
						<% 
							if(nPageCurrent>1){
						%>
						<input type="button" class="btn btn-default btn-sm " style="float:right;width:100px;margin-right:20px" value="上页" onclick="javascript:location.href='../../JYTest02/resign_info?operid=10&pageCurrent=<%=pageCurrent %>&searchvalue=<%=searchvalue%>'">
					     <%}
						%>           	
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

<script type="text/javascript">
	var minwidth = 282;
	resizeWidth();
	$(top.window).resize(function(e) {
       resizeWidth();
    });
	$(function() {
		$( ".content-list" ).sortable({
		  revert: true,
		  handle:'h2'
		});
		
	});
	
 
	function resizeWidth (){
		if($('#main').width() / 3 < minwidth){
			$('.content-item').width(($('#main').width() / 2) - 15);
		}else{
			$('.content-item').width(($('#main').width() / 3) - 15);	
		}
	}
	
	function check_all() {  
		  var checkall = document.getElementById("checkAll");  
		  var checkboxs = document.getElementsByName("cbItem");  
		  var len=checkboxs.length;
		  if(checkall.value=="全选"){
			   for ( var i = 0; i <  len  ; i+=1)
					checkboxs[i].checked =true;  
			   checkall.value="全不选";
		  }
		  else{
			   for ( var i = 0; i < len; i+=1)
					checkboxs[i].checked =false;  
		 	   checkall.value="全选";
		  }
	}  
	
	function delete_checked(){
		var checkboxs = document.getElementsByName("cbItem");
		var id ="";  
		for ( var i = 0 ; i < checkboxs.length; i++)
			if(checkboxs[i].checked){
				id+=checkboxs[i].value+",";
			}
		id=id.substring(0,id.length-1);
		if(confirm("确认删除这"+id.split(",").length+"项纪录？")){
			location.href="../resign_info?operid=7&id="+id+"&pageCurrent="+"<%=pageCurrent %>"+"&searchvalue="+"<%=searchvalue%>";
			return true;
		}
		else
			return false;
	}
	
	
</script>
</html>

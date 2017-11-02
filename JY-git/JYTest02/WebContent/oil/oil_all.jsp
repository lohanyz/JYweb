<%@page contentType="text/html; charset=Utf-8"%>
<%@page import="java.util.*" %>
<%@page import="cn.jy.entity.Oilinfo"%>
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
<title>全部用户</title>
<%
	ArrayList<Oilinfo> list 			= 	(ArrayList<Oilinfo>) session.getAttribute("listOil");
	String 				  pageCurrent	=	(String)session.getAttribute("pageCurrent");
	int 				  nPageCurrent	=	Integer.parseInt(pageCurrent)+1;
	String 				  kindName		=	(String)session.getAttribute("kindName");
	String				  kindValue		=	(String)session.getAttribute("kindValue");
%>
</head>
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
	<div id="hd">
    </div>
    <div id="bd">
    	<div id="main">
    	  <div class="search-box ue-clear">
    	  		<div id="loadpagediv" class="loadpagediv" style="width:100%;height:500px;background-color: #fff;position: absolute;z-index:9999;"> 
					 	<div class="ui active centered inline loader" style="top:60px;">
					 		<div class="ui text loader"></div>
					 	</div>
				</div> 
                <div class="grid">
						<table  class="table table-hover" >
							<thead align="center">
								<tr align="center">
									<th>&nbsp;&nbsp;</th>
									<th>油控时间</th>
									<th>主车编号</th>
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
										value="<%=list.get(i).getOid()%>" /></td>
									<td ><%=list.get(i).getOtime() %></td>
									<td ><%=list.get(i).getTid()%></td>
									<td ><input type="button" value="详情" class="btn btn-default btn-sm"
										onclick="javascript:location.href='../../JYTest02/oil_info?operid=3&id=<%=list.get(i).getId()%>'" /></td>
									<td ><input type="button" value="修改" class="btn btn-default btn-sm"
										onclick="javascript:location.href='../../JYTest02/oil_info?operid=5&id=<%=list.get(i).getId()%>'"/></td>
									<td ><input type="button" value="删除" class="btn btn-default btn-sm"
										onclick="javascript:location.href='../../JYTest02/oil_info?operid=4&id=<%=list.get(i).getId()%>'" /></td>
								</tr>
								<%
									}
								}
								%>
							</tbody>
						</table>
							第<%=nPageCurrent%>页&nbsp;&nbsp;/共<%=nPageCurrent%>页&nbsp;&nbsp;&nbsp;&nbsp;
							跳转到第&nbsp;&nbsp;<input type="text" name="goto_page" id="goto_page" style="width:50px">&nbsp;&nbsp;页&nbsp;&nbsp;
							<input type="button" class="btn btn-default btn-sm " style=" width:60px; " value="跳转" onclick="goto_page();">
						<script type="text/javascript">
							function goto_page(){
								var goto_page=document.getElementById("goto_page").value;
								if(isNaN(goto_page)){
									alert("页码格式不正确，请重新输入！");
									location.reload;
								}
								else
									location.href="../../JYTest02/oil_info?operid=12&pageCurrent="+goto_page+"&kindName=<%=kindName%>&kindValue=<%=kindValue%>";
							}
						
						</script>
						
						<input type="button" class="btn btn-default btn-sm " style="float:right;width:100px;margin-right:40px" value="下页" onclick="javascript:location.href='../../JYTest02/oil_info?operid=11&pageCurrent=<%=pageCurrent %>&kindName=<%=kindName%>&kindValue=<%=kindValue%>'">
						<% 
							if(nPageCurrent>1){
						%>
						<input type="button" class="btn btn-default btn-sm " style="float:right;width:100px;margin-right:20px" value="上页" onclick="javascript:location.href='../../JYTest02/oil_info?operid=10&pageCurrent=<%=pageCurrent %>&kindName=<%=kindName%>&kindValue=<%=kindValue%>'">
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
</script>
</html>

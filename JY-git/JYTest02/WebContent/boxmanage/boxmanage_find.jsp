<%@page import="cn.jy.entity.Workerinfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<link rel="stylesheet" type="text/css" href="../css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="../css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="../css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="../css/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="../css/semantic/semantic.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/semantic.min.js"></script>
<title>精确查询</title>
</head>
<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
        	<div class="search-box ue-clear">
        		 <form action="../../JYTest02/boxmanage_info?operid=6" method="post"  target="sResult">
						<label>查询条件:</label>&nbsp;&nbsp;&nbsp;
					    <select class="ui dropdown" style="width:120px" name="kindName">
							  <option value="bid">业务编号</option>
							  <option value="bmid">箱管理ID</option>
							  <option value="transtid">换装车号</option>
							  <option value="getboxspace">提箱地</option>
						</select>&nbsp;&nbsp;&nbsp;
						<div class="ui input">
						  <input type="text" placeholder="请输入..." id="sInfo" name="kindValue">
						</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 		<input type="submit" class="btn btn-default" value="搜索一下" onclick="return search();"/>
                <script type="text/javascript">
                	function search(){
                		var sInfo=document.getElementById("sInfo").value;
                		if(!sInfo||sInfo.equals("请输入...")){
                			alert("请输入查询信息！");
                			location.reload;
                			return false;
                		}
                		return true;
                	}
                </script>
                
                </form>
                
                <iframe name="sResult" src=""  width="1150"  height="500"></iframe>
                
                
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

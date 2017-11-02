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
<title>分类查询</title>
<style>
#skind select { 
	background: transparent; 
	padding: 5px; 
	font-size: 14px; 
	border: 1px solid #ccc; 
	height: 34px;
	width:150px;
	margin-right:20px;
</style>
</head>
<body>
<div id="container">
	<div id="hd"></div>
    <div id="bd">
    	<div id="main">
        	<div class="search-box ue-clear">
        		 <form action="../../JYTest02/getgoods_info?operid=13" method="post"  target="sResult">
        		 <div id="skind"> 
						<label >查询类型:</label>&nbsp;&nbsp;&nbsp;
                 		<input type="submit" class="btn btn-default" value="搜索一下" onclick="return search();" style="float:right;margin-right:600px"/>
                </div>
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
<script type="text/javascript">
 var value = [
		{
			"id": "lkind","kind": "运输方式", "value": [
				{ "kind": "汽运", "name": "trunk"},
				{ "kind": "铁路", "name": "railway"}
			]
		},
		{
			"id": "stime","kind": "xxx", "value": [
				{ "kind": "异常", "name": "exception"},
				{ "kind": "正常", "name": "normal"},
			]
		}
];
	var kindName = document.createElement("select");
	var kindValue = document.createElement("select");
	var skind = document.getElementById("skind");
	kindName.name="kindName";
	kindValue.name="kindValue";
	skind.appendChild(kindName);
	skind.appendChild(kindValue);
	kindName.options[0] = new Option("请选择");
	kindValue.options[0] = new Option("请选择");
	
	for (var i = 0; i < value.length; i++) {
		kindName.options[kindName.length] = new Option(value[i].kind,value[i].id);
		
		kindName.onchange = function(){
			kindValue.options.length = 0;
			kindValue.options[kindValue.length] = new Option("请选择");
			for (var j = 0; j < value[kindName.selectedIndex-1].value.length; j++) {
				kindValue.options[kindValue.length] = new Option(value[kindName.selectedIndex-1].value[j].kind,value[kindName.selectedIndex-1].value[j].name);
			}
			
		}
	};

</script>
</html>

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
</style>

<body>
<form action="../../JYTest02/goods_info" method="get">
	<input type="hidden" name="operid" value="8">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">添加货物信息</h4>
		  <div class="fields">
	  			<div class="field">
			      <label>业务编号</label>
			      <input type="text" name="bid"  placeholder="业务编号">
			    </div>
			    <div class="field">
			      <label>商品编号</label>
			      <input type="text" name="gid"  placeholder="商品编号">
			    </div>
			    <div class="field">
			      <label>商品名称</label>
			      <input type="text"  name="gname"  placeholder="商品名称">
			    </div> 
	    </div>
		<div class="fields">
				 <div class="field">
			      <label>箱号</label>
			      <input type="text" name="boxid"  placeholder="箱号" >
			    </div>
			     <div class="field">
			      <label>箱型</label>
			      <input type="text" name="boxkind"  placeholder="箱型" >
			    </div>
			     <div class="field">
			      <label>尺寸</label>
			      <input type="text" name="boxsize"   placeholder="尺寸">
			    </div>
		</div>
		<div class="fields">
				 <div class="field">
			      <label>铅封号</label>
			      <input type="text" name="leadnumber"  placeholder="铅封号">
			    </div>
			    <div class="field">
			      <label>件数</label>
			      <input type="text" name="gcount"  placeholder="件数">
			    </div>
			     <div class="field">
			      <label>单位</label>
			      <input type="text" name="gunit"  placeholder="单位">
			    </div>
			     <div class="field">
			      <label>总毛重</label>
			      <input type="text" name="gtotalweight"  placeholder="总毛重">
			    </div>
		</div>
		<div class="inline fields">
				 <div class="field">
			      <label>长</label>
			      <input type="text" name="glength" id="length" style="width:70px;" onchange="edit()"  placeholder="长">&nbsp;x
			    </div>
			    <div class="field">
			      <label>宽</label>
			      <input type="text" name="gwidth" id="width"  style="width:70px;" onchange="edit()"  placeholder="宽">&nbsp;x
			    </div>
			     <div class="field">
			      <label>高</label>
			      <input type="text" name="gheight" id="height" style="width:70px;" onchange="edit()" placeholder="高">&nbsp;=
			    </div>
			     <div class="field">
			      <label>体积</label>
			      <input type="text" id="volume1"  disabled="disabled"  style="width:100px;" placeholder="体积">
			      <input type="hidden" name="gvolume" id="volume2">
			    </div>
		</div>
		<script type="text/javascript">
			function edit(){
				var length=document.getElementById("length").value;
				var width=document.getElementById("width").value;
				var height=document.getElementById("height").value;
				var volume=parseInt(length)*parseInt(width)*parseInt(height);
				document.getElementById("volume1").value=volume;
				document.getElementById("volume2").value=volume;
			}
		</script>
			<div class="fields" >
				    <div class="field"  style="margin-top:30px" >
						<input type="submit" value="提交" class="small ui button" style="width:100px;margin-right:50px;" >
						<input type="reset" value="重置" class="small ui button" style="width:100px;margin-right:50px;" >
					    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  	</div>
		</div>
</form>

	</body>
</html>
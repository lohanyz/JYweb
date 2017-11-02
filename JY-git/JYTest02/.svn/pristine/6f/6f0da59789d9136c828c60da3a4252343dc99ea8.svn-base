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
<form action="../../JYTest02/problem_info" method="get">
	<input type="hidden" name="operid" value="8">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">添加追踪信息</h4>
			    <div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text" name="bid" placeholder="业务编号" >
						    </div>
							<div class="field">
						      <label>员工编号</label>
						      <input type="text" name="wid" placeholder="员工编号">
						    </div>
						    <div class="field">
						      <label>员工名称</label>
						      <input type="text"  name="wname" placeholder="员工名称">
						    </div>
					</div>
			  		<div class="fields">
						    <div class="field">
						      <label>操作类型</label>
						      <select class="ui dropdown" style="width:180px" name="poper" id="poper">
								<option value="port" >港口操作</option>
								<option value="sign" >签收操作</option>
						  	  </select>    
						    </div>
							<div class="field">
						      <label>提交城市</label>
						      <input type="text" name="pcity" placeholder="提交城市">
						    </div>
						    <div class="field">
						      <label>提交时间</label>
						      <input type="text"  name="ptime"  style="width:200px;" placeholder="提交时间">
						    </div>
					</div>
					
						<div class="fields">
						    <div class="field">
						      <label>事件状态</label>
								<select class="ui dropdown" style="width:180px" name="pstate" id="pstate">
									<option value="normal" >正常</option>
									<option value="exception" >异常</option>
							    </select>    
						    </div>
							<div class="field">
						      <label>异常信息</label>
						      <textarea name="pexception" style="width:400px;"> </textarea>
							</div>
						    </div>
						</div>
				<div class="fields" >
				    <div class="field"  style="margin-top:30px;margin-left:30px" >
						<input type="submit" value="提交" class="small ui button" style="width:100px;margin-right:50px;" >
						<input type="reset" value="重置" class="small ui button" style="width:100px;margin-right:50px;" >
					    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  		</div>
		</form>

	</body>
</html>
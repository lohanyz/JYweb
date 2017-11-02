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
<form action="../../JYTest02/boxmanage_info" method="get">
	<input type="hidden" name="operid" value="8">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">添加箱管理信息</h4>
			    <div class="fields">
						    <div class="field">
						      <label>业务编号</label>
						      <input type="text"  placeholder="业务编号" name="bid">
						    </div>
							<div class="field">
						      <label>ID</label>
						      <input type="text" placeholder="箱管理ID" name="bmid">
						    </div>
						    <div class="field">
						      <label>状态</label>
						      <input type="text" placeholder="状态信息" name="state">
						    </div>
					</div>
					
			  		<div class="fields">
							<div class="field">
						      <label>提箱地</label>
						      <input type="text"  placeholder="提箱地" name="getboxspace">
						    </div>
						    <div class="field">
						      <label>提箱时间</label>
						      <input type="text" placeholder="提箱时间" name="getboxtime" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>返回中方口岸时间</label>
							  <input type="text"  placeholder="返回中方口岸时间" name="backchnportime">
						    </div>
						     <div class="field">
						      <label>返回口岸库房时间</label>
						      <input type="text" placeholder="返回口岸库房时间" name="backportstorehoustime" >
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>口岸换装时间</label>
								<input type="text"  placeholder="口岸换装时间" name="portranstime">
						    </div>
							<div class="field">
						      <label>换装车号</label>
						      <input type="text" placeholder="换装车号" name="transtid">
						    </div>
					</div>
					<div class="fields">
						    <div class="field">
						      <label>下线结费时间</label>
								<input type="text"  placeholder="下线结费时间" name="downlineovertime">
						    </div>
							<div class="field">
						      <label>铁路下线时间</label>
						      <input type="text" placeholder="铁路下线时间" name="railwaydownlinetime">
						    </div>
						    <div class="field">
						      <label>实际回空时间</label>
						      <input type="text" placeholder="实际回空时间" name="fbacknulltime">
						    </div>
					</div>
				<div class="fields" >
				    <div class="field"  style="margin-top:30px;margin-left:30px" >
						<input type="submit" value="提交" class="small ui button" style="width:100px;margin-right:50px;" >
						<input type="reset" value="重置" class="small ui button" style="width:100px;margin-right:50px;" >
					    <input type="button" value="返回" class="small ui button" style="width:100px" onclick="javascript:history.go(-1)">
					</div>
		  		</div>
		  	</div>
		</form>

	</body>
</html>
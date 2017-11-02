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
<form action="../../JYTest02/oil_info" method="get">
	<input type="hidden" name="operid" value="8">
		<div class="ui form" style="margin-left:30px;margin-top:20px;">
		  <h4 class="ui dividing header">添加卡车信息</h4>
			   <div class="fields">
			    	<div class="field">
				      <label>加油类型</label>
				  	  <select class="ui dropdown" style="width:180px" name="okind" id="okind">
							<option value="gas"  >汽油</option>
							<option value="diesel" >柴油</option>
					  </select>
				    </div> 
				    <div class="field">
				      <label>加油编号</label>
				      <input type="text" name="oid" placeholder="加油编号">
				    </div>
					<div class="field">
				      <label>油量</label>
				      <input type="text" name="oliter" placeholder="油量">
				    </div>
				    <div class="field">
				      <label>金额</label>
				      <input type="text"  name="omoney" placeholder="金额">
			    	</div>
				</div>
				<div class="fields">
						<div class="field">
					      <label>付款方式</label>
					   	  <select class="ui dropdown" style="width:180px" name="opayway" id="opayway">
								<option value="cash"  >现金</option>
								<option value="card" >刷卡</option>
						  </select>    
						</div>
					    <div class="field">
					      <label>加油城市</label>
					      <input type="text"  name="ocity" placeholder="加油城市">
					    </div>
					    <div class="field">
					      <label>加油时间</label>
					      <input type="text" name="otime" placeholder="加油时间">
					    </div>
				</div>
				<div class="fields">
					    <div class="field">
					      <label>油卡编号</label>
					      <input type="text"   name="ocardid" placeholder="油卡编号">
					    </div>
						<div class="field">
					      <label>油卡余额</label>
					      <input type="text"  name="olmoney" placeholder="油卡余额">
					    </div>
					    <div class="field">
					      <label>行驶里程</label>
					      <input type="text" name="omile" placeholder="行驶里程">
					    </div>
				</div>
				<div class="fields">
					    <div class="field">
					      <label>主车编号</label>
					      <input type="text" name="tid" placeholder="主车编号">
					    </div>
						<div class="field">
					      <label>员工编号</label>
					      <input type="text" name="wid" placeholder="员工编号">
					    </div>
					    <div class="field">
					      <label>员工名称</label>
					      <input type="text" name="wname" placeholder="员工名称">
					    </div>
				</div>
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
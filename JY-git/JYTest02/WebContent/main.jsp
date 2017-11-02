<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.jy.entity.Workerinfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/nav.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/content.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/main.css" />
<link rel="stylesheet" type="text/css" href="css/semantic/icon.css" />
<link rel="stylesheet" type="text/css" href="css/semantic/semantic.min.css" />
<link rel="stylesheet" type="text/css" href="css/semantic/semantic.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.dialog.css" />
<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="js/semantic.min.js"></script>
<title>嘉友物流</title>
</head>
<body>
<% 
 	Workerinfo		info	=	(Workerinfo ) session.getAttribute("user");
	session.setAttribute("user", info);  
%>
<div id="container">
	<div id="hd">
    	<div class="hd-top">
    		<h1 class="logo">
    			<img src="img/skin_/JY_logo.png" /> 
    		</h1>
            <div class="setting ue-clear">
                <ul class="setting-main ue-clear">
<%--             	<li style="width:130px;"><a href="javascript:;">用户：<%=info.getWname() %> </a></li> --%>
                    <li><a href="javascript:;">设置</a></li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li><a href="javascript:;" class="close-btn exit"></a></li>
                </ul>
            </div>
        </div>
        <div class="hd-bottom">
        	<h2><i class="small list layout icon"></i><span>后台管理系统</span> </h2>
       		<div class="user-info">
       			<span>用户：<%=info.getWname() %> </span>
       		</div>
        </div>
	</div>
	<hr width="100%" size="1" color="#ddd" style="margin-top:0px;margin-bottom:0px;"/>
	<div id="bd">
    	<div class="sidebar">
        	<div class="sidebar-bg"></div>
<!--             <h2><a href="javascript:;"><i class="h2-icon" ></i><span>后台管理系统</span></a></h2> -->
            <div class="ui styled accordion" style="width:100%">
             <!--系统管理 -->
			  <div class="title"> <i class="dropdown icon"></i> 系统管理 </div>
			  <div class="content">
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i>安全管理 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="worker/worker_info.jsp" target="content">用户管理</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="worker/worker_permission.jsp" target="content">授权管理</a>
					    </p>
					  </div>
				  </div>
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i> 日志管理 </div>
					  <div class="content">
					    <p class="transition hidden">
					    <i class="file text outline icon"></i>
					    <a href="logs/logs_info.jsp" target="content">日志管理</a>
					    </p>
					  </div>
				  </div>
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i>个人信息 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="../../JYTest02/user_info?operid=5&wid=<%=info.getWid()%>" target="content">基本信息</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="worker/worker_pwd_update.jsp" target="content">修改密码</a>
					    </p>
					  </div>
				  </div>
<!-- 				  <div class="transition hidden"> -->
<!-- 				    <div class="title"><i class="dropdown icon"></i> 其它 </div> -->
<!-- 					  <div class="content"> -->
<!-- 					    <p class="transition hidden"> -->
<!-- 					    <i class="file text outline icon"></i> -->
<!-- 					    <a href="javascript:;" target="content">其它</a> -->
<!-- 					    </p> -->
<!-- 					  </div> -->
<!-- 				  </div> -->
			  </div>
			  <!--综合业务管理 -->
			  <div class="title"><i class="dropdown icon"></i> 业务管理 </div>
			  <div class="content">
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i> 提货管理 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="getgoods/getgoods_add.jsp" target="content">新增提货信息</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="getgoods/getgoods_info.jsp" target="content">提货信息管理</a>
					    </p>
					  </div>
				  </div>
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i> 港口管理 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="port/port_add.jsp" target="content">新增港口货物</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="port/port_info.jsp" target="content">港口货物信息管理</a>
					    </p>
					  </div>
				  </div>
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i> 口岸管理 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="harbor/harbor_add.jsp" target="content">新增口岸货物</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="harbor/harbor_info.jsp" target="content">口岸货物信息管理</a>
					    </p>
					  </div>
				  </div>
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i> 箱管 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="boxmanage/boxmanage_add.jsp" target="content">新增箱管信息</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="boxmanage/boxmanage_info.jsp" target="content">箱管信息管理</a>
					    </p>
					  </div>
				  </div>
				  <div class="transition hidden">
				    <div class="title"><i class="dropdown icon"></i> 签收管理 </div>
					  <div class="content">
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="resign/resign_add.jsp" target="content">新增签收信息</a>
					    </p>
					    <p class="transition hidden">
						    <i class="file text outline icon"></i>
						    <a href="resign/resign_info.jsp" target="content">签收信息管理</a>
					    </p>
					  </div>
				  </div>
			  </div>
			  <!--物流追踪-->
<!-- 			  <div class="title"><i class="dropdown icon"></i> 物流追踪 </div> -->
<!-- 			  <div class="content"> -->
<!-- 				  <div class="transition hidden"> -->
<!-- 				    <div class="title"><i class="dropdown icon"></i> xxx </div> -->
<!-- 					  <div class="content"> -->
<!-- 					    <p class="transition hidden"> -->
<!-- 						    <i class="file text outline icon"></i> -->
<!-- 						    <a href="javascript:;" target="content">xxx</a> -->
<!-- 					    </p> -->
<!-- 					    <p class="transition hidden"> -->
<!-- 						    <i class="file text outline icon"></i> -->
<!-- 						    <a href="javascript:;" target="content">xxx</a> -->
<!-- 					    </p> -->
<!-- 					  </div> -->
<!-- 				  </div> -->
<!-- 			  </div> -->
		</div>
		</div>
  		<div class="main">
            <div class="content" > 
            	 <iframe name="content" src="index.jsp"  width="100%"  height="100%"></iframe>
            </div>
		</div>
	</div>
      <!-- 最底部显示 -->
    <div id="ft" class="ue-clear">
    	<div class="ft1 ue-clear">
        	<i class="ft-icon1"></i>
            <span>嘉友物流管理系统</span>
            <em>Digital Pertal</em>
        </div>
        <div class="ft2 ue-clear">
        	<span>Call Center</span>
            <em>V2.0 2017</em>
            <i class="ft-icon2"></i>
        </div>
    </div>
</div>
<div class="exitDialog">
	<div class="content">
<!--     	<div class="ui-dialog-icon"></div> -->
        <div class="ui-dialog-text">
        	<p class="dialog-content">你确定要退出系统？</p>
            <p class="tips">如果是请点击“确定”，否则点“取消”</p>
            
            <div class="buttons">
                <input type="button" class="button long2 ok" value="确定" />
                <input type="button" class="button long2 normal" value="取消" />
            </div>
        </div>
        
    </div>
</div>
<script type="text/javascript">
	$('.ui.accordion')
	.accordion()
	;

	$('.trigger.example .accordion')
	.accordion({
	  selector: {
	    trigger: '.title .icon'
	  }
	})
	;
</script>
</body>
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.dialog.js"></script>
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript"> 
	$("#bd").height($(window).height()-$("#hd").outerHeight()-26);

	$(window).resize(function(e) {
	    $("#bd").height($(window).height()-$("#hd").outerHeight()-26);

	});

	$('.exitDialog').Dialog({
		title:'提示信息',
		autoOpen: false,
		width:400,
		height:200
	});

	$('.exit').click(function(){
		$('.exitDialog').Dialog('open');
	});

	$('.exitDialog input[type=button]').click(function(e) {
	    $('.exitDialog').Dialog('close');
		
		if($(this).hasClass('ok')){
			window.location.href = "JYLogin.jsp"	;
		}
	});
</script>
</html>
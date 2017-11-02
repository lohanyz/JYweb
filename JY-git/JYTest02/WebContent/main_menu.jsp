<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href=" css/style.css" />
<link rel="stylesheet" type="text/css" href=" css/skin_/main.css" />
<link rel="stylesheet" type="text/css" href=" css/jquery.dialog.css" />
<script type="text/javascript" src=" js/jquery.js"></script>
<script type="text/javascript" src=" js/global.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>嘉友物流管理系统</title>
</head>
<body>
<div id="container">
	<div id="hd">
    	<div class="hd-top">
    		<h1 class="logo">
    			<img src="img/skin_/JY_logo.png"> 
    		</h1>
    		
    		<!-- 原系统logo -->
<!--             <h1 class="logo"><a href="javascript:;" class="logo-icon"></a></h1> -->
            
            <!-- 用户信息   -->
<!--             <div class="user-info"> -->
<!--                 <a href="javascript:;" class="user-avatar"><span><i class="info-num">2</i></span></a> -->
<!--                 <span class="user-name">admin</span> -->
<!--                 <a href="javascript:;" class="more-info"></a> -->
<!--             </div> -->


            <div class="setting ue-clear">
                <ul class="setting-main ue-clear">
                    <li><a href="javascript:;">设置</a></li>
                    <li><a href="javascript:;">帮助</a></li>
                    <li><a href="javascript:;" class="close-btn exit"></a></li>
                </ul>
            </div>
        </div>
        <hr width="100%" size="1" color="#CD0000" style="margin-top:3px;margin-bottom:0px;">
        <div class="hd-bottom">
        	<i class="home"><a href="javascript:;"></a></i>
        	<div class="nav-wrap">
                <ul class="nav ue-clear">
<!--                     <li><a href="javascript:;" target="content">平台管理</a></li> -->
           	<!-- 
           			<li><a href="worker/worker.html" target="content">用户管理</a></li>
                    <li><a href="business/business.html" target="content">业务管理</a></li>
                    <li><a href="truck/truck.html" target="content">卡车管理</a></li>
                    <li><a href="struck/struck.html" target="content">挂车管理</a></li>
                    <li><a href="goods/goods.html" target="content">货物管理</a></li>
                    <li><a href="oil/oil.html" target="content">油控管理</a></li>
                    <li><a href="problem/problem.html" target="content">信息追踪</a></li> 
            -->
                    <li><a href="getgoods/getgoods.html" target="content">提货管理</a></li>
                    <li><a href="harbor/harbor.html" target="content">口岸管理</a></li>
                    <li><a href="port/port.html" target="content">港口管理</a></li>
                    <li><a href="boxmanage/boxmanage.html" target="content">箱管操作</a></li>
                    <li><a href="resign/resign.html" target="content">签收管理</a></li>
                    <li><a href="multipleManage.html" target="content">综合管理</a></li>
                </ul>
            </div>
            
        </div>
        <hr width="100%" size="1" color="#CD0000" style="margin-top:0px;margin-bottom:0px;">
    </div>
    <div id="bd">
        <iframe width="100%" height="100%" id="mainIframe" src="main.html" frameborder="0" name="content"></iframe>
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
    	<div class="ui-dialog-icon"></div>
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

<div class="opt-panel user-opt" style="top:52px;left:330px;">
	<ul>
    	<li><a class="text">用户资料</a></li>
        <li><a class="text">短消息<span class="num">(2)</span></a></li>
        <li><a class="text">资料信息</a></li>
        <li><a class="text">注销</a></li>
        <li><a class="text">自定义</a></li>
    </ul>
    <div class="opt-panel-tl"></div>
    <div class="opt-panel-tc"></div>
    <div class="opt-panel-tr"></div>
    <div class="opt-panel-ml"></div>
    <div class="opt-panel-mr"></div>
    <div class="opt-panel-bl"></div>
    <div class="opt-panel-bc"></div>
    <div class="opt-panel-br"></div>
    <div class="opt-panel-arrow"></div>
</div>


</body>
<script type="text/javascript" src=" js/core.js"></script>
<script type="text/javascript" src=" js/jquery.dialog.js"></script>
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

(function(){
	var totalWidth = 0, current = 1;
	
	$.each($('.nav').find('li'), function(){
		totalWidth += $(this).outerWidth();
	});
	
	$('.nav').width(totalWidth);
	
	function currentLeft(){
		return -(current - 1) * 93;	
	}
	
	$('.nav-btn a').click(function(e) {
		var tempWidth = totalWidth - ( Math.abs($('.nav').css('left').split('p')[0]) + $('.nav-wrap').width() );
        if($(this).hasClass('nav-prev-btn')){
			if( parseInt($('.nav').css('left').split('p')[0])  < 0){
				current--;
				Math.abs($('.nav').css('left').split('p')[0]) > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': 0}, 200);
			}
		}else{

			if(tempWidth  > 0)	{
				
			   	current++;
				tempWidth > 93 ? $('.nav').animate({'left': currentLeft()}, 200) : $('.nav').animate({'left': $('.nav').css('left').split('p')[0]-tempWidth}, 200);
			}
		}
    });
	
	
/* 	
	$.each($('.skin-opt li'),function(index, element){
		if((index + 1) % 3 == 0){
			$(this).addClass('third');	
		}
		$(this).css('background',$(this).attr('attr-color'));
	});
	
	$('.setting-skin').click(function(e) {
        $('.skin-opt').show();
    });
	
	$('.skin-opt').click(function(e) {
        if($(e.target).is('li')){
			alert($(e.target).attr('attr-color'));	
		}
    });
	
	$('.hd-top .user-info .more-info').click(function(e) {
       $(this).toggleClass('active'); 
	   $('.user-opt').toggle();
    });
	
	$('.logo-icon').click(function(e) {
         $(this).toggleClass('active'); 
	     $('.system-switch').toggle();
    }); */
	
	hideElement($('.user-opt'), $('.more-info'), function(current, target){

		$('.more-info').removeClass('active'); 
	});
	
	hideElement($('.skin-opt'), $('.switch-bar'));
	
	hideElement($('.system-switch'), $('.logo-icon'), function(current, target){

		$('.logo-icon').removeClass('active'); 
	});
	
	
	
})();

	

</script>
</html>

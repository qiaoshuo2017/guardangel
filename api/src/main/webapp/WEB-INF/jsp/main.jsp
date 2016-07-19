<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>慧网金服后台管理主界面</title>
<link rel="stylesheet" type="text/css" href="css/la.css">
<link rel="stylesheet" type="text/css" href="css/lrtk.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/only.js"></script>
</head>
<body>
	<div>
		<div class="hd">
			<div class="tubiao">
				<img src="img/tubiao.gif">
			</div>
		</div>
		<div class="zhongjian">
			<div class="leftlan">
				<!-- 代码 开始 -->
				<div class="subNavBox">
					<div id="title1" name="title1" class="subNav currentDd currentDt">Banner管理</div>
					<ul class="navContent " style="display: block">
						<li id="title1small1" name="title1small1"><a
							href="banner/toAdd" target="asd">Banner编辑</a></li>
						<li id="title1small2" name="title1small2"><a
							href="banner/selallbanner" target="asd">Banner查询</a></li>
							<li id="title1small3" name="title1small3"><a
							href="banner/toAdd" target="asd">Banner新增</a></li>
					</ul>

					<div id="title2" name="title2" class="subNav">公告管理</div>
					<ul class="navContent">
						<li id="title2small1" name="title2small1"><a
							href="#" target="asd">公告编辑</a></li>
								<li id="title2small2" name="title2small2"><a
							href="#" target="asd">公告审核</a></li>
								<li id="title2small3" name="title2small3"><a
							href="#" target="asd">公告新增</a></li>
						<!-- 
							<li id="title2small2" name="title2small2"><a
							href="yuangong/yuanGongPeiXunJieYeList" target="asd">未结业列表</a></li>
					 -->
					</ul>
					<div id="title3" name="title3" class="subNav">起投设置管理</div>
					<ul class="navContent">
						<li id="title3small1" name="title3small1"><a
							href="#" target="asd">起投设置编辑</a></li>
						<!-- <li id="title3small2" name="title3small2"><a
							href="yuangong/yuanGongRuZhiList?zhuangtai=3" target="asd">已入职查询</a></li>
						<li id="title3small3" name="title3small3"><a
							href="yuangong/yuanGongRuZhiList?zhuangtai=31" target="asd">待审批查询</a></li>
						<li id="title3small3" name="title3small3"><a
							href="yuangong/yuanGongRuZhiList?zhuangtai=4" target="asd">已离职查询</a></li> -->
					</ul>

					<div id="title4" name="title4" class="subNav">会员管理</div>
					<ul class="navContent">
						<li id="title4small1" name="title4small1"><a
							href="#" target="asd">会员编辑（拉黑，完善信息，修改信息）</a></li>
						<li id="title4small2" name="title4small2"><a
							href="#" target="asd">会员查询（条件）</a></li>
						<li id="title4small3" name="title4small3"><a href="#"
							target="asd">会员查询（全部）</a></li>
						<li id="title4small4" name="title4small4"><a
							href="#" target="asd">会员新增</a></li>
						<!-- <li id="title4small5" name="title4small5"><a
							href="zhengjianleixing/zhengJianLeiXingList" target="asd">证件类型管理</a></li> -->
					</ul>

					<div id="title5" name="title5" class="subNav">会员资金管理</div>
					<ul class="navContent">
						<li id="title5small1" name="title5small1"><a
							href="#" target="asd">会员资金编辑</a></li>
						<li id="title5small2" name="title5small2"><a
							href="#" target="asd">会员资金查询</a></li>
						<!-- <li id="title5small3" name="title4small3"><a
							href="bumen/quYuList" target="asd">区域管理</a></li>
						<li id="title5small4" name="title4small4"><a
							href="bumen/fenGongSiList" target="asd">分公司管理</a></li>
						<li id="title5small5" name="title4small5"><a
							href="bumen/yingYeBuList" target="asd">营业部管理</a></li>
						<li id="title5small5" name="title4small5"><a
							href="bumen/tuanDuiList" target="asd">团队管理</a></li> -->
					</ul>

					<div id="title6" name="title6" class="subNav">充值记录管理</div>
					<ul class="navContent">
						<li id="title6small1" name="title6small1"><a
							href="#" target="asd">充值记录查询（条件）</a></li>
						<li id="title6small2" name="title6small2"><a
							href="#" target="asd">充值记录查询（全部）</a></li>
						<li id="title6small3" name="title6small3"><a
							href="#" target="asd">充值记录编辑</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title7" name="title7" class="subNav">提现记录管理</div>
					<ul class="navContent">
						<li id="title7small1" name="title7small1"><a
							href="#" target="asd">提现记录编辑</a></li>
						<li id="title7small2" name="title7small2"><a
							href="#" target="asd">体现记录查询（全部）</a></li>
						<li id="title7small3" name="title7small3"><a
							href="#" target="asd">提现记录查询（条件）</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title8" name="title8" class="subNav">客户银行管理</div>
					<ul class="navContent">
						<li id="title8small1" name="title8small1"><a
							href="#" target="asd">客户银行编辑</a></li>
						<li id="title8small2" name="title8small2"><a
							href="#" target="asd">客户银行查询（条件）</a></li>
						<li id="title8small3" name="title8small3"><a
							href="#" target="asd">客户银行查询（全部）</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title9" name="title9" class="subNav">银行管理</div>
					<ul class="navContent">
						<li id="title9small1" name="title9small1"><a
							href="#" target="asd">银行信息查询</a></li>
						<li id="title9small2" name="title9small2"><a
							href="#" target="asd">银行信息编辑</a></li>
						<li id="title9small3" name="title9small3"><a
							href="#" target="asd">银行信息新增</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title10" name="title10" class="subNav">投标项目管理</div>
					<ul class="navContent">
						<li id="title10small1" name="title10small1"><a
							href="#" target="asd">投标项目查询</a></li>
						<li id="title10small2" name="title10small2"><a
							href="#" target="asd">投标项目新增</a></li>
						<li id="title10small3" name="title10small3"><a
							href="#" target="asd">投标项目编辑</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title11" name="title11" class="subNav">抵押物管理</div>
					<ul class="navContent">
						<li id="title11small1" name="title11small1"><a
							href="#" target="asd">抵押物查询</a></li>
						<li id="title11small2" name="title11small2"><a
							href="#" target="asd">抵押物编辑</a></li>
						<!-- <li id="title11small3" name="title11small3"><a
							href="licaichanpin/toLiCaiChanPinList" target="asd"></a></li> -->
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title12" name="title12" class="subNav">借款人管理</div>
					<ul class="navContent">
						<li id="title12small1" name="title12small1"><a
							href="#" target="asd">借款人查询</a></li>
						<li id="title12small2" name="title12small2"><a
							href="#" target="asd">借款人编辑</a></li>
						<!-- <li id="title12small3" name="title12small3"><a
							href="licaichanpin/toLiCaiChanPinList" target="asd"></a></li> -->
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title13" name="title13" class="subNav">投标记录管理</div>
					<ul class="navContent">
						<li id="title13small1" name="title13small1"><a
							href="#" target="asd">投标记录查询</a></li>
						<li id="title13small2" name="title13small2"><a
							href="#" target="asd">投标记录编辑</a></li>
						<li id="title13small3" name="title13small3"><a
							href="#" target="asd">投标记录新增</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title14" name="title14" class="subNav">还款明细管理</div>
					<ul class="navContent">
						<li id="title14small1" name="title14small1"><a
							href="#" target="asd">还款记录查询</a></li>
						<li id="title14small2" name="title14small2"><a
							href="#" target="asd">还款记录编辑</a></li>
						<li id="title14small3" name="title14small3"><a
							href="#" target="asd">还款记录新增</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title15" name="title15" class="subNav">应收明细管理</div>
					<ul class="navContent">
						<li id="title15small1" name="title15small1"><a
							href="#" target="asd">应收记录查询</a></li>
						<li id="title15small2" name="title15small2"><a
							href="#" target="asd">应收记录编辑</a></li>
						<li id="title15small3" name="title15small3"><a
							href="#" target="asd">应收记录新增</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title16" name="title16" class="subNav">借款信息管理</div>
					<ul class="navContent">
						<li id="title16small1" name="title16small1"><a
							href="#" target="asd">借款信息查询</a></li>
						<li id="title16small2" name="title16small2"><a
							href="#" target="asd">借款信息编辑</a></li>
						<li id="title16small3" name="title16small3"><a
							href="#" target="asd">借款信息新增</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title17" name="title17" class="subNav">手续费管理</div>
					<ul class="navContent">
						<li id="title17small1" name="title17small1"><a
							href="#" target="asd">手续费查询</a></li>
						<li id="title17small2" name="title17small2"><a
							href="#" target="asd">手续费编辑</a></li>
						<!-- <li id="title17small3" name="title17small3"><a
							href="licaichanpin/toLiCaiChanPinList" target="asd"></a></li> -->
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title18" name="title18" class="subNav">关于我们管理</div>
					<ul class="navContent">
						<li id="title18small1" name="title18small1"><a
							href="zhifufangshi/toZhiFuFangShi" target="asd">关于我们编辑</a></li>
						<!-- 	<li id="title18small2" name="title18small2"><a
								href="licaichanpin/toLiCaiChanPin" target="asd"></a></li>
							<li id="title18small3" name="title18small3"><a
								href="licaichanpin/toLiCaiChanPinList" target="asd"></a></li> -->
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					<div id="title19" name="title19" class="subNav">版本信息管理</div>
					<ul class="navContent">
						<li id="title19small1" name="title19small1"><a
							href="#" target="asd">版本信息编辑</a></li>
						<li id="title19small2" name="title19small2"><a
							href="#" target="asd">版本信息查询</a></li>
						<li id="title19small3" name="title19small3"><a
							href="#" target="asd">版本信息新增</a></li>
				<!-- 		<li id="title6small4" name="title6small4"><a
							href="yinhang/toYinHangSelect" target="asd">客户银行</a></li> -->
					</ul>
					
					
				</div>
				
				<!-- 代码 结束 -->
			</div>
			<div class="shutiao"></div>
			<div class="rightlan">
				<iframe id="iframe" name="asd" src="rightFrame" width="100%"
					height="100%" frameborder="0"></iframe>
			</div>
		</div>
		<div class="heng"></div>
		<div class="dibu">
			<div style="margin-top: 30px; text-align: center;">
				<p>江苏慧网金融信息有限公司</p>
			</div>
		</div>
	</div>
</body>
</html>
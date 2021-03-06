<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/howtotrade.css" >
</head>
<body>
	<header>
		<a href="<s:url action='IndexAction'/>">
			<img alt="warasibe" src="./images/logo.png" class="icon">
		</a>

		<div class="searchContainer">
			<s:form action="SearchAction" theme="simple">
				<input type="search" name="searchText" class="searchText">
				<s:submit value=" " class="textSearchSubmit"/>
			</s:form>
		</div>

		<ul class="headerRightList">
			<s:if test="#session.id == null">
				<jsp:forward page="login.jsp"/>
			</s:if>
			<s:else>
				<s:if test="#session.id != userId">
					<li class="headerRightItem"><a href='<s:url action="MyPageAction"/>'>マイページ</a></li>
				</s:if>
				<li class="headerRightItem"><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</s:else>
		</ul>
	</header>

	<div id="main">
		<div class="leftSideBar">
			<p>配送するもの</p>
			<div class="targetContainer">
				<p class="appliedItemName"><s:property value="myCommodityDTO.getName()" /></p>
				<p class="appliedItemCategory"><s:property value="myCommodityDTO.getCategory()" /></p>
				<p class="appliedItemDetail">詳細：<br><s:property value="myCommodityDTO.getDetail()" /></p>
				<p class="appliedItemColor"><s:property value="myCommodityDTO.getColor()"/>色</p>
				<p class="appliedItemSize">
					<s:property value="myCommodityDTO.getHeight()" />×
					<s:property value="myCommodityDTO.getWidth()" />×
					<s:property value="myCommodityDTO.getDepth()" />
					<s:property value="myCommodityDTO.getSize_unit()" />
				</p>
				<address>住所：東京都文京区湯島３丁目２−１２</address>
			</div>
			<img alt="↓↑" src="./images/tradeVertical.png" class="indicator">
			<p>届くもの</p>
			<div class="selectContainer">
				<p class="appliedItemName"><s:property value="yourCommodityDTO.getName()" /></p>
				<p class="appliedItemCategory"><s:property value="yourCommodityDTO.getCategory()" /></p>
				<p class="appliedItemDetail">詳細：<br><s:property value="yourCommodityDTO.getDetail()" /></p>
				<p class="appliedItemColor"><s:property value="yourCommodityDTO.getColor()"/>色</p>
				<p class="appliedItemSize">
					<s:property value="yourCommodityDTO.getHeight()" />×
					<s:property value="yourCommodityDTO.getWidth()" />×
					<s:property value="yourCommodityDTO.getDepth()" />
					<s:property value="yourCommodityDTO.getSize_unit()" />
				</p>
			</div>

			<a href="<s:url action='MyPageAction'/>">マイページへ</a>
			<s:if test="checkArrived()">
				<a href='<s:url action="ConfirmTradingAction" ><s:param name="fromArrive" value="true" /></s:url>'>届いた</a>
			</s:if>
		</div>
		<div class="rightSideBar">
			<p><s:property value="message"/></p>
			<ol>
				<li>商品を弊社へ配送してください。</li>
				<img src="./images/delivery1.png">
				<li>商品が揃うまで弊社で保管いたします。</li>
				<img src="./images/delivery2.png">
				<li>商品が揃い次第交換先住所へ配送します。</li>
				<img src="./images/delivery3.png">
			</ol>
		</div>

	</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
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

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<jsp:forward page="login.jsp"/>
			</s:if>
			<s:else>
				<a href='<s:url action="MyPageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<div class="leftSideBar">
			<div>
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
			</div>
			<div>
				<address>住所：東京都文京区湯島３丁目２−１２</address>
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
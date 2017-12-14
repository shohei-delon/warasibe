<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/confirmApplying.css" >
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

		<div class="mainContainer">
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
			</div>
			<img alt="←　→" src="./images/trade.png" class="indicator">
			<div class="selectContainer">
				<p class="appliedItemName"><s:property value="wantCommodityDTO.getName()" /></p>
				<p class="appliedItemCategory"><s:property value="wantCommodityDTO.getCategory()" /></p>
				<p class="appliedItemDetail">詳細：<br><s:property value="wantCommodityDTO.getDetail()" /></p>
				<p class="appliedItemColor"><s:property value="wantCommodityDTO.getColor()"/>色</p>
				<p class="appliedItemSize">
					<s:property value="wantCommodityDTO.getHeight()" />×
					<s:property value="wantCommodityDTO.getWidth()" />×
					<s:property value="wantCommodityDTO.getDepth()" />
					<s:property value="wantCommodityDTO.getSize_unit()" />
				</p>
			</div>
		</div>
		<div class="submitWrapper">
			<a href="<s:url action="AddWishItemAction" ><s:param name="userId" value="#session.id" /></s:url>">決定</a>
		</div>

	</div>

</body>
</html>
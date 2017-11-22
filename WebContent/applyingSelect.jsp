<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/applying.css" >
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

		<div>
			<p class="appliedItemName"><s:property value="commodityDTO.getName()" /></p>
			<p class="appliedItemCategory"><s:property value="commodityDTO.getCategory()" /></p>
			<p class="appliedItemDetail">詳細：<br><s:property value="commodityDTO.getDetail()" /></p>
			<p class="appliedItemColor"><s:property value="commodityDTO.getColor()"/>色</p>
			<p class="appliedItemSize">
				<s:property value="commodityDTO.getHeight()" />×
				<s:property value="commodityDTO.getWidth()" />×
				<s:property value="commodityDTO.getDepth()" />
				<s:property value="commodityDTO.getSize_unit()" />
			</p>
		</div>

		<ul class="belongsList">
			<s:iterator value="belongsList" status="list">
				<li class="belongsItem">
					<p class="belongsItemName"><s:property value="getName()" /></p>
					<p class="belongsItemCategory"><s:property value="getCategory()" /></p>
					<p class="belongsItemDetail">詳細：<br><s:property value="getDetail()" /></p>
					<p class="belongsItemColor"><s:property value="getColor()"/>色</p>
					<p class="belongsItemSize">
						<s:property value="getHeight()" />×
						<s:property value="getWidth()" />×
						<s:property value="getDepth()" />
						<s:property value="getSize_unit()" />
					</p>
					<a href="<s:url action="ConfirmApplyingAction"><s:param name="belongsId" value="#list.index"/></s:url>">選択</a>
				</li>
			</s:iterator>
		</ul>
	</div>
</body>
</html>
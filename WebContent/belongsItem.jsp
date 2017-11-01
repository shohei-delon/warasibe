<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
</head>
<body>
	<header>
		<a href="./index.jsp">
			<img alt="warasibe" src="./images/logo.png" class="icon">
		</a>

		<div class="searchContainer">
			<s:form action="TextSearchAction" theme="simple">
				<input type="search" name="searchText" class="searchText">
				<s:submit value=" " class="textSearchSubmit"/>
			</s:form>
		</div>

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<jsp:forward page="login.jsp"/>
			</s:if>
			<s:else>
				<a href='<s:url action="MypageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<div class="addBelongs">
			<a href="<s:url value='AddBelongsAction'/>">追加</a>
		</div>
		<ul>
			<s:iterator value="belongsList">
				<li>
					<p class="belongsItemName">名前：<s:property value="getName()" /></p>
					<p class="belongsItemCategory">カテゴリ：<s:property value="category" /></p>
					<p class="belongsItemDetail">詳細：<s:property value="getDetail" /></p>
					<p class="belongsItemSize">サイズ
						<s:property value="getHeight()" />×
						<s:property value="getWidth()" />×
						<s:property value="getDepth" />
						<s:property value="getSize_unit()" />
					</p>
					<p class="belongsItemPrice">値段<s:property value="getPrice()" /></p>
				</li>
			</s:iterator>
		</ul>
	</div>

</body>
</html>
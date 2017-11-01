<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/myPage.css" >
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
		<div class="wishListContainer">
			<h2>欲しいものリスト</h2>
			<ul>
				<li>
					<div>
					</div>
				</li>
			</ul>
		</div>
		<div class="centerWraper">
			<h2>名前のマイページ</h2>
			<div class="centerContainer">
				<div class="archiveContainer">
					<h3>実績</h3>
					<ul class="archiveList">
						<li class="archiveItem"></li>
					</ul>
				</div>
				<div class="recentTradeContainer">
					<h3>最近の取引</h3>
					<ul class="recentTrade">
						<li></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="belongsListContainer">
			<div class="belongsListTop">
				<h2>所持中のわらしべ</h2>
				<a href="<s:url action='MoveBelongsAction'/>">編集</a>
			</div>
			<ul class="belongsList">
				<s:iterator value="belongsList">
					<li class="belongsItem">
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
	</div>

</body>
</html>
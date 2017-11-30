<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/search.css">
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
				<li class="headerRightItem"><a href='<s:url action="MyPageAction"><s:param name="userId" value="#session.id" /></s:url>'>マイページ</a></li>
				<li class="headerRightItem"><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</s:else>
		</ul>
	</header>

	<div id="main">
		<div id="leftSideBar">
			<h3>カテゴリ検索</h3>
			<ul class="categoryList">
				<s:iterator value="categoryList" status="list">
					<s:if test="searchCategory == #list.count">
						<li class=" categoryListItem selected"><a href="<s:url action='SearchAction'><s:param name='searchCategory' value='#list.count' /></s:url>"><s:property /></a></li>
					</s:if>
					<s:else>
						<li class="categoryListItem"><a href="<s:url action='SearchAction'><s:param name='searchCategory' value='#list.count' /></s:url>"><s:property /></a></li>
					</s:else>
				</s:iterator>
			</ul>

		</div>

		<div id="mainBar">
			<s:if test='searchText != null && !searchText.equals("")'>
				<h2>検索結果</h2>
				<p>検索テキスト：<s:property value="searchText"/></p>
				<p>検索ヒット数：<s:property value="itemList.size()"/>件</p>
			</s:if>
			<s:else>
				<h2>全件表示</h2>
			</s:else>

			<ul class="searchList">
				<s:iterator value="itemList" status="list">
					<li class="searchItem">
						<a href="<s:url action='MyPageAction'><s:param name='userId' value='getPostId()' /></s:url>">
							<span class="itemName">名前：<s:property value="getName()" /></span>
							<span class="itemCategory">カテゴリ：<s:property value="getCategory()" /></span>
							<span class="itemDetail">詳細：<s:property value="getDetail()" /></span>
							<span class="itemSize">サイズ
								<s:property value="getHeight()" />×
								<s:property value="getWidth()" />×
								<s:property value="getDepth()" />
								<s:property value="getSize_unit()" />
							</span>
						</a>
						<s:if test="session.id != getPostId()">
							<div class="center">
								<a href="<s:url action='ApplyingSelectAction'><s:param name="listIndex" value="#list.index"/></s:url>" class="submit">交換申請</a>
							</div>
						</s:if>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>

</body>
</html>
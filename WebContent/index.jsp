<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/index.css" >
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
				<a href='<s:url action="MyPageAction"><s:param name="userId" value="#session.id" /></s:url>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<div id="leftSideBar">
			<h3>カテゴリ検索</h3>
			<ul class="categoryList">
				<s:iterator value="categoryList" status="list">
					<li class="categoryListItem"><a href="<s:url action='SearchAction'><s:param name='searchCategory' value='#list.count' /></s:url>"><s:property /></a></li>
				</s:iterator>
			</ul>

		</div>

		<div id="centerBar">
			<h2>firstTopic</h2>
			<ul class="topicList">
				<s:iterator value="firstTopicList" status="list">
					<li class="topicItem">
						<a href="<s:url action='MyPageAction'><s:param name='userId' value='getId()' /></s:url>">
							<span class="userName"><s:property value="getNickname()"/></span>
							<img alt="userImage" src="./images/user.png" class="userImage">
							<span class="userProfile">よろしく</span>
						</a>
					</li>
				</s:iterator>
			</ul>

			<h2>secondTopic</h2>
			<ul class="topicList">
				<s:iterator value="secondTopicList">
					<li class="topicItem">
						<a href="<s:url action='MyPageAction'><s:param name='userId' value='getId()' /></s:url>">
							<span><s:property value="getNickname()"/></span>
							<img alt="userImage" src="./images/user.png" class="userImage">
							<span class="userProfile">よろしく</span>
						</a>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>
</body>
</html>
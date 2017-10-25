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
		<img alt="warasibe" src="./images/logo.png" class="icon">

		<div class="searchContainer">
			<s:form action="TextSearchAction" theme="simple">
				<input type="search" name="searchText" class="seachText">
				<s:submit value=" " class="textSearchSubmit"/>
			</s:form>
		</div>

		<div class="headerRightContainer">
			<a></a>
			<a></a>
			<a></a>
		</div>
	</header>

	<div id="leftSideBar">
		<h3>カテゴリ検索</h3>

	</div>

	<div id="main">
		<h2>firstTopic</h2>
		<ul class="firstTopicList">
			<li class="topicItem">
				<a>
					<img alt="userImage" src="" class="userImage">
					<span class="userProfile">よろしく</span>
				</a>
			</li>
		</ul>

		<h2>secondTopic</h2>
		<ul class="secondTopicContainer">
			<li class="topicItem">
				<a>
				<img alt="userImage" src="">
				<span class="userProfile">よろしく</span>
				</a>
			</li>
		</ul>
	</div>

	<div id="rightSideBar">

		<div class="loginContainer">
			<s:form action="LoginAction">
				<label>ログインID</label>
				<input type="text" name="loginUserId">
				<label>パスワード</label>
				<input type="password" name="loginUserPassword">
				<s:submit value="ログイン"/>
			</s:form>
		</div>

		<div class="signupContainer">
			<s:form action="SignupAction">
				<label>ログインID</label>
				<input type="text" name="loginUserId">
				<label>パスワード</label>
				<input type="password" name="loginUserPassword">
				<label>メールアドレス</label>
				<input type="email" name="userEmail">
				<s:submit value="新規登録"/>
			</s:form>
		</div>

	</div>

</body>
</html>
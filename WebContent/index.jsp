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
		<img alt="warasibe" src="./images/logo.png" class="icon">

		<div class="searchContainer">
			<s:form action="TextSearchAction" theme="simple">
				<input type="search" name="searchText" class="searchText">
				<s:submit value=" " class="textSearchSubmit"/>
			</s:form>
		</div>

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<a href='<s:url action="MoveLoginAction"/>'>ログイン</a>
			</s:if>
			<s:else>
				<a href='<s:url action="MoveMypageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<div id="leftSideBar">
			<h3>カテゴリ検索</h3>

		</div>

		<div id="centerBar">
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
				<s:form action="LoginAction" theme="simple">
					<label>ログインID:</label><br>
					<input type="text" name="loginUserId"><br>
					<label>パスワード:</label><br>
					<input type="password" name="loginUserPassword"><br>
					<s:submit value="ログイン"/>
				</s:form>
			</div>

			<div class="signupContainer">
				<s:form action="SignupAction" theme="simple">
					<label>ログインID:</label><br>
					<input type="text" name="loginUserId"><br>
					<label>パスワード:</label><br>
					<input type="password" name="loginUserPassword"><br>
					<label>メールアドレス:</label><br>
					<input type="email" name="userEmail"><br>
					<s:submit value="新規登録"/>
				</s:form>

			</div>
		</div>
	</div>
</body>
</html>
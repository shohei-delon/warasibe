<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/login_authentification.css" >
</head>
<body>
	<header>
		<a href="./index.jsp">
			<img alt="warasibe" src="./images/logo.png" class="icon">
		</a>

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<a href="./signup.jsp" class="signup" >新規登録</a>
			</s:if>
			<s:else>
				<a href='<s:url action="MoveMypageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<h3>サイト閲覧にはログインをお願いします。</h3>
		<div class="loginContainer">
			<s:form action="LoginAction" theme="simple">
				<label for="loginUserId">ログインID
					<input type="text" name="loginUserId" id="loginUserId">
				</label>
				<label for="loginPassword">パスワード
					<input type="password" name="loginPassword" id="loginPassword">
				</label>
				<s:submit value="ログイン"/>
			</s:form>
		</div>
	</div>

</body>
</html>
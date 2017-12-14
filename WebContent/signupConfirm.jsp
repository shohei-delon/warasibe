<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/login_auth.css" >
</head>
<body>
	<header>
		<a href="<s:url action='IndexAction'/>">
			<img alt="warasibe" src="./images/logo.png" class="icon">
		</a>

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<a href="./login.jsp">ログイン</a>
				<a href="./signup.jsp">新規登録</a>
			</s:if>
			<s:else>
				<a href='<s:url action="MoveMypageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>


	<div id="main">
		<s:form action="SignupConfirmAction" theme="simple">
			<h1>登録情報の確認</h1>

			<label>ログインID
				<input disabled type="text" name="signupUserId" value="<s:property value="signupUserId" escape="false" />" >
			</label>

			<label>パスワード
				<input disabled type="text" name="signupPassword" value="<s:property value="signupPassword" escape="false" />" >
			</label>

			<label>ユーザーネーム
				<input disabled type="text" name="nickname" value="<s:property value="nickname" escape="false" />" >
			</label>

			<label>メールアドレス
				<input disabled type="text" name="mail" value="<s:property value="mail" escape="false" />" >
			</label>

			<s:submit value="確認" />
		</s:form>
	</div>

</body>
</html>
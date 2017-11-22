<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
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
			<table>
				<tr>
					<td colspan="2">登録情報の確認</td>
				<tr>
				<tr>
					<td>ログインID</td>
					<td><s:property value="signupUserId" escape="false" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><s:property value="signupPassword" escape="false" /></td>
				</tr>
				<tr>
					<td>ユーザーネーム</td>
					<td><s:property value="nickname" escape="false" /></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><s:property value="mail" escape="false" /></td>
				</tr>
				<tr>
					<td><s:submit value="確認" /></td>
				</tr>
			</table>
		</s:form>
	</div>

</body>
</html>
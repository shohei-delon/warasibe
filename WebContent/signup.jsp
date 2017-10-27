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
		<img alt="warasibe" src="./images/logo.png" class="icon">

		<div class="searchContainer">
			<s:form action="TextSearchAction" theme="simple">
				<input type="search" name="searchText" class="searchText">
				<s:submit value=" " class="textSearchSubmit"/>
			</s:form>
		</div>

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<a href="./login.jsp">ログイン</a>
			</s:if>
			<s:else>
				<a href='<s:url action="MoveMypageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">

		<s:if test="message != null">
			<p><s:property value="message"/></p>
		</s:if>
		<s:form action="SignupAction" theme="simple">

			<label>ログインID:</label><br>
			<s:if test="signupUserId != null">
				<input type="text" name="signupUserId" value="<s:property value='signupUserId'/>"><br>
			</s:if>
			<s:else>
				<input type="text" name="signupUserId"/><br>
			</s:else>

			<label>パスワード:</label><br>
			<input type="password" name="signupPassword"><br>

			<label>ユーザーネーム:</label><br>
			<s:if test="nickname != null">
				<input type="text" name="nickname" value="<s:property value='nickname'/>"><br>
			</s:if>
			<s:else>
				<input type="text" name="nickname"><br>
			</s:else>

			<label>メールアドレス:</label><br>
			<s:if test="mail != null">
				<input type="email" name="mail" value="<s:property value='mail'/>"><br>
			</s:if>
			<s:else>
				<input type="email" name="mail"><br>
			</s:else>

			<s:submit value="新規登録"/>
		</s:form>
	</div>

</body>
</html>
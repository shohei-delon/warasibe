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
	<header id="header">
		<div class="cmpName" ><a href='<s:url action="GoHomeAction"/>' class="releaseLink">AI.inc</a></div>
		<div class="session">
			<s:if test="#session.user_id != null">
				<a href='<s:url action="MyPageAction" />' class="myPage">マイページ</a>
				<a href='<s:url action="LogoutAction" />' class="logInOut" >ログアウト</a>
			</s:if>
			<s:else>
				<a href="./signup.jsp" class="signup" >新規登録</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<h3>サイト閲覧にはログインをお願いします。</h3>
		<div class="loginContainer">
			<s:form action="LoginAction" theme="simple">
				<label>ログインID:</label><br>
				<input type="text" name="loginUserId"><br>
				<label>パスワード:</label><br>
				<input type="password" name="loginPassword"><br>
				<s:submit value="ログイン"/>
			</s:form>
		</div>
	</div>

</body>
</html>
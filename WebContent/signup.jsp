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

		<ul class="headerRightList">
			<li class="headerRightItem"><a href="./login.jsp">ログイン</a></li>
		</ul>
	</header>

	<div id="main">

		<s:if test="message != null">
			<p><s:property value="message"/></p>
		</s:if>
		<s:form action="SignupAction" theme="simple">

			<label >ログインID:<br>
				<s:if test="signupUserId != null">
					<input type="text" name="signupUserId" value="<s:property value='signupUserId'/>"><br>
				</s:if>
				<s:else>
					<input type="text" name="signupUserId"/><br>
				</s:else>
			</label>

			<label>パスワード:<br>
				<input type="password" name="signupPassword"><br>
			</label>

			<label>ユーザーネーム:<br>
				<s:if test="nickname != null">
					<input type="text" name="nickname" value="<s:property value='nickname'/>"><br>
				</s:if>
				<s:else>
					<input type="text" name="nickname"><br>
				</s:else>
			</label>

			<label>メールアドレス:<br>
				<s:if test="mail != null">
					<input type="email" name="mail" value="<s:property value='mail'/>"><br>
				</s:if>
				<s:else>
					<input type="email" name="mail"><br>
				</s:else>
			</label>

			<s:submit value="新規登録"/>
		</s:form>
	</div>

</body>
</html>
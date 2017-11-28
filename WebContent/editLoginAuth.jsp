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

		<p><s:property value="message"/></p>

		<s:form action="EditLoginAuthAction" theme="simple">
			<label for="oldId">古いログインID</label>
			<input type="text" name="oldId" id="oldId">
			<label for="oldPassword">古いパスワード</label>
			<input type="password" name="oldPassword" id="oldPassword">
			<label for="newId">新しいログインID</label>
			<input type="text" name="newId" id="newId">
			<label for="newPassword">新しいパスワード</label>
			<input type="password" name="newPassword" id="newPassword">
			<s:submit value="更新"/>
		</s:form>
	</div>
</body>
</html>
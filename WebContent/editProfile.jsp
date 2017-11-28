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

		<s:form action="EditProfileAction" theme="simple">
			<label for="loginId">ログインID</label>
			<input type="text" name="loginId" id="loginId">
			<label for="loginPassword">パスワード</label>
			<input type="password" name="loginPassword" id="loginPassword">
			<label for="newNickname">ユーザーネーム</label>
			<input type="text" name="nickname" id="newNickname" placeholder="<s:property value='accountDTO.getNickname()'/>">
			<label for="newIntroduce">自己紹介</label>
			<textarea rows="3" cols="50" name="introduce" id="newIntroduce"><s:property value="accountDTO.getIntroduce()"/></textarea>
			<s:submit value="更新"/>
		</s:form>
	</div>

</body>
</html>
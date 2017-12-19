<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/edit.css" >
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

		<ul class="headerRightList">
			<s:if test="#session.id == null">
				<jsp:forward page="login.jsp"/>
			</s:if>
			<s:else>
				<s:if test="#session.id != userId">
					<li class="headerRightItem"><a href='<s:url action="MyPageAction"/>'>マイページ</a></li>
				</s:if>
				<li class="headerRightItem"><a href='<s:url action="LogoutAction"/>'>ログアウト</a></li>
			</s:else>
		</ul>
	</header>

	<div id="main">

		<p><s:property value="message"/></p>

		<s:form action="EditLoginAuthAction" theme="simple">
			<label for="oldId">古いログインID<br>
				<input type="text" name="oldId" id="oldId">
			</label>
			<label for="oldPassword">古いパスワード<br>
				<input type="password" name="oldPassword" id="oldPassword">
			</label>
			<label for="newId">新しいログインID<br>
				<input type="text" name="newId" id="newId">
			</label>
			<label for="newPassword">新しいパスワード<br>
				<input type="password" name="newPassword" id="newPassword">
			</label>
			<s:submit value="更新"/>
		</s:form>
	</div>
</body>
</html>
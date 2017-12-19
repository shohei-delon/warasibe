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

		<s:form action="EditProfileAction" theme="simple">
			<label for="loginId">現在のログインID<br>
				<input type="text" name="loginId" id="loginId">
			</label>
			<label for="loginPassword">現在のパスワード<br>
				<input type="password" name="loginPassword" id="loginPassword">
			</label>
			<label for="newNickname">変更するユーザーネーム<br>
				<input type="text" name="nickname" id="newNickname" placeholder="<s:property value='accountDTO.getNickname()'/>">
			</label>
			<label for="newIntroduce">変更する自己紹介<br>
				<textarea rows="3" cols="50" name="introduce" id="newIntroduce"><s:property value="accountDTO.getIntroduce()"/></textarea>
			</label>
			<s:submit value="更新"/>
		</s:form>
	</div>

</body>
</html>
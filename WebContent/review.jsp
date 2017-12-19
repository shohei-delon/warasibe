<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/review.css" >
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
		<s:form action="ReviewAction" theme="simple">
			<div class="reviewList">
				<input type="radio" name="rate" value="1" id="value1">
				<label for="value1">1<br>(最低)</label>
				<input type="radio" name="rate" value="2" id="value2">
				<label for="value2">2<br>(低)</label>
				<input type="radio" name="rate" value="3" id="value3">
				<label for="value3">3<br>(普通)</label>
				<input type="radio" name="rate" value="4" id="value4">
				<label for="value4">4<br>(良)</label>
				<input type="radio" name="rate" value="5" id="value5">
				<label for="value5">5<br>(最良)</label>
				<input type="radio" name="rate" value="0" id="value0">
				<label for="value0">評価しない</label>
			</div>
			<div class="submitContainer">
				<s:submit id="submit"></s:submit>
				<label for="submit">決定</label>
			</div>
		</s:form>
	</div>


</body>
</html>
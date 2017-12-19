<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/belongsItem.css" >
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
		<ul class="belongsList">
			<s:iterator value="belongsList">
				<li class="belongsItem">
					<div class="topContainer">
						<p class="belongsItemName"><s:property value="getName()" /></p>
						<p class="belongsItemCategory"><s:property value="getCategory()" /></p>
					</div>
					<p class="belongsItemDetail">詳細：<br><s:property value="getDetail()" /></p>
					<div class="bottomContainer">
						<p class="belongsItemColor"><s:property value="getColor()"/>色</p>
						<p class="belongsItemSize">
							<s:property value="getHeight()" />×
							<s:property value="getWidth()" />×
							<s:property value="getDepth()" />
							<s:property value="getSize_unit()" />
						</p>
						<a href="<s:url action='RemoveBelongsAction'><s:param name='itemId' value='getId()'/></s:url>">削除</a>
					</div>
				</li>
			</s:iterator>
		</ul>
		<div class="addBelongs">
			<s:form action="AddBelongsAction" theme="simple">
				<label>商品名：<s:property value="nameError"/><br>
					<input type="text" name="name" maxlength="10" required/>
				</label>
				<label>商品情報：<s:property value="nameError"/><br>
					<textarea name="detail" rows="5"></textarea>
				</label>
				<label>カテゴリ：<s:property value="nameError"/><br>
					<s:select name="category_id" list="categoryMap"/>
				</label>
				<label>色：<br>
					<input type="text" name="color" maxlength="5">
				</label>
				<label>サイズ：<br>
					<input type="number" name="height" min="0" max="9999" required/>×
					<input type="number" name="width" min="0" max="9999" required/>×
					<input type="number" name="depth" min="0" max="9999" required/>
					<s:select name="size_unit" list="#{'mm':'mm','cm':'cm','m':'m'}" theme="simple"/>
				</label>
				<label>使用歴：<br>
					<input type="number" name="age" min="0" max="9999"/>年
				</label>
				<s:submit value="登録"/>
			</s:form>
		</div>
	</div>

</body>
</html>
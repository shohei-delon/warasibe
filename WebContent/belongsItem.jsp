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

		<div class="headerRightContainer">
			<s:if test="#session.id == null">
				<jsp:forward page="login.jsp"/>
			</s:if>
			<s:else>
				<a href='<s:url action="MyPageAction"/>'>マイページ</a>
				<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
			</s:else>
		</div>
	</header>

	<div id="main">
		<ul class="belongsList">
			<s:iterator value="belongsList">
				<li class="belongsItem">
					<p class="belongsItemName"><s:property value="getName()" /></p>
					<p class="belongsItemCategory"><s:property value="getCategory()" /></p>
					<p class="belongsItemDetail">詳細：<br><s:property value="getDetail()" /></p>
					<p class="belongsItemColor"><s:property value="getColor()"/>色</p>
					<p class="belongsItemSize">
						<s:property value="getHeight()" />×
						<s:property value="getWidth()" />×
						<s:property value="getDepth()" />
						<s:property value="getSize_unit()" />
					</p>
					<a href="<s:url action='RemoveBelongsAction'><s:param name='itemId' value='getId()'/></s:url>">削除</a>
				</li>
			</s:iterator>
		</ul>
		<div class="addBelongs">
			<s:form action="AddBelongsAction" theme="simple">
				<label>商品名：<br><input type="text" name="name"/></label><br>
				<label>商品情報：<br><textarea name="detail" cols="30" rows="5"></textarea></label><br>
				<label>カテゴリ：<br>
					<s:select name="category_id" list="categoryMap"/>
				</label><br>
				<label>色：<br><s:select name="color" list="#{'黒':'黒','白':'白','赤':'赤','青':'青','黄':'黄' }"/></label><br>
				<label>サイズ：<br>
					<input type="number" name="height"/>×
					<input type="number" name="width"/>×
					<input type="number" name="depth"/>
					<s:select name="size_unit" list="#{'mm':'mm','cm':'cm','m':'m'}" theme="simple"/>
				</label><br>
				<label>使用歴：<br><input type="number" name="age"/>年</label><br>
				<s:submit value="登録"/>
			</s:form>
		</div>
	</div>

</body>
</html>
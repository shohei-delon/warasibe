<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset=UTF-8>
	<title>Insert title here</title>
	<link rel="stylesheet" href="./css/common.css" >
	<link rel="stylesheet" href="./css/myPage.css" >
</head>
<body>
	<header>
		<a href="<s:url action='IndexAction'/>">
			<img alt="warasibe" src="./images/logo.png" class="icon">
		</a>

		<div class="searchContainer">
			<s:form action="TextSearchAction" theme="simple">
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
		<div class="wishListContainer">
			<h3>欲しいものリスト</h3>
			<ul class="wishList">
				<s:iterator value="wishList">
					<li class="sideListItem">
						<p class="belongsItemName">名前：<s:property value="getName()" /></p>
						<p class="belongsItemCategory">カテゴリ：<s:property value="getCategory()" /></p>
						<p class="belongsItemDetail">詳細：<s:property value="getDetail()" /></p>
						<p class="belongsItemSize">サイズ
							<s:property value="getHeight()" />×
							<s:property value="getWidth()" />×
							<s:property value="getDepth()" />
							<s:property value="getSize_unit()" />
						</p>
						<s:if test="accountDTO.getId() == session.id">
							<a href="<s:url action='RemoveWishItemAction'><s:param name='commodityId' value='getId()' /><s:param name='userId' value='session.id' /></s:url>">いらない。</a>
						</s:if>
					</li>
				</s:iterator>
			</ul>
		</div>

		<div class="centerWraper">
			<h2><s:property value="accountDTO.getNickname()"/>のマイページ</h2>
			<div class="centerContainer">
				<div class="archiveContainer">
					<h3>実績</h3>
					<ul class="archiveList">
						<li class="archiveItem"></li>
					</ul>
				</div>
				<s:if test="userId = session.id">
					<div class="eachWishContainer">
						<h3>相互ほしい</h3>
						<ul class="eachWishList">
							<s:iterator value="linkWishMap">
								<li class="eachWisItem">
									<p><a href="<s:url action="MyPageAction"><s:param name="userId" value="getKey().getId()"/></s:url>"><s:property value="getKey().getNickname()"/></a></p>
									<div>
										<p class="itemName"><s:property value="getValue()[0].getName()" /></p>
										<p class="itemCategory"><s:property value="getValue()[0].getCategory()" /></p>
										<p class="itemDetail">詳細：<br><s:property value="getValue()[0].getDetail()" /></p>
										<p class="itemColor"><s:property value="getValue()[0].getColor()"/>色</p>
										<p class="itemSize">
											<s:property value="getValue()[0].getHeight()" />×
											<s:property value="getValue()[0].getWidth()" />×
											<s:property value="getValue()[0].getDepth()" />
											<s:property value="getValue()[0].getSize_unit()" />
										</p>

										<p class="itemName"><s:property value="getValue()[1].getName()" /></p>
										<p class="itemCategory"><s:property value="getValue()[1].getCategory()" /></p>
										<p class="itemDetail">詳細：<br><s:property value="getValue()[1].getDetail()" /></p>
										<p class="itemColor"><s:property value="getValue()[1].getColor()"/>色</p>
										<p class="itemSize">
											<s:property value="getValue()[1].getHeight()" />×
											<s:property value="getValue()[1].getWidth()" />×
											<s:property value="getValue()[1].getDepth()" />
											<s:property value="getValue()[1].getSize_unit()" />
										</p>

									</div>
								</li>
							</s:iterator>
						</ul>
					</div>
				</s:if>
			</div>
		</div>

		<div class="belongsListContainer">
			<div class="belongsListTop">
				<h3>所持中のわらしべ</h3>
				<s:if test="session.id == accountDTO.getId()">
					<a href="<s:url action='MoveBelongsAction'/>">編集</a>
				</s:if>
			</div>
			<ul class="belongsList">
				<s:iterator value="belongsList">
					<li class="sideListItem">
						<p class="belongsItemName">名前：<s:property value="getName()" /></p>
						<p class="belongsItemCategory">カテゴリ：<s:property value="getCategory()" /></p>
						<p class="belongsItemDetail">詳細：<s:property value="getDetail()" /></p>
						<p class="belongsItemSize">サイズ
							<s:property value="getHeight()" />×
							<s:property value="getWidth()" />×
							<s:property value="getDepth()" />
							<s:property value="getSize_unit()" />
						</p>
						<s:if test="accountDTO.getId() != session.id">
							<a href="<s:url action='AddWishItemAction'><s:param name='commodityId' value='getId()' /><s:param name='userId' value='session.id' /></s:url>">ほしい。</a>
						</s:if>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>

</body>
</html>
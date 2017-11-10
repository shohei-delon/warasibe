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
		<div class="mainLeftContainer">
			<h2><s:property value="accountDTO.getNickname()"/>のマイページ</h2>
			<div class="belongsListTop">
				<h3>所持中のわらしべ</h3>
				<s:if test="session.id == accountDTO.getId()">
					<a href="<s:url action='MoveBelongsAction'/>">編集</a>
				</s:if>
			</div>
		</div>

		<s:if test="userId == session.id">
			<div class="appliedListContainer">
				<h3>申し込まれた交換</h3>
				<ul class="list">
					<s:iterator value="appliedMap">
						<li class="item">
							<p><a href="<s:url action="MyPageAction"><s:param name="userId" value="getKey().getId()"/></s:url>"><s:property value="getKey().getNickname()"/></a>さんからの申請</p>
							<div class="itemBlockContainer">
								<div class="leftItemBlock">
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

								</div>
								<img alt="←　→" src="./images/trade.png" class="indicatorImg">
								<div class="rightItemBlock">
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
							</div>

							<div class="submitContainer">
								<a href="">
									承諾
								</a>
								<a href="">
									拒否
								</a>
							</div>
						</li>
					</s:iterator>
				</ul>
			</div>

			<div class="wishListContainer">
				<h3>申し込んだ交換</h3>
				<ul class="list">
					<s:iterator value="wishMap">
						<li class="item">
							<p><a href="<s:url action="MyPageAction"><s:param name="userId" value="getKey().getId()"/></s:url>"><s:property value="getKey().getNickname()"/></a>さんへの申請</p>
							<div class="itemBlockContainer">
								<div class="leftItemBlock">
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
								</div>
								<img alt="←　→" src="./images/trade.png" class="indicatorImg">
								<div class="rightItemBlock">
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
							</div>
							<s:if test="accountDTO.getId() == session.id">
								<a href="
									<s:url action='RemoveWishItemAction'>
										<s:param name='myCommodityId' value='getValue()[0].getId()' />
										<s:param name='userId' value='session.id' />
										<s:param name='yourCommodityId' value='getValue()[1].getId()' />
										<s:param name='yourUserId' value='getKey().getId()' />
									</s:url>
								">申請の取り消し</a>
							</s:if>
						</li>
					</s:iterator>
				</ul>
			</div>
		</s:if>
		<s:else>
			<ul class="belongsList">
				<s:iterator value="belongsList" status="list">
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
						<a href="<s:url action="ApplyingSelectAction"><s:param name="listIndex" value="#list.index"/></s:url>">交換申請</a>
					</li>
				</s:iterator>
			</ul>
		</s:else>
	</div>

</body>
</html>
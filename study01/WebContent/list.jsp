<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="article.model.Article"%>
<%@ page import="article.service.ArticleListView"%>
<%@ page import="article.service.GetArticleListService"%>
<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}

	GetArticleListService articleListService = 
			GetArticleListService.getInstance();
	ArticleListView viewData = 
			articleListService.getArticleList(pageNumber);
%>
<c:set var="viewData" value="<%= viewData %>"/>
<html>
<head>
	<title>방명록 메시지 목록a</title>
</head>
<body>
<div style="margin-top: 100px;">
<!-- <form action="writeMessage.jsp" method="post">
이름: <input type="text" name="guestName"> <br>
암호: <input type="password" name="password"> <br>
메시지: <textarea name="message" cols="30" rows="3"></textarea> <br>
<input type="submit" value="메시지 남기기" />
</form>
<hr> -->
<c:if test="${viewData.isEmpty()}">
등록된 메시지가 없습니다.
</c:if>

<c:if test="${!viewData.isEmpty()}">
<table border="1">
	<c:forEach var="article" items="${viewData.articleList}">
	<tr>
		<td>
		메시지 번호: ${article.id} <br/>
		손님 이름: ${article.title} <br/>
		메시지: ${article.content} <br/>
		<%-- <a href="confirmDeletion.jsp?messageId=${article.id}">[삭제하기]</a> --%>
		</td>
	</tr>
	</c:forEach>
</table>

<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
<a href="list.jsp?page=${pageNum}">[${pageNum}]</a> 
</c:forEach>

</c:if>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
</head>
<body>
<div style="margin-top: 100px;">
<c:if test="${articlePage.hasNoArticles()}">
게시글이 없습니다.
</c:if>

<table class="table table-striped">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="article" items="${articlePage.content}">
		<tr>
			<td>${article.id}</td>
			<td>${article.title}</td>
			<td>${article.createdBy}</td>
			<td>${article.modifiedDt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</hr>
<div class="text-center">
	<ul class="pagination">
	<c:forEach var="pageNum" begin="${articlePage.startPage}" end="${articlePage.endPage}">
	<li><a href="noticeList.jsp?page=${pageNum}">${pageNum}</a></li>
	</c:forEach>
	</ul>
</div>

<%-- <c:if test="${articlePage.startPage > 5}">
<a href="list.do?pageNo=${articlePage.startPage - 5}">[이전]</a>
</c:if>
<c:forEach var="pNo" 
		   begin="${articlePage.startPage}" 
		   end="${articlePage.endPage}">
<a href="list.do?pageNo=${pNo}">[${pNo}]</a>
</c:forEach>
<c:if test="${articlePage.endPage < articlePage.totalPages}">
<a href="list.do?pageNo=${articlePage.startPage + 5}">[다음]</a>
</c:if> --%>
</div>
</body>
</html>
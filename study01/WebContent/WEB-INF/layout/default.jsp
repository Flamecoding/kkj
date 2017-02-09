<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %> <!-- 태그 라이브러리 설정 -->
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>              <!-- 태그 라이브러리 설정 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/layout/common/styles.jsp" %>
<%@ include file="/WEB-INF/layout/common/scripts.jsp" %>
<decorator:head />
</head>
<body>
<%@ include file="/WEB-INF/layout/common/header.jsp" %>
<div style="margin-top: 100px;">
<div id="container">
<decorator:body />
</div>
</div>
<%@ include file="/WEB-INF/layout/common/footer.jsp" %>
</body>
</html>
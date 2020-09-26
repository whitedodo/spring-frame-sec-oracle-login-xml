<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page session="false" %>
<html>
<head>
	<title>Spring-Security 5 (XML 방식)</title>
	<meta charset="UTF-8">
	<style>
		body{
			font-family:'Arial';
			font-size:12px;
		}
		
		a{
			text-decoration:none;
			color:#666;
		}
	</style>
</head>
<body>
<h1>
	Hello world!(Spring-Security 5(XML 방식)) - DB연동(Oracle)
</h1>
<hr />
<sec:authorize access="isAnonymous()">
	<!-- 로그인 전 -->
	<p>
		<a href="<c:url value="/member/loginForm" />">로그인</a>
	</p>
</sec:authorize> 

<sec:authorize access="isAuthenticated()">
	<!-- 로그인 성공 -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="로그아웃" />
	</form:form>
	
	<p>
		${username} &nbsp; ${password}
	</p>
	
</sec:authorize> 

<h3>
	<a href="<c:url value="/admin/home" />">관리자 홈</a>&nbsp;&nbsp;
	<a href="<c:url value="/encode-password?password=pass" />">비밀번호</a>
</h3>

<!-- 비밀번호 생성기 -->
<c:set var="gene_pwd" value="${encode}" />
<c:if test="${gene_pwd != null}">
    <c:out value="${gene_pwd}" />
</c:if>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <title>로그인 - 페이지(Login - Page)</title>
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

<h1>아이디와 비밀번호를 입력해주세요.</h1>
<hr />

<c:url value="/login" var="loginUrl" />

<form:form name="f" action="${loginUrl}" method="POST">
    <p>
        <label for="username">아이디</label>
        <input type="text" id="id" name="id" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password"/>
    </p>
    <p>
        <label for="remember-me">Remember-me(로그인 상태 유지)</label>
        <input type="checkbox" id="remember-me" name="remember-me"/>
    </p>
    <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn">로그인</button>
    
    <!-- 에러 메시지 영역 -->
    <c:if test="${param.error != null}">
        <p>아이디와 비밀번호가 잘못되었습니다.</p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>로그아웃 하였습니다.</p>
    </c:if>
    
</form:form>
<h3>[<a href="<c:url value="/" />">홈으로(Home)</a>]</h3>

</body>
</html>

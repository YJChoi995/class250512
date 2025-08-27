<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>제목</title>
</head>
<body>
	<h1>회원 목록</h1>
	
	<table border=1>
		<tr>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>JOB</th>
			<th>MGR</th>
			<th>HIREDATE</th>
			<th>SAL</th>
			<th>COMM</th>
			<th>DEPTNO</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.empno }</td>
				<td>${dto.ename }</td>
				<td>${dto.job }</td>
				<td>${dto.mgr }</td>
				<td><fmt:formatDate value="${dto.hiredate}" pattern="yyyy-MM-dd" /></td>
				<td>${dto.sal }</td>
				<td>${dto.comm }</td>
				<td>${dto.deptno }</td>
			</tr>
		</c:forEach>
	</table><br>
	
	<!-- 페이지 네비게이션 -->
	<div>
	    <!-- 이전 버튼 -->
	    <c:if test="${page > 1}">
	        <a href="list?page=${page-1}">[이전]</a>
	    </c:if>
	
	    <!-- 페이지 번호 5개 표시 -->
	    <c:forEach var="i" begin="${startPage}" end="${endPage}">
	        <c:choose>
	            <c:when test="${i == page}">
	                <b>[${i}]</b>
	            </c:when>
	            <c:otherwise>
	                <a href="list?page=${i}">[${i}]</a>
	            </c:otherwise>
	        </c:choose>
	    </c:forEach>
	
	    <!-- 다음 버튼 -->
	    <c:if test="${page < totalPage}">
	        <a href="list?page=${page+1}">[다음]</a>
	    </c:if>
	</div>
</body>
</html>
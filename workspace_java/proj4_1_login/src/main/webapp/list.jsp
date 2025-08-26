<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>quiz250825_quiz</title>
</head>
<body>

	dto : ${dto }<br>
	\${empty dto } : ${empty dto }
	
	<c:if test="${empty dto }">
		<c:redirect url="login.jsp" />
	</c:if>
	
	<h1>회원 목록</h1>
	<c:if test="${dto.job eq 'PRESIDENT' }">
		[관리자]
	</c:if>
	${dto.ename } 님 반갑습니다<br>
	<a href="logout">로그아웃</a>
	
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
			<th>비고</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.empno }</td>
				<td>${dto.ename }</td>
				<td>${dto.job }</td>
				<td>${dto.mgr }</td>
				<td>${dto.hiredate }</td>
				<td>${dto.sal }</td>
				<td>${dto.comm }</td>
				<td>${dto.deptno }</td>
				<td>
					<c:if test="${sessionScope.dto.empno eq dto.empno }">
					[수정]
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table><br>
	${list }
	
	

</body>
</html>
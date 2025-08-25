<!-- html 주석 -->
<%-- jsp 주석 --%>

<%-- 디렉티브 테그 --%>
<%-- 
	"<%@"로 시작하는 태그
	 1. page
	 2. include
--%>
<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.List"
    import="java.util.Map"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@ page import="emp.dto.EmpDTO" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		window.onload = function(){
			console.log('jsp')
		}
	</script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<h1>jsp.jsp</h1>
		
	<!-- 스크립틀릿Scriptlet -->
	<%
		// 여기는 java 땅입니다
		System.out.println("test");
		out.println("<strong>강한 글씨</strong>");
	%>
	
	<table border=1>
	<%
		for(int i=0; i<5; i++){
	%>
			<tr>
				<td>제목</td>
				<td>내용</td>
			</tr>
	<%
		}
	%>
	</table>
	
	<%
		int a = 10;
		String name = request.getParameter("name");
		
		EmpDTO dto = (EmpDTO)request.getAttribute("dto");
	%>
	ename : <%= dto.getEname() %>
	
	여기서 a : <% out.print(a); %><br>
	여기서 name : <% out.print(name); %><br>
	
	<!-- 표현식 -->
	<%= a %><br>
	<%= name %><br>
	
	<!-- 선언문 -->
	<%!
		String title = "F1";
		String getTitle(){
			return this.title;
		}
	%>
	
	3단<br>
	3x1=3<br>
	3x2=6<br>
	
</body>
</html>
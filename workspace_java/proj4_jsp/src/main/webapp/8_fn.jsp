<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<c:set var="title" value="영일이삼사오육칠팔구칠팔" />
	\${title } : ${title }<br>
길이 : 			 \${fn:length(title) } : ${fn:length(title) }<br>
자르기 : 		 \${fn:substring(title, 3, 6) } : ${fn:substring(title, 3, 6) }<br>
치환 : 			 \${fn:replace(title, "칠팔", "78") } : ${fn:replace(title, "칠팔", "78") }<br>
위치 찾기 : 	 \${fn:indexOf(title, "칠팔") } : ${fn:indexOf(title, "칠팔") } }<br>
위치 없으면 -1 : \${fn:indexOf(title, "abc") } : ${fn:indexOf(title, "abc") } }<br>

</body>
</html>
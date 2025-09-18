<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>결과</title>
</head>
	
<body>	
	<h3>회원가입 결과</h3>
	
	아이디 : \${id } : ${id }<br> 
	아이디 : ${memberDTO["id"] }<br> 
	아이디 : ${memberDTO.id }<br> 
	아이디(memberDTO2) : ${memberDTO2.id }
	<hr> 
	비밀번호 : ${memberDTO.pw }<br>
	이름 : ${memberDTO.name }<br>
	나이 : ${memberDTO.age }<br>
	전화번호 : ${memberDTO.tel }<br>
</body>
</html>
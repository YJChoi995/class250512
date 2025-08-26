<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>quiz250825_login</title>
	
	<style>
		.popup {
			border: 1px solid black;
			width: 200px;
			height: 200px;
			background-color: yellow;
		}
		.hide {
			display: none;
		}
	</style>
	
	<script>
		window.addEventListener('load', ()=>{
		
			showPopup();
			
			document.querySelector('#noShow').addEventListener('click', function(event){
					// 쿠키 먹이는 것(세션쿠키, 만료일 없음)
					document.cookie = 'a=a1'
					document.cookie = 'abcd=1234'
					
					// 쿠키 가져오기
					console.log(document.cookie)
					
					const isCheck = event.target.checked;
					if( isCheck ){
						// 10초 뒤 시간 가져오기
						const now = new Date()	// 현재 시간
						const after_60s = now.getSeconds() + 60
						now.setSeconds(after_60s)  // 초 단위 재설정
						
						document.cookie = 'noShow=true;expires='+ now.toGMTString()
					}
			})
		})
		
		function showPopup(){
			console.log(document.cookie);
			// "a=a1; abcd=1234; noShow=true"
			
			const cookies = document.cookie.split('; ');
			for(let i=0; i<cookies.length; i++){
				
				const cookie = cookies[i].split('=')
				const name = cookie[0]
				const value = cookie[1]
				
				if(name == 'noShow' && value == 'true'){
					document.querySelector('.popup').classList.add('hide');
				}
			}
		}
	</script>
</head>

<body>
	<form method="post" action="loginCheck">
		id : <input type="text" name="ename" value="SMITH"><br>
		password : <input type="text" name="empno" value="7369"><br>
		<button type="submit">LOGIN</button>
		
		<c:if test="${param.msg eq '1' }">
			<span style="color: red">
				아이디 또는 패스워드를 확인해주세요
			</span>
		</c:if>
	</form>
	
	
	<div class="popup">
		공지입니다<br>
		<input type="checkbox" id="noShow"> 1분 동안 보지 않기
	</div>
</body>
</html>
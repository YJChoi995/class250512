<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1>ajax.jsp 실행</h1>
	<button type="button" id="btn">ajax 실행</button>
	
	<script>
		const btn = document.querySelector("#btn");
		btn.addEventListener("click", function(){
			console.log("btn 눌림");
			
			let data = {
					id: 'abcd'
			}
			console.log(data);
			console.log('' + data);  			// 그냥 json을 보냈을 때 서버가 받는 글씨
			console.log(JSON.stringify(data));  // 
			
			const xhr = new XMLHttpRequest();
//			xhr.open('post', 'ajax1');
			xhr.open('post', 'ajax2');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.send(JSON.stringify(data));
			xhr.onload = function(){
				console.log(xhr.responseText);
			}
		});
		
	</script>
</body>
</html>
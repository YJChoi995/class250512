<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><tiles:insertAttribute name="title" /></title>
	<style>
		div {
			border: 1px solid red;
		}
		
		.main-wrapper {
			display: flex;
			
		}
		
		.main-wrapper .side {
			flex-grow: 1;
		}
		
		.main-wrapper .content {
			flex-grow: 2;
		}
	</style>
</head>
<body>
	<!-- header -->
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	
	<!-- main start -->
	<section class="main-wrapper">
		
		<!-- side -->
		<aside class="side">
			<tiles:insertAttribute name="side" />
		</aside>
		
		<!-- content -->
		<article class="content">
			<tiles:insertAttribute name="content" />
		</article>
	
	</section>
	<!-- main end -->
	
	<!-- footer -->
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
	
	
</body>
</html>
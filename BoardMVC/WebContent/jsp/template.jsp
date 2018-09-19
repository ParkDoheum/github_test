<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/${content}.css">
</head>
<body>
	
	<div class="container">
		<jsp:include page="top.jsp"/>	
		<div class="content">
			<jsp:include page='${content}.jsp' />
		</div>	
		<jsp:include page="bottom.jsp"/>		
	</div>	
</body>
</html>






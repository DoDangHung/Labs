<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${listCmt}" var="list" varStatus="Comment">
		<h4 style="margin-top: 20px; margin-bottom: -0.5px; color: #00B38F;"
			class="input-large">${list.getMember_name()}</h4>
		<p style="background-color: powderblue; height: 100px"
			class="input-xxlarge">${list.getCmt_content()}</p>
		<hr style="margin-top: -5px">
		</p>
	</c:forEach>
</body>
</html>
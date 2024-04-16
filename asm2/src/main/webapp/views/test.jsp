<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/asm2/test?them=hehe">them</a>
	<br>
	<a href="/asm2/test?them=hehe2">xoa</a>

	
      <c:if test="${not empty test}">
            <c:import url="${test}" />
        </c:if>
 		

	<form action="/asm2/test">

		




	</form>
</body>
</html>
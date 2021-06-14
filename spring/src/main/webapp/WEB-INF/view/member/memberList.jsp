<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원리스트페이지
<table border=1>
	<tr><td>아이디</td></tr><td>연락처</td><td>성별</td><td>등록일</td></tr>
	<c:forEach items="${lists }" var="dto">
	<tr><td>${dto.membId }</td></tr><td>${dto.membName }</td><td>${dto.membPhoneNumber}
	</td><td>${dto.membGender }</td><td>${dto.membEnterDate }</td></tr>
	</c:forEach>


</table>
</body>
</html>
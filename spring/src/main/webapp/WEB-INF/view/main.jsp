<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
<tr><td colspan="3"></td></tr>
<tr><td>아이디</td>

<td>
	<input type="text" name="loginId"/>
</td><td rowspan="2">
	<input type="image" src=""/>
</td></tr>


<tr><td>비밀번호</td>

<td>
	<input type="password" name="loginPw"/>
</td><td colspan="3">
	아이디/비밀번호 찾기
	<a href ="member/agree">회원가입</a>
</td></tr>
</table>

<a href= "emp/emplist">직원정보 리스트</a>
<a href= "member/memberList">회원정보 리스트</a>
</body>
</html>
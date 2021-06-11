<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored=false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원번호 : ${emp.empNo }<br/>
아이디 : ${emp.empId }<br/>
이름 : ${emp.empName }<br/>
부서명 : ${emp.empDeptNumber }<br/>
이메일 : ${emp.empEmail }<br/>
연락처 : ${emp.empPhoneNumber }<br/>
입사일 : <fmt:formatDate value="${emp.hireDate }" type="date" pattern="yy/mm/dd"/><br/>
급여 : ${emp.salary }<br/>
<a href="empModify?empNo=${emp.empNo}" >수정</a>
<a href="empDelete?empNo=${emp.empNo}">삭제</a>

</body>
</html>
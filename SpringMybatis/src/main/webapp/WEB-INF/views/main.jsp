<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin:0;
padding:0;
}

table{
	width:600px;
	margin:0 auto;
	border-collapse: collapse;
	
}

td{
	border:1px solid black;
	text-align: center;
	padding:5px 0px;

}

</style>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td>암호</td>
			<td>이름</td>
			<td>나이</td>
			<td>성별</td>
			<td>고객등급</td>
		</tr>
		<tbody>
		<c:forEach var="m" items="${requestScope.list }">
			<tr>
				<td>${m.memberId }</td>
				<td>${m.memberPasswd }</td>
				<td>${m.memberName }</td>
				<td>${m.memberAge }</td>
				<td>${m.memberGender }</td>
				<td>${m.gradeNo }</td>
			</tr>
		</c:forEach>
		</tbody>

	</table>
	
	<table>
		<c:forEach var="m" items="${requestScope.grade }">
			<tr>
				<td>${m.gradeNo }</td>
				<td>${m.gradeName }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
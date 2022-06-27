<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>목록</title>
<style>
table {
	margin: auto;
}
img {
	width:100px;
	height:100px;
	object-fit:contain;
	}
td {
	text-align: center;
}
th {
	text-align: center;
	background-color: #bbdefb;
}
div {
	text-align: center;
}
</style>
</head>
<body>
	<div>
	<h2>책 검색</h2>
	<form>
		<input type="text" placeholder="책제목 및 저자 검색" name="keyword" value="${keyword}"/>
		<input type="submit" value="검색"/>
		<br><br>
	</form>
	</div>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>표지</th>
			<th>ISBN</th>
			<th>책제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:forEach var="board" items="${boardList}" varStatus="Loop">
			<tr>
				<td>${board.seq}</td>
				<td><img alt="" src="<c:url value="/resources/images/${board.image}"/>"/></td>
				<td>${board.isbn}</td>
				<td><a href="<c:url value="/board/read/${board.seq}"/>">
				${board.bookname}</a></td>
				<td>${board.author}</td>
				<td>${board.publisher}</td>
				<td>${board.price}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div>
	<a href="<c:url value="/board/write"/>">도서추가</a>&nbsp;
	<a href="<c:url value="/board/list"/>">도서목록</a>
	</div>
</body>
</html>
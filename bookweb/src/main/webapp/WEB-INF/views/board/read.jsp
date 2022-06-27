<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>${boardVO.bookname}&nbsp내용</title>
<style>
table, th, td {
	border: 1px solid #bcbcbc;
	margin: auto;
}
td {
	text-align: center;
}
th {
	text-align: center;
	background-color: #bbdefb;
}
img {
	width:300px;
	height:400px;
	object-fit:contain;
}
div {
	text-align: center;
}
</style>
</head>
<body>
	<div>
	<h2>Book Detail</h2>
	</div>
	<table>
			<tr>
				<td rowspan="6" width="500" height="300">
				<img alt="" src="<c:url value="/resources/images/${boardVO.image}"/>"/>
				</td>
			</tr>
			<tr>
				<th>ISBN</th>
				<td>${boardVO.isbn}</td>
			</tr>
			<tr>
				<th>책제목</th>
				<td>${boardVO.bookname}</td>
			</tr>
			<tr>
				<th>저자</th>
				<td>${boardVO.author}</td>
			</tr>
			<tr>
				<th>출판사</th>
				<td>${boardVO.publisher}</td>
			</tr>
			<tr>
				<th>가격(원)</th>
				<td>${boardVO.price}</td>
			</tr>
			<tr>
				<th>소개</th>
				<td width="300" height="200" colspan="2">
				${boardVO.info}</td>
			</tr>
		
		<!--
		<tr>
			<th>이미지</th>
			<td>${boardVO.image}</td>
		</tr>
		<tr>
			<th>ISBN</th>
			<td>${boardVO.isbn}</td>
		</tr>
		<tr>
			<th>책제목</th>
			<td>${boardVO.bookname}</td>
		</tr>
		<tr>
			<th>저자</th>
			<td>${boardVO.author}</td>
		</tr>
		<tr>
			<th>출판사</th>
			<td>${boardVO.publisher}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${boardVO.price}</td>
		</tr>
		<tr>	
			<th>소개</th>
			<td>${boardVO.info}</td>
		</tr>
		-->
	</table>
	<br>
	<div>
		<a href="<c:url value="/board/list"/>">도서 목록</a>
	</div>
</body>
</html>
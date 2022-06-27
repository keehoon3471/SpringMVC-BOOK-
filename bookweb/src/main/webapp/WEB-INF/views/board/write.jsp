<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<title>도서 추가</title>
<style>
table, th, td {
	border: 1px solid #bcbcbc;
	text-align: center;
	margin: auto;
}
td {
	text-align: center;
}
th {
	background-color: #bbdefb;
}
.image_container {
	width:300px;
	height:400px;
	overflow:hidden;
	margin:0 auto;
}
img {
	width:300px;
	height:400px;
	object-fit:container;
}
div {
	text-align:center;
}
</style>
</head>
<body>
	<div>
	<h2>도서 추가하기</h2>
	</div>
	<br>
	<form:form modelAttribute="boardVO" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td rowspan="7" width="500" height="300">
				이미지
				<div id="image_container"></div>
				</td>
			</tr>
			<tr>
				<th><form:label path="isbn">ISBN</form:label></th>
				<td><form:input path="isbn"/>
				<form:errors path="isbn"/></td>
			</tr>
			<tr>
				<th><form:label path="bookname">책제목</form:label></th>
				<td><form:input path="bookname"/>
				<form:errors path="bookname"/></td>
			</tr>
			<tr>
				<th><form:label path="author">저자</form:label></th>
				<td><form:input path="author"/>
				<form:errors path="author"/></td>
			</tr>
			<tr>
				<th><form:label path="publisher">출판사</form:label></th>
				<td><form:input path="publisher"/>
				<form:errors path="publisher"/></td>
			</tr>
			<tr>
				<th><form:label path="price">가격(원)</form:label></th>
				<td><form:input path="price"/>
				<form:errors path="price"/></td>
			</tr>
			<tr>
				<th><form:label path="image">이미지</form:label></th>
				<td><input type="file" name="uploadFile" accept="image/*" onchange="setThumbnail(event);"/>
				<!--
				<input name="uploadFile" type="file">
				-->
				
				<!-- <form:input type="file" path="image"/> -->
				<!--<form:input path="image"/> -->
				<form:errors path="image"/></td>
			</tr>
			<tr>
				<th><form:label path="info">소개</form:label></th>
				<td width="300" height="200" colspan="2">
				<form:textarea path="info" cols="50" rows="10"/>
				<form:errors path="info"/></td>
			</tr>
		</table>
		<br>
		<div>
			<input type="submit" value="도서등록">&nbsp;
			<a href="<c:url value="/board/list"/>">도서목록</a>		
		</div>
	</form:form>
	
	<script>
		function setThumbnail(event) {
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				document.querySelector("div#image_container").appendChild(img);
			};
			reader.readAsDataURL(event.target.files[0]);
		}
	</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 1. 단순 submit -->
<form method="post" enctype="multipart/form-data" action="/chapter06_SpringWebMaven/user/upload">
	<input type="file" name="img">
	<!-- <input type="button" value="이미지 등록">  이부분을 카메라 아이콘으로 바꿀거임-->
	<br><br>
	<input type="submit" id="uploadBtn" value="이미지 등록">

</form>


<!-- 2. Ajax 통신 -->


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
	<a href="/chapter06_SpringWebMaven/">
		<img src="../img/12.png" width="60" height="60">
	</a>이미지목록
</h3>
<hr/>
<input type="text" id="pg" value="${pg }">

<table id="userImageListTable" border="1" frame="hsides" rules="rows">

	
	<tr>
		<th width="150">번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
	</tr>
	
	<!--동적 처리  -->
	
	</table>
	

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/upload.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
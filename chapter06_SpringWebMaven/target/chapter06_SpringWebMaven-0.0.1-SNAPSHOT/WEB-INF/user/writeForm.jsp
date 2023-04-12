<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="/chapter06_SpringWebMaven/index.jsp" method="post">
	<table border="1">
		<tr>
			<th width="70">이름</th>
			<td><input type="text" name="name"></td>
		</tr>
			<tr>
			<th width="70">아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
			<tr>
			<th width="70">비밀번호</th>
			<td><input type="text" name="pwd"></td>
		</tr>
		
				<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>


</body>
</html>
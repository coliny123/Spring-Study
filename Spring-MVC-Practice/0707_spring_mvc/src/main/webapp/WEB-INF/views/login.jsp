<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<!--  로그인 실패시 메시지  -->
	<div style="color:red">${errorMsg}</div>
	
	<form action="login.do" method="post">
		id : <input type="text" name="userId"> <br/>
		pw : <input type="password" name="password"> <br/>
<!-- 		gender : <input type="radio" name="gender" value="male" /> 남
				<input type="radio" name="gender" value="female" /> 여
				 <br/>
		hobby : <input type="checkbox" name="hobby" value="game" /> 게임
				<input type="checkbox" name="hobby" value="dance" /> 춤
				 <br/>  -->
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
	</form>
</body>
</html>
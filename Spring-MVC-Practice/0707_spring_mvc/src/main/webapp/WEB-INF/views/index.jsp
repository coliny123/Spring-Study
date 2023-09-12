<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<ul>
		<li><a href="${root}/user/register_form.do">사용자 등록 </a></li>
		<li><a href="${root}/user/list.do">사용자 목록</a></li>
		<li><a href="${root}/api/users">사용자 목록-JSON</a></li>
		<li><a href="${root}/api/users/dh990921">사용자 상세정보-JSON</a></li>
		<li><a href="${root}/api/users/spring">사용자 상세정보-JSON</a></li>
	</ul>
</body>
</html>
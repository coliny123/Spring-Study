<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">사용자 목록</h2>
		</div>

		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
					</tr>			
				</thead>
				<tbody>
<c:choose>
	<%-- 부서 있을때 --%>
	<c:when test="${not empty users}">
		<c:forEach items="${users}" var="user" varStatus="st">
				<tr>
					<td>${st.count}</td>
					<td>${user.userId}</td>
					<td><a href="${root}/user/detail.do?userId=${user.userId}">${user.name}</a></td>

				</tr>
		</c:forEach>		
	</c:when>
	<c:otherwise>
			<tr><td colspan="3">등록된 사용자가 없습니다.</td></tr>		
	</c:otherwise>	
</c:choose>				
		</tbody>
	</table>
	</div>

	</div>
</body>
</html>













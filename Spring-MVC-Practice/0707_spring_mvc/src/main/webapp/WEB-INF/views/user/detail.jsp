<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/menu.jsp"/>
	<div class="container">
		<div class="row mt-3">
			<h2 class="bg-primary text-light text-center">사용자 상세 조회</h2>
		</div>						
		<form method="post" action="${root}/user/modify.do" class="row">		<!--  -->
			<table class="table">
				<tbody>
					<tr>
						<th><label for="userId">아이디</label></th>
						<td><input type="text" name="userId" id="userId" 
									value="${user.userId}" readonly="readonly"/></td>	<!-- readonly도 파라미터는 감  -->
					</tr>
					<tr>
						<th><label for="password">비밀번호</label></th>
						<td><input type="text" name="password" id="password" 
							value="${user.password}"/></td>
					</tr>
					<tr>
						<th><label for="name">이름</label></th>
						<td><input type="text" name="name" id="name" 
								value="${user.name}" readonly="readonly"/></td>
					</tr>
					<tr>
						<th><label for="email">이메일</label></th>
						<td><input type="text" name="email" id="email" 
								value="${user.email}" /></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
<%-- 						<c:if test="${userId eq 'admin'}"> --%>
							<input type="submit" value="수정"/>		<!-- 위의 action을 이용해서 이동 -->
							<input type="submit" value="삭제" formaction="${root}/user/remove.do"  formmethod="get"/>		<!-- formaction으로 이동 -->
<%-- 						</c:if> --%>						
							<input type="reset" value="취소"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>






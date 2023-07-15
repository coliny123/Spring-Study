<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<h2 class="bg-primary text-light text-center">사용자 등록</h2>
		</div>
	<form method="post" action="./register.do">
        <table class="table">
            <tbody>
                <tr>
                    <th><label for="userId">아이디</label></th>
                    <td><input type="text" name="userId" id="userId"/></td>
                </tr>
                <tr>
                    <th><label for="password">비밀번호</label></th>
                    <td><input type="password" name="password" id="password"/></td>
                </tr>
                <tr>
                    <th><label for="name">이름</label></th>
                    <td><input type="text" name="name" id="name"/></td>
                </tr>
                <tr>
                    <th><label for="email">이몌일</label></th>
                    <td><input type="text" name="email" id="email"/></td>
                </tr>
            </tbody>
            <tfoot>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="등록"/>
                        <input type="reset" value="취소"/>
                    </td>
                </tr>
            </tfoot>
        </table>
    </form>
</div>    
</body>
</html>
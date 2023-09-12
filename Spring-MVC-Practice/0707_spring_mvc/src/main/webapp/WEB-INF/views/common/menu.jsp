<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
	<ul class="navbar-nav me-auto">
<c:choose>
	<c:when test="${empty userName}">
	    <li class="nav-item"><a class="nav-link"  href="${root}/user/login_form.do">로그인</a>
	    <li class="nav-item"><a class="nav-link bg-success text-white" href="${root}/user/register_form.do">사용자 등록</a></li>
	</c:when>
	<c:otherwise>
	    <span class="navbar-text me-3 ms-3 text-white">${userName}님 로그인 중</span>		<!-- 로그인 성공시 userName 정보가 유지되어야 함 -->
	    <li class="nav-item"><a class="nav-link bg-success text-white" href="${root}/user/register_form.do">사용자 등록</a></li>
	    <li class="nav-item"><a class="nav-link ms-2  bg-success text-white" href="${root}/user/logout.do">로그아웃</a></li>
	</c:otherwise>
</c:choose>
	<li class="nav-item"><a class="nav-link ms-2 bg-primary text-white" href="${root}/">
		홈</a></li>  
	</ul>
</nav>
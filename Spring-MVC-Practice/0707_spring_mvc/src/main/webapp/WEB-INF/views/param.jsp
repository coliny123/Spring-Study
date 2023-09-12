<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Param</title>
</head>
<body>
   <h1>Parameter Test</h1>
   <!--  로그인 실패시 메시지  -->
   <div style="color:red">${errorMsg}</div>
   
   <form action="param.do" method="post">
      name : <input type="text" name="name"> <br/>

      gender : <input type="radio" name="gender" value="male" /> 남
            <input type="radio" name="gender" value="female" /> 여
             <br/>
      hobby : <input type="checkbox" name="hobby" value="game" /> 게임
            <input type="checkbox" name="hobby" value="dance" /> 춤
             <br/> 
      <input type="submit" value="전송">
      <input type="reset" value="취소">
   </form>
</body>
</html>
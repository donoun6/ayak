<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberShip Login</title>
  <link type="text/css" rel="stylesheet" href="./css/successStyle.css?ver=1">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
  <div class="wrap">
       <div class="login">
       <% String id = request.getParameter("userId"); %>
           <h2> <%= id %>님 반갑습니다!</h2>
           <div class="img"><img src="./img/success.jpg" alt=""></div>
           <p><a href="/phms/index.jsp">홈페이지로 이동</a></p>
     </div>
  </div>
</body>
</html>

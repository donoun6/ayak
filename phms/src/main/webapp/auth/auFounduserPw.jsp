<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberShip Found User Pw</title>
<link type="text/css" rel="stylesheet" href="./css/style.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/53a8c415f1.js" crossorigin="anonymous"></script>
</head>
<body>
	<form action="msLogin" method="POST">
  <div class="wrap">
       <div class="login">
           <h2>비밀번호 찾기</h2>
           <div class="login_id">
               <h4 class="findinfo">고객님의 정보와 일치하는 비밀번호는 아래와 같습니다.</h4>
               <%@ page import="com.ayak.phms.membership.UserDao" %>
               <% UserDao userDao = new UserDao();
       		String Id = request.getParameter("userId");
    		String phone = request.getParameter("userphone");
    		userDao.findUserPw(Id, phone); 
               %>
               <h4 class="find"><%= userDao.getFindUserPw() %></h4>
           </div>
  			   <div class="login_etc"style="justify-content: space-between;">
               <div class="checkbox">
                 <a href="auLogin.jsp" style="margin-left: 15px;">로그인</a>
               </div>
               <div class="forgot_pw">
                 <a href="auFinduserId.jsp" style="margin-right: 15px;">아이디 찾기</a>
           </div>
           </div>
           <div class="submit">
           <a class="submit findLogin" href="auLogin.jsp">로그인 하러가기</a>
           <p class="main"><a href="../index.jsp">메인페이지</a></p>
           </div>
       </div>
   </div>
	</form>
</body>
</html>
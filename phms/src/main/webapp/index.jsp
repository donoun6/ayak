<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ko" dir="ltr">
      <head>
        <title>Ayak</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1. minimum-scale=1 user-scalable=no">
        <!-- bootstrap css code -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/initial.min.css">
        <link rel="stylesheet" href="./css/style.min.css">
        <link rel="stylesheet" href="../css/initial.min.css">
        <link rel="stylesheet" href="../css/style.min.css">
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
        <script type="text/javascript" src="./js/jquery.min.js"></script>
        <script type="text/javascript" src="./js/common.js"></script>
      </head>
      <body>
        <div id="wrap">
          <!-- alert -->
          <div class="alert alert-primary alert-dismissible fade show" role="alert" style="color:">
            <strong>Ayak</strong><span>&nbsp;&nbsp;‘#알고먹자’</span>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <!-- header -->
          <header id="header">
            <nav class="navbar navbar-expand-lg">
              <a class="navbar-brand" href="/phms/">Ayak</a>
              <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
              <% String id = (String)session.getAttribute("userId");
              if(id != null){%> 
              <ul class="navbar-nav" style=" align-items: center; ">
                  <li class="nav-item">
                  <%= id %>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="./auth/logout">로그아웃</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="./membership/mypage">마이페이지</a>
                  </li>
                </ul>
              <%}else {%>
               	<ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" href="/phms/auth/auLogin.jsp">로그인</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/phms/membership/msSignUp.jsp">회원가입</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/phms/auth/auLogin.jsp">마이페이지</a>
                  </li>
                </ul>
              <% } %>
              </div>
              <form class="form-inline" action="drugName.do" method="post">
                <input class="form-control mr-sm-2" type="text" name="M_DrugName" placeholder="약 이름을 검색하세요" aria-label="Search" style="font-size: 14px;">
                <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search</button>
              </form>
            </nav>
          </header>
          <!-- main -->
          <main id="main">
            <div class="swiper mySwiper">
              <div class="swiper-wrapper">
                <div class="swiper-slide">
                  <img src="https://richwood.net/wp-content/uploads/2021/09/main-visual-pharmaceuticals.jpg" alt="">
                  <div class="textbox">
                    <h2>Ayak</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                     <form action="pilllist.do" method="post">
		                <button class="btn btn-primary my-2 my-sm-0" type="submit">약 검색하기</button>
		             </form>
                  </div>
                </div>
              </div>
              <div class="swiper-pagination"></div>
            </div>
            <section id="section1">
            </section>
          </main>
          <footer>
         <div class="inner">
           <div class="fbox">
             <ul>
               <li>이용약관</li>
               <li>개인정보처리방침</li>
               <li>책임의 한계와 법적고지</li>
               <li>회원정보 고객센터</li>
             </ul>
           </div>
           <div class="fbox_bottom">
             <h2>Ayak</h2>
             <div class="copy">Copyright Ayak Corp. All Rights Reserved.</div>
           </div>
         </div>
       </footer>
        </div>
        <!-- bootstrap js code-->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <script type="text/javascript">
          $('#myModal').on('shown.bs.modal', function() {
            $('#myInput').trigger('focus')
          })
        </script>
        <!-- Swiper JS -->
        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
        <!-- Initialize Swiper -->
        <script>
          var swiper = new Swiper(".mySwiper", {
            pagination: {
              el: ".swiper-pagination",
              clickable: true,
            },
            keyboard: true,
          });
        </script>
      </body>
    </html>
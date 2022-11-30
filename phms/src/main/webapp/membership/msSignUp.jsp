<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ayak.phms.membership.UserServlet"%>
<%@ page import="com.ayak.phms.membership.UserDao"%>
  <!DOCTYPE html>
  <html lang="ko">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
      <title>Membership Sign Up</title>
      <link rel="stylesheet" href="./css/normalize.css">
      <link rel="stylesheet" href="./css/default.css">
      <link rel="stylesheet" href="./css/style.css">
      <script type="text/javascript" src="./js/prefix.js"></script>
      </head>
      <body>
        <div id="wrap">
          <div class="title"> 
             <h2><a href="../index.jsp">Ayak</a></h2>
          </div>
          <form action="adduser" method="post">
            <table class="table_a">
              <tr>
                <td>
                  <ul class="id">
                   <li><h2>아이디</h2></li>
                   <li><input type="text" placeholder="5~20자의 영문 소문자,숫자와 사용가능합니다.      @Ayak.com" name="userId" minlength="5" maxlength="20" pattern="^[a-zA-Z0-9]+$"></li>
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>비밀번호</h2> </li>
                    <input type="password" placeholder="8~16자의 영문 대 소문자,숫자를 사용하세요."  name="userPassWd" minlength="8" maxlength="16" pattern="^[a-zA-Z0-9]+$" >
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2 class="name">이름</h2></li>
                    <input type="text" name="userName" maxlength="6">
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>생년월일</h2></li>
                    <input type="text" placeholder="년(4자)" maxlength="4" class="small" name="year">
                    <select class="select-1" name="month" required>
                        <option disabled selected>월</option>
                        <option value="01">1</option>
                        <option value="02">2</option>
                        <option value="03">3</option>
                        <option value="04">4</option>
                        <option value="05">5</option>
                        <option value="06">6</option>
                        <option value="07">7</option>
                        <option value="08">8</option>
                        <option value="09">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <select class="small" name="day" required>
                      <option disabled selected>일</option>
                      <option value="01">1</option>
                      <option value="02">2</option>
                      <option value="03">3</option>
                      <option value="04">4</option>
                      <option value="05">5</option>
                      <option value="06">6</option>
                      <option value="07">7</option>
                      <option value="08">8</option>
                      <option value="09">9</option>
                      <option value="10">10</option>
                      <option value="11">11</option>
                      <option value="12">12</option>
                      <option value="13">13</option>
                      <option value="14">14</option>
                      <option value="15">15</option>
                      <option value="16">16</option>
                      <option value="17">17</option>
                      <option value="18">18</option>
                      <option value="19">19</option>
                      <option value="20">20</option>
                      <option value="21">21</option>
                      <option value="22">22</option>
                      <option value="23">23</option>
                      <option value="24">24</option>
                      <option value="25">25</option>
                      <option value="26">26</option>
                      <option value="27">27</option>
                      <option value="28">28</option>
                      <option value="29">29</option>
                      <option value="30">30</option>
                      <option value="31">31</option>
                    </select>
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li> <h2>성별</h2> </li>
                    <select class="gender" name="userGender" required>
                      <option disabled selected>성별</option>
                      <option value="M">남자</option>
                      <option value="W">여자</option>
                    </select>
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>본인 이메일</h2></li>
                    <input type="email" placeholder="이메일 형식을 입력해주세요." name="userEmail" maxlength="20">
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>휴대전화</h2></li>
                    <input type="tel" placeholder="ex) 010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13" name="userphone">
                  </ul>
                </td>
              </tr>
            </table>
            <div class="button-group">
              <button type="submit" class="gbtn normal" cursor: pointer;>가입하기</button>
            </div>
          </form>
        </div>
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
     </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.ayak.phms.membership.UserServlet"%>
<%@ page import="com.ayak.phms.membership.UserDao"%>
<%@ page import= "java.util.*" %>

<%
	String userId = request.getParameter("userId");
	String userPassWd = request.getParameter("userPassWd");
	String userName = request.getParameter("userName");
	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	String userGender = request.getParameter("userGender");
	String userEmail = request.getParameter("userEmail");
	String userphone = request.getParameter("userphone");
	
	UserDao userDao = new UserDao();
	int resultId = userDao.checkUserId(userId);
	int resultEmail = userDao.checkUserEmail(userEmail);
	int resultPhone = userDao.checkUserPhone(userphone);
%>
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
                   <%if(userId == null || userId.length() == 0) {
                  		String unlluserId = "<p class=error>ID는 필수입력 정보입니다.</p>";%>
                  		<%=unlluserId %>
                  		<%
                  	} %>
                  	<% if(resultId == 1){
                	   String checkId = "<p class=error>해당 아이디는 중복된 아이디입니다.</p>"; %>
                	   <%= checkId %>
                   <% } %>
                   <li><input type="text" placeholder="@Ayak.com" name="userId"></li>
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>비밀번호</h2> </li>
                     <%if(userPassWd == null || userPassWd.length() == 0) {
                  		String unlluserPassWd = "<p class=error>비밀번호는 필수입력 정보입니다.</p>";%>
                  		<%=userPassWd %>
                  		<%
                  	} %>
                    <input type="password" name="userPassWd">
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2 class="name">이름</h2></li>
                     <%if(userName == null || userName.length() == 0) {
                  		String unlluserName = "<p class=error>이름은 필수입력 정보입니다.</p>";%>
                  		<%=unlluserName %>
                  		<%
                  	} %>
                    <input type="text" name="userName">
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>생년월일</h2></li>
                    <%if(year == null || year.length() == 0 || month == null || month.length() == 0 || day == null || day.length() == 0) {
                  		String ssn = "<p class=error>필수입력 정보입니다.</p>";%>
                  		<%=ssn %>
                  		<%
                  	} %>
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
                    <%if(userGender == null || userGender.length() == 0) {
                  		String unlluserGender = "<p class=error>성별은 필수입력 정보입니다.</p>";%>
                  		<%=unlluserGender %>
                  		<%
                  	} %>
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
                    <%if(userEmail == null || userEmail.length() == 0) {
                  		String unlluserPhone = "<p class=error>이메일은 필수입력 정보입니다.</p>";%>
                  		<%=unlluserPhone %>
                  		<%
                  	} %>
                  		<% if(resultEmail == 1){
                	   String checkEmail = "<p class=error>해당 이메일은 중복된 이메일입니다.</p>"; %>
                	   <%= checkEmail %>
                   <% } %>
                    <input type="email" placeholder="이메일 형식을 입력해주세요." name="userEmail">
                  </ul>
                </td>
              </tr>
              <tr>
                <td>
                  <ul>
                    <li><h2>휴대전화</h2></li>
                    <%if(userphone == null || userphone.length() == 0) {
                  		String unlluserPhone = "<p class=error>휴대전화는 필수입력 정보입니다.</p>";%>
                  		<%=unlluserPhone %>
                  		<%
                  	} %>
                  	<% if(resultPhone == 1){
                	   String checkPhone = "<p class=error>해당 번호는 중복된 번호입니다.</p>"; %>
                	   <%= checkPhone %>
                   <% } %>
                    <input type="tel" placeholder="ex) 010-0000-0000" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" maxlength="13" name="userphone">
                  </ul>
                </td>
              </tr>
            </table>
            <div class="button-group">
              <button type="submit" class="gbtn normal" href="http://localhost:8080/phms/loginOut/msLogin.jsp" cursor: pointer;>가입하기</button>
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

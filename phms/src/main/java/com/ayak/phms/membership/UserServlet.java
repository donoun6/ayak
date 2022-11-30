package com.ayak.phms.membership;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/membership/adduser")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //form태그의 method를 post로 할시 doPost로 받는다.
		response.setContentType("text/html;charset=UTF-8"); //출력값을 한글로 받겠다.
		request.setCharacterEncoding("UTF-8"); //POST요청 방식의 한글 처리
		
		String userId = request.getParameter("userId"); //클라이언트가 요청한(from에 입력한)데이터를 가져와서 userId라는 변수에 넣는다. 
		String userPassWd = request.getParameter("userPassWd");
		String userName = request.getParameter("userName");
		String year = request.getParameter("year");	
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		String userphone = request.getParameter("userphone");
		
		User user = new User(); //User 클래스를 인스턴스(객체화)
		user.setUserId(userId); //위에서 getParameter메서드로 받은 값을 User클래스의 set메서드에 저장.
		user.setUserPassWd(userPassWd);
		user.setUserName(userName);
		user.setDateOfBirth(year+month+day);
		user.setUserGender(userGender);
		user.setUserEmail(userEmail);
		user.setUserphone(userphone);
		
		UserDao userDao = new UserDao(); //UserDao 클래스를 인스턴스화
		int resultId = userDao.checkUserId(userId);
		int resultEmail = userDao.checkUserEmail(userEmail);
		int resultPhone = userDao.checkUserPhone(userphone);
		userDao.addUser(user); //UserDao클래스 안에있는 addUser()메서드를 실행 . 인자값으로 User 인스턴스를 넣는다. (UserDao 에서 필요한 User클래스 안에있는 메서드를 가져와 사용한다는 뜻?)
		
		if(userId == null || userId.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(resultId == 1 ) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(userPassWd == null || userPassWd.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(userName == null || userName.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(year == null || year.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(month == null || month.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(day == null || day.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(userGender == null || userGender.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(userEmail == null || userEmail.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(resultEmail == 1 ) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(userphone == null || userphone.length() == 0) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}if(resultPhone == 1 ) {
			request.getRequestDispatcher("/membership/msSignUpError.jsp").forward(request, response);
		}										
				
		RequestDispatcher dispatcher = null;
		
		request.setAttribute("user", user); //setParameter은 String형식으로 setAttribute는 object타입으로 저장
		dispatcher = request.getRequestDispatcher("msSuccess.jsp"); //페이지를 이동시키는것
		dispatcher.forward(request, response); //해당 요청값 응답값을 이동페이지 내에서도 적용시킬수 있도록?
		
		
	}

}

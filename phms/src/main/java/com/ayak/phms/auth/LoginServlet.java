package com.ayak.phms.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ayak.phms.membership.UserDao;

@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("auLogin.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassWd = request.getParameter("userPassWd");		

		UserDao userDao = new UserDao();
		int result = userDao.login(userId,userPassWd);
		
		if(result == 2) {
			request.getRequestDispatcher("auError.jsp").forward(request, response);
			return;
		}else if(result == -1) {
			request.getRequestDispatcher("auError.jsp").forward(request, response);
			return;
		}		
		
		//다른 사용자와 구분되는 페이지를만들기위해 아래 코드를 사용
		HttpSession session = request.getSession(true); 
		session.setAttribute("userId", userId); //Servlet간 공유하는 객체이다. 변환 유형이 object이다.
		//getParameter은 반환 유형이 String이며 클라이언트의 정보를 HTML 페이지에서 얻는데 사용
		response.sendRedirect("../index.jsp");
	}

}

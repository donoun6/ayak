package com.ayak.phms.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ayak.phms.membership.UserDao;

@WebServlet("/auth/finduserpw")
public class FindUserPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //post방식의 요청값 한글처리 안하면 깨진다.
		String id = request.getParameter("userId"); //클라이언트의 요청값을 받아온다. form태그의 action과 위의 Webservlet 매핑이 맞아야한다.
		String phone = request.getParameter("userphone");
		
		
		UserDao userDao = new UserDao();
		int result = userDao.findUserPw(id, phone); //findUserPw는 UserDao안에있는 메서드이며 리턴값이 Int이기 때문에 Int변수를 만들어 담는다.
		
		if(result == 2) {
			request.getRequestDispatcher("auErrorPw.jsp").forward(request, response);
			return;
		}else if(result == -1) {
			request.getRequestDispatcher("auErrorPw.jsp").forward(request, response);
			return;
		}	
		
		RequestDispatcher dispatcher = null;
		
		request.setAttribute("id", id);
		dispatcher = request.getRequestDispatcher("auFounduserPw.jsp");
		dispatcher.forward(request, response);
	}

}

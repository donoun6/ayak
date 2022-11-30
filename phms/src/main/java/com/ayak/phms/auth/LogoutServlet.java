package com.ayak.phms.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/auth/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//HttpSession는 인터페이스로 둘 이상의 page request에서 사용자를 식별하거나, 해상 사용자에 대한 정보를 저장하는 인터페이스
		HttpSession session = request.getSession(false); // getSession은 세션을 생성하고 반환하는 메서드로 인자값에 True , false가 들어간다. true는 기본적으로 ()와같이 공백으로 둘수있으며,
		//true = HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 세션을 생성.
		//false = HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 세션을 생성하지 않고 null값을 반환한다.
		
		session.invalidate(); //해당 함수는 세션을 없애고 세션에 속해있는 값을 없앤다.
		
		response.sendRedirect("auLogin.jsp"); //해당 함수는 페이지 이동을 담당하는 함수로 RequestDispatcherh와 차이가 있다.
		//1. SendRedirect는 이동 경로가 URL을 통해 변화하지만, RequestDispatcherh는 이동하는 경로 변화가 없음
		//2. SendRedirect는 경로 이동시 데이터를 가져갈 수 없지만, RequestDispatcher는 경로 이동시 데이터를 가져갈 수 있음
		//forward(): 페이지 출력, 페이지 전환, 이동된 url이 화면에 안보인다. request스코프에 담긴값이 유요하다. request,response가 유지된다는 말
		//SendRedirect(): 특정 url로 재 요청 클라이언트가 새로 페이지를 요청한것과 같은 방식으로 페이지가 이동된다. request,response가 유지X
	}

}

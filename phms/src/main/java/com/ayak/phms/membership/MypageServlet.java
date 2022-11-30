package com.ayak.phms.membership;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/membership/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false); //있을때만 연결하라는 뜻 false면 httpSession이 없으면 null값이 출력
		String userId = (String)session.getAttribute("userId"); //받아오기 String 으로 세션 받아 오기
		if(userId == null ) {  //로그인을 안하고 왔을때 로그인을 제대로 하고왔는지 체크 (세션이 없으면 아래동작)
			request.getRequestDispatcher("../index.jsp").forward(request, response); //로그인 안했을때 로그인페이지로 보내기
			return;
		}
		
		
		
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies){//세션을 유지 시키기 위해서
			System.out.println(cookie.getName() + " : " + cookie.getValue());
			if(cookie.getName().equals("lastAccessTime")) {
				request.setAttribute("lastAccessTime", URLDecoder.decode(cookie.getValue(), "UTF-8")); //값이 있으면 jsp에 값을 찍어 최근 방문일 확인
			}
		}
		
		response.addCookie(lastAccessTime());// cookie라는 인자를 달라고 한다. 쿠키를 만들어야 함	, 브라우저 메모리에 보관 브라우저가 꺼지더라도 일정정도 하드웨어에 보관하여 나타나도록
		request.getRequestDispatcher("msMypage.jsp").forward(request, response); //로그인이 되었으면 mypage로 보낸다.
	}

	private Cookie lastAccessTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String datestr = format.format(new Date());
		
		Cookie cookie = null;
		try {
			cookie = new Cookie("lastAccessTime", URLEncoder.encode(datestr,"UTF-8"));
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		cookie.setMaxAge(60 * 60 * 24 * 30);
		cookie.setPath("/"); // 슬래시는 root 이다 , 최상위 루트 
		return cookie;
	}
}

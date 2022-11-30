package com.ayak.phms.pill;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pilllist.do")
public class pillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Medicine medi = new Medicine();
		
		MedicineService medi_service = new MedicineService();
		
		List<Medicine> mediList = medi_service.getList();
		
		RequestDispatcher dispatcher = null;
		
		request.setAttribute("mediList", mediList);
		dispatcher = request.getRequestDispatcher("/pill/pill_search.jsp");
		dispatcher.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package com.ayak.phms.pill;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/PillSearch")
public class PillSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String cate = request.getParameter("sel");
		
		if(cate == null) {
			RequestDispatcher dispatcher = null;
			dispatcher = request.getRequestDispatcher("/pill/pill_search.jsp");
			dispatcher.forward(request, response);
		}
		
		if(cate.contentEquals("name")) {
			String drugInfo = request.getParameter("drugInfo");
			
			MedicineService medi_service = new MedicineService();
			
			List<Medicine> mediList = medi_service.getListByDrugName(drugInfo);
			
			RequestDispatcher dispatcher = null;
			
			request.setAttribute("mediList", mediList);
			dispatcher = request.getRequestDispatcher("pill/listByDrugName.jsp");
			dispatcher.forward(request, response);
		}else if(cate.contentEquals("company")) {
			String drugInfo = request.getParameter("drugInfo");
			System.out.println(drugInfo);
			MedicineService medi_service = new MedicineService();
			List<Medicine> mediList = medi_service.getListByCompany(drugInfo);
			
			
			System.out.println(mediList);
			RequestDispatcher dispatcher = null;
			
			request.setAttribute("mediList", mediList);
			dispatcher = request.getRequestDispatcher("/pill/listByDrugName.jsp");
			dispatcher.forward(request, response);
		}else if(cate.contentEquals("effect")) {
			String drugInfo = request.getParameter("drugInfo");
			MedicineService medi_service = new MedicineService();
			
			List<Medicine> mediList = medi_service.getListByDrugEffect(drugInfo);
			
			
			RequestDispatcher dispatcher = null;
			
			request.setAttribute("mediList", mediList);
			dispatcher = request.getRequestDispatcher("/pill/listByDrugName.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}

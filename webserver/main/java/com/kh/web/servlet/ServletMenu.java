package com.kh.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletMenu
 */
@WebServlet("/menu.do")
public class ServletMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mainMenu = request.getParameter("mainMenu");
		String sideMenu = request.getParameter("sideMenu");
		String drinkMenu = request.getParameter("drinkMenu");
		
		int priceAll;
		int priceMain = 0;
		int priceSide = 0;
		int priceDrink = 0;
		
		switch(mainMenu) {
		case "한우버거" : priceMain = 5000; break;
		case "밥버거" : priceMain = 4500; break;
		case "치즈버거" : priceMain = 4000; break;
		}
		switch(sideMenu) {
		case "감자튀김" : priceSide = 1500; break;
		case "어니언링" : priceSide = 1700; break;
		}
		switch(drinkMenu) {
		case "콜라" : priceDrink = 1000; break;
		case "사이다" : priceDrink = 1000; break;
		case "커피" : priceDrink = 1500; break;
		case "밀크쉐이크" : priceDrink = 2500; break;
		}
		
		priceAll = priceMain + priceSide + priceDrink; 
		
		//jsp에 위임
		request.setAttribute("priceAll", priceAll);
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/menu/menuEnd.jsp");
		reqDispatcher.forward(request, response);
	}

}

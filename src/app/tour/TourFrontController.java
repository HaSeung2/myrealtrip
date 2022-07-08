package app.tour;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionTo;
import app.air.action.AirReserveAction;
import app.air.action.AirSearchAction;
import app.tour.action.TourTicketAction;

public class TourFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
		  doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();	// /board_mvc2/UserJoin.usrt
		String contextPath = req.getContextPath(); // /board_mvc2
		String command = requestURI.substring(contextPath.length());
		ActionTo acto = null;
		
		switch (command) {
		case "/tour/tourTicket.tr":
			try {
				System.out.println("tourTicket");
				acto = new TourTicketAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("투어티켓 이동 에러 : "+e);
			}
			break;
		}
		if(acto != null) {
			if(acto.isRedirect()) {
				resp.sendRedirect(acto.getPath());
			}
			else {
				RequestDispatcher disp = req.getRequestDispatcher(acto.getPath());
				disp.forward(req, resp);
			}
		}
	}
}

package app.mytrip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionTo;
import app.loading.action.AirReserveAction;
import app.loading.action.ReserveAction;
import app.mytrip.action.DeleteAirAction;
import app.mytrip.action.DeleteHotelAction;
import app.mytrip.action.MytripAction;

public class MytripFrontController  extends HttpServlet{

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
		case "/mytrip/mytrip.mt":
			try {
				acto = new MytripAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("내 여행 이동 에러 : "+e);
			}
			break;
		case "/mytrip/deleteHotelTicket.mt":
			try {
				acto = new DeleteHotelAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("호텔 삭제 이동 에러 : "+e);
			}
			break;
		case "/mytrip/deleteAirTicket.mt":
			try {
				acto = new DeleteAirAction().execute(req,resp);
			} catch (Exception e) {
				System.out.println("호텔 삭제 이동 에러 : "+e);
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

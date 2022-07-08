package app.loading;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionTo;
import app.loading.action.AirReserveAction;
import app.loading.action.ReserveAction;

public class ReserveFrontController  extends HttpServlet{

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
		case "/loading/reserve.rs":
			try {
				acto = new ReserveAction().execute(req,resp);
			}catch (StringIndexOutOfBoundsException e) {
				acto = new ActionTo();
				acto.setRedirect(true);
				acto.setPath("/myrealtrip/hotel/hotel.ht");
			}  catch (Exception e) {
				System.out.println("예매 이동 에러 : "+e);
			}
			break;
		case "/loading/airReserve.rs":
			try {
				acto = new AirReserveAction().execute(req,resp);
			}catch (Exception e) {
				System.out.println("예매 이동 에러 : "+e);
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

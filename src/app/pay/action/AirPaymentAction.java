package app.pay.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.pay.dao.AirPaymentDTO;
import app.pay.dao.PaymentDAO;

public class AirPaymentAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 날짜를 받아와서 년, 월, 일 나누어 보내줌.
		String datefilter = req.getParameter("datefilter");
		String airline  = req.getParameter("airline");
		String airnum  = req.getParameter("airnum");
		String dep  = req.getParameter("dep");
		String arr  = req.getParameter("arr");
		String price  = req.getParameter("price");
		String useremail = req.getParameter("useremail");
		
        AirPaymentDTO paydto = new AirPaymentDTO();
        paydto.setUseremail(useremail);
        paydto.setDatefilter(datefilter);
        paydto.setAirline(airline);
        paydto.setAirnum(airnum);
        paydto.setDep(dep);
        paydto.setArr(arr);
        paydto.setPrice(price);
		
		PaymentDAO pdao = new PaymentDAO();
		pdao.airPay(paydto);
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/index.jsp?pay=a");
		return acto;
	}
}

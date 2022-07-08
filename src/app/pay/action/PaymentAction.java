package app.pay.action;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.pay.dao.PaymentDAO;
import app.pay.dao.paymentDTO;

public class PaymentAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 날짜를 받아와서 년, 월, 일 나누어 보내줌.
		String datefilter = req.getParameter("datefilter");
		String hotelname  = req.getParameter("hotelname");
		String hotelImg  = req.getParameter("hotelImg");
		String hotelPrice  = req.getParameter("hotelPrice");
		String useremail = req.getParameter("useremail");
		
        paymentDTO paydto = new paymentDTO();
        paydto.setUseremail(useremail);
        paydto.setDatefilter(datefilter);
        paydto.setHotelImg(hotelImg);
        paydto.setHotelname(hotelname);
        paydto.setHotelPrice(hotelPrice);
		
		PaymentDAO pdao = new PaymentDAO();
		pdao.pay(paydto);
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/index.jsp?pay=a");
		return acto;
	}
}

package app.mytrip.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.mytrip.dao.MytripDAO;

public class DeleteHotelAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MytripDAO mtdao = new MytripDAO();
		
		String useremail = req.getParameter("useremail");
		String hotelname = req.getParameter("hotelname");
		
		mtdao.deleteHotel(useremail, hotelname);
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(true);
		acto.setPath("/myrealtrip/mytrip/mytrip.mt");
		return acto;
	}
}

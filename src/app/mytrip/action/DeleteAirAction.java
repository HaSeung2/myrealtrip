package app.mytrip.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.mytrip.dao.MytripDAO;

public class DeleteAirAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MytripDAO mtdao = new MytripDAO();
		
		String useremail = req.getParameter("useremail");
		String airnum = req.getParameter("airnum");
		
		mtdao.deleteAir(useremail, airnum);
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(true);
		acto.setPath("/myrealtrip/mytrip/mytrip.mt");
		return acto;
	}
}

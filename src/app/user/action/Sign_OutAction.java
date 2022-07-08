package app.user.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionTo;

public class Sign_OutAction implements Action {
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		ActionTo acto = new ActionTo();
		HttpSession session = req.getSession();
		session.setAttribute("loginUser", null);
		acto.setRedirect(true);
		acto.setPath("/myrealtrip/index.jsp");
		return acto;
	}
}

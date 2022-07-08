package app.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;

public class PwSearchAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/user/pwCheck.jsp");
		return acto;
	}
}

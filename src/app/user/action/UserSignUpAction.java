package app.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;

public class UserSignUpAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//단순 페이지 이동임으로 forward로 보냄
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/user/sign_up.jsp");
		return acto;
	}
}

package app.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.user.dao.UserDAO;



public class CheckIdOkAction implements Action {

	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userid = req.getParameter("userid");
		UserDAO udao = new UserDAO();
		PrintWriter out = resp.getWriter();
		if(udao.checkId(userid)) {
			// ajax으로 날라온거기 때문에
			// 바로 결과를 응답을 해야지 페이지를 이동해서는 안된다.
			// 우리가 직접 응답을 해줘야 할 때 write를 사용한다.
			out.write("O");
		} else {
			out.write("X");
		}
		out.close();
		return null;
	}
	
}

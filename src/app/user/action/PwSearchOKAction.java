package app.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionTo;
import app.user.dao.UserDAO;

public class PwSearchOKAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		UserDAO udao = new UserDAO();
		String useremail = req.getParameter("userEmail");
		HttpSession session = req.getSession();
		session.setAttribute("useremail", useremail);
		//System.out.println(useremail);
		ActionTo acto = new ActionTo();
		
		PrintWriter out = resp.getWriter();
		if(udao.checkEmail(useremail)) {
			acto.setRedirect(false);
			acto.setPath("/app/user/changePw.jsp?userEmail="+useremail);
			return acto;
		} else {
			out.print("<script>");
			out.print("alert('존재하지 않는 이메일 입니다~');");
			out.print("history.go(-1);");
			out.print("</script>");
		}
		out.close();
		return null;
	}
}

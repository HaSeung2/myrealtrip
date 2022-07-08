package app.user.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionTo;
import app.user.dao.UserDAO;
import app.user.dao.UserDTO;

public class Sign_InOkAction implements Action{

	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String useremail = req.getParameter("userEmail");
		String userpw = req.getParameter("userPassword");
		PrintWriter out = resp.getWriter();
		
		UserDAO udao = new UserDAO();
		
		UserDTO loginUser = udao.login(useremail,userpw);	
		
		ActionTo acto = new ActionTo();
		
		if(loginUser != null) {		
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", loginUser);
			out.print("<script>");
			out.print("location.href = '"+req.getContextPath()+"/index.jsp';");
			out.print("</script>");
		} else {
			out.print("<script>");
			out.print("location.href = '"+req.getContextPath()+"/index.jsp';");
			out.print("</script>");
		}
		return null;
	}
}

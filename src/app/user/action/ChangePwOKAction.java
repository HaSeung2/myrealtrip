package app.user.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import action.Action;
import action.ActionTo;
import app.user.dao.UserDAO;
import app.user.dao.UserDTO;

public class ChangePwOKAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		UserDAO udao = new UserDAO();
		HttpSession session = req.getSession();
		String userPassword = req.getParameter("userPassword");
		String useremail = (String) session.getAttribute("useremail");
		//System.out.println(userPassword);
		//System.out.println(useremail);
		
		PrintWriter out = resp.getWriter();
		
		if(udao.changePw(userPassword,useremail)) {
			System.out.println("들어옴");
			  out.print("<script>"); 
			  out.print("alert('비밀번호 변경되었습니다');");
			  out.print("location.href = '"+req.getContextPath()+"/user/sign_in.us';");
			  out.print("</script>");
		}
		else {
			System.out.println("실패");
			out.print("<script>");
			out.print("alert('비밀번호 변경실패');");
			out.print("history.go(-1);");
			out.print("</script>");
		}
		out.close();
		return null;
	}
}

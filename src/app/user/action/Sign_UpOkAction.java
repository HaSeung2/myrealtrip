package app.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.user.dao.UserDAO;
import app.user.dao.UserDTO;

public class Sign_UpOkAction implements Action{
      
   @Override
   public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
	  String useremail = req.getParameter("userEmail");
      String username = req.getParameter("userName");
      String userpw = req.getParameter("userPassword");
      boolean check1 = Boolean.parseBoolean(req.getParameter("check1"));
      boolean check2 = Boolean.parseBoolean(req.getParameter("check2"));
      boolean check3 = Boolean.parseBoolean(req.getParameter("check3"));
      boolean check4 = Boolean.parseBoolean(req.getParameter("check4"));
      
      UserDTO newUser = new UserDTO();
      newUser.setUseremail(useremail);
      newUser.setUsername(username);
      newUser.setUserpw(userpw);
      newUser.setCheck1(check1);
      newUser.setCheck2(check2);
      newUser.setCheck3(check3);
      newUser.setCheck4(check4);
      
      UserDAO udao = new UserDAO();
      ActionTo acto = new ActionTo();
      
      acto.setRedirect(true);
      if(udao.join(newUser)) {
         acto.setPath(req.getContextPath()+"/user/sign_in.us?useremail"+useremail);
      }
      else {
         acto.setPath(req.getContextPath());
      }
      return acto;
   }
}
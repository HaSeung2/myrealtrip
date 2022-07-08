package app.mytrip.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionTo;
import app.mytrip.dao.MytripDAO;
import app.mytrip.dao.MytripDTO;
import app.mytrip.dao.MytripRoomDTO;
import app.user.dao.UserDTO;

public class MytripAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		MytripDAO mtdao = new MytripDAO();
		
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO) session.getAttribute("loginUser");
		String useremail = user.getUseremail();
		
		List<MytripDTO> mytripAirList = mtdao.getairlist(useremail);
		List<MytripRoomDTO> mytripRoomList = mtdao.getroomlist(useremail);
		
		req.setAttribute("mytripAirList", mytripAirList);
		req.setAttribute("mytripRoomList", mytripRoomList);
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/mytrip/mytrip.jsp");
		return acto;
	}
}

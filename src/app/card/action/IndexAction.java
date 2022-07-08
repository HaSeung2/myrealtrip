package app.card.action;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.ActionTo;
import app.card.dao.CardBennerDTO;
import app.card.dao.CardDAO;
import app.card.dao.CardDTO;
import app.card.dao.CardTicketDTO;

public class IndexAction implements Action {
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		CardDAO cdao = new CardDAO();
		
		List<CardDTO> cardList = cdao.cardList();
		List<CardBennerDTO> bannerList = cdao.bannerList();
		List<CardTicketDTO> ticketList = cdao.ticketList();
		
		
		req.setAttribute("cardList", cardList);
		req.setAttribute("bannerList", bannerList);
		req.setAttribute("ticketList", ticketList);
		
		HashMap<String, String> loginUser = new HashMap<>();
		HttpSession session = req.getSession();
		
		if(req.getParameter("loginUser") != null) {
			loginUser.put("useremail", req.getParameter("loginUser"));
			loginUser.put("username", req.getParameter("username"));
			session.setAttribute("loginUser", loginUser);
		}
		
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/card/myrealtrip.jsp");
		return acto;
	}
}

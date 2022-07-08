package app.tour.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.card.dao.CardBennerDTO;
import app.card.dao.CardDAO;
import app.card.dao.CardTicketDTO;

public class TourTicketAction implements Action {
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		CardDAO cdao = new CardDAO();

		List<CardBennerDTO> bannerList = cdao.bannerList();
		List<CardTicketDTO> ticketList = cdao.ticketList();
		
		req.setAttribute("bannerList", bannerList);
		req.setAttribute("ticketList", ticketList);
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/tour_ticket/tourTicket.jsp");
		return acto;
	}
}

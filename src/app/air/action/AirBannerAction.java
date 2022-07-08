package app.air.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.air.dao.AirSubBannerDTO;
import app.air.dao.AirDAO;
import app.card.dao.CardDAO;
import app.card.dao.CardDTO;
import app.card.dao.CardTicketDTO;

public class AirBannerAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		AirDAO adao = new AirDAO();
		
		List<AirSubBannerDTO> subbannerList = adao.subBannerList();
		
		
		req.setAttribute("subbannerList", subbannerList);
		
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/air/airReserve.jsp");
		return acto;
	}
}

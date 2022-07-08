package app.air.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.air.dao.AirDAO;
import app.air.dao.AirJejuTicketDTO;
import app.air.dao.AirSubBannerDTO;

public class AirReserveAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//단순 페이지 이동임으로 forward로 보냄
		AirDAO adao = new AirDAO();
		List<AirJejuTicketDTO> jejuTicketList = adao.jejuTicketList();
		List<AirSubBannerDTO> subBannerList = adao.subBannerList();
		
		req.setAttribute("jejuTicketList", jejuTicketList);
		req.setAttribute("subBannerList", subBannerList);
		
		System.out.println("AirReserveAction");
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/air/airReserve.jsp");
		return acto;
	}
}

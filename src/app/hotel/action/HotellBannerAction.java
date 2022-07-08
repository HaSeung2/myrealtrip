package app.hotel.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionTo;
import app.air.dao.AirDAO;
import app.air.dao.AirSubBannerDTO;
import app.hotel.dao.HotelBannerDAO;
import app.hotel.dao.HotelBannerDTO;
import app.hotel.dao.HotelSpecialBannerDTO;
import app.hotel.dao.HotelSugsoDTO;

public class HotellBannerAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HotelBannerDAO hdao = new HotelBannerDAO();
		
		List<HotelBannerDTO> hotelbannerList = hdao.hotelBannerList();
		List<HotelSugsoDTO> hotelsugsoList = hdao.hotelsugsoList();
		List<HotelSpecialBannerDTO> hotelspecialList = hdao.hotelSpecialBannerList();
		
		
		req.setAttribute("hotelbannerList", hotelbannerList);
		req.setAttribute("hotelsugsoList", hotelsugsoList);
		req.setAttribute("hotelspecialList", hotelspecialList);
		
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/hotel/hotel.jsp");
		return acto;
	}
}

package app.hotel.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;

public class HotelBannerDAO {
	SqlSession sqlsession;

	public HotelBannerDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}
	
	public List<HotelBannerDTO> hotelBannerList(){
		List<HotelBannerDTO> hotel = null;
		try {
			hotel = sqlsession.selectList("Hotel.hotelbannerlist");
		} catch (Exception e) {
			System.out.println("호텔 배너 리스트 불러오기 실패" + e);
		}
		return hotel;
	}

	public List<HotelSugsoDTO> hotelsugsoList() {
		List<HotelSugsoDTO> hotel = null;
		try {
			hotel = sqlsession.selectList("Hotel.sugsolist");
		} catch (Exception e) {
			System.out.println("호텔 숙소 리스트 불러오기 실패" + e);
		}
		return hotel;
	}
	public List<HotelSpecialBannerDTO> hotelSpecialBannerList() {
		List<HotelSpecialBannerDTO> hotel = null;
		try {
			hotel = sqlsession.selectList("Hotel.specialbannerlist");
		} catch (Exception e) {
			System.out.println("호텔 특가 리스트 불러오기 실패" + e);
		}
		return hotel;
	}
}

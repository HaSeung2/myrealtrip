package app.card.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;

public class CardDAO {
	SqlSession sqlsession;
	
	public CardDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}
	
	public List<CardDTO> cardList() {
		List<CardDTO> cards = null;
		try {
			cards = sqlsession.selectList("Card.list");
		} catch (Exception e) {
			System.out.println("카드 리스트 불러오기 실패" + e);
		}
		return cards;	
	}

	public List<CardBennerDTO> bannerList() {
		List<CardBennerDTO> cards = null;
		try {
			cards = sqlsession.selectList("Card.bannerlist");
		} catch (Exception e) {
			System.out.println("카드 배너 불러오기 실패 : " + e);
		}
		return cards;	
	}

	public List<CardTicketDTO> ticketList() {
		List<CardTicketDTO> cards = null;
		try {
			cards = sqlsession.selectList("Card.ticketlist");
		} catch (Exception e) {
			System.out.println("티켓 불러오기 실패 : " + e);
		}
		return cards;	
	}
	
	
}


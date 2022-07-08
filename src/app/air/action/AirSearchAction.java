package app.air.action;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import action.Action;
import action.ActionTo;
import app.air.dao.AirDAO;

public class AirSearchAction implements Action{
	
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//date 정보
		String date = req.getParameter("datefilter");
		//System.out.println(data);
		int ticket_cnt = Integer.parseInt(req.getParameter("count-total-input")) ;
		//System.out.println(ticket_cnt);
		String boardingYear = date.substring(6,10);
		String boardingMonth = date.substring(0,2);
		String boardingDay = date.substring(3,5);
		String arriveYear = date.substring(19,23);
		String arriveMonth = date.substring(13,15);
		String arriveDay = date.substring(16,18);
		//System.out.println("출발 : " + boardingYear +"년"+boardingMonth +"월"+boardingDay +"일" );
		//System.out.println("도착 : " + arriveYear+"년" + arriveMonth+"월" +arriveDay+"일");
		req.setAttribute("ticket_cnt", ticket_cnt);
		req.setAttribute("boardingYear", boardingYear);
		req.setAttribute("boardingMonth", boardingMonth);
		req.setAttribute("boardingDay", boardingDay);
		req.setAttribute("arriveYear", arriveYear);
		req.setAttribute("arriveMonth", arriveMonth);
		req.setAttribute("boardingYear", boardingYear);
		req.setAttribute("arriveDay", arriveDay);
		
		
		
		//api
		AirDAO adao = new AirDAO();
		NodeList nodelist = adao.getAirAPI();
		
		List<Map<String, Object>> list = null;
		list = new ArrayList<>();
		
		Map<String, Object> map = null;
		
		String [] random_price = new String[10];
		int [] remainSeat = new int[10];
	
		for (int i = 0; i < nodelist.getLength(); i++) {
			//랜덤으로 가격 생성하기 
			int price_hd = (int) (Math.random()*(999-100+1)+100);
			int price_b = (int) (Math.random()*(99-50+1)+50);
			random_price[i] = price_b+","+price_hd;
			remainSeat[i] = (int) (Math.random()*(20)+1);		
			
			map = new HashMap<>();
			Node node = nodelist.item(i);
			NodeList item_childlist = node.getChildNodes();
			//req.setAttribute("node", item_childlist);
			for (int j = 0; j < item_childlist.getLength(); j++) {
				Node item_childe = item_childlist.item(j);
				if(item_childe.getNodeName().equals("etd")) {					
					//System.out.println(item_childe.getTextContent().substring(0,2));
					//System.out.println(item_childe.getTextContent().substring(2,4));
					map.put("fEtd", item_childe.getTextContent().substring(0,2)); 
					map.put("bEtd", item_childe.getTextContent().substring(2,4));
				}else {
					//System.out.println(item_childe.getTextContent());
					map.put(item_childe.getNodeName(), item_childe.getTextContent());					
				}
			}
			list.add(i,map);
		}
		req.setAttribute("remainSeat", remainSeat);
		req.setAttribute("price", random_price);
		//System.out.println(list);
		req.setAttribute("list", list);
		
		ActionTo acto = new ActionTo();
		acto.setRedirect(false);
		acto.setPath("/app/air/airlist.jsp");
		return acto;
	}
}












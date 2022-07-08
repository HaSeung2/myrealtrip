package app.air.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ibatis.session.SqlSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import mybatis.SqlMapConfig;

public class AirDAO {
SqlSession sqlsession;
public AirDAO() {
	sqlsession = SqlMapConfig.getFactory().openSession(true);
}

public NodeList getAirAPI() {
	 try {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 
		 StringBuffer pharm_url = new StringBuffer();
		 pharm_url.append("http://openapi.airport.co.kr/service/rest/FlightStatusList/getFlightStatusList");
		 pharm_url.append("?ServiceKey=rD9TOfCyg9tmZUi9W4yCMLyDIYanxc0Jc1wdI8lKfoSlldX1MTnbGj%2BtvvW2%2BxOZUFwt%2FPIEU6v4DALsgFeMGg%3D%3D");
		 pharm_url. append("&schAirCode=GMP");
		 URL url = new URL(pharm_url.toString());
		 
		 BufferedInputStream xmldata = new BufferedInputStream(url.openStream());
		 
		 HashMap<String, String> datas = new HashMap<String, String>();
		
		Document document = builder.parse(xmldata);
		Element root = document.getDocumentElement();
		NodeList list = root.getElementsByTagName("item");
		return list;
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (SAXException e) {
		e.printStackTrace();
	}
	return null;
	}

public List<AirSubBannerDTO> subBannerList() {
	List<AirSubBannerDTO> ards = null;
	try {
		ards = sqlsession.selectList("Air.subbannerlist");
	} catch (Exception e) {
		System.out.println("카드 서브 배너 불러오기 실패 : " + e);
	}
	return ards;	
	}

public List<AirJejuTicketDTO> jejuTicketList() {
	List<AirJejuTicketDTO> ards = null;
	try {
		ards = sqlsession.selectList("Air.jejuticketlist");
	} catch (Exception e) {
		System.out.println("카드 서브 배너 불러오기 실패 : " + e);
	}
	return ards;	
	}
}
package app.mytrip.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;


public class MytripDAO {
SqlSession sqlsession;

public MytripDAO() {
	sqlsession = SqlMapConfig.getFactory().openSession(true);	// true로 설정시 오토커밋
}

public List<MytripDTO> getairlist(String useremail) {
	HashMap<String, Object> datas = new HashMap<String, Object>();
	List<MytripDTO> trip;
	datas.put("useremail", useremail);
    trip = sqlsession.selectList("Mytrip.airlist",datas);
	return trip;
}

public List<MytripRoomDTO> getroomlist(String useremail) {
	HashMap<String, Object> datas = new HashMap<String, Object>();
	List<MytripRoomDTO> trip;
	datas.put("useremail", useremail);
	trip = sqlsession.selectList("Mytrip.roomlist",datas);
	return trip;
}

public boolean deleteHotel(String useremail, String hotelname) {
	HashMap<String, String> datas = new HashMap<String, String>();
	datas.put("useremail", useremail);
	datas.put("hotelname", hotelname);
	return sqlsession.delete("Mytrip.deleteHotel",datas) == 1;
}

public boolean deleteAir(String useremail, String airnum) {
	HashMap<String, String> datas = new HashMap<String, String>();
	datas.put("useremail", useremail);
	datas.put("airnum", airnum);
	return sqlsession.delete("Mytrip.deleteAir",datas) == 1;
}


}
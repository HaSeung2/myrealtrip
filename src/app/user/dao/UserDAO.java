package app.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import mybatis.SqlMapConfig;


public class UserDAO {
SqlSession sqlsession;

public UserDAO() {
	sqlsession = SqlMapConfig.getFactory().openSession(true);	// true로 설정시 오토커밋
}

public boolean join(UserDTO newUser) {
	return sqlsession.insert("User.join",newUser) == 1;
}
public boolean checkId(String userid) {
	int result = sqlsession.selectOne("User.checkId",userid);
	return result == 0;
}
public boolean checkEmail(String useremail) {
	int result = sqlsession.selectOne("User.checkEmail",useremail);
	return result == 1;
}
public UserDTO login(String useremail,String userpw) {
	// 관련이 없는 DTO로 묶일 수 없는 여러개의 값을 보낼 때는 HashMap을 사용한다.
	HashMap<String, String> datas = new HashMap<>();
	datas.put("useremail", useremail);
	datas.put("userpw", userpw);
	
	UserDTO loginUser = sqlsession.selectOne("User.login",datas);
	return loginUser;
}

public boolean changePw(String userPassword, String useremail) {
	HashMap<String, String> datas = new HashMap<>();
	datas.put("useremail", useremail);
	datas.put("userpw", userPassword);
	
	int result = sqlsession.update("User.changePw",datas);
	return result == 1;
}
}
package app.pay.dao;

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


public class PaymentDAO {
SqlSession sqlsession;

public PaymentDAO() {
	sqlsession = SqlMapConfig.getFactory().openSession(true);	// true로 설정시 오토커밋
}

public boolean pay(paymentDTO newPayment) {
	return sqlsession.insert("Pay.payment",newPayment) == 1;
}

public boolean airPay(AirPaymentDTO paydto) {
	return sqlsession.insert("Pay.airpayment",paydto) == 1;	
}


}
package com.javalec.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class InsertRightPayment_dao {
DataSource dataSource;
	
	public InsertRightPayment_dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/1teamp");
			//Servers > context.xml  뿉  엳 뒗  젙蹂대줈 DB  뿰寃곗쓣  걹 궦 寃 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}/////
	
	
	public void insertRightPayment(String cPrice, String cAddress, String product_pCode, String uid, int cQuantity) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into cart ( cPrice, cDate, cAddress, cQuantity, cDecision, product_pCode, user_uId) values ( ?, now(), ?, ?, ?, ?, ? ) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cPrice);
			preparedStatement.setString(2, cAddress);
			preparedStatement.setInt(3, cQuantity);
			preparedStatement.setString(4, "결재완료");
			preparedStatement.setString(5, product_pCode);
			preparedStatement.setString(6, uid);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//write
}

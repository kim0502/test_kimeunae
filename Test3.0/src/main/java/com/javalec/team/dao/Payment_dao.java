package com.javalec.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Payment_dao {


	DataSource dataSource; // Servers-context.xml을 가져올거임
	
	public Payment_dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/1teamp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		}
	
	public void revise(String cQuantity, String product_pCode) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		

		try {
			connection = dataSource.getConnection();
			String query = "update cart set cQuantity = ?  Where product_pCode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(cQuantity));
			preparedStatement.setString(2, product_pCode);
			preparedStatement.executeUpdate();

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {

				if(preparedStatement!=null) preparedStatement.close();
				if(connection!=null) connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


		
	}
	
	
	

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

	
	public void inserto(int oPrice, int oQuantity,String product_pCode,String user_uId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		

		try {
			connection = dataSource.getConnection();
			String query = "insert into ordering(oPrice,oDate,oQuantity,product_pCode,user_uId) values (?,now(),?,?,?) ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,oPrice);
			preparedStatement.setInt(2,oQuantity);
			preparedStatement.setString(3, product_pCode);
			preparedStatement.setString(4, user_uId);
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
	
	
	

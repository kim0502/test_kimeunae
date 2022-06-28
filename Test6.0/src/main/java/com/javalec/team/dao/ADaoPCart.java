package com.javalec.team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.team.dto.ADtoPCart;

public class ADaoPCart {

	DataSource dataSource;

	public ADaoPCart() {
		// TODO Auto-generated constructor stub
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/1teamp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ADtoPCart> list(String uID, int[] checkBox) {
		ArrayList<ADtoPCart> dtos = new ArrayList<ADtoPCart>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
			try {
				connection = dataSource.getConnection();
				String queryA = "select c.cCode, p.pCode, p.pImg_main, p.pName, p.pPrice c.cQuantity , c.cSum";
				String queryB = "from cart c, user u, product p where c.user_uID = u.uID and c.product_pCode = p.pCode and u.uID = ?";
				if(checkBox!=null) {
					queryB = queryB + " and c.cCode = ?";
				}
				preparedStatement = connection.prepareStatement(queryA+queryB);
				preparedStatement.setString(1, uID);
				if(checkBox!=null) {
					for(int j=0; j<checkBox.length; j++) {
						preparedStatement.setInt(2, checkBox[j]);
						
						resultSet = preparedStatement.executeQuery();
						
						while (resultSet.next()) {
							int cCode = resultSet.getInt("cCode");
							String pCode = resultSet.getString("pCode");
							String pImg_main = resultSet.getString("pImg_main");
							String pName = resultSet.getString("pName");
							int pPrice = resultSet.getInt("pPrice");
							int cQuantity = resultSet.getInt("cQuantity");
							int cSum = cQuantity*pPrice;
							
							ADtoPCart dto = new ADtoPCart(cCode, pCode, pImg_main, pName,  pPrice, cQuantity, cSum);
							dtos.add(dto);
						}
					}
				}else {
					resultSet = preparedStatement.executeQuery();
					
					while (resultSet.next()) {
						int cCode = resultSet.getInt("cCode");
						String pCode = resultSet.getString("pCode");
						String pImg_main = resultSet.getString("pImg_main");
						String pName = resultSet.getString("pName");
						int pPrice = resultSet.getInt("pPrice");
						int cQuantity = resultSet.getInt("cQuantity");
						int cSum = cQuantity*pPrice;
						
						ADtoPCart dto = new ADtoPCart(cCode, pCode, pImg_main, pName,  pPrice, cQuantity, cSum);
						dtos.add(dto);
					}
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				try {
					if(resultSet != null)resultSet.close();
					if(preparedStatement != null)preparedStatement.close();
					if(connection != null)connection.close();
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			return dtos;
	}
}

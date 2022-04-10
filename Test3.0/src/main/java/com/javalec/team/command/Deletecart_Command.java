package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.dao.Deletecart_dao;



public class Deletecart_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String product_pCode = request.getParameter("product_pCode");
		
		
		Deletecart_dao dao = new Deletecart_dao();
		dao.deletecart(product_pCode); 
		
		
	}

}

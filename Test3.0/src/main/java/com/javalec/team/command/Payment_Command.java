package com.javalec.team.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.dao.Payment_dao;
import com.javalec.team.dao.Wishlist_dao;
import com.javalec.team.dto.Wishlist_dto;


public class Payment_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String cQuantity = request.getParameter("cQuantity");
		String product_pCode = request.getParameter("product_pCode");
		
		Payment_dao dao = new Payment_dao();
		dao.revise(cQuantity, product_pCode);
		
		
		Wishlist_dao dao1 = new Wishlist_dao();
		ArrayList<Wishlist_dto> dtos = dao1.list();
		request.setAttribute("list", dtos);
	
	}

}

package com.javalec.team.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.Wishlist_dao;
import com.javalec.team.dto.Wishlist_dto;

public class Wishlist_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
	    String uid =(String)session.getAttribute("uId");
	    
		Wishlist_dao dao = new Wishlist_dao();
		ArrayList<Wishlist_dto> dtos = dao.list(uid);
		request.setAttribute("list", dtos);

		
	}

}

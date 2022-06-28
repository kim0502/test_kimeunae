package com.javalec.team.command;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.dao.Payment_dao;
import com.javalec.team.dto.Payment_dto;



public class Payment_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Payment_dao dao = new Payment_dao();
		ArrayList<Payment_dto> dtos = dao.list();
		request.setAttribute("list", dtos);

	}

}

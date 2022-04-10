package com.javalec.team.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.dao.Paymentrevise_dao;
import com.javalec.team.dto.Paymentrevise_dto;


public class Paymentrevise_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Paymentrevise_dao dao = new Paymentrevise_dao();
		//context.xml을 통해 데이터 불러옴
		ArrayList<Paymentrevise_dto> dtos =dao.list();
		request.setAttribute("list", dtos);
	}

}

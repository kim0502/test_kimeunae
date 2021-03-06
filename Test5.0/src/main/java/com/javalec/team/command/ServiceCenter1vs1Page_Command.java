package com.javalec.team.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.dao.ServiceCenter1vs1_dao;
import com.javalec.team.dto.ServiceCenter1vs1_dto;

public class ServiceCenter1vs1Page_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int startnum =Integer.parseInt(request.getParameter("startnum"));
		int endnum= Integer.parseInt(request.getParameter("endnum"));
		ServiceCenter1vs1_dao dao = new ServiceCenter1vs1_dao();
		ArrayList<ServiceCenter1vs1_dto> dtos = dao.ServiceCenter1vs1Page(startnum,endnum);
		request.setAttribute("list", dtos);
	}

}

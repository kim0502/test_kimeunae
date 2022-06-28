package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.InsertOrdering_dao;


public class Insertordering_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
	    String uid =(String)session.getAttribute("uId");		
		
		InsertOrdering_dao dao = new InsertOrdering_dao();
		dao.modify(address, uid);
	}

}

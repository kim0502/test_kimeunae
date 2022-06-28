package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.InsertCart_dao;

public class InsertCart_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			String pCode = request.getParameter("pCode") ;
		    int pQuantity = Integer.parseInt(request.getParameter("pQuantity")) ;
		    String cDecision = request.getParameter("cDecision") ;
		    int pPrice = Integer.parseInt(request.getParameter("pPrice"))*pQuantity ;
		   
		    HttpSession session = request.getSession();
		      String uid =(String)session.getAttribute("uId");
		InsertCart_dao dao = new InsertCart_dao();
		dao.insertCart(pCode,pQuantity,cDecision,pPrice,uid);
	}

}
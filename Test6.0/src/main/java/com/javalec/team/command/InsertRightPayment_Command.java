package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.InsertCart_dao;
import com.javalec.team.dao.InsertRightPayment_dao;

public class InsertRightPayment_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String cPrice = request.getParameter("cPrice");
		String cAddress = request.getParameter("cAddress");
		String product_pCode = request.getParameter("product_pCode");
		String uid = request.getParameter("uId");
	    System.out.println(uid);
	    int cQuantity = Integer.parseInt(request.getParameter("cQuantity")); 
		
		InsertRightPayment_dao dao = new InsertRightPayment_dao();
		dao.insertRightPayment(cPrice, cAddress, product_pCode, uid, cQuantity);
	}

}

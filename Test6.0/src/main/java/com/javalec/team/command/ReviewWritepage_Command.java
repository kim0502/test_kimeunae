package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.ReviewWrite_dao;

public class ReviewWritepage_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		
		String oCode=request.getParameter("oCode");
		String rTitle = request.getParameter("rTitle");
		String rImg = request.getParameter("imgFile");
		String rContent = request.getParameter("rContent");
		int cCode=Integer.parseInt(request.getParameter("cCode"));
		HttpSession session = request.getSession();
		
		String uid =(String)session.getAttribute("uId");
		
	
		
		ReviewWrite_dao dao = new ReviewWrite_dao();
		dao.write(rTitle, rImg, rContent, uid, oCode, cCode);
		}
	}


//rTitle rImg rContent user_uId order_oCode
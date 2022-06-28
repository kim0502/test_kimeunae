package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.ServiceCenter1vs1Write_dao;

public class ServiceCenterWrite_Command implements PCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String iCode = request.getParameter("iCode");
		HttpSession session = request.getSession();
	    String uid =(String)session.getAttribute("uId");
	    
		String user_uEmail = request.getParameter("user_uEmail");
		String iTitle = request.getParameter("iTitle");
		String iContent = request.getParameter("iContent");
		
		ServiceCenter1vs1Write_dao dao = new ServiceCenter1vs1Write_dao(); //BDao.java의 dao라는 변수를 만들어주고 BDao.java로 보내준다.
		dao.write(iCode, uid, user_uEmail, iTitle, iContent);
	}

}

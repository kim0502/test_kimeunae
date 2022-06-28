package com.javalec.team.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.dao.Deletecart_dao;



public class Deletecart_Command implements PCommand {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      
      String pCode = request.getParameter("pCode");
      int cQuantity = Integer.parseInt(request.getParameter("cQuantity"));
      
      HttpSession session = request.getSession();
      String uid =(String)session.getAttribute("uId");
      
     
      Deletecart_dao dao = new Deletecart_dao();
      dao.deletecart(pCode, cQuantity, uid); 
      
      
   }

}
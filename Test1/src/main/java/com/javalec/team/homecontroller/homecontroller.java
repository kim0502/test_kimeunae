package com.javalec.team.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.project.command.Delete_Command;
import com.javalec.project.command.Paymentrevise_Command;
import com.javalec.project.command.Wishlist_Command;
import com.javalec.team.command.PCommand;
import com.javalec.team.command.ServiceCenter1vs1_Command;

/**
 * Servlet implementation class homecontroller
 */
@WebServlet("*.do")
public class homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public homecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet"); 
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost"); 
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8"); //한글처리를 줘야되기때문에 써줘야됨
		
		String viewPage = null; // viewPage는 사용자가 보는 화면을 뜻함. switch를 통해 이줄밑에는 viewPage의 종류를 정의해주면됨
		PCommand command =null;
		
		String uri = request.getRequestURI(); // uri는 프로젝트 이름/~.do
		String conPath = request.getContextPath(); // conPath는 프로젝트 이름
		String com = uri.substring(conPath.length()); // com은 ~.do
		
//		System.out.println(uri); 
//		System.out.println(conPath);
//		System.out.println(com);
		
		switch(com) {
		
			
			case("/wishlist.do")://전체 내용 보여주기
//				command = new Wishlist_Command();
//				command.execute(request, response);
				viewPage = "wishlist.jsp";
				break;									
			
			case("/delete.do")://장바구니삭제
//				command = new Delete_Command();
//				command.execute(request, response);
				viewPage = "wishlist.do";
				break;
			case("/payment.do")://결제
//				command = new Payment_Command();
//				command.execute(request, response);
				viewPage = "payment.jsp";
				break;
			case("/paymentrevise.do")://결제에서 물품 수정하기
//				command = new Paymentrevise_Command();
//				command.execute(request, response);
				viewPage = "payment.jsp";
				break;	
		
		} // switch(com)
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}

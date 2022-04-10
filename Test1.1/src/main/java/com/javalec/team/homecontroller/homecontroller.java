package com.javalec.team.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.command.MPchange_Command;
import com.javalec.team.command.MPdelete_Command;
import com.javalec.team.command.MPinformation_Command;
import com.javalec.team.command.OrderpageCategory_Command;
import com.javalec.team.command.PCommand;
import com.javalec.team.command.ServiceCenter1vs1Detail_Command;
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
		
		case("/mainpage.do"): //메인홈페이지로 가기
			viewPage = "mainpage.jsp";
			break;
			
		//로그인(영진형) 시작	
		//로그인(영진형) 끝
			
		//고객센터 시작(승민)
		case("/serviceCenter.do"): //전체 내용 보여주기
			viewPage = "serviceCenter.jsp";
			break;
		
		case("/serviceCenter1vs1.do"): //1:1 문의로 가기
			command = new ServiceCenter1vs1_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1.jsp";
			break;
			
		case("/serviceCenter1vs1Detail.do")://문의 내용 보러가는 상세화면가기
			command = new ServiceCenter1vs1Detail_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1Detail.jsp";
			break;
			
		case("/serviceCenterWrite.do"): //글작성하러 가기
			viewPage = "serviceCenterWrite.jsp";
			break;
			
		case("/serviceCenterWriteFinish.do")://Write.jsp에서 폼으로 보내기
			command = new ServiceCenter1vs1Detail_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1.do";
			break;
		//고객센터 끝
			
		//마이페이지(수연누나) 시작	
		case ("/mpInformation.do"): //나의정보 보여주기
			command = new MPinformation_Command(); 
			command.execute(request, response);
			viewPage ="mypageInformation.jsp";
			break;
			
		case("/mpchange.do"): //내정보 수정
			command = new MPchange_Command();
			command.execute(request, response);
			viewPage="mpInformation.do";
			break;
			
		case("/mpdelete.do"): //탈퇴
			command = new MPdelete_Command();
			command.execute(request, response);
			viewPage = "mainpage.jsp"; //do로 해서 다시 케이스1에 들어가도록!! jsp 아님!!!!!
			break;
			
		case ("/orderpageCategory.do"): //나의정보 보여주기
			command = new OrderpageCategory_Command(); 
			command.execute(request, response);
			viewPage ="orderpageCategory.jsp";
		break;
		//마이페이지(수연누나) 끝
		
		//제품(가슬)시작
		//제품(가슬)끝
		
		//장바구니(은애누나) 시작
		//장바구니(은애누나) 끝
			
		
		case("/naver_login.do"):
			viewPage = "naver_login.jsp";
			break;
		case("/savelogin.do"):
			viewPage = "mainpage.do";
			break;
		
		} // switch(com)

		

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}

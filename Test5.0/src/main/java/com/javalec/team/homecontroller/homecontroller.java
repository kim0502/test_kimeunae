package com.javalec.team.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.team.command.Adduser_Command;
import com.javalec.team.command.AllCategoryPage_Command;
import com.javalec.team.command.AllCategory_Command;
import com.javalec.team.command.AllDetail_Command;
import com.javalec.team.command.Finduserid_Command;
import com.javalec.team.command.Finduserpw_Command;
import com.javalec.team.command.IdCheck_Command;
import com.javalec.team.command.InsertCart_Command;
import com.javalec.team.command.InsertRightPayment_Command;
import com.javalec.team.command.InteriorCategory_Command;
import com.javalec.team.command.InteriorCategoryyPage_Command;
import com.javalec.team.command.InteriorDetail_Command;
import com.javalec.team.command.Login_Command;
import com.javalec.team.command.MPchange_Command;
import com.javalec.team.command.MPdelete_Command;
import com.javalec.team.command.MPinformation_Command;
import com.javalec.team.command.OfficeCategory_Command;
import com.javalec.team.command.OfficeCategoryyPage_Command;
import com.javalec.team.command.OfficeDetail_Command;
import com.javalec.team.command.OrderpageCategory_Command;
import com.javalec.team.command.PCommand;
import com.javalec.team.command.ReviewWritepage_Command;
import com.javalec.team.command.RightPayment_Command;
import com.javalec.team.command.SearchAllCategory_Command;
import com.javalec.team.command.SearchAllDetail_Command;
import com.javalec.team.command.ServiceCenter1vs1Detail_Command;
import com.javalec.team.command.ServiceCenter1vs1Page_Command;
import com.javalec.team.command.ServiceCenter1vs1_Command;
import com.javalec.team.command.ServiceCenterWrite_Command;
import com.javalec.team.command.StoolCategory_Command;
import com.javalec.team.command.StoolCategoryyPage_Command;
import com.javalec.team.command.StoolDetail_Command;
import com.javalec.team.command.StudentCategory_Command;
import com.javalec.team.command.StudentCategoryyPage_Command;
import com.javalec.team.command.StudentDetail_Command;
import com.javalec.team.command.Wishlist_Command;

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
		request.setCharacterEncoding("utf-8"); //??????????????? ????????????????????? ????????????
		
		HttpSession session = request.getSession();
		
		String viewPage = null; // viewPage??? ???????????? ?????? ????????? ??????. switch??? ?????? ??????????????? viewPage??? ????????? ??????????????????
		PCommand command =null;
		
		String uri = request.getRequestURI(); // uri??? ???????????? ??????/~.do
		String conPath = request.getContextPath(); // conPath??? ???????????? ??????
		String com = uri.substring(conPath.length()); // com??? ~.do
		
//		System.out.println(uri); 
//		System.out.println(conPath);
//		System.out.println(com);
		switch(com) {
		//???????????????
		case("/mainpage.do"): 
			command = new Login_Command();
			command.execute(request, response);
			viewPage = "infocheck.jsp";
			break;
		// ????????????
		case("/searchallCategory.do"): 
			command = new SearchAllCategory_Command();
			command.execute(request, response);
			viewPage = "searchallCategory.jsp";
			break;
			
		case("/searchallDetail.do"): 
			command = new SearchAllDetail_Command();
			command.execute(request, response);
			viewPage = "searchalldetail.jsp";
			break;	
			
			//?????????(?????????) ??????   
		case("/login.do"): 
	         viewPage = "login.jsp";
	         break;
	         
	      case("/idcheck.do"): 
	         viewPage = "idcheck.jsp";
	         break;
	         
	      case("/idcheckuser.do"): 
	         command = new IdCheck_Command();
	         command.execute(request, response);
	         viewPage = "adduser.jsp";
	         break;
	         
	      case("/adduser.do"): 
	         viewPage = "adduser.jsp";
	         break;
	      
	      case("/addfinish.do"): 
	         command = new Adduser_Command();
	         command.execute(request, response);
	         viewPage = "beforelogin.jsp";
	         break;
	      
	      case("/finduser.do"): 
	         viewPage = "finduser.jsp";
	         break;
	         
	      case("/finduserid.do"): 
	         command = new Finduserid_Command();
	         command.execute(request, response);
	         viewPage = "findidcheck.jsp";
	         break;
	         
	      case("/finduserpw.do"): 
	         command = new Finduserpw_Command();
	         command.execute(request, response);
	         viewPage = "findpwcheck.jsp";
	         break;
	      
	      //?????????(?????????) ???
			
		//???????????? ??????(??????)
		case("/serviceCenter.do"): //?????? ?????? ????????????
			viewPage = "serviceCenter.jsp";
			break;
		
		case("/serviceCenter1vs1.do"): //1:1 ????????? ??????
			command = new ServiceCenter1vs1_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1.jsp";
			break;
			
		case("/serviceCenter1vs1Page.do"): //1:1 ????????? ??????
			command = new ServiceCenter1vs1Page_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1.jsp";
			break;
			
		case("/serviceCenter1vs1Detail.do")://?????? ?????? ???????????? ??????????????????
			command = new ServiceCenter1vs1Detail_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1Detail.jsp";
			break;
			
		case("/serviceCenterWrite.do"): //??????????????? ??????
			viewPage = "serviceCenterWrite.jsp";
			break;
			
		case("/serviceCenterWriteFinish.do")://Write.jsp?????? ????????? ?????????
			command = new ServiceCenterWrite_Command();
			command.execute(request, response);
			viewPage = "serviceCenter1vs1.do";
			break;
		//???????????? ???
			
		//???????????????(????????????) ??????	
		case ("/mpInformation.do"): //???????????? ????????????
			command = new MPinformation_Command(); 
			command.execute(request, response);
			viewPage ="mypageInformation.jsp";
			break;
			
		case("/mpchange.do"): //????????? ??????
			command = new MPchange_Command();
			command.execute(request, response);
			viewPage="mpInformation.do";
			break;
			
		case("/mpdelete.do"): //??????
			command = new MPdelete_Command();
			command.execute(request, response);
			viewPage = "mainpage.jsp"; //do??? ?????? ?????? ?????????1??? ???????????????!! jsp ??????!!!!!
			break;
			
		case ("/orderpageCategory.do"): //??????????????????
			command = new OrderpageCategory_Command(); 
			command.execute(request, response);
			viewPage ="orderpageCategory.jsp";
			break;
		
		case ("/reviewWritepage.do"): //????????????????????? ??????
			viewPage="reviewWritepage.jsp";
			break;
	
		case("/reviewWrite.do")://??????????????? ??????
			command = new ReviewWritepage_Command();
			command.execute(request, response);
			viewPage = "mainpage.jsp"; //do??? ?????? ?????? ?????????1??? ???????????????!! jsp ??????!!!!!
			break;
		//???????????????(????????????) ???
		
		//??????(??????)??????
			// allcategory - gaseul
			
		case("/allCategory.do"): 
			command = new AllCategory_Command();
			command.execute(request, response);
			viewPage = "allCategory.jsp";
			break;
		
		case("/allCategoryPage.do"): //pagination
			command = new AllCategoryPage_Command();
			command.execute(request, response);
			viewPage = "allCategory.jsp";
			break;
			
			
			case("/interiorCategory.do"): 
			command = new InteriorCategory_Command();
			command.execute(request, response);
			viewPage = "interiorCategory.jsp";
			break;
			
		case("/interiorCategoryPage.do"): //pagination
			command = new InteriorCategoryyPage_Command();
			command.execute(request, response);
			viewPage = "interiorCategory.jsp";
			break;
		
		
			
		case("/officeCategory.do"): 
			command = new OfficeCategory_Command();
			command.execute(request, response);
			viewPage = "officeCategory.jsp";
			break;
			
		case("/officeCategoryPage.do"): //pagination
			command = new OfficeCategoryyPage_Command();
			command.execute(request, response);
			viewPage = "officeCategory.jsp";
			break;
				
		
			
		case("/stoolCategory.do"): 
			command = new StoolCategory_Command();
			command.execute(request, response);
			viewPage = "stoolCategory.jsp";
			break;
			
		case("/stoolCategoryPage.do"): //pagination
			command = new StoolCategoryyPage_Command();
			command.execute(request, response);
			viewPage = "stoolCategory.jsp";
			break;
		
			
			
		case("/studentCategory.do"): 
			command = new StudentCategory_Command();
			command.execute(request, response);
			viewPage = "studentCategory.jsp";
			break;
			
		case("/studentCategoryPage.do"): //pagination
			command = new StudentCategoryyPage_Command();
		command.execute(request, response);
		viewPage = "studentCategory.jsp";
		break;
			//category.do - end
					
					//DetailPage.do
					
				case("/allDetail.do"): 
					command = new AllDetail_Command();
					command.execute(request, response);
					viewPage = "alldetail.jsp";
					break;
					
				case("/studentDetail.do"): 
					command = new StudentDetail_Command();
					command.execute(request, response);
					viewPage = "studentDetail.jsp";
					break;
					
					
				case("/officeDetail.do"): 
					command = new OfficeDetail_Command();
					command.execute(request, response);
					viewPage = "officeDetail.jsp";
					break;
					
				case("/interiorDetail.do"): 
					command = new InteriorDetail_Command();
					command.execute(request, response);
					viewPage = "interiorDetail.jsp";
					break;
					
				case("/stoolDetail.do"): 
					command = new StoolDetail_Command();
					command.execute(request, response);
					viewPage = "stoolDetail.jsp";
					break;
					//DetailPage.do - end
				case("/cartin.do"): 
					command = new InsertCart_Command();
					command.execute(request, response);
					viewPage = "wishlist.do";
					break;
					//detail page -> rightPayment
	            case("/rightPayment.do")://????????? ??? ??? ?????????  ??? ??? ?????? 
	               command = new RightPayment_Command();
	               command.execute(request, response);
	               viewPage = "rightPayment.jsp";
	               break;
		//??????(??????)???
		
		//????????????(????????????) ??????
				case("/wishlist.do")://?????? ?????? ????????????
					command = new Wishlist_Command();
					command.execute(request, response);
					viewPage = "wishlist.jsp";
					break;									
				
				case("/delete.do")://??????????????????
		//			command = new Delete_Command();
		//			command.execute(request, response);
					viewPage = "wishlist.do";
					break;
				case("/payment.do")://??????
		//			command = new Payment_Command();
		//			command.execute(request, response);
					viewPage = "payment.jsp";
					break;
				case("/paymentrevise.do")://???????????? ?????? ????????????
		//			command = new Paymentrevise_Command();
		//			command.execute(request, response);
					viewPage = "payment.jsp";
					break;
				case("/rightpaymentmethod.do")://??????????????????
					command = new InsertRightPayment_Command();
					command.execute(request, response);
					viewPage = "paymentmethod.jsp";
					break;
				//????????????(????????????) ???
					
				
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

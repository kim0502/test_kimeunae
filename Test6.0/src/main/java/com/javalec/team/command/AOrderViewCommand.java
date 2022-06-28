package com.javalec.team.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.team.dao.ADaoPCart;
import com.javalec.team.dto.ADtoPCart;

public class AOrderViewCommand implements ACommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			String uID = request.getParameter("uID");
			String[] checkArray = request.getParameterValues("checkBox");
			int[] checkBox = null;
			if(checkArray!=null) {
				checkBox = new int[checkArray.length];
				for(int i=0; i<checkArray.length; i++) {
					checkBox[i] =Integer.parseInt(checkArray[i]);
				}
				ADaoPCart dao = new ADaoPCart();
				ArrayList<ADtoPCart> dtos = dao.list(uID, checkBox);
				request.setAttribute("cartList", dtos);
			}
	}

}

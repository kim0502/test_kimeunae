package com.javalec.team.dto;

public class Payment_dto {

	//Field
	int oPrice;
	int oQuantity;
	String product_pCode;
	String user_uId;
	
	
		
	//Constructor
	public Payment_dto(){
		
	}
	
	public Payment_dto(int oPrice, int oQuantity, String product_pCode, String user_uId) {
		super();
		this.oPrice = oPrice;
		this.oQuantity = oQuantity;
		this.product_pCode = product_pCode;
		this.user_uId = user_uId;
	}

	//Method	

	public int getoPrice() {
		return oPrice;
	}



	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}



	public int getoQuantity() {
		return oQuantity;
	}



	public void setoQuantity(int oQuantity) {
		this.oQuantity = oQuantity;
	}



	public String getProduct_pCode() {
		return product_pCode;
	}



	public void setProduct_pCode(String product_pCode) {
		this.product_pCode = product_pCode;
	}



	public String getUser_uId() {
		return user_uId;
	}



	public void setUser_uId(String user_uId) {
		this.user_uId = user_uId;
	}
	

	
	
	
	
}

package com.javalec.team.dto;

public class Payment_dto {

	//Field
	
	int cQuantity;
	String product_pCode;
	
	
	//Constructor
	
	public Payment_dto(int cQuantity, String product_pCode) {
		super();
		this.cQuantity = cQuantity;
		this.product_pCode = product_pCode;
	}
	

	//Method
	
	public int getcQuantity() {
		return cQuantity;
	}

	public void setcQuantity(int cQuantity) {
		this.cQuantity = cQuantity;
	}

	public String getProduct_pCode() {
		return product_pCode;
	}

	public void setProduct_pCode(String product_pCode) {
		this.product_pCode = product_pCode;
	}

	
	
}

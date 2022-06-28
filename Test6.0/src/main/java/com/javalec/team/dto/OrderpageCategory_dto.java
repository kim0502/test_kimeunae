package com.javalec.team.dto;

public class OrderpageCategory_dto {
	String cCode;
	String pCode;
	String user_uId;
	String pImg_main;
	String pName ;
	String cQuantity ;
	String cPrice ;
	
	public OrderpageCategory_dto(String cCode, String pCode, String user_uId, String pImg_main, String pName,
			String cQuantity, String cPrice) {
		super();
		this.cCode = cCode;
		this.pCode = pCode;
		this.user_uId = user_uId;
		this.pImg_main = pImg_main;
		this.pName = pName;
		this.cQuantity = cQuantity;
		this.cPrice = cPrice;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getUser_uId() {
		return user_uId;
	}

	public void setUser_uId(String user_uId) {
		this.user_uId = user_uId;
	}

	public String getpImg_main() {
		return pImg_main;
	}

	public void setpImg_main(String pImg_main) {
		this.pImg_main = pImg_main;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getcQuantity() {
		return cQuantity;
	}

	public void setcQuantity(String cQuantity) {
		this.cQuantity = cQuantity;
	}

	public String getcPrice() {
		return cPrice;
	}

	public void setcPrice(String cPrice) {
		this.cPrice = cPrice;
	}
	
	
	
	
	
	
}//end

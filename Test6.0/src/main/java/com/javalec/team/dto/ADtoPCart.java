package com.javalec.team.dto;

public class ADtoPCart {

	
	int cCode;
	String pCode;
	String pImg_main;
	String pName;
	int pPrice;
	int cQuantity;
	int cSum;
	
	
	public ADtoPCart(int cCode, String pCode, String pImg_main, String pName, int cSum, int pPrice, int cQuantity) {
		super();
		this.cCode = cCode;
		this.pCode = pCode;
		this.pImg_main = pImg_main;
		this.pName = pName;
		this.cSum = cSum;
		this.pPrice = pPrice;
		this.cQuantity = cQuantity;

	}



	public int getcCode() {
		return cCode;
	}



	public void setcCode(int cCode) {
		this.cCode = cCode;
	}



	public String getpCode() {
		return pCode;
	}



	public void setpCode(String pCode) {
		this.pCode = pCode;
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



	public int getcSum() {
		return cSum;
	}



	public void setcSum(int cSum) {
		this.cSum = cSum;
	}



	public int getpPrice() {
		return pPrice;
	}



	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}



	public int getcQuantity() {
		return cQuantity;
	}



	public void setcQuantity(int cQuantity) {
		this.cQuantity = cQuantity;
	}

	
	
	
	
}

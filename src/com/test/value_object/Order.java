package com.test.value_object;

import java.io.Serializable;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1844943016368750484L;
	
	private int orderid;
	private String clientName;
	private int number;
	private String productName;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}

package com.mycart.project.beans;

import java.util.Calendar;
import java.util.List;

public class Bill {
	
	String billNo;
	Calendar billDate;
	String customerId;
	String customerType;
	List<Item> items;
	Double totalAmount;
	Double netAmount;
	Double groceryAmount;
	
	public Bill() {}

	public Bill(String billNo, Calendar billDate, String customerId, String customerType, List<Item> items) {
		this.billNo = billNo;
		this.billDate = billDate;
		this.customerId = customerId;
		this.customerType = customerType;
		this.items = items;
	}
	
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public Calendar getBillDate() {
		return billDate;
	}
	public void setBillDate(Calendar billDate) {
		this.billDate = billDate;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
	public Double getGroceryAmount() {
		return groceryAmount;
	}
	public void setGroceryAmount(Double groceryAmount) {
		this.groceryAmount = groceryAmount;
	}
}

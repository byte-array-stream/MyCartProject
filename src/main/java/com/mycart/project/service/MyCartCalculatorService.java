package com.mycart.project.service;

import java.util.stream.Collectors;

import com.mycart.project.beans.Bill;
import com.mycart.project.utility.Utility;

public class MyCartCalculatorService {

	public Bill calcualateNetAmount(Bill pBill) {
		
		if(!(pBill == null)) {
			pBill.setNetAmount(0.00);
			pBill.setTotalAmount(0.00);
			pBill = calculateTotalCartAmount(pBill);
		}
		return pBill;
	}
	
	private Bill calculateTotalCartAmount(Bill pBill) {
		if( !(pBill.getItems() == null) && pBill.getItems().size() > 0) {
			Double lTotalAmt = pBill.getItems().stream().mapToDouble((item) -> item.getItemCost()).sum();
			Double lTotalGroceryAmt = pBill.getItems().stream().filter((item) -> item.getItemType().equalsIgnoreCase("GROCERY")).collect(Collectors.toList())
			.stream().mapToDouble((item) -> item.getItemCost()).sum();
			Double lPercentageDiscAmt = calculatePercentageDiscount((lTotalAmt-lTotalGroceryAmt), pBill.getCustomerType());
			Double lDiscAmount = calculateDiscount(lTotalAmt);
			
			pBill.setNetAmount(lTotalAmt - (lPercentageDiscAmt + lDiscAmount));
			pBill.setTotalAmount(lTotalAmt);
			pBill.setGroceryAmount(lTotalGroceryAmt);
			
		}
		return pBill;
	}
	
	private Double calculatePercentageDiscount(Double pTotalAmount, String pEmployementType) {
		Integer lPercentage = 0;
		Double lCalculatedAmount = 0.00;
		
		if(!(pTotalAmount == null) && pTotalAmount > 0.00) {
			if(!(pEmployementType == null)) {
				
				switch (pEmployementType){
					case "EMPLOYEE" :
						lPercentage = 30;
						break;
					case "AFFILIATED" :
						lPercentage = 10;
						break;
					case "REGULAR" :
						lPercentage = 5; 
						break;
				}
			lCalculatedAmount = Utility.calcultePercentage(pTotalAmount, lPercentage); 	
			}
		}
		return lCalculatedAmount;
	}
	
	private Double calculateDiscount(Double pTotalAmount) {
		Double ldiscountAmount = 0.00;
		if(!(pTotalAmount == null) && pTotalAmount > 99.99) {
			System.out.println("After ceilng => "+Math.floor((pTotalAmount/100)));
			ldiscountAmount = Math.floor((pTotalAmount/100)) * 5;
		}
		System.out.println("Discount amount => "+ldiscountAmount);
		return ldiscountAmount;
	}
	
	
}

package com.mycart.project.utility;

import java.text.DecimalFormat;

public class Utility {
	
	public static final DecimalFormat formatter = new DecimalFormat("#0.00");

	public static Double calcultePercentage(Double pAmount, Integer pPercetageValue) {
		if(pAmount != null && pAmount > 0.00) {
			pAmount = (pAmount * pPercetageValue)/100;
		}
		return pAmount;
	}
	
	public static String formatCurrency(Double pValue) {
		return formatter.format(pValue == null? 0.0:pValue);
	}
}

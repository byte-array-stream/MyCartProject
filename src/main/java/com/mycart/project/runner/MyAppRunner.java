package com.mycart.project.runner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mycart.project.beans.Bill;
import com.mycart.project.beans.Item;
import com.mycart.project.service.MyCartCalculatorService;
import com.mycart.project.utility.Utility;


// HIIIIIII
public class MyAppRunner 
{
	public static Bill bill1 = null;
	public static Bill bill2 = null;
	public static Bill bill3 = null;
	public static Bill bill4 = null;
	
	static {
		Item item1 =new Item("Fruit","Fruits",100.00, "FRUITS");
		Item item2 =new Item("Tomato","Tomato",0.00, "VEGETABLES");
		Item item3 =new Item("Shirt","Shirt",0.00, "CLOTHS");
		Item item4 =new Item("Grocery1","Grocery1",1000.00, "GROCERY");
		Item item5 =new Item("Grocery2","Grocery2",0.00, "GROCERY");
		List<Item> list1 = new ArrayList<Item>();
		list1.add(item1);
		list1.add(item2);
		list1.add(item3);
		//list1.clear();
		list1.add(item4);
		list1.add(item5);
		//list1.clear();
		
		bill1 = new Bill("B101", Calendar.getInstance(), "C1", "REGULAR", list1);
		bill2 = new Bill("B102", Calendar.getInstance(), "C2", "AFFILIATED", list1);
		bill3 = new Bill("B103", Calendar.getInstance(), "C3", "EMPLOYEE", list1);
		bill4 = new Bill("B104", Calendar.getInstance(), "C4", "ORDINARY", list1);
		
	}
	
    public static void main( String[] args )
    {
     MyCartCalculatorService lService = new MyCartCalculatorService();
     Bill generatedBill = lService.calcualateNetAmount(bill1);
     System.out.println("Net Amount => "+ Utility.formatCurrency(generatedBill.getNetAmount()));
     System.out.println("Total Amount => "+ Utility.formatCurrency(generatedBill.getTotalAmount()));
     System.out.println("Grocery Amount => "+ Utility.formatCurrency(generatedBill.getGroceryAmount()));
    }
}

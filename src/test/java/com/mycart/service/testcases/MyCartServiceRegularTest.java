package com.mycart.service.testcases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycart.project.beans.Bill;
import com.mycart.project.beans.Item;
import com.mycart.project.service.MyCartCalculatorService;

public class MyCartServiceRegularTest {
	private static MyCartCalculatorService service;
	
	Item item1, item2, item3 , item4 , item5;
	List<Item> list1 = null;
	
	@BeforeClass
	public static void initialSetup() {
		service = new MyCartCalculatorService();
	}
	
	@Before
	public void dataSetup() {
		item1 =new Item("Fruit","Fruits",100.00, "FRUITS");
		item2 =new Item("Tomato","Tomato",0.00, "VEGETABLES");
		item3 =new Item("Shirt","Shirt",0.00, "CLOTHS");
		list1 = new ArrayList<Item>();
		list1.add(item1);
		list1.add(item2);
		list1.add(item3);
	}
	
	@Test
	public void testCalcualateNetAmount_WITH_GROCERY() {
		Item item4 =new Item("Grocery1","Grocery1",1000.00, "GROCERY");
		Item item5 =new Item("Grocery2","Grocery2",0.00, "GROCERY");
		list1.add(item4);
		list1.add(item5);
		Bill bill1 = new Bill("102", Calendar.getInstance(), "C1", "REGULAR", list1);
		Double netAmountExpected = 1040.00;
		assertEquals(netAmountExpected, service.calcualateNetAmount(bill1).getNetAmount());
	}
	
	@Test
	public void testCalcualateNetAmount_NO_GROCERY() {
		Bill bill1 = new Bill("102", Calendar.getInstance(), "C1", "REGULAR", list1);
		Double netAmountExpected = 90.00;
		assertEquals(netAmountExpected, service.calcualateNetAmount(bill1).getNetAmount());
	}
	
	@Test
	public void testCalcualateNetAmount_ONLY_GROCERY() {
		Item item4 =new Item("Grocery1","Grocery1",1000.00, "GROCERY");
		Item item5 =new Item("Grocery2","Grocery2",100.00, "GROCERY");
		list1.clear();
		list1.add(item4);
		list1.add(item5);
		Bill bill1 = new Bill("102", Calendar.getInstance(), "C1", "REGULAR", list1);
		Double netAmountExpected = 1045.00;
		assertEquals(netAmountExpected, service.calcualateNetAmount(bill1).getNetAmount());
	}
	
	@Test
	public void testCalcualateNetAmount_EMPTY_CART() {
		list1.clear();
		Bill bill1 = new Bill("102", Calendar.getInstance(), "C1", "REGULAR", list1);
		Double netAmountExpected = 0.00;
		assertEquals(netAmountExpected, service.calcualateNetAmount(bill1).getNetAmount());
	}
	
	@After
	public void cleanUp() {
		list1.clear();
		list1 = null;
	}
	
	@AfterClass
	public static void cleaningData() {
		service = null;
	}
}

package com.mycart.project.beans;

public class Item {
	
	String itemId;
	String itemDescription;
	Double itemCost;
	String itemType;
	
	public Item() {
	}

	public Item(String itemId, String itemDescription, Double itemCost, String itemType) {
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.itemCost = itemCost;
		this.itemType = itemType;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Double getItemCost() {
		return itemCost;
	}
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
}

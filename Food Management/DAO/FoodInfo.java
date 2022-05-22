package com.hotel.management.sunsets.DAO;

public class FoodInfo {
	
	//idfood_info, food_description, price, image, status, portion, food_type

	int idfood_info;
	String food_description;
	String price;
	String image;
	int status;
	String portion;
	String food_type;
	
	public FoodInfo() {
		super();
	}

	public FoodInfo(String food_description, String price, String image, int status, String portion, String food_type) {
		super();
		this.food_description = food_description;
		this.price = price;
		this.image = image;
		this.status = status;
		this.portion = portion;
		this.food_type = food_type;
	}

	public FoodInfo(int idfood_info, String food_description, String price, String image, int status, String portion,
			String food_type) {
		super();
		this.idfood_info = idfood_info;
		this.food_description = food_description;
		this.price = price;
		this.image = image;
		this.status = status;
		this.portion = portion;
		this.food_type = food_type;
	}

	public int getIdfood_info() {
		return idfood_info;
	}

	public void setIdfood_info(int idfood_info) {
		this.idfood_info = idfood_info;
	}

	public String getFood_description() {
		return food_description;
	}

	public void setFood_description(String food_description) {
		this.food_description = food_description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPortion() {
		return portion;
	}

	public void setPortion(String portion) {
		this.portion = portion;
	}

	public String getFood_type() {
		return food_type;
	}

	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	
	
	
	
}

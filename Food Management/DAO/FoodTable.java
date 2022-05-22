package com.hotel.management.sunsets.DAO;

public class FoodTable {

	//idfood_table, table_location, seat_count, status
	int idfood_table;
	String table_location;
	String seat_count;
	int status;
	
	public FoodTable() {
		super();
	}

	public FoodTable(String table_location, String seat_count, int status) {
		super();
		this.table_location = table_location;
		this.seat_count = seat_count;
		this.status = status;
	}

	public FoodTable(int idfood_table, String table_location, String seat_count, int status) {
		super();
		this.idfood_table = idfood_table;
		this.table_location = table_location;
		this.seat_count = seat_count;
		this.status = status;
	}

	public int getIdfood_table() {
		return idfood_table;
	}

	public void setIdfood_table(int idfood_table) {
		this.idfood_table = idfood_table;
	}

	public String getTable_location() {
		return table_location;
	}

	public void setTable_location(String table_location) {
		this.table_location = table_location;
	}

	public String getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(String seat_count) {
		this.seat_count = seat_count;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}

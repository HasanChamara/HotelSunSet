package com.hotel.management.sunsets.DAO;

public class MenuInfo {
	
	//idmenu, menu_name, menu_description, menu_price, status, menu_type
	
	 int idmenu;
	 String menu_name;
	 String menu_description;
	 String menu_price;
	 int status;
	 String menu_type;
	 
	public MenuInfo() {
		super();
	}

	public MenuInfo(String menu_name, String menu_description, String menu_price, int status, String menu_type) {
		super();
		this.menu_name = menu_name;
		this.menu_description = menu_description;
		this.menu_price = menu_price;
		this.status = status;
		this.menu_type = menu_type;
	}

	public MenuInfo(int idmenu, String menu_name, String menu_description, String menu_price, int status,
			String menu_type) {
		super();
		this.idmenu = idmenu;
		this.menu_name = menu_name;
		this.menu_description = menu_description;
		this.menu_price = menu_price;
		this.status = status;
		this.menu_type = menu_type;
	}

	public int getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_description() {
		return menu_description;
	}

	public void setMenu_description(String menu_description) {
		this.menu_description = menu_description;
	}

	public String getMenu_price() {
		return menu_price;
	}

	public void setMenu_price(String menu_price) {
		this.menu_price = menu_price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}
	 
	 
	

}

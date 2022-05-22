package com.hotel.management.sunsets.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hotel.management.sunsets.DAO.DataAccess;
import com.hotel.management.sunsets.DAO.FoodTable;
import com.hotel.management.sunsets.DAO.MenuInfo;

public class MenuInfoController {

	public static int addMenuInfoToDB(MenuInfo menu) {

		int i = 0;

		Connection con = DataAccess.connect();

		String sql = "INSERT INTO `hotel_sunset`.`menu` (`menu_name`, `menu_description`, `menu_price`, `menu_type`) VALUES (?, ?, ?, ?);";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			
			////idmenu, menu_name, menu_description, menu_price, status, menu_type

			
			ps.setString(1, menu.getMenu_name());
			ps.setString(2, menu.getMenu_description());
			ps.setString(3, menu.getMenu_price());
			ps.setString(4, menu.getMenu_type());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}
	
	
	public static ArrayList<MenuInfo> retrieveAllMenuInfo(String cus) {

		ArrayList<MenuInfo> menu_table_list = new ArrayList<>();
		MenuInfo menu_table = null;

		Connection con = DataAccess.connect();

		String sql = "";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet resultset = ps.executeQuery();

			// while theres data remaining
			while (resultset.next()) {
				menu_table = new MenuInfo();
				////idmenu, menu_name, menu_description, menu_price, status, menu_type
				menu_table.setIdmenu(resultset.getInt("idmenu"));
				menu_table.setMenu_name(resultset.getString("menu_name"));
				menu_table.setMenu_description(resultset.getString("menu_description"));
				menu_table.setMenu_price(resultset.getString("menu_price"));
				menu_table.setMenu_type(resultset.getString("menu_type"));
				menu_table.setStatus(resultset.getInt("status"));

				menu_table_list.add(menu_table);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return arraylist
		return menu_table_list;

	}

}

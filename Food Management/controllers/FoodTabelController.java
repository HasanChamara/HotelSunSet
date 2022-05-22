package com.hotel.management.sunsets.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hotel.management.sunsets.DAO.DataAccess;
import com.hotel.management.sunsets.DAO.FoodTable;

public class FoodTabelController {

	public static int addTabelInfoToDB(FoodTable tabels) {

		int i = 0;

		Connection con = DataAccess.connect();

		String sql = "INSERT INTO `food_table` (`table_location`, `seat_count`) VALUES (?, ?);";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tabels.getTable_location());
			ps.setString(2, tabels.getSeat_count());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}

	public static ArrayList<FoodTable> retrieveAllTabelInfo() {

		ArrayList<FoodTable> food_table_list = new ArrayList<>();
		FoodTable food_table = null;

		Connection con = DataAccess.connect();

		String sql = "";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet resultset = ps.executeQuery();

			// while theres data remaining
			while (resultset.next()) {
				food_table = new FoodTable();
				//// idfood_table, table_location, seat_count, status
				food_table.setIdfood_table(resultset.getInt("idfood_table"));
				food_table.setTable_location(resultset.getString("table_location"));
				food_table.setSeat_count(resultset.getString("seat_count"));
				food_table.setStatus(resultset.getInt("status"));

				food_table_list.add(food_table);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return arraylist
		return food_table_list;

	}

}

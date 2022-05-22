package com.hotel.management.sunsets.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hotel.management.sunsets.DAO.DataAccess;
import com.hotel.management.sunsets.DAO.FoodInfo;

public class FoodInfoController {
	
	
	public static int addFoodInfoToDB(FoodInfo foodInfo) {
		
		int i = 0;
		
		Connection con = DataAccess.connect();

		String sql = "INSERT INTO `food_info` (`food_description`, `price`, `image`, `portion`, `food_type`) VALUES (?, ?, ?, ?, ?);";

		try {

			PreparedStatement ps = con.prepareStatement(sql);
			

			//idfood_info, food_description, price, image, status, portion, food_type

			
			ps.setString(1, foodInfo.getFood_description());
			ps.setString(2, foodInfo.getPrice());
			ps.setString(3, foodInfo.getImage());
			ps.setString(4, foodInfo.getPortion());
			ps.setString(5, foodInfo.getFood_type());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return i;
		
	}
	
	
	public static ArrayList<FoodInfo> retrieveAllFoodInfo() {

		ArrayList<FoodInfo> food_table_list = new ArrayList<>();
		FoodInfo food_table = null;

		Connection con = DataAccess.connect();

		String sql = "SELECT * FROM food_info where status = '1';";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet resultset = ps.executeQuery();

			// while theres data remaining
			while (resultset.next()) {
				food_table = new FoodInfo();
				//idfood_info, food_description, price, image, status, portion, food_type

				food_table.setIdfood_info(resultset.getInt("idfood_info"));
				food_table.setFood_description(resultset.getString("food_description"));
				food_table.setPrice(resultset.getString("price"));
				food_table.setImage(resultset.getString("image"));
				food_table.setPortion(resultset.getString("portion"));
				food_table.setFood_type(resultset.getString("food_type"));
				food_table.setStatus(resultset.getInt("status"));

				food_table_list.add(food_table);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// return arraylist
		return food_table_list;

	}
	
	public static boolean updateFoodInfoToDB(FoodInfo foodInfo) {
		
		
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "UPDATE `food_info` SET `food_description` = ?, `price` = ?, `image` = ?, `status` = ?, `portion` = ?, `food_type` = ? WHERE `idfood_info` = ?;";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setString(1, foodInfo.getFood_description());
			psUpdate.setString(2, foodInfo.getPrice());
			psUpdate.setString(3, foodInfo.getImage());
			psUpdate.setString(5, foodInfo.getPortion());
			psUpdate.setString(6, foodInfo.getFood_type());
			psUpdate.setInt(4, foodInfo.getStatus());
			psUpdate.setInt(7, foodInfo.getIdfood_info());
			psUpdate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
		
	}
	
	public static boolean deleteFoodInfoToDB(FoodInfo foodInfo) {
		
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "DELETE FROM food_info where idfood_info = ?;";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			
			psUpdate.setInt(1, foodInfo.getIdfood_info());
			
			psUpdate.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return true;
	}
	
	
	
	
}

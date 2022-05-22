package com.hotel.management.sunsets.API;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hotel.management.sunsets.DAO.FoodInfo;
import com.hotel.management.sunsets.DAO.FoodTable;
import com.hotel.management.sunsets.DAO.MenuInfo;
import com.hotel.management.sunsets.controllers.FoodInfoController;
import com.hotel.management.sunsets.controllers.FoodTabelController;
import com.hotel.management.sunsets.controllers.MenuInfoController;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("API")
public class mainAPI {

	FoodInfoController foodObj = new FoodInfoController();
	FoodTabelController tabelObj = new FoodTabelController();
	MenuInfoController menuObj = new MenuInfoController();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String checkAPIWorking() {
		return "API working Fine, Good luck";
	}

	@POST
	@Path("/addFoodInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertFoodInfo(String foodData) {
		
		System.out.print("data "+foodData);

		JsonObject foodObject = new JsonParser().parse(foodData).getAsJsonObject();
		System.out.print("data 1 "+foodObject.toString());
		// Read the values from the JSON object
		String fname = foodObject.get("fname").getAsString();
		String fdetails = foodObject.get("fname").getAsString(); //fdetails
		String portion = foodObject.get("portion").getAsString();
		String price = foodObject.get("price").getAsString();
		String food_type = foodObject.get("food_type").getAsString();

		FoodInfo info = new FoodInfo(fname, price, "", 1, portion, food_type);

		JSONObject obj = new JSONObject();
		obj.put("state", "1");
		

		int output = foodObj.addFoodInfoToDB(info);

		if (output == 1) {
			obj.put("message", "Succesfully add FoodInfo !");
		} else {
			obj.put("message", "Failed to add FoodInfo !");
		}

		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}
	
	@POST
	@Path("/updateFoodInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateFoodInfo(String foodData) {
		
		System.out.print("data "+foodData);

		JsonObject foodObject = new JsonParser().parse(foodData).getAsJsonObject();
		System.out.print("data 1 "+foodObject.toString());
		// Read the values from the JSON object
		String ids = foodObject.get("ids").getAsString();
		String fname = foodObject.get("fname").getAsString();
		String fdetails = foodObject.get("fname").getAsString(); //fdetails
		String portion = foodObject.get("portion").getAsString();
		String price = foodObject.get("price").getAsString();
		String food_type = foodObject.get("food_type").getAsString();

		FoodInfo info = new FoodInfo(Integer.parseInt(ids),fname, price, "", 1, portion, food_type);

		JSONObject obj = new JSONObject();
		obj.put("state", "1");
		

		boolean output = foodObj.updateFoodInfoToDB(info);

		if (output) {
			obj.put("message", "Succesfully update FoodInfo !");
		} else {
			obj.put("message", "Failed to update FoodInfo !");
		}

		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}
	
	@POST
	@Path("/removeFoodInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeFoodInfo(String foodData) {
		
		System.out.print("data "+foodData);

		JsonObject foodObject = new JsonParser().parse(foodData).getAsJsonObject();
		System.out.print("data 1 "+foodObject.toString());
		// Read the values from the JSON object
		String ids = foodObject.get("ids").getAsString();

		FoodInfo info = new FoodInfo();
		info.setIdfood_info(Integer.parseInt(ids));

		JSONObject obj = new JSONObject();
		obj.put("state", "1");
		

		boolean output = foodObj.deleteFoodInfoToDB(info);

		if (output) {
			obj.put("message", "Succesfully remove FoodInfo !");
		} else {
			obj.put("message", "Failed to remove FoodInfo !");
		}

		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}

	@POST
	@Path("/addFoodTabelInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertTabelInfo(String foodTabelData) {

		JsonObject foodTabelObject = new JsonParser().parse(foodTabelData).getAsJsonObject();
		// Read the values from the JSON object
		String tbl_name = foodTabelObject.get("tbl_name").getAsString();
		String tbl_location = foodTabelObject.get("tbl_location").getAsString();
		String tbl_seat = foodTabelObject.get("tbl_seat").getAsString();

		FoodTable info = new FoodTable(tbl_name, tbl_seat, 1);

		JSONObject obj = new JSONObject();
		obj.put("state", "1");

		int output = tabelObj.addTabelInfoToDB(info);

		if (output == 1) {
			obj.put("message", "Succesfully add Table Info !");
		} else {
			obj.put("message", "Failed to add Table Info !");
		}

		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}

	@POST
	@Path("/addMenuInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertMenuInfo(String menuData) {

		JsonObject menuTabelObject = new JsonParser().parse(menuData).getAsJsonObject();
		// Read the values from the JSON object
		// String menu_name, String menu_description, String menu_price, int status,
		// String menu_typ
		String menu_name = menuTabelObject.get("menu_name").getAsString();
		String menu_description = menuTabelObject.get("menu_description").getAsString();
		String menu_price = menuTabelObject.get("menu_price").getAsString();
		String menu_typ = menuTabelObject.get("menu_typ").getAsString();

		MenuInfo info = new MenuInfo(menu_name, menu_description, menu_price, 1, menu_typ);

		JSONObject obj = new JSONObject();
		obj.put("state", "1");

		int output = menuObj.addMenuInfoToDB(info);

		if (output == 1) {
			obj.put("message", "Succesfully add menu Info !");
		} else {
			obj.put("message", "Failed to add menu Info !");
		}

		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}

	
	@GET
	@Path("/getAllTabelInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTabelInfos() {

		ArrayList<FoodTable> foodtable = tabelObj.retrieveAllTabelInfo();

		JSONObject obj = new JSONObject();
		JSONArray jsArray = new JSONArray();

		obj.put("state", "1");
		if (foodtable.size() != 0) {
			System.out.println("Succesfully get all payment info!");

			for (int counter = 0; counter < foodtable.size(); counter++) {
				JSONObject objs = new JSONObject();

				//idfood_table, table_location, seat_count, status
				
				objs.put("idfood_table", foodtable.get(counter).getIdfood_table());
				objs.put("table_location", foodtable.get(counter).getTable_location());
				objs.put("seat_count", foodtable.get(counter).getSeat_count());
				objs.put("status", foodtable.get(counter).getStatus());
				// System.out.println(arrlist.get(counter));
				jsArray.add(objs);
			}

			obj.put("data", jsArray);
			obj.put("message", "Succesfully get all tabel info !");

		} else {
			System.out.println("Error get all tabel info !");
			obj.put("data", jsArray);
			obj.put("message", "Error get all tabel info !");
		}

		// responseStatus = false;
		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}
	
	@GET
	@Path("/getAllFoodInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFoodInfos() {

		ArrayList<FoodInfo> foodinfos = foodObj.retrieveAllFoodInfo();

		JSONObject obj = new JSONObject();
		JSONArray jsArray = new JSONArray();

		obj.put("state", "1");
		if (foodinfos.size() != 0) {
			System.out.println("Succesfully get all food info!");

			for (int counter = 0; counter < foodinfos.size(); counter++) {
				JSONObject objs = new JSONObject();

				////idfood_info, food_description, price, image, status, portion, food_type
				
				objs.put("idfood_info", foodinfos.get(counter).getIdfood_info());
				objs.put("food_description", foodinfos.get(counter).getFood_description());
				objs.put("price", foodinfos.get(counter).getPrice());
				objs.put("image", foodinfos.get(counter).getImage());
				objs.put("status", foodinfos.get(counter).getStatus());
				objs.put("portion", foodinfos.get(counter).getPortion());
				objs.put("food_type", foodinfos.get(counter).getFood_type());
				// System.out.println(arrlist.get(counter));
				jsArray.add(objs);
			}

			obj.put("data", jsArray);
			obj.put("message", "Succesfully get all food info !");

		} else {
			System.out.println("Error get all food info !");
			obj.put("data", jsArray);
			obj.put("message", "Error get all food info !");
		}

		// responseStatus = false;
		Response response = Response.status(Status.OK).entity(obj.toString()).build();

		return response;

	}

}

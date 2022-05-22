package Reservation.bean;

public class Room {

	protected int id;
	protected String number;
	protected String type;
	protected int noOfBeds;
	protected String wifi;
	protected String phoneService;
	
	
	public Room() {
		
	}
	
	
	public Room(String number, String type, int noOfBeds, String wifi, String phoneService) {
		super();
		this.number = number;
		this.type = type;
		this.noOfBeds = noOfBeds;
		this.wifi = wifi;
		this.phoneService = phoneService;
	}


	public Room(int id, String number, String type, int noOfBeds, String wifi, String phoneService) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.noOfBeds = noOfBeds;
		this.wifi = wifi;
		this.phoneService = phoneService;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getNoOfBeds() {
		return noOfBeds;
	}


	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}


	public String getWifi() {
		return wifi;
	}


	public void setWifi(String wifi) {
		this.wifi = wifi;
	}


	public String getPhoneService() {
		return phoneService;
	}


	public void setPhoneService(String phoneService) {
		this.phoneService = phoneService;
	}
	
	
}

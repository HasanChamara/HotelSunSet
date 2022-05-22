package Attendance.bean;

public class Attendance {
	protected int id;
	protected String name;
	protected String typeOfWork;
	protected String date;
	protected String inTime;
	protected String outTime;
	
	
	
	public Attendance(String name, String typeOfWork, String date, String inTime, String outTime) {
		super();
		this.name = name;
		this.typeOfWork = typeOfWork;
		this.date = date;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public Attendance(int id, String name, String typeOfWork, String date, String inTime, String outTime) {
		super();
		this.id = id;
		this.name = name;
		this.typeOfWork = typeOfWork;
		this.date = date;
		this.inTime = inTime;
		this.outTime = outTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfWork() {
		return typeOfWork;
	}
	public void setTypeOfWork(String typeOfWork) {
		this.typeOfWork = typeOfWork;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

}

package CustomerManagement.bean;

public class Customer {

	protected int id;
	protected String title;
	protected String fname;
	protected String lname;
	protected String email;
	protected int phoneNo;
	protected String nationality;
	
    public Customer() {
		
	}

	public Customer(String title, String fname, String lname, String email, int phoneNo, String nationality) {
		super();
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.nationality = nationality;
	}

	public Customer(int id, String title, String fname, String lname, String email, int phoneNo, String nationality) {
		super();
		this.id = id;
		this.title = title;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phoneNo = phoneNo;
		this.nationality = nationality;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
}

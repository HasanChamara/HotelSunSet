package Reservation.bean;

public class Reservation {

	protected int id;
	protected int customerid;
	protected String checkindate;
	protected String checkoutdate;
	protected String paymentMethod;
	
	public Reservation() {
		
	}

	public Reservation(int customerid, String checkindate, String checkoutdate, String paymentMethod) {
		super();
		this.customerid = customerid;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.paymentMethod = paymentMethod;
	}

	public Reservation(int id, int customerid, String checkindate, String checkoutdate, String paymentMethod) {
		super();
		this.id = id;
		this.customerid = customerid;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCheckindate() {
		return checkindate;
	}

	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}

	public String getCheckoutdate() {
		return checkoutdate;
	}

	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	
	
}

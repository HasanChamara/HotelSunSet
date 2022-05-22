package MemberManagement.bean;

public class Member {
	
	protected int no;
	protected String name;
	protected int cid;
	protected String type;
	protected String sdate;
	protected String edate;
	
	
	public Member () {
	
	}


	public Member(String name, int cid, String type, String sdate, String edate) {
		super();
		this.name = name;
		this.cid = cid;
		this.type = type;
		this.sdate = sdate;
		this.edate = edate;
	}


	public Member(int no, String name, int cid, String type, String sdate, String edate) {
		super();
		this.no = no;
		this.name = name;
		this.cid = cid;
		this.type = type;
		this.sdate = sdate;
		this.edate = edate;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getSdate() {
		return sdate;
	}


	public void setSdate(String sdate) {
		this.sdate = sdate;
	}


	public String getEdate() {
		return edate;
	}


	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	
}

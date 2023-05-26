package in.ineuron.dto;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sid;
	private String sname;
	private String slastname;
	private Integer sage;
	private String smail;
	private String saddress;
	private String spassword;
	
	private Integer bookCount;
	private Integer fine;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSlastname() {
		return slastname;
	}

	public void setSlastname(String slastname) {
		this.slastname = slastname;
	}

	public Integer getSage() {
		return sage;
	}

	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getSmail() {
		return smail;
	}

	public void setSmail(String smail) {
		this.smail = smail;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getBookCount() {
		return bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", slastname=" + slastname + ", sage=" + sage + ", smail="
				+ smail + ", saddress=" + saddress + ", spassword=" + spassword + ", bookCount=" + bookCount + ", fine="
				+ fine + "]";
	}

}

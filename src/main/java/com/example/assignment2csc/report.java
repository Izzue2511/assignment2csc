package assignment2;

import java.io.Serializable;
import java.sql.Date;

public class report implements Serializable {


	private static final long serialVersionUID = 1L;
	public int rpid;
	public String category;
	public Date visitdate;
	public String item;
	public double price;
	public String subject;
	public String message;
	public String nric;

	public report() {}

	public int getRpid() {
		return rpid;
	}

	public void setRpid(int rpid) {
		this.rpid = rpid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	

	public Date getVisitdate() {
		return visitdate;
	}

	public void setVisitdate(Date visitdate) {
		this.visitdate = visitdate;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNric() {
		return nric;
	}

	public void setNric(String nric) {
		this.nric = nric;
	}
	
	
	
}
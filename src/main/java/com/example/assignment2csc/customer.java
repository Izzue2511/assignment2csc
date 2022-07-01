package assignment2;
import java.io.Serializable;

public class customer implements Serializable {


	private static final long serialVersionUID = 1L;
	public String id;
	public String custname;
	public String custeemail;
	public String custphone;
	
	public customer() {}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCusteemail() {
		return custeemail;
	}

	public void setCusteemail(String custeemail) {
		this.custeemail = custeemail;
	}

	public String getCustphone() {
		return custphone;
	}

	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}
	
	

}
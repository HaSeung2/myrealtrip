package app.pay.dao;

public class AirPaymentDTO {
	private String useremail;
	private String datefilter;
	private String airline;
	private String airnum;
	private String dep;
	private String arr;
	private String price;
	
	String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	String getDatefilter() {
		return datefilter;
	}
	public void setDatefilter(String datefilter) {
		this.datefilter = datefilter;
	}
	String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	String getAirnum() {
		return airnum;
	}
	public void setAirnum(String airnum) {
		this.airnum = airnum;
	}
	String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}

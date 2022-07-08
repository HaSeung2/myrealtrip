package app.mytrip.dao;

public class MytripDTO {
	private String useremail;
    private String datefilte;
    private String airline;
    private String airnum; 
    private String dep; 
    private String arr; 
    private String price;
    
    public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getDatefilte() {
		return datefilte;
	}
	public void setDatefilte(String datefilte) {
		this.datefilte = datefilte;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getAirnum() {
		return airnum;
	}
	public void setAirnum(String airnum) {
		this.airnum = airnum;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getArr() {
		return arr;
	}
	public void setArr(String arr) {
		this.arr = arr;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
    
    
}

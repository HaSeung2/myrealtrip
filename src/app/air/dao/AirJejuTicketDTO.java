package app.air.dao;

public class AirJejuTicketDTO {
	private int jeju_ticket_num;
	private String nation ;
	private String trip;
    private String airtime;
    private String price;
    private String airline;
    private String img_url;
    
	public int getJeju_ticket_num() {
		return jeju_ticket_num;
	}
	public void setJeju_ticket_num(int jeju_ticket_num) {
		this.jeju_ticket_num = jeju_ticket_num;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getTrip() {
		return trip;
	}
	public void setTrip(String trip) {
		this.trip = trip;
	}
	public String getAirtime() {
		return airtime;
	}
	public void setAirtime(String airtime) {
		this.airtime = airtime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
}

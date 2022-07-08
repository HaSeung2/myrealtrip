package app.card.dao;

public class CardDTO {
	private String cardid;
	private String traveltitle;
	private String travelcontent;
	private boolean isolate;
    private String travelpicture;
    
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getTraveltitle() {
		return traveltitle;
	}
	public void setTraveltitle(String traveltitle) {
		this.traveltitle = traveltitle;
	}
	public String getTravelcontent() {
		return travelcontent;
	}
	public void setTravelcontent(String travelcontent) {
		this.travelcontent = travelcontent;
	}
	public boolean isIsolate() {
		return isolate;
	}
	public void setIsolate(boolean isolate) {
		this.isolate = isolate;
	}
	public String getTravelpicture() {
		return travelpicture;
	}
	public void setTravelpicture(String travelpicture) {
		this.travelpicture = travelpicture;
	}
    
    
}

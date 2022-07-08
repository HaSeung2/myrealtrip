package app.pay.dao;

public class paymentDTO {
	
	private String useremail;
	private String datefilter;
	private String hotelname;
	private String hotelImg;
	private String hotelPrice;
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getDatefilter() {
		return datefilter;
	}
	public void setDatefilter(String datefilter) {
		this.datefilter = datefilter;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getHotelImg() {
		return hotelImg;
	}
	public void setHotelImg(String hotelImg) {
		this.hotelImg = hotelImg;
	}
	public String getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(String hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	
	
}

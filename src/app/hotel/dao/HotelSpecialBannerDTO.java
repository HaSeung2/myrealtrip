package app.hotel.dao;

public class HotelSpecialBannerDTO {
	private int specal_hotel_num;
	private String img_url;
    private String category;
    private String sugso_name;
    private String icon_img;
    private String rating;
    private String count;
    
	public int getSpecal_hotel_num() {
		return specal_hotel_num;
	}
	public void setSpecal_hotel_num(int specal_hotel_num) {
		this.specal_hotel_num = specal_hotel_num;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSugso_name() {
		return sugso_name;
	}
	public void setSugso_name(String sugso_name) {
		this.sugso_name = sugso_name;
	}
	public String getIcon_img() {
		return icon_img;
	}
	public void setIcon_img(String icon_img) {
		this.icon_img = icon_img;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
}

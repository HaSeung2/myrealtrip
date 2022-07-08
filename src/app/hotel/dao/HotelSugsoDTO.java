package app.hotel.dao;

public class HotelSugsoDTO {
	private int up_sugso_num;
	private String img_url;
    private String category;
    private String sugso_name;
    private String icon_img;
    private String rating;
    private String count;
    private String price;
    
	public int getUp_sugso_num() {
		return up_sugso_num;
	}
	public void setUp_sugso_num(int up_sugso_num) {
		this.up_sugso_num = up_sugso_num;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
    
}

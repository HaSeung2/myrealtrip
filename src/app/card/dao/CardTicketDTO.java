package app.card.dao;

public class CardTicketDTO {
	private String ticket_name;
	private String ticket_kind;
	private String ticket_event;
	private String  country;
	private int  scope;
	private String replyCount;
	private boolean heart_like;
	private String image;
	private int standard_num;
	private String originalPrice;
	private String  price;
	public String getTicket_name() {
		return ticket_name;
	}
	public void setTicket_name(String ticket_name) {
		this.ticket_name = ticket_name;
	}
	public String getTicket_kind() {
		return ticket_kind;
	}
	public void setTicket_kind(String ticket_kind) {
		this.ticket_kind = ticket_kind;
	}
	public String getTicket_event() {
		return ticket_event;
	}
	public void setTicket_event(String ticket_event) {
		this.ticket_event = ticket_event;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getScope() {
		return scope;
	}
	public void setScope(int scope) {
		this.scope = scope;
	}
	public String getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(String replyCount) {
		this.replyCount = replyCount;
	}
	public boolean isHeart_like() {
		return heart_like;
	}
	public void setHeart_like(boolean heart_like) {
		this.heart_like = heart_like;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getStandard_num() {
		return standard_num;
	}
	public void setStandard_num(int standard_num) {
		this.standard_num = standard_num;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	
}

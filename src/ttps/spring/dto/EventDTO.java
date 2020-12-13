package ttps.spring.dto;

import java.util.Date;

import ttps.spring.model.Event;

public class EventDTO {
	
	private Long id;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private String state;
	private	String address;
	private String zipCode;
	private long latitude;
	private long longitude;
	private String province;
	private Date dayAndTime;
	private String mail;
	private String description;
	private String payment;
	private String phone;

	
	// trucks: Truck[];

	// eventPlanner: EventPlanner;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public EventDTO() {
		
	}

	public EventDTO(Event event) {
		this.id = event.getId();
		this.state = event.getState();
		this.address = event.getAdress();
		this.zipCode = event.getZipCode();
		this.latitude = event.getLatitude();
		this.longitude = event.getLongitude();
		this.province = event.getProvince();
		this.dayAndTime = event.getDayAndTime();
		this.mail = event.getEmail();
		this.description = event.getDescription();
		this.payment = event.getPayment();
		this.name = event.getName();
		this.phone = event.getPhone();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long lat) {
		this.latitude = lat;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long lng) {
		this.longitude = lng;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Date getDayAndTime() {
		return dayAndTime;
	}
	public void setDayAndTime(Date dayAndTime) {
		this.dayAndTime = dayAndTime;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	
	
}



package ttps.spring.dto;

import ttps.spring.model.Truck;

public class TruckViewDTO {
	
	private Long id;

	private String name;

	private String description;

	private String uri;
	
	private String whatsapp;

	private String instagram;

	private String twitter;
	
	private Double average;
	
	public TruckViewDTO(Truck truck) {
		this.id = truck.getId();
		this.name = truck.getName();
		this.description = truck.getDescription();
		this.uri = truck.getUri();
		this.whatsapp = truck.getWhatsapp();
		this.instagram = truck.getInstagram();
		this.twitter = truck.getTwitter();
		this.average = truck.getAVGvaloration();
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	
	
}

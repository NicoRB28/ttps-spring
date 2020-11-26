package ttps.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "event")
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "event_truck", 
			joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id")
			)
	private List<Truck> trucks;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_planner_id")
	private EventPlanner eventPlanner;
	@Column(name = "state", length = 255)
	private String state;
	@Column(name = "name", length = 255)
	private String name;
	@Column(name = "adress", length = 255)
	private String adress;
	@Column(name = "zipCode", length = 255)
	private String zipCode;
	@Column(name = "latitude")
	private long latitude;
	@Column(name = "longitude")
	private long longitude;
	@Column(name = "province", length = 255)
	private String province;
	@Column(name = "day")
	@Temporal(TemporalType.DATE)
	private Date dayAndTime;
	@Column(name = "email", length = 255)
	private String email;
	@Column(name = "phone", length = 255)
	private String phone;
	@Column(name = "description", length = 255)
	private String description;
	@Column(name = "payment", length = 255)
	private String payment;
	
	public Event() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Truck> getTrucks() {
		return trucks;
	}

	public void setTrucks(List<Truck> trucks) {
		this.trucks = trucks;
	}

	public EventPlanner getEventPlanner() {
		return eventPlanner;
	}

	public void setEventPlanner(EventPlanner eventPlanner) {
		this.eventPlanner = eventPlanner;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
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

	public void setDayAndTime(Date day) {
		this.dayAndTime = day;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

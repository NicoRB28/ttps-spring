package ttps.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ttps.spring.dto.CreateTruckDTO;
import ttps.spring.dto.EditTruckDTO;

@Entity
@Table(name = "truck")
@JsonIgnoreProperties(value= {"suppliers"})
public class Truck implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "name", length = 255)
	@NotEmpty
	private String name;

	@OneToOne(mappedBy = "truck", fetch = FetchType.EAGER)
	@JoinColumn(name = "owner_id", referencedColumnName = "id")
	private FoodTrucker owner;

	@Column(name = "description", length = 255)
	@NotEmpty
	private String description;

	@Column(name = "uri", length = 255)
	private String uri;

	@Column(name = "whatsapp", length = 255)	
	private String whatsapp;

	@Column(name = "instagram", length = 255)
	private String instagram;

	@Column(name = "twitter", length = 255)
	private String twitter;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Integer> valoraciones;
	
	@ManyToMany(mappedBy = "trucks", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Event> reservations;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(
			name = "truck_servicio", 
			joinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "servicio_id", referencedColumnName = "id")
			)
	private List<Service> servicios;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<String> imagenes;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<String> tags;

	public Truck() {
		super();
		this.servicios = new ArrayList<>();
		this.valoraciones = Arrays.asList();
		this.reservations = Arrays.asList();
		this.imagenes = Arrays.asList();
		this.tags = Arrays.asList();
	}
	
	public Truck(CreateTruckDTO dto, FoodTrucker owner) {
		super();
		this.servicios = new ArrayList<>();
		this.valoraciones = Arrays.asList();
		this.reservations = Arrays.asList();
		this.imagenes = Arrays.asList();
		this.tags = Arrays.asList();
		
		this.description = dto.getDescription();
		this.instagram = dto.getInstagram();
		this.name = dto.getName();
		this.owner = owner;
		this.twitter = dto.getTwitter();
		this.uri = dto.getUri();
		this.whatsapp = dto.getWhatsapp();
		this.tags = dto.getTags();
	}
	
	public Truck(EditTruckDTO dto) {		
		this.description = dto.getDescription();
		this.instagram = dto.getInstagram();
		this.name = dto.getName();
		this.twitter = dto.getTwitter();
		this.uri = dto.getUri();
		this.whatsapp = dto.getWhatsapp();
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public FoodTrucker getOwner() {
		return owner;
	}

	public void setOwner(FoodTrucker owner) {
		this.owner = owner;
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

	public List<Integer> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Integer> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public List<Event> getReservations() {
		return reservations;
	}

	public void setReservations(List<Event> reservations) {
		this.reservations = reservations;
	}

	public List<Service> getServicios() {
		return servicios;
	}

	public void setServicios(List<Service> servicios) {
		this.servicios = servicios;
	}

	public List<String> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}
	
	public void addImage(String image) {
		this.imagenes.add(image);
	}
	
	public void addService(Service serv) {
		this.servicios.add(serv);
	}
	
	public void addValoration(Integer valoration) {
		this.valoraciones.add(valoration);
	}
	
	public Double getAVGvaloration() {
		
		return this.valoraciones.isEmpty()?Double.valueOf(0): this.valoraciones.stream()
															.mapToInt(Integer::intValue)
															.asDoubleStream()
															.average()
															.getAsDouble();
		
	}
	
}

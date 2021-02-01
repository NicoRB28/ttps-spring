package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;

import ttps.spring.dto.UsuarioDTO;



@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "username",unique = true, length = 255, nullable=false)
	@NotEmpty
	private String username;
	
	@Column(name = "mail", length = 255, nullable=false)
	@NotEmpty
	private String mail;
	
	@Column(name = "password", length = 255, nullable = false)
	@NotEmpty
	private String password;
	
	
	public Usuario() {
		super();
	}
	public Usuario(UsuarioDTO userDTO) {
		this.mail = userDTO.getMail();
		this.username = userDTO.getUsername();
		this.password = userDTO.getPassword();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

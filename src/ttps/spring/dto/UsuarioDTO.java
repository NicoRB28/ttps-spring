package ttps.spring.dto;

import ttps.spring.model.Usuario;

public class UsuarioDTO {

	private String username;
	private String mail;
	private String password;
	private String type;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario data) {
		this.mail = data.getMail();
		this.username = data.getUsername();
		this.password = data.getPassword();
		this.type = null;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

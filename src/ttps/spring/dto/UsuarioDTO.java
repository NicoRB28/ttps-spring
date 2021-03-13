package ttps.spring.dto;

import ttps.spring.model.Usuario;

public class UsuarioDTO {
	
	private Long userId;																																																
	private String username;
	private String mail;
	private String password;
	private Boolean isTrucker;
	
	public UsuarioDTO() {
		
	}
	
	public <T extends Usuario> UsuarioDTO(T data) {
		this.mail = data.getMail();
		this.username = data.getUsername();
		this.password = data.getPassword();
		this.userId = data.getId();
		this.isTrucker = data.isTrucker();
	}
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
	public void isTrucker(Boolean isTrucker) {
		this.isTrucker = isTrucker;
	}
	public Boolean isTrucker() {
		return this.isTrucker;
	}
}

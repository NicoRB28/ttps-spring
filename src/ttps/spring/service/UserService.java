package ttps.spring.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.Usuario;

@Service
public interface UserService {
	
	public Usuario createUser(UsuarioDTO userDTO);
	
	public boolean authenticate(String username, String password);
	
	public Optional<Usuario> getUserByUsername(String  username);
	
	public Optional<Usuario> getUserById(Long id);
	
	public void updateUser(Usuario user) throws EntityNotFoundException;
}

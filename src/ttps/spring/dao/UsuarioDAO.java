package ttps.spring.dao;

import java.util.Optional;

import ttps.spring.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	public Optional<Usuario> getUserByUserName(String username);
}

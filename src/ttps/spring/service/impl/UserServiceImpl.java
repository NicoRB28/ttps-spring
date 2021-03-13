package ttps.spring.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import ttps.spring.dao.UsuarioDAO;
import ttps.spring.dto.UsuarioDTO;
import ttps.spring.model.EventPlanner;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Usuario;
import ttps.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public Usuario createUser(UsuarioDTO userDTO) {
		return null;
	}

	@Override
	public boolean authenticate(String username, String password) {
		Optional<Usuario> userDb = this.usuarioDAO.getUserByUserName(username);
		
		if(userDb.isPresent()) {
			return (userDb.get().getPassword().equals(password))? true
					: false;			
		}
		return false;
	}

	@Override
	public Optional<Usuario> getUserByUsername(String username) {
		return this.usuarioDAO.getUserByUserName(username); 
	}

	@Override
	public Optional<Usuario> getUserById(Long id) {
		Usuario userDb = this.usuarioDAO.findById(id);
		
		return (userDb == null)? Optional.empty(): Optional.of(userDb);
	}

	@Override
	public void updateUser(Usuario user) throws EntityNotFoundException,ConstraintViolationException {
		
		Usuario userDb = this.getUserById(user.getId()).orElseThrow(EntityNotFoundException::new);

		userDb.setMail(user.getMail());
		userDb.setUsername(user.getUsername());
		userDb.setPassword(user.getPassword());
		
		this.usuarioDAO.update(userDb);
		
	}
	
	

}

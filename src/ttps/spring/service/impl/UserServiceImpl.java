package ttps.spring.service.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
		
		if(userDTO.getType().equals("FoodTrucker")) {
			FoodTrucker trucker = new FoodTrucker(userDTO);
			this.usuarioDAO.save(trucker);
			return trucker;
		}
		EventPlanner evPlanner = new EventPlanner(userDTO);
		this.usuarioDAO.save(evPlanner);
		return evPlanner;
	}

	@Override
	public boolean authenticate(String username, String password) {
		Usuario userDb = this.usuarioDAO.getUserByUserName(username)
										.orElseThrow(EntityNotFoundException::new);
		return (userDb.getPassword().equals(password))? true
												  : false;
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
	public void updateUser(Usuario user) throws EntityNotFoundException {
		Usuario userDb = this.getUserById(user.getId()).orElseThrow(EntityNotFoundException::new);
		userDb.setMail(user.getMail());
		userDb.setUsername(user.getUsername());
		
		this.usuarioDAO.update(userDb);
		
	}
	
	

}

package ttps.spring.dao.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.UsuarioDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;
import ttps.spring.model.Usuario;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO{

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public Optional<Usuario> getUserByUserName(String username) {	
			Usuario user = (Usuario) this.getEntityManager().createQuery("FROM Usuario u WHERE u.username = :string ")
									.setParameter("string", username).getSingleResult();
			//Usuario user = (Usuario) this.getEntityManager().createNativeQuery("SELECT * FROM usuario  WHERE username LIKE :username")
			//									  .setParameter("username", username)
			//									  .getSingleResult();
			return Optional.of(user);
		
	}


	

}

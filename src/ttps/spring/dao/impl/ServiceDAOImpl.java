package ttps.spring.dao.impl;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.ServiceDAO;
import ttps.spring.model.Service;

@Repository
public class ServiceDAOImpl extends GenericDAOImpl<Service> implements ServiceDAO {

	public ServiceDAOImpl() {
		super(Service.class);	
	}

}

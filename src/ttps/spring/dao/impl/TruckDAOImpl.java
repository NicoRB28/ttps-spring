package ttps.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.TruckDAO;
import ttps.spring.model.Truck;


@Repository
public class TruckDAOImpl extends GenericDAOImpl<Truck> implements TruckDAO{

	public TruckDAOImpl() {
		super(Truck.class);
	}

	@Override
	public List<Truck> findByServiceId(Long serviceId) {
		
		return	this.getEntityManager().createQuery("SELECT t FROM Truck as t join t.servicios as ps WHERE ps.id =:serviceId")
						.setParameter("serviceId", serviceId)
						.getResultList();
		 
	}
		
	
	@Override
	public Truck findByTruckname(String truckname) {
		
		Truck truck = (Truck) this.getEntityManager().createQuery("FROM Truck t WHERE t.name = :string ")
								.setParameter("string", truckname).getSingleResult();
		return truck;
	}

	@Override
	public Truck findByUserId(Long userId) {
		return	(Truck)	this.getEntityManager().createQuery("SELECT t FROM Truck as t join t.owner as o WHERE o.id =:userId")
							.setParameter("userId", userId)
							.getSingleResult();
 
	}
	
	
	

}

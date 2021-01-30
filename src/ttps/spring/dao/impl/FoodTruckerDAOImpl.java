package ttps.spring.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import ttps.spring.dao.FoodTruckerDAO;
import ttps.spring.model.FoodTrucker;
import ttps.spring.model.Truck;

@Repository
public class FoodTruckerDAOImpl extends GenericDAOImpl<FoodTrucker> implements FoodTruckerDAO{

	public FoodTruckerDAOImpl() {
		super(FoodTrucker.class);
	}
	
	@SuppressWarnings({"unchecked"})
	public List<Truck> findTrucksById(Long id){
		return	this.getEntityManager().createQuery("SELECT t FROM Truck as t join t.owner as o WHERE o.id = :id")
				.setParameter("id", id).getResultList();

	}
}

package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Vehicule;
@Repository
@Transactional
public class VehiculeDao extends AbstractDao<Integer, Vehicule> implements IVehicule{

	public void addVehicule(Vehicule vehicule) {
		persist(vehicule);
		
	}

}

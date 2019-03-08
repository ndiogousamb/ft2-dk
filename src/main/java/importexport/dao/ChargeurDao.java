package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Chargeur;

@Repository
@Transactional
public class ChargeurDao extends AbstractDao<Integer, Chargeur> implements IChargeur {

	public void AddChargeur(Chargeur chargeur) {
		persist(chargeur);
		
	}

	public void UpdateChargeur(Chargeur chargeur) {
		update(chargeur);
		
	}
}

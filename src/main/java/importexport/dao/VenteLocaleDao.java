package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Achat;
@Repository
@Transactional
public class VenteLocaleDao extends AbstractDao<Integer, Achat> implements IVenteLocale{

	public void addAchat(Achat achat) {
		persist(achat);
		
	}

	public void updateAchat(Achat achat) {
		update(achat);
		
	}

	
}

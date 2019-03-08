package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Fournisseur;

@Repository
@Transactional
public class FournisseurDao extends AbstractDao<Integer, Fournisseur> implements IFournisseur {

	public void AddFournisseur(Fournisseur Fournisseur) {
		persist(Fournisseur);
		
	}

	public void UpdateFournisseur(Fournisseur Fournisseur) {
		update(Fournisseur);
		
	}

}

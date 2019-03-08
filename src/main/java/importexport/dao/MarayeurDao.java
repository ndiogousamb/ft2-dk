package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Marayeur;
@Repository
@Transactional
public class MarayeurDao extends AbstractDao<Integer, Marayeur>implements IMarayeur{

	public void AddMarayeur(Marayeur marayeur) {
		persist(marayeur);
		
	}

}

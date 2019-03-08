package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Origine;

@Repository
@Transactional
public class OrigineDao extends AbstractDao<Integer, Origine> implements IOrigine{

	public void AddOrigine(Origine origine) {
		persist(origine);
		
	}

	public void UpdateOrigine(Origine origine) {
		update(origine);
	}

}

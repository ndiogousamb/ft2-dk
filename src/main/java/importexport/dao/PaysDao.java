package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Pays;
@Repository
@Transactional
public class PaysDao  extends AbstractDao<Integer, Pays> implements IPays {

	public void AddPays(Pays Pays) {
		// TODO Auto-generated method stub
		persist(Pays);
		
	}

	public void UpdatePays(Pays Pays) {
		// TODO Auto-generated method stub
		update(Pays);
		
	}

}

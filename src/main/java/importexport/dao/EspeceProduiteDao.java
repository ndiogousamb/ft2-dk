package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import importexport.model.EspeceProduite;

@Repository
@Transactional
public class EspeceProduiteDao extends AbstractDao<Integer, EspeceProduite> implements IEspeceProduite{


	public void AddEspeceProduite(EspeceProduite especeProduite) {
		persist(especeProduite);
		
	}

	public void UpdateEspeceProduite(EspeceProduite especeProduite) {
		update(especeProduite);
		
	}

}

package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.EspeceDemoulee;

@Repository
@Transactional
public class EspeceDemouleeDao extends AbstractDao<Integer, EspeceDemoulee> implements IEspeceDemoulee{

	public void AddDemoulage(EspeceDemoulee especeDemoulee) {
		persist(especeDemoulee);
		
	}

	public void UpdateDemoulage(EspeceDemoulee especeDemoulee) {
		update(especeDemoulee);
		
	}

	public void DeleteDemoulage(EspeceDemoulee especeDemoulee) {
		update(especeDemoulee);
		
	}
	
	
}


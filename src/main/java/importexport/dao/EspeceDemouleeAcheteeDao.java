package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.EscepeDemouleeAchetee;
import importexport.model.EspeceDemoulee;


@Repository
@Transactional
public class EspeceDemouleeAcheteeDao extends AbstractDao<Integer, EscepeDemouleeAchetee> implements IEspeceDemouleeAchetee{

	public void AddEscepeDemouleeAchetee(EscepeDemouleeAchetee EspeceDemouleeAchetee) {
		persist(EspeceDemouleeAchetee);
		
	}

	public void UpdateEscepeDemouleeAchetee(EscepeDemouleeAchetee EspeceDemouleeAchetee) {
		update(EspeceDemouleeAchetee);
		
	}

}

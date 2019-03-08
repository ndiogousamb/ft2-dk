package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.EspeceDebarqueeTransportees;
import importexport.model.EspeceDemoulee;

@Repository
@Transactional
public class EspeceDebarqueeTranspDao extends AbstractDao<Integer, EspeceDebarqueeTransportees>
		implements IEspeceDebarqueTransp {

	public void AddEspeceDebarqueTransp(EspeceDebarqueeTransportees debarqueeTransp) {
		persist(debarqueeTransp);

	}

	public void UpdateEspeceDebarqueTransp(EspeceDebarqueeTransportees debarqueeTransp) {
		update(debarqueeTransp);

	}

}

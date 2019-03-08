package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Debarquement;


@Repository
@Transactional
public class DebarquementDao extends AbstractDao<Integer, Debarquement> implements IDebarquement{

	public void addDebarquement(Debarquement debarquement) {
		persist(debarquement);
		
	}

	public void updateDebarquement(Debarquement debarquement) {
		update(debarquement);
		
	}

}

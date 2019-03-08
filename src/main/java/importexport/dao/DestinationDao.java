package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Destination;



@Repository
@Transactional
public class DestinationDao extends AbstractDao<Integer, Destination> implements IDestination{

	public void addDestination(Destination destination) {
		persist(destination);
		
	}

	public void updateDestination(Destination destination) {
		update(destination);
	}

}

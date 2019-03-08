package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Container;
import importexport.model.Debarquement;

@Repository
@Transactional
public class ContainerDao extends AbstractDao<Integer, Container> implements IContainer {

	public void addContainer(Container container) {
	persist(container);
		
	}

	public void updateContainer(Container container) {
		update(container);
	}

}

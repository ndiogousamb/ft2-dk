package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Navire;

@Repository
@Transactional
public class NavireDao extends AbstractDao<Integer, Navire> implements INavire {

	public void AddNavire(Navire Navire) {
		persist(Navire);
		
	}

	public void UpdateNavire(Navire Navire) {
		update(Navire);
		
	}

}

package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Exportation;

@Repository
@Transactional
public class ExportationDao extends AbstractDao<Integer, Exportation> implements IExportation{

	public void AddExportation(Exportation Exportation) {
		persist(Exportation);
		
	}

	public void UpdateExportation(Exportation Exportation) {
		update(Exportation);
	}
	
}

package importexport.dao;

import java.text.DecimalFormat;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.*;
@Repository
@Transactional
public class ProductionDao extends AbstractDao<Integer, Production> implements IProduction{

	public void AddProduction(Production prod) {
		persist(prod);
		
	}

	public void UpdateProduction(Production prod) {
	update(prod);
		
	}

	public void DeleteProduction(Production prod) {
		update(prod);
		
	}

	

	
	

	
}

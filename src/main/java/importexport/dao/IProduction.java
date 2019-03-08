package importexport.dao;

import org.springframework.stereotype.Component;

import importexport.model.*;

public interface IProduction {
	public void AddProduction(Production prod);
	public void UpdateProduction(Production prod);
	public void DeleteProduction(Production prod);
	
}

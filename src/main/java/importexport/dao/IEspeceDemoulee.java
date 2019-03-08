package importexport.dao;

import importexport.model.EspeceDemoulee;
import importexport.model.Production;

public interface IEspeceDemoulee {
	public void AddDemoulage(EspeceDemoulee especeDemoulee);
	public void UpdateDemoulage(EspeceDemoulee especeDemoulee);
	public void DeleteDemoulage(EspeceDemoulee especeDemoulee);
}

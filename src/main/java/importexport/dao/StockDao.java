package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.*;
@Repository
@Transactional
public class StockDao extends AbstractDao<Integer, Stock> implements IStock{

	public void AddStock(Stock stock) {
		persist(stock);
		
	}

	public void UpdateStock(Stock stock) {
		update(stock);
		
	}

}

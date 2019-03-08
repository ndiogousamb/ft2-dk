package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Achat;
import importexport.model.Client;
@Repository
@Transactional
public class ClientDao extends AbstractDao<Integer, Client> implements IClient{

	public void addClient(Client client) {
		persist(client);
		
	}

	public void updateClient(Client client) {
		update(client);
	}

}

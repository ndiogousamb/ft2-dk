package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Destinataire;
@Repository
@Transactional
public class DestinataireDao extends AbstractDao<Integer, Destinataire> implements IDestinataire{

	public void addDestinataire(Destinataire destinataire) {
		persist(destinataire);
		
	}

	public void updateDestinataire(Destinataire destinataire) {
		update(destinataire);
	}

}

package importexport.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Destinataire;

@Repository
@Transactional
public interface IDestinataire {
	public void addDestinataire(Destinataire destinataire);

	public void updateDestinataire(Destinataire destinataire);
}

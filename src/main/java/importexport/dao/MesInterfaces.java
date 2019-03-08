package importexport.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import importexport.model.*;


public interface MesInterfaces {
	public String generateCodeProduction();
	public String generateCodeMarayeur();
	
	public List<Espece>ListEspeces();
	public List<Calibre>ListCalibres();
    public Date formatDate(String date);
    public Calibre GetCalibreByNom(String nomCalibre);
    public Espece GetEspeceByNom(String nomEspece);
    public Marayeur MarayeurByNomEtPrenom(String Prenom,String Nom);
    public Marayeur MarayeurByCIN(String CIN);
    public Production GetProductionMaximal();
    public Vehicule GetVehiculeMaximal();
    public List<Production>listProduction();
    public List<EspeceProduite>listEspeceProduiteByCode(Integer Code);
    public Vehicule GetVehiculeByMatricule(String Immatricule);
}

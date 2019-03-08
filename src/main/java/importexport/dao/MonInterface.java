package importexport.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import importexport.model.*;

public interface MonInterface {
	public String generateCodeProduction();
	
	public String genererFactureProduction();
	
	public String genererFactureVenteLocale();
	
	public String genererFactureExportation();
	
	public Achat GetVenteLocaleMaximalRegle();
	
	public Exportation GetExportationMaximalRegle();

	public String generateCodeMarayeur();
	
	public String generateCodeExportation(); 
	
	public String generateCodeAchat();
	
	public List<Debarquement> ListDebarquement();
	
	public Chargeur GetChargeurByNomChargeur(String nomChargeur);
	
	public Origine GetOrigineByNomOrigine(String nomOrigine);
	
	public Pays GetPaysDestinataireByNom(String paysDestination);
	
	public Destinataire GetDestinataireByPrenomEtNomEtAdresse(String PrenomDestinataire,String NomDestinataire,String adresseDestinataire);
	
	public Container GetContainerByNumContainerEtNumPlombs(String NumContainer,String NumPlombs);
	
	
	public Client GetClientByPrenomEtNom(String Prenom,String Nom);
	
	public  List<Stock>  GetDispoStock(String espece,String calibre,String nbCarton,String qualite);
	
	public  List<Stock>  GetDispoStockGrosPoisson(String espece,String poids,String qualite);
	
	public  List<Stock>  GetActuel(String espece,String calibre,String qualite);
	
	public List<Stock> GetActuelPourModification(String espece, String calibre);
	
	public  List<Stock>  GetActuelGrosPoisson(String espece,String qualite);
	
	public String generateCodeFournisseur();
	
	public List<Debarquement> listDebarquementNonRegle();
	
	public List<Achat> listVenteLocaleNonRegle();
	
	public List<Exportation> listExportationNonRegle();
	
	public List<Exportation> listExportationRegle();
	
	public List<Exportation> listExportationAConsulter();
	
	public List<Achat> listVenteLocaleRegle();
	
	public List<Achat> listTousLesVenteLocales();
	
	public List<Debarquement> listDebarquementRegle();

	public List<EspeceDemoulee> GetEspeceDemoulee(Espece espece, Calibre calibre, TypeCarton typeCarton,
			Qualite qualite);

	public List<EspeceDemoulee> GetEspeceGrosPoissonDemoulee(Espece espece, CalibreGP calibreGP, Qualite qualite);

	public List<Stock> GetStockByEspeceGrosPoissonDemoulee(EspeceDemoulee especeDemoulee);

	public String generateCodeDebarquement(String nomNavire, Date date);

	public List<Espece> ListEspeces();

	public List<Tunnel> ListTunnel();

	public List<TypeCarton> ListTypeCarton();

	public List<Calibre> ListCalibres();
	
	public List<TypeContainer> ListTypeContainer();

	public List<Qualite> ListQualites();

	public Date formatDate(String date);

	public Calibre GetCalibreByNom(String nomCalibre);
	
	public TypeContainer GetTypeContainerByNom(String nomTypeContainer);
	
	public Debarquement GetDebarquementById(Integer Id);
	
	public Achat GetAchatById(Integer Id);
	
	public Exportation GetExportationById(Integer Id);

	public CalibreGP GetCalibreGrosPoisson(String nomCalibre);

	public Espece GetEspeceByNom(String nomEspece);

	public Marayeur MarayeurByNomEtPrenom(String Prenom, String Nom);

	public Marayeur MarayeurByCIN(String CIN);

	public Production GetProductionMaximal();
	public Production GetProductionMaximalRegle();

	public Production GetProductionByCode(String Code);
	
	public Production GetProductionById(String Id);

	public Vehicule GetVehiculeMaximal();

	public List<Production> listProduction();

	public List<Production> listProductionNonRegle();

	public List<Production> listProductionRegle();

	public List<EspeceProduite> listEspeceProduiteByCode(Integer Code);

	public List<EspeceProduite> listEspeceProduiteNonDemoules();

	public List<EspeceProduite> listEspeceProduiteByCodeProduction(Integer Code);

	public List<EspeceProduite> listEspeceProduiteByCodeNonRegle(Integer Code);

	public List<EspeceDemoulee> listEspeceDemouleeByCodeNonRegle(Integer Code);
	
	public List<EscepeDemouleeAchetee> listEspeceDemouleeAcheteByCodeNonRegle(Integer Code);
	
	public List<EspeceDebarqueeTransportees> listEspeceDebarqueeTransporteesByCodeNonRegle(Integer Code);
	
	public List<EspeceDebarqueeTransportees> listEspeceDebarqueeTransporteesByCodePourConsulterExportation(Integer Code);
	
	public List<EscepeDemouleeAchetee> listEspeceDemouleeAcheteByCodeRegle(Integer Code);
	
	public List<EspeceProduite> listEspeceProduiteRegle(Integer Code);
	
	public List<EspeceDemoulee> listEspeceDemouleRegle(Integer Code);
	
	public List<EspeceDemoulee> listEspeceDemoule(Integer Code);

	public EspeceProduite EspeceProduiteById(Integer Id);

	public Vehicule GetVehiculeByMatricule(String Immatricule);
	
	public Container GetContainerByNumContainer(String NumContainer);

	public Destination GetDestionationByLieu(String Destination);

	public Qualite GetQualiteById(Integer Id);

	public Qualite GetQualiteByNom(String nom);

	public Tunnel GetTunnelById(Integer Id);

	public TypeCarton GetTypeCartonById(String Id);

	public TypeCarton GetTypeCartonByLibelle(String Libelle);

	public List<EspeceDemoulee> GetEspeceDemouleeByEspeceEtCalibre(Espece espece, Calibre calibre);

	public EspeceDemoulee GetEspeceDemouleeMax();
	
	public EspeceDemoulee GetEspeceDemouleeById(Integer Id);
	
	public EscepeDemouleeAchetee GetEspeceDemouleeAcheteById(Integer Id);
	
	public EspeceDemoulee GetEspeceDemouleeByEspeceCalibreEtTypeCarton(Espece espece, Calibre calibre,TypeCarton typeCarton);
	
	public EspeceDebarqueeTransportees GetEspeceTransporteesAcheteById(Integer Id);

	public List<EspeceProduite> GetEspeceProduiteByEspeceEtCalibre(Espece espece, Calibre calibre);
	
	public List<EspeceProduite> GetEspeceProduiteById(String Id);

	public Stock GetStock();

	public List<Production> listProductionNonDemoule();
	
	public List<Production> listTousLesProduction();
	
	

	public List<Stock> GetStockByEspeceDemoulee(EspeceDemoulee especeDemoulee);

	public List<Stock> GetListStock();

	public Navire GetNavireByNom(String nomNavire);

	public Fournisseur GetFourniseurByPrenomEtNom(String prenom, String nom);

	public List<Navire> GetNavireMax();
	
	public List<Client> GetClientMax();
	
	public List<Chargeur> GetChargeurMax();
	public List<Container> GetContainerMax();
	
	public List<Origine> GetOrigineMax();
	
	public List<Pays> GetPaysDestinataireMax();
	
	public List<Destinataire> GetDestinataireMax();
	
	public List<Exportation> GetExportationMax();
	
	public List<Achat> GetAchatMax();

	public List<Fournisseur> GetFournisseurMax();

	public List<Debarquement> GetDebarquementMax();
}

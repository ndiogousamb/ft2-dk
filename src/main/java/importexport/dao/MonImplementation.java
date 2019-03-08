package importexport.dao;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.*;

@Repository
@Transactional
public class MonImplementation implements MonInterface {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	public String generateCodeProduction() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Production p");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return "BE N°" + "0001";
		}
		return "BE N°" + new DecimalFormat("0000").format(max + 1);
	}

	public String generateCodeMarayeur() {
		Query query = getSession().createQuery("SELECT MAX(m.id) FROM Marayeur m");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return "MARAYEUR" + "0001";
		}
		return "MARAYEUR" + new DecimalFormat("0000").format(max + 1);
	}
	public String generateCodeExportation() {
		Query query = getSession().createQuery("SELECT MAX(m.id) FROM Exportation m");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return "EXPORTATION" + "0000000001";
		}
		return "EXPORTATION" + new DecimalFormat("0000000000").format(max + 1);
	}

	public List<Espece> ListEspeces() {
		@SuppressWarnings("unchecked")
		List<Espece> list = (List<Espece>) getSession().createQuery("SELECT e FROM Espece e").list();
		return list;
	}

	public List<Calibre> ListCalibres() {
		@SuppressWarnings("unchecked")
		List<Calibre> list = (List<Calibre>) getSession().createQuery("SELECT e FROM Calibre e").list();
		return list;
	}

	public Date formatDate(String date) {
		
		Date MyDate = null;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			MyDate = formatter.parse(date);
			MyDate = (Date) formatter.parse(date);
			/*
			 * SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			 * String dateInString = "07/06/2013"; Date date =
			 * formatter.parse(dateInString);
			 */

			return MyDate;
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return MyDate;
	}

	public Calibre GetCalibreByNom(String nomCalibre) {
		Query query = getSession().createQuery("FROM Calibre c WHERE c.libelleCalibre = :libelleCalibre");
		query.setParameter("libelleCalibre", nomCalibre);
		return (Calibre) query.uniqueResult();
	}

	public Espece GetEspeceByNom(String nomEspece) {
		Query query = getSession().createQuery("FROM Espece e WHERE e.libelleEspece = :libelleEspece");
		query.setParameter("libelleEspece", nomEspece);
		return (Espece) query.uniqueResult();
	}

	public Marayeur MarayeurByNomEtPrenom(String Prenom, String Nom) {
		Query query = getSession().createQuery("SELECT m FROM Marayeur m WHERE m.prenomMarayeur = :prenomMarayeur "
				+ "and m.nomMarayeur = :nomMarayeur");
		query.setParameter("prenomMarayeur", Prenom);
		query.setParameter("nomMarayeur", Nom);
		Marayeur marayeur = (Marayeur) query.uniqueResult();
		return marayeur;

	}

	public Production GetProductionMaximal() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Production p");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("FROM Production p WHERE p.id = :id");
		query.setParameter("id", id);
		Production production = (Production) query.uniqueResult();
		return production;
	}
	public Production GetProductionMaximalRegle() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Production p where p.regle=1");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("FROM Production p WHERE p.id = :id");
		query.setParameter("id", id);
		Production production = (Production) query.uniqueResult();
		return production;
	}
	public Achat GetVenteLocaleMaximalRegle() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Achat p where p.regle=1");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("FROM Achat p WHERE p.id = :id");
		query.setParameter("id", id);
		Achat achat = (Achat) query.uniqueResult();
		return achat;
	}

	public Vehicule GetVehiculeMaximal() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Vehicule p");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("FROM Vehicule p WHERE p.id = :id");
		query.setParameter("id", id);
		Vehicule vehicule = (Vehicule) query.uniqueResult();
		return vehicule;
	}

	@SuppressWarnings("unchecked")
	public List<Production> listProduction() {
		return (List<Production>) getSession().createQuery("FROM Production as p order by p.id desc").list();

	}
	@SuppressWarnings("unchecked")
	public List<Production> listProductionNonDemoule() {
		return (List<Production>) getSession().createQuery("FROM Production as p WHERE p.demoule = 0 order by p.id desc").list();

	}
	@SuppressWarnings("unchecked")
	public List<Production> listTousLesProduction() {
		return (List<Production>) getSession().createQuery("FROM Production as p order by p.id desc").list();

	}
	@SuppressWarnings("unchecked")
	public List<Production> listProductionNonRegle() {
		return (List<Production>) getSession().createQuery("FROM Production as p WHERE p.regle = 0 order by p.id desc").list();

	}
	@SuppressWarnings("unchecked")
	public List<Debarquement> listDebarquementNonRegle() {
		return (List<Debarquement>) getSession().createQuery("SELECT d FROM Debarquement d WHERE d.regle = 0 order by d.id desc").list();

	}
	@SuppressWarnings("unchecked")
	public List<Production> listProductionRegle() {
		return (List<Production>) getSession().createQuery("FROM Production as p WHERE p.regle = 1 order by p.id desc").list();

	}
	public Vehicule GetVehiculeByMatricule(String Immatricule) {
		Query query = getSession()
				.createQuery("SELECT v FROM Vehicule v WHERE v.numImmatriculation = :numImmatriculation");
		query.setParameter("numImmatriculation", Immatricule);
		Vehicule vehicule = (Vehicule) query.uniqueResult();
		return vehicule;
	}
	public Container GetContainerByNumContainer(String NumContainer) {
		Query query = getSession()
				.createQuery("SELECT c FROM Container c WHERE c.numeroContaineur = :numeroContaineur");
		query.setParameter("numeroContaineur", NumContainer);
		Container container = (Container) query.uniqueResult();
		return container;
	}

	public Marayeur MarayeurByCIN(String CIN) {

		Query query = getSession().createQuery("SELECT m FROM Marayeur m WHERE m.cinMarayeur = :cinMarayeur");
		query.setParameter("cinMarayeur", CIN);
		Marayeur marayeur = (Marayeur) query.uniqueResult();
		return marayeur;
	}

	@SuppressWarnings("unchecked")
	public List<EspeceProduite> listEspeceProduiteByCode(Integer Code) {

		return (List<EspeceProduite>) getSession()
				.createQuery(
						"SELECT e FROM EspeceProduite e WHERE e.production.id= :id and e.demoule=0 order by e.production desc")
				.setParameter("id", Code).list();

	}
	@SuppressWarnings("unchecked")
	public List<EspeceProduite> listEspeceProduiteNonDemoules() {

		return (List<EspeceProduite>) getSession()
				.createQuery("SELECT e FROM EspeceProduite e WHERE e.demoule=0 and e.poids >=10 order by e.production desc")
				.list();

	}
	public Production GetProductionByCode(String Code) {
		Query query = getSession().createQuery("SELECT p FROM Production p WHERE p.codeProduction = :codeProduction");
		query.setParameter("codeProduction", Code);
		Production production = (Production) query.uniqueResult();
		return production;
	}

	public EspeceProduite EspeceProduiteById(Integer Id) {
		Query query = getSession().createQuery("SELECT e FROM EspeceProduite e WHERE e.id = :id");
		query.setParameter("id", Id);
		EspeceProduite especeProduite = (EspeceProduite) query.uniqueResult();
		return especeProduite;

	}

	@SuppressWarnings("unchecked")
	public List<Tunnel> ListTunnel() {
		return (List<Tunnel>) getSession().createQuery("FROM Tunnel as q").list();

	}

	@SuppressWarnings("unchecked")
	public List<TypeCarton> ListTypeCarton() {
		return (List<TypeCarton>) getSession().createQuery("FROM TypeCarton as q").list();
	}

	@SuppressWarnings("unchecked")
	public List<Qualite> ListQualites() {

		return (List<Qualite>) getSession().createQuery("FROM Qualite as q").list();

	}
	public List<Debarquement> ListDebarquement() {

		return (List<Debarquement>) getSession().createQuery("SELECT d FROM Debarquement d order by d.id desc").list();

	}

	public Qualite GetQualiteById(Integer Id) {
		Query query = getSession().createQuery("SELECT e FROM Qualite e WHERE e.id = :id");
		query.setParameter("id", Id);
		Qualite qualite = (Qualite) query.uniqueResult();
		return qualite;

	}
	
	public Qualite GetQualiteByNom(String nom) {
		Query query = getSession().createQuery("SELECT e FROM Qualite e WHERE e.libelleQualite = :libelleQualite");
		query.setParameter("libelleQualite", nom);
		Qualite qualite = (Qualite) query.uniqueResult();
		return qualite;

	}

	public Tunnel GetTunnelById(Integer Id) {

		Query query = getSession().createQuery("SELECT e FROM Tunnel e WHERE e.id = :id");
		query.setParameter("id", Id);
		Tunnel tunnel = (Tunnel) query.uniqueResult();
		return tunnel;

	}

	public TypeCarton GetTypeCartonById(String Id) {

		Query query = getSession().createQuery("SELECT e FROM TypeCarton e WHERE e.id = :id");
		query.setParameter("id", Integer.parseInt(Id));
		TypeCarton typeCarton = (TypeCarton) query.uniqueResult();
		return typeCarton;

	}
	public TypeCarton GetTypeCartonByLibelle(String libelle) {

		Query query = getSession().createQuery("SELECT t FROM TypeCarton t WHERE t.libelleTypecarton = :libelleTypecarton");
		query.setParameter("libelleTypecarton", libelle);
		TypeCarton typeCarton = (TypeCarton) query.uniqueResult();
		return typeCarton;

	}

	public String generateCodeEntreeDemoulage() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM STOCK p");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return "ENTREE-DEMOUL-" + "000001";
		}
		return "ENTREE-DEMOUL-" + new DecimalFormat("000000").format(max + 1);
	}

	@SuppressWarnings("unchecked")
	public List<EspeceDemoulee> GetEspeceDemouleeByEspeceEtCalibre(Espece espece, Calibre calibre) {

		Query query = getSession()
				.createQuery("SELECT e FROM EspeceDemoulee e WHERE e.espece.id = :idE AND e.calibre.id=:idC ORDER BY id DESC");
		query.setParameter("idE", espece.getId());
		query.setParameter("idC", calibre.getId());
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<EspeceDemoulee>) query.list();
		
	}

	public EspeceDemoulee GetEspeceDemouleeMax() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM EspeceDemoulee p");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("FROM EspeceDemoulee p WHERE p.id = :id");
		query.setParameter("id", id);
		EspeceDemoulee especeDemoulee = (EspeceDemoulee) query.uniqueResult();
		return especeDemoulee;
	}

	

	public Stock GetStock() {
		Query query = getSession().createQuery("SELECT MAX(e.id) FROM Entree e");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("SELECT s FROM Stock s WHERE s.id = :id");
		query.setParameter("id", id);
		Stock stock = (Stock) query.uniqueResult();
		return stock;

	}

	@SuppressWarnings("unchecked")
	public List<Stock> GetStockByEspeceDemoulee(EspeceDemoulee especeDemoulee) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.especeDemoulee.espece.id = :idE AND s.especeDemoulee.calibre.id=:idC AND s.especeDemoulee.typeCarton.id=:idCarton AND s.especeDemoulee.qualite.id=:idQualite ORDER BY id DESC");
		query.setParameter("idE", especeDemoulee.getEspece().getId());
		query.setParameter("idC", especeDemoulee.getCalibre().getId());
		query.setParameter("idCarton", especeDemoulee.getTypeCarton().getId());
		query.setParameter("idQualite", especeDemoulee.getQualite().getId());
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Stock>) query.list();

	}
	@SuppressWarnings("unchecked")
	public List<EspeceDemoulee> GetEspeceDemoulee(Espece espece,Calibre calibre,TypeCarton typeCarton,Qualite qualite) {
		Query query = getSession().createQuery("SELECT e FROM EspeceDemoulee e WHERE e.espece.id = :idE AND e.calibre.id=:idC AND e.typeCarton.id=:idCarton AND e.qualite.id=:idQualite ORDER BY id DESC");
		query.setParameter("idE", espece.getId());
		query.setParameter("idC", calibre.getId());
		query.setParameter("idCarton", typeCarton.getId());
		query.setParameter("idQualite", qualite.getId());
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<EspeceDemoulee>) query.list();

	}

	@SuppressWarnings("unchecked")
	public List<EspeceProduite> GetEspeceProduiteByEspeceEtCalibre(Espece espece, Calibre calibre) {
		Query query = getSession().createQuery(
				"SELECT e FROM EspeceProduite e WHERE e.espece.id = :idE AND e.calibre.id=:idC ORDER BY id DESC");
		query.setParameter("idE", espece.getId());
		query.setParameter("idC", calibre.getId());
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<EspeceProduite>) query.list();

	}
	@SuppressWarnings("unchecked")
	public List<EspeceProduite> GetEspeceProduiteById(String Id) {
		Query query = getSession().createQuery(
				"SELECT e FROM EspeceProduite e WHERE e.id = :id");
		query.setParameter("id", Id);
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<EspeceProduite>) query.list();

	}
	@SuppressWarnings("unchecked")
	public List<Stock> GetListStock() {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.afficher = 1 ORDER BY id DESC");
		    return (List<Stock>) query.list();
	}

	
	@SuppressWarnings("unchecked")
	public List<EspeceProduite> listEspeceProduiteByCodeNonRegle(Integer Code) {

		return (List<EspeceProduite>) getSession()
				.createQuery(
						"SELECT e FROM EspeceProduite e WHERE e.production.id= :id order by e.production desc")
				.setParameter("id", Code).list();

	}
	@SuppressWarnings("unchecked")
	public List<EspeceProduite> listEspeceProduiteRegle(Integer Code) {

		return (List<EspeceProduite>) getSession()
				.createQuery(
						"SELECT e FROM EspeceProduite e WHERE e.production.id= :id and e.regle=1 order by e.production desc")
				.setParameter("id", Code).list();

	}

	@SuppressWarnings("unchecked")
	public List<EspeceProduite> listEspeceProduiteByCodeProduction(Integer Code) {

		return (List<EspeceProduite>) getSession()
				.createQuery(
						"SELECT e FROM EspeceProduite e WHERE e.production.id= :id order by e.production desc")
				.setParameter("id", Code).list();

	}

	public String generateCodeDebarquement(String nomNavire, Date date) {
		Format formatter = new SimpleDateFormat("dd/MM/yy");
		String string = formatter.format(date);
		return ""+nomNavire+" DU "+string;
	}

	public Navire GetNavireByNom(String nomNavire) {
		
			Query query = getSession()
					.createQuery("SELECT n FROM Navire n WHERE n.nomNavire = :nomNavire");
			query.setParameter("nomNavire", nomNavire);
			Navire navire = (Navire) query.uniqueResult();
			return navire;
		
	}
	public Client GetClientByPrenomEtNom(String Prenom,String Nom) {
		
		Query query = getSession()
				.createQuery("SELECT c FROM Client c WHERE c.prenomClient = :prenomClient and c.nomClient = :nomClient");
		query.setParameter("prenomClient", Prenom);
		query.setParameter("nomClient", Nom);
		Client client = (Client) query.uniqueResult();
		return client;
	
}
public Chargeur GetChargeurByNomChargeur(String nomChargeur) {
		
		Query query = getSession()
				.createQuery("SELECT c FROM Chargeur c WHERE c.nomChargeur = :nomChargeur");
		query.setParameter("nomChargeur", nomChargeur);
		Chargeur chargeur = (Chargeur) query.uniqueResult();
		return chargeur;
	
}

	@SuppressWarnings("unchecked")
	public List<Navire> GetNavireMax() {
		Query query = getSession().createQuery(
				"SELECT e FROM Navire e ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Navire>) query.list();
	}

	public String generateCodeFournisseur() {
		
			Query query = getSession().createQuery("SELECT MAX(p.id) FROM Fournisseur p");
			Integer max = (Integer) query.uniqueResult();
			if (max == null) {
				return "FOURNISSEUR N°" + "000001";
			}
			return "FOURNISSEUR N°" + new DecimalFormat("000000").format(max + 1);
		
	}

	public Fournisseur GetFourniseurByPrenomEtNom(String prenom, String nom) {
		Query query = getSession().createQuery("SELECT f FROM Fournisseur f WHERE f.prenomFournisseur = :prenomFournisseur and f.nomFournisseur = :nomFournisseur");
		query.setParameter("prenomFournisseur", prenom);
		query.setParameter("nomFournisseur", nom);
		Fournisseur fournisseur = (Fournisseur) query.uniqueResult();
		return fournisseur;
	}

	@SuppressWarnings("unchecked")
	public List<Fournisseur> GetFournisseurMax() {
		Query query = getSession().createQuery(
				"SELECT e FROM Fournisseur e ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Fournisseur>) query.list();
	
	}

	public List<Debarquement> GetDebarquementMax() {
		Query query = getSession().createQuery(
				"SELECT e FROM Debarquement e ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Debarquement>) query.list();
	}

	public CalibreGP GetCalibreGrosPoisson(String nomCalibre) {
		Query query = getSession().createQuery("SELECT c FROM CalibreGP c WHERE c.libelleCalibreGP = :libelleCalibreGP");
		query.setParameter("libelleCalibreGP", nomCalibre);
		return (CalibreGP) query.uniqueResult();
	}

	public List<EspeceDemoulee> GetEspeceGrosPoissonDemoulee(Espece espece, CalibreGP calibreGP, Qualite qualite) {
		Query query = getSession().createQuery("SELECT e FROM EspeceDemoulee e WHERE e.espece.id = :idE AND e.grosPoisson.id=:idC AND e.qualite.id=:idQualite ORDER BY id DESC");
		query.setParameter("idE", espece.getId());
		query.setParameter("idC", calibreGP.getId());
		query.setParameter("idQualite", qualite.getId());
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<EspeceDemoulee>) query.list();
	}

	public List<Stock> GetStockByEspeceGrosPoissonDemoulee(EspeceDemoulee especeDemoulee) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.especeDemoulee.espece.id = :idE AND s.especeDemoulee.grosPoisson.id=:idC AND s.especeDemoulee.qualite.id=:idQualite ORDER BY id DESC");
		query.setParameter("idE", especeDemoulee.getEspece().getId());
		query.setParameter("idC", especeDemoulee.getGrosPoisson().getId());
		query.setParameter("idQualite", especeDemoulee.getQualite().getId());
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Stock>) query.list();
	}

	public Destination GetDestionationByLieu(String Destination) {
		Query query = getSession()
				.createQuery("SELECT d FROM Destination d WHERE d.nomDestination = :nomDestination");
		query.setParameter("nomDestination", Destination);
		Destination destination = (Destination) query.uniqueResult();
		return destination;
	}

	public List<EspeceDemoulee> listEspeceDemouleeByCodeNonRegle(Integer Code) {
		

			return (List<EspeceDemoulee>) getSession()
					.createQuery(
							"SELECT e FROM EspeceDemoulee e WHERE e.debarquement.id= :id and e.regle=0 order by e.debarquement desc")
					.setParameter("id", Code).list();

		
	}

	public EspeceDemoulee GetEspeceDemouleeById(Integer Id) {
		Query query = getSession().createQuery("SELECT e FROM EspeceDemoulee e WHERE e.id = :id");
		query.setParameter("id", Id);
		EspeceDemoulee especeDemoulee = (EspeceDemoulee) query.uniqueResult();
		return especeDemoulee;
	}

	public Debarquement GetDebarquementById(Integer Id) {
		Query query = getSession().createQuery("SELECT d FROM Debarquement d WHERE d.id = :id");
		query.setParameter("id", Id);
		Debarquement debarquement = (Debarquement) query.uniqueResult();
		return debarquement;
	}

	public List<Debarquement> listDebarquementRegle() {
		return (List<Debarquement>) getSession().createQuery("SELECT d FROM Debarquement d WHERE d.regle = 1  order by d.id desc").list();

	}

	@SuppressWarnings("unchecked")
	public List<EspeceDemoulee> listEspeceDemouleRegle(Integer Code) {
		return (List<EspeceDemoulee>) getSession()
				.createQuery(
						"SELECT e FROM EspeceDemoulee e WHERE e.debarquement.id= :id and e.regle=1 order by e.debarquement desc")
				.setParameter("id", Code).list();
	}

	public List<EspeceDemoulee> listEspeceDemoule(Integer Code) {
		return (List<EspeceDemoulee>) getSession()
				.createQuery(
						"SELECT e FROM EspeceDemoulee e WHERE e.debarquement.id= :id order by e.debarquement desc")
				.setParameter("id", Code).list();
	}

	public List<Client> GetClientMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Client c ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Client>) query.list();
	}

	public String generateCodeAchat() {
		Query query = getSession().createQuery("SELECT MAX(a.id) FROM Achat a");
		Integer max = (Integer) query.uniqueResult();
		if (max == null) {
			return "ACHAT" + "000000000001";
		}
		return "ACHAT" + new DecimalFormat("000000000000").format(max + 1);
	}

	
	@SuppressWarnings("unchecked")
	public List<Stock> GetDispoStock(String espece, String calibre, String nbCarton, String qualite) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.especeDemoulee.espece.libelleEspece = :espece AND s.especeDemoulee.calibre.libelleCalibre = :calibre AND s.especeDemoulee.qualite.libelleQualite=:qualite AND s.soldeStock>=:nbCarton ORDER BY id DESC");
		query.setParameter("espece", espece);
		query.setParameter("calibre", calibre);
		query.setParameter("qualite", qualite);
		query.setParameter("nbCarton", Float.parseFloat(nbCarton));
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		return (List<Stock>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Stock> GetActuel(String espece, String calibre, String qualite) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.especeDemoulee.espece.libelleEspece = :espece AND s.especeDemoulee.calibre.libelleCalibre = :calibre AND s.especeDemoulee.qualite.libelleQualite=:qualite ORDER BY s.id DESC");
		query.setParameter("espece", espece);
		query.setParameter("calibre", calibre);
		query.setParameter("qualite", qualite);
		query.setFirstResult(0); 
		query.setMaxResults(1);
		return (List<Stock>) query.list();
	}
	public List<Stock> GetActuelPourModification(String espece, String calibre) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.especeDemoulee.espece.libelleEspece = :espece AND s.especeDemoulee.calibre.libelleCalibre = :calibre ORDER BY s.id DESC");
		query.setParameter("espece", espece);
		query.setParameter("calibre", calibre);
		query.setFirstResult(0); 
		query.setMaxResults(1);
		return (List<Stock>) query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Stock> GetDispoStockGrosPoisson(String espece, String poids, String qualite) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE s.especeDemoulee.espece.libelleEspece = :espece AND s.especeDemoulee.grosPoisson.libelleCalibreGP = :calibre AND s.especeDemoulee.qualite.libelleQualite=:qualite AND s.soldeStock>=:poids ORDER BY id DESC");
		query.setParameter("espece", espece);
		query.setParameter("calibre", "GROS POISSON");
		query.setParameter("poids", Float.parseFloat(poids));
		query.setParameter("qualite", qualite);
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		return (List<Stock>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Stock> GetActuelGrosPoisson(String espece, String qualite) {
		Query query = getSession().createQuery("SELECT s FROM Stock s WHERE  s.especeDemoulee.espece.libelleEspece = :espece AND s.especeDemoulee.grosPoisson.libelleCalibreGP = :calibre AND s.especeDemoulee.qualite.libelleQualite=:qualite  ORDER BY id DESC");
		query.setParameter("espece", espece);
		query.setParameter("calibre", "GROS POISSON");
		query.setParameter("qualite", qualite);
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		return (List<Stock>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Achat> GetAchatMax() {
		Query query = getSession().createQuery(
				"SELECT a FROM Achat a ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Achat>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Achat> listVenteLocaleNonRegle() {
		return (List<Achat>) getSession().createQuery("SELECT a FROM Achat a WHERE a.regle = 0").list();

	}

	@SuppressWarnings("unchecked")
	public List<EscepeDemouleeAchetee> listEspeceDemouleeAcheteByCodeNonRegle(Integer Code) {

		return (List<EscepeDemouleeAchetee>) getSession()
				.createQuery(
						"SELECT e FROM EscepeDemouleeAchetee e WHERE e.achat.id = :id order by e.achat desc")
				.setParameter("id", Code).list();

	
	}
	@SuppressWarnings("unchecked")
	public List<EspeceDebarqueeTransportees> listEspeceDebarqueeTransporteesByCodeNonRegle(Integer Code) {

		return (List<EspeceDebarqueeTransportees>) getSession()
				.createQuery(
						"SELECT e FROM EspeceDebarqueeTransportees e WHERE e.exportation.id = :id order by e.exportation desc")
				.setParameter("id", Code).list();

	
	}
	@SuppressWarnings("unchecked")
	public List<EspeceDebarqueeTransportees> listEspeceDebarqueeTransporteesByCodePourConsulterExportation(Integer Code) {
		return (List<EspeceDebarqueeTransportees>) getSession()
				.createQuery(
						"SELECT e FROM EspeceDebarqueeTransportees e WHERE e.exportation.id = :id order by e.exportation desc")
				.setParameter("id", Code).list();

	
	}
	
	public EscepeDemouleeAchetee GetEspeceDemouleeAcheteById(Integer Id) {
		Query query = getSession().createQuery("SELECT e FROM EscepeDemouleeAchetee e WHERE e.id = :id");
		query.setParameter("id", Id);
		EscepeDemouleeAchetee especeDemoulee = (EscepeDemouleeAchetee) query.uniqueResult();
		return especeDemoulee;
	}
	
	public EspeceDemoulee GetEspeceDemouleeByEspeceCalibreEtTypeCarton(Espece espece, Calibre calibre,TypeCarton typeCarton) {
		Query query = getSession().createQuery("SELECT e FROM EspeceDemoulee e WHERE e.espece.id = :idEspece AND e.calibre.id = :idCalibre AND e.typeCarton.id = :idtypeCarton ORDER BY id DESC");
		query.setParameter("idEspece", espece.getId());
		query.setParameter("idCalibre", calibre.getId());
		query.setParameter("idtypeCarton", typeCarton.getId());
		EspeceDemoulee EscepeDemoulee = (EspeceDemoulee) query.uniqueResult();
		return EscepeDemoulee;
	}
	public EspeceDebarqueeTransportees GetEspeceTransporteesAcheteById(Integer Id) {
		Query query = getSession().createQuery("SELECT e FROM EspeceDebarqueeTransportees e WHERE e.id = :id");
		query.setParameter("id", Id);
		EspeceDebarqueeTransportees EspeceDebarqueeTransportees = (EspeceDebarqueeTransportees) query.uniqueResult();
		return EspeceDebarqueeTransportees;
	}

	public Achat GetAchatById(Integer Id) {
		Query query = getSession().createQuery("SELECT a FROM Achat a WHERE a.id = :id");
		query.setParameter("id", Id);
		Achat especeDemoulee = (Achat) query.uniqueResult();
		return especeDemoulee;
	}
	public Exportation GetExportationById(Integer Id) {
		Query query = getSession().createQuery("SELECT e FROM Exportation e WHERE e.id = :id");
		query.setParameter("id", Id);
		Exportation Exportation = (Exportation) query.uniqueResult();
		return Exportation;
	}

	public List<Achat> listVenteLocaleRegle() {
		return (List<Achat>) getSession().createQuery("SELECT a FROM Achat a WHERE a.regle = 1 order by a.id desc").list();
	}

	public List<EscepeDemouleeAchetee> listEspeceDemouleeAcheteByCodeRegle(Integer Code) {
		return (List<EscepeDemouleeAchetee>) getSession()
				.createQuery(
						"SELECT e FROM EscepeDemouleeAchetee e WHERE e.achat.id = :id order by e.achat desc")
				.setParameter("id", Code).list();
	}

	@SuppressWarnings("unchecked")
	public List<Achat> listTousLesVenteLocales() {
		return (List<Achat>) getSession().createQuery("SELECT a FROM Achat a order by a.id desc").list();
	}

	@SuppressWarnings("unchecked")
	public List<Chargeur> GetChargeurMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Chargeur c ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Chargeur>) query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Container> GetContainerMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Container c ORDER BY id DESC");
		query.setFirstResult(0); 
		query.setMaxResults(1);
		    return (List<Container>) query.list();
	}

	public Origine GetOrigineByNomOrigine(String nomOrigine) {
		Query query = getSession()
				.createQuery("SELECT o FROM Origine o WHERE o.nomOrigine = :nomOrigine");
		query.setParameter("nomOrigine", nomOrigine);
		Origine origine = (Origine) query.uniqueResult();
		return origine;
	}

	@SuppressWarnings("unchecked")
	public List<Origine> GetOrigineMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Origine c ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Origine>) query.list();
	}

	public Pays GetPaysDestinataireByNom(String paysDestination) {
		Query query = getSession()
				.createQuery("SELECT p FROM Pays p WHERE p.pays = :pays");
		query.setParameter("pays", paysDestination);
		Pays Pays = (Pays) query.uniqueResult();
		return Pays;
	}

	@SuppressWarnings("unchecked")
	public List<Pays> GetPaysDestinataireMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Pays c ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Pays>) query.list();
	}

	public Destinataire GetDestinataireByPrenomEtNomEtAdresse(String PrenomDestinataire, String NomDestinataire,String adresseDestinataire) {
		Query query = getSession()
				.createQuery("SELECT d FROM Destinataire d WHERE d.prenomDestinataire = :prenomDestinataire AND d.nomDestinataire = :nomDestinataire AND d.adresseDestinataire = :adresseDestinataire");
		query.setParameter("prenomDestinataire", PrenomDestinataire);
		query.setParameter("nomDestinataire", NomDestinataire);
		query.setParameter("adresseDestinataire", adresseDestinataire);
		Destinataire Destinataire = (Destinataire) query.uniqueResult();
		return Destinataire;
	}

	@SuppressWarnings("unchecked")
	public List<Destinataire> GetDestinataireMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Destinataire c ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Destinataire>) query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Exportation> GetExportationMax() {
		Query query = getSession().createQuery(
				"SELECT c FROM Exportation c ORDER BY id DESC");
		query.setFirstResult(0); // modify this to adjust paging
		query.setMaxResults(1);
		    return (List<Exportation>) query.list();
	}

	public Container GetContainerByNumContainerEtNumPlombs(String NumContainer, String NumPlombs) {
			Query query = getSession()
					.createQuery("SELECT c FROM Container c WHERE c.numeroContaineur = :numeroContaineur AND c.numeroPlombs = :numeroPlombs");
			query.setParameter("numeroContaineur", NumContainer);
			query.setParameter("numeroPlombs", NumPlombs);
			Container Container = (Container) query.uniqueResult();
			return Container;
		
	}

	@SuppressWarnings("unchecked")
	public List<Exportation> listExportationNonRegle() {
		return (List<Exportation>) getSession().createQuery("SELECT e FROM Exportation e WHERE e.regle = 0 order by e.id desc").list();

	}
	@SuppressWarnings("unchecked")
	public List<Exportation> listExportationAConsulter() {
		return (List<Exportation>) getSession().createQuery("SELECT e FROM Exportation e order by e.id desc").list();

	}

	@SuppressWarnings("unchecked")
	public List<Exportation> listExportationRegle() {
		return (List<Exportation>) getSession().createQuery("SELECT e FROM Exportation e WHERE e.regle =1 order by e.id desc").list();
	}

	public Production GetProductionById(String Id) {
		Query query = getSession().createQuery("SELECT p FROM Production p WHERE p.id = :id");
		query.setParameter("id", Integer.parseInt(Id));
		Production production = (Production) query.uniqueResult();
		return production;
	}
	public String generateNumeroFactureProduction() {
		
		return "";
		
	}
	public String genererFactureProduction() {
		Date date = new Date();
		String codeFacture;
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String annee=sdf.format(date);
		Production production=GetProductionMaximalRegle();
		if(production==null){
			return codeFacture="N°" + "000007"+"/"+annee;
		}
		else if (production.getCodeFacture()==null)
			return codeFacture="N°" + "000007"+"/"+annee;
		String Facture=production.getCodeFacture();
		String []tableau=Facture.split("/");
		String codeAncienFacture=tableau[0];
		String chiffreDeFacture=tableau[1];
		String []tableaudeNum=codeAncienFacture.split("°");
		String codeAncienFactureSansNum=tableaudeNum[1];
		int codeAncienFactureEnEntier=Integer.parseInt(codeAncienFactureSansNum);
		codeFacture= "N°" + new DecimalFormat("000000").format(codeAncienFactureEnEntier + 7);
		int anFacture=Integer.parseInt(chiffreDeFacture);
		int anCourant=Integer.parseInt(annee);
		if(anCourant>anFacture){
			codeFacture="N°" + "000007";
		}
		codeFacture=codeFacture+"/"+annee;
		System.out.println(codeFacture);
		return codeFacture;
	}

	public String genererFactureVenteLocale() {
		Date date = new Date();
		String codeFacture;
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String annee=sdf.format(date);
		Achat achat=GetVenteLocaleMaximalRegle();
		if(achat==null){
			return codeFacture="N°" + "000007"+"/"+annee;
		}else if ( achat.getCodeFacture()==null)
			return codeFacture="N°" + "000007"+"/"+annee;
		String Facture=achat.getCodeFacture();
		String []tableau=Facture.split("/");
		String codeAncienFacture=tableau[0];
		String chiffreDeFacture=tableau[1];
		String []tableaudeNum=codeAncienFacture.split("°");
		String codeAncienFactureSansNum=tableaudeNum[1];
		int codeAncienFactureEnEntier=Integer.parseInt(codeAncienFactureSansNum);
		codeFacture= "N°" + new DecimalFormat("000000").format(codeAncienFactureEnEntier + 7);
		int anFacture=Integer.parseInt(chiffreDeFacture);
		int anCourant=Integer.parseInt(annee);
		if(anCourant>anFacture){
			codeFacture="N°" + "000007";
		}
		codeFacture=codeFacture+"/"+annee;
		System.out.println(codeFacture);
		return codeFacture;
	}

	public List<TypeContainer> ListTypeContainer() {
		@SuppressWarnings("unchecked")
		List<TypeContainer> list = (List<TypeContainer>) getSession().createQuery("SELECT t FROM TypeContainer t").list();
		return list;
	}

	public TypeContainer GetTypeContainerByNom(String nomTypeContainer) {
		Query query = getSession().createQuery("SELECT t FROM TypeContainer t WHERE t.nomTyepcontainer = :nomTyepcontainer");
		query.setParameter("nomTyepcontainer", nomTypeContainer);
		return (TypeContainer) query.uniqueResult();
	}

	public String genererFactureExportation() {
		Date date = new Date();
		String codeFacture;
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String annee=sdf.format(date);
		Exportation exportation=GetExportationMaximalRegle();
		if(exportation==null  ){
			return codeFacture="N°" + "000007"+"/"+annee;
		}
		else if ( exportation.getCodeFacture()==null)
			return codeFacture="N°" + "000007"+"/"+annee;
		String Facture=exportation.getCodeFacture();
		String []tableau=Facture.split("/");
		String codeAncienFacture=tableau[0];
		String chiffreDeFacture=tableau[1];
		String []tableaudeNum=codeAncienFacture.split("°");
		String codeAncienFactureSansNum=tableaudeNum[1];
		int codeAncienFactureEnEntier=Integer.parseInt(codeAncienFactureSansNum);
		codeFacture= "N°" + new DecimalFormat("000000").format(codeAncienFactureEnEntier + 7);
		int anFacture=Integer.parseInt(chiffreDeFacture);
		int anCourant=Integer.parseInt(annee);
		if(anCourant>anFacture){
			codeFacture="N°" + "000007";
		}
		codeFacture=codeFacture+"/"+annee;
		System.out.println(codeFacture);
		return codeFacture;
	}

	public Exportation GetExportationMaximalRegle() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Exportation p where p.regle=1");
		Integer id = (Integer) query.uniqueResult();
		query = getSession().createQuery("FROM Exportation p WHERE p.id = :id");
		query.setParameter("id", id);
		Exportation exportation = (Exportation) query.uniqueResult();
		return exportation;
	}

	

	
}
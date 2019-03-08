package importexport.dao;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.taglibs.standard.tag.common.fmt.FormatDateSupport;
import org.apache.taglibs.standard.tag.el.fmt.FormatDateTag;
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
public class MesImplementations implements MesInterfaces {

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
		Query query = getSession().createQuery(
				"SELECT m FROM Marayeur m WHERE m.prenomMarayeur = :prenomMarayeur "
				+ "and m.nomMarayeur = :nomMarayeur");
		query.setParameter("prenomMarayeur", Prenom);
		query.setParameter("nomMarayeur", Nom);
		Marayeur marayeur= (Marayeur) query.uniqueResult();
		return marayeur;

	}

	public Production GetProductionMaximal() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Production p");
		Integer id=(Integer) query.uniqueResult();
		 query = getSession().createQuery("FROM Production p WHERE p.id = :id");
		query.setParameter("id", id);
		Production production =(Production) query.uniqueResult();
		 return production;
	}

	public Vehicule GetVehiculeMaximal() {
		Query query = getSession().createQuery("SELECT MAX(p.id) FROM Vehicule p");
		Integer id=(Integer) query.uniqueResult();
		query = getSession().createQuery("FROM Vehicule p WHERE p.id = :id");
		query.setParameter("id", id);
		Vehicule vehicule= (Vehicule) query.uniqueResult();
		 return vehicule;
	}

	@SuppressWarnings("unchecked")
	public List<Production> listProduction() {
		return (List<Production>) getSession().createQuery("FROM Production as p order by p.id desc").list();
		
		
	}

	public Vehicule GetVehiculeByMatricule(String Immatricule) {
		Query query = getSession().createQuery("SELECT v FROM Vehicule v WHERE v.numImmatriculation = :numImmatriculation");
		query.setParameter("numImmatriculation", Immatricule);
		Vehicule vehicule= (Vehicule) query.uniqueResult();
		 return vehicule;
	}

	public Marayeur MarayeurByCIN(String CIN) {
		
				Query query = getSession().createQuery(
						"SELECT m FROM Marayeur m WHERE m.cinMarayeur = :cinMarayeur");
				query.setParameter("cinMarayeur", CIN);
				Marayeur marayeur= (Marayeur) query.uniqueResult();
				return marayeur;
	}

	
	@SuppressWarnings("unchecked")
	public List<EspeceProduite> listEspeceProduiteByCode(Integer Code) {
		
		return (List<EspeceProduite>) getSession().createQuery("SELECT e FROM EspeceProduite e WHERE e.production.id= :id and e.demoule=0 order by e.production desc")
		.setParameter("id", Code)
		.list();
	
	}	
	
	
}
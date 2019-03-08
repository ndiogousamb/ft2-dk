package importexport.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import importexport.dao.IContainer;
import importexport.dao.IDebarquement;
import importexport.dao.IDestination;
import importexport.dao.IEspeceDebarqueTransp;
import importexport.dao.IEspeceDemoulee;
import importexport.dao.IFournisseur;
import importexport.dao.INavire;
import importexport.dao.IStock;
import importexport.dao.IUsers;
import importexport.dao.IVehicule;
import importexport.dao.MonInterface;
import importexport.model.*;

@Controller
@RequestMapping("/debarquement")
public class DebarquementController {
	@Autowired
	private IUsers iUser;
	@Autowired
	private INavire in;
	@Autowired
	private IDebarquement id;
	@Autowired
	private IEspeceDemoulee ied;
	@Autowired
	private IFournisseur ifournisseur;
	@Autowired
	public IStock is;
	@Autowired
	public IVehicule iv;
	@Autowired
	public IDestination idest;
	@Autowired
	public IContainer icont;
	@Autowired
	public IEspeceDebarqueTransp iedTransp;
	@Autowired
	ServletContext context;
	@Autowired
	public MonInterface mi;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String MenuDebarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuDebarquement";
	}

	@RequestMapping(value = "/addDebarquement", method = RequestMethod.GET)
	public String addDebarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "AddDebarquement";
	}

	@RequestMapping(value = "/listEspeces", method = RequestMethod.GET)
	public @ResponseBody List<Espece> listEspeces() {
		List<Espece> lE = mi.ListEspeces();
		return lE;
	}

	@RequestMapping(value = "/listCalibres", method = RequestMethod.GET)
	public @ResponseBody List<Calibre> lisCalibres() {
		List<Calibre> lC = mi.ListCalibres();
		return lC;
	}

	@RequestMapping(value = "/listCartons", method = RequestMethod.GET)
	public @ResponseBody List<TypeCarton> listCartons() {
		List<TypeCarton> lC = mi.ListTypeCarton();
		return lC;
	}

	@RequestMapping(value = "/listQualites", method = RequestMethod.GET)
	public @ResponseBody List<Qualite> listQualites() {
		List<Qualite> lC = mi.ListQualites();
		return lC;
	}
	@RequestMapping(value = "/listTousLesDebarquement", method = RequestMethod.GET)
	public @ResponseBody List<Debarquement> listTousLesDebarquement() {
		List<Debarquement> lC = mi.ListDebarquement();
		return lC;
	}
	
	@RequestMapping(value = "/ListeDebarquement", method = RequestMethod.GET)
	public String ListeDebarquement(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=iUser.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "ListeDebarquement";
	}
	@RequestMapping(value = "/GetDebarquement", method = RequestMethod.GET)
	public String GetDebarquement(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=iUser.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "GetDebarquement";
	}
	@RequestMapping(value = "/verifierNavire", method = RequestMethod.GET)
	public @ResponseBody Object verifierNavire(@RequestParam("Navire") String Navire) {
		Navire navire = mi.GetNavireByNom(Navire);
		if (navire != null)
			return navire;
		return new Navire(0);

	}
	
	@RequestMapping(value = "/EspeceDemoulePourConsulter", method = RequestMethod.GET)
	public @ResponseBody List<EspeceDemoulee> EspeceDemouleReglePourFacturation(@RequestParam("Code") String Code) {
		List<EspeceDemoulee> lC = mi.listEspeceDemoule(Integer.parseInt(Code));
		return lC;
	}
	@RequestMapping(value = "/saveDebarquement", method = RequestMethod.GET)
	public @ResponseBody Object saveDebarquement(@RequestParam("Navire") String nomNavire,
			@RequestParam("PrenomFournisseur") String prenomFournisseur,
			@RequestParam("NomFournisseur") String nomFournisseur, @RequestParam("DateDebarq") String dateDebarquement,
			@RequestParam("Manifeste") String manifeste, @RequestParam(value = "lesElements") String[] items) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);

		Calibre calibre = null;
		Espece espece = null;
		TypeCarton typecarton = null;
		Navire navire = null;
		Fournisseur fournisseur = null;
		Qualite qualite = null;
		CalibreGP grospoisson = null;

		Debarquement debarquement = null;

		try {
			navire = mi.GetNavireByNom(nomNavire);
			if (navire == null) {
				navire = new Navire();
				navire.setNomNavire(nomNavire);
				in.AddNavire(navire);
				List<Navire> listNavire = mi.GetNavireMax();
				if (listNavire.isEmpty() == false)
					for (Navire temp : listNavire) {
						navire = temp;
					}
			}
			fournisseur = mi.GetFourniseurByPrenomEtNom(prenomFournisseur, nomFournisseur);
			if (fournisseur == null) {
				fournisseur = new Fournisseur();
				fournisseur.setCodeFournisseur(mi.generateCodeFournisseur());
				fournisseur.setNomFournisseur(nomFournisseur);
				fournisseur.setPrenomFournisseur(prenomFournisseur);
				ifournisseur.AddFournisseur(fournisseur);
				List<Fournisseur> listFournisseur = mi.GetFournisseurMax();
				if (listFournisseur.isEmpty() == false)
					for (Fournisseur temp : listFournisseur) {
						fournisseur = temp;
					}
			}
			debarquement = new Debarquement();
			debarquement.setDateDebarquement(mi.formatDate(dateDebarquement));
			debarquement.setCodeDebarquement(mi.generateCodeDebarquement(nomNavire, mi.formatDate(dateDebarquement)));
			debarquement.setNavire(navire);
			debarquement.setFournisseur(fournisseur);
			debarquement.setNumeroManifeste(manifeste);
			debarquement.setUtilisateur(utilisateur);
			id.addDebarquement(debarquement);
			List<Debarquement> listDebarquement = mi.GetDebarquementMax();
			if (listDebarquement.isEmpty() == false)
				for (Debarquement temp : listDebarquement) {
					debarquement = temp;
				}

			for (int i = 0; i < items.length; i++) {
				if (i != items.length - 1)
					items[i] = items[i] + ',';

			}
			String tab = null;
			for (int i = 0; i < items.length; i++) {
				if (i == 0)
					tab = "[";
				tab = tab + items[i];
				if (i == items.length - 1)
					tab = tab + "]";
			}
			System.out.println(tab);

			JSONArray jsonArray = new JSONArray(tab);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				EspeceDemoulee especeDemoulee = new EspeceDemoulee();
				float poids = (object.getInt(("poids")));
				float nombreCarton;
				espece = mi.GetEspeceByNom(object.getString("espece"));
				if (object.getString("calibre").equals("GROS POISSON")) {
					grospoisson = mi.GetCalibreGrosPoisson(object.getString("calibre"));
					especeDemoulee.setGrosPoisson(grospoisson);
					nombreCarton = poids;
					especeDemoulee.setCodeEspecedemoulee(espece.getCodeEspece() + grospoisson.getLibelleCalibreGP()
							+ debarquement.getCodeDebarquement());
				} else {
					calibre = mi.GetCalibreByNom(object.getString("calibre"));
					especeDemoulee.setCalibre(calibre);
					nombreCarton = Float.parseFloat(object.getString("nbCarton"));
					typecarton = mi.GetTypeCartonByLibelle(object.getString("typecarton"));
					especeDemoulee.setCodeEspecedemoulee(
							espece.getCodeEspece() + calibre.getCodeCalibre() + debarquement.getCodeDebarquement());
					especeDemoulee.setTypeCarton(typecarton);
					especeDemoulee.setNombre(nombreCarton);
				}

				qualite = mi.GetQualiteByNom(object.getString("qualite"));
				especeDemoulee.setEspece(espece);
				especeDemoulee.setPoids(poids);
				especeDemoulee.setAfficher(1);
				especeDemoulee.setQualite(qualite);
				especeDemoulee.setDebarquement(debarquement);
				especeDemoulee.setUtilisateur(utilisateur);
				List<EspeceDemoulee> list = null;
				if (object.getString("calibre").equals("GROS POISSON")) {
					list = mi.GetEspeceGrosPoissonDemoulee(espece, grospoisson, qualite);
				} else {
					list = mi.GetEspeceDemoulee(espece, calibre, typecarton, qualite);
				}
				if (list.isEmpty() == false)
					for (EspeceDemoulee temp : list) {
						EspeceDemoulee eDemouleeAnePlusAfficher = temp;
						eDemouleeAnePlusAfficher.setAfficher(0);
						ied.UpdateDemoulage(eDemouleeAnePlusAfficher);
					}
				ied.AddDemoulage(especeDemoulee);
				especeDemoulee = mi.GetEspeceDemouleeMax();
				Stock ancienStock = null;
				Stock stock = new Stock();
				List<Stock> liststock = null;
				if (object.getString("calibre").equals("GROS POISSON")) {
					liststock = mi.GetStockByEspeceGrosPoissonDemoulee(especeDemoulee);
				} else {
					liststock = mi.GetStockByEspeceDemoulee(especeDemoulee);
				}
				if (liststock.isEmpty() == false)
					for (Stock temp : liststock) {
						ancienStock = temp;
					}
				if (ancienStock != null) {
					stock.setSoldeAvant(ancienStock.getSoldeStock());
					stock.setSoldeStock(ancienStock.getSoldeStock() + nombreCarton);
				} else {
					stock.setSoldeStock(nombreCarton);
					stock.setSoldeAvant(0);
				}
				stock.setEspeceDemoulee(especeDemoulee);
				stock.setDate(new Date());
				stock.setNombre(nombreCarton);
				stock.setAfficher(1);
				is.AddStock(stock);
				if(ancienStock!=null){
					ancienStock.setAfficher(0);
					is.UpdateStock(ancienStock);
				}
				Vehicule vehicule = null;
				Destination destination = null;
				Container container=null;
				EspeceDebarqueeTransportees debarqueeTransportees = new EspeceDebarqueeTransportees();
				if (object.has("Immatricule")) {
					vehicule = mi.GetVehiculeByMatricule(object.getString("Immatricule"));
					if (vehicule == null) {
						vehicule = new Vehicule();
						vehicule.setNumImmatriculation(object.getString("Immatricule"));
						iv.addVehicule(vehicule);
						vehicule = mi.GetVehiculeByMatricule(object.getString("Immatricule"));
					}
					debarqueeTransportees.setVehicule(vehicule);
				}else{
					container = mi.GetContainerByNumContainer((object.getString("NumContainer")));
					if (container == null) {
						container = new Container();
						container.setNumeroContaineur((object.getString("NumContainer")));
						container.setNumeroPlombs((object.getString("NumPlombs")));
						icont.addContainer(container);
						container = mi.GetContainerByNumContainer((object.getString("NumContainer")));
					}
						debarqueeTransportees.setContainer(container);
				}
				debarqueeTransportees.setEspeceDemoulee(especeDemoulee);
				debarqueeTransportees.setNombreTransporte(Float.parseFloat(object.getString("NbTransporter")));
				destination = mi.GetDestionationByLieu(object.getString("Destination"));
				if (destination == null) {
					destination = new Destination();
					destination.setNomDestination(object.getString("Destination"));
					idest.addDestination(destination);
					destination = mi.GetDestionationByLieu(object.getString("Destination"));
				}
				debarqueeTransportees.setDestination(destination);
				iedTransp.AddEspeceDebarqueTransp(debarqueeTransportees);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return debarquement;
	}
	
}

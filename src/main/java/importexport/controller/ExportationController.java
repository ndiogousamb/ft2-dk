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

import importexport.dao.*;
import importexport.model.*;

@Controller
@RequestMapping("/exportation")
public class ExportationController {
	@Autowired
	ServletContext context;
	@Autowired
	public MonInterface mi;
	@Autowired
	private IUsers iUser;
	@Autowired
	private IChargeur ichargeur;
	@Autowired
	private IDestination idest;
	@Autowired
	private IOrigine iorigine;
	@Autowired
	private IDestinataire idestinataire;
	@Autowired
	private IPays ipays;
	@Autowired
	private IContainer icontainer;
	@Autowired
	public IStock is;
	@Autowired
	public IExportation iexportation;
	@Autowired
	public IEspeceDebarqueTransp iespecedebTrans;
	

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String MenuDebarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuExportation";
	}
	@RequestMapping(value = "/EspeceTransporteExportation", method = RequestMethod.GET)
	public @ResponseBody List<EspeceDebarqueeTransportees> EspeceTransportePourReglerFactureExportation(
			@RequestParam("Code") String Code) {
		List<EspeceDebarqueeTransportees> lC = mi.listEspeceDebarqueeTransporteesByCodePourConsulterExportation(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/addExportation", method = RequestMethod.GET)
	public String addExportation(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "addExportation";
	}

	@RequestMapping(value = "/listEspeces", method = RequestMethod.GET)
	public @ResponseBody List<Espece> listEspeces() {
		List<Espece> lE = mi.ListEspeces();
		return lE;
	}
	@RequestMapping(value = "/GetSoldeActuel", method = RequestMethod.GET)
	public @ResponseBody Object GetSoldeActuel(
			@RequestParam("espece") String espece,
			@RequestParam("calibre") String calibre, 
			@RequestParam("qualite") String qualite) {
		Stock stock = null;
		List<Stock> list = mi.GetActuel(espece, calibre, qualite);
		if (list.isEmpty() == false)
			for (Stock temp : list) {
				stock = temp;
				return stock;
			}
		return new Stock(0);

	}

	@RequestMapping(value = "/listCalibres", method = RequestMethod.GET)
	public @ResponseBody List<Calibre> lisCalibres() {
		List<Calibre> lC = mi.ListCalibres();
		return lC;
	}
	@RequestMapping(value = "/listTypeContainer", method = RequestMethod.GET)
	public @ResponseBody List<TypeContainer> listTypeContainer() {
		List<TypeContainer> lC = mi.ListTypeContainer();
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
	@RequestMapping(value = "/GetSoldeActuelGrosPoisson", method = RequestMethod.GET)
	public @ResponseBody Object GetSoldeActuelGrosPoisson(@RequestParam("espece") String espece,
			@RequestParam("qualite") String qualite) {
		Stock stock = null;
		List<Stock> list = mi.GetActuelGrosPoisson(espece, qualite);
		if (list.isEmpty() == false)
			for (Stock temp : list) {
				stock = temp;
				return stock;
			}

		return new Stock(0);

	}

	@RequestMapping(value = "/VerifierDispoStock", method = RequestMethod.GET)
	public @ResponseBody Object verifierDispoStock(@RequestParam("espece") String espece,
			@RequestParam("calibre") String calibre, @RequestParam("nbCarton") String nbCarton,
			@RequestParam("qualite") String qualite) {
		Stock stock = null;
		List<Stock> list = mi.GetDispoStock(espece, calibre, nbCarton, qualite);

		if (list.isEmpty() == false)
			for (Stock temp : list) {
				stock = temp;
				return stock;
			}

		return new Stock(0);

	}

	@RequestMapping(value = "/VerifierDispoStockGrosPoisson", method = RequestMethod.GET)
	public @ResponseBody Object VerifierDispoStockGrosPoisson(@RequestParam("espece") String espece,
			@RequestParam("poids") String poids, @RequestParam("qualite") String qualite) {
		Stock stock = null;
		List<Stock> list = mi.GetDispoStockGrosPoisson(espece, poids, qualite);
		if (list.isEmpty() == false)
			for (Stock temp : list) {
				stock = temp;
				return stock;
			}

		return new Stock(0);

	}
	@RequestMapping(value = "/ListeExportationAConsulter", method = RequestMethod.GET)
	public String ListeFacturationVenteLocaleAConsulter(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeExportationAConsulter";
	}
	@RequestMapping(value = "/GetExportation", method = RequestMethod.GET)
	public String GetExportation(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetExportation";
	}
	@RequestMapping(value = "/getListExportationAConsulter", method = RequestMethod.GET)
	public @ResponseBody List<Exportation> getListExportationAConsulter() {
		List<Exportation> lp = mi.listExportationAConsulter();
		return lp;
	}
	@RequestMapping(value = "/saveExportation", method = RequestMethod.GET)
	public @ResponseBody Object saveVenteLocale(@RequestParam("PrenomDestinataire") String PrenomDestinataire,
			@RequestParam("NomDestinataire") String NomDestinataire,
			@RequestParam("paysDestination") String paysDestination,
			@RequestParam("ChargeurExportation") String ChargeurExportation,
			@RequestParam("AdresseDestinataire") String AdresseDestinataire,
			@RequestParam("paysOrigine") String paysOrigine, @RequestParam("DateExportation") String DateExportation,
			@RequestParam(value = "lesElementsExp") String[] items) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);

		Calibre calibre = null;
		Espece espece = null;
		TypeCarton typecarton = null;
		Qualite qualite = null;
		CalibreGP grospoisson = null;
		Chargeur chargeur = null;
		Origine origine = null;
		Pays pays = null;
		Destinataire destinataire = null;
		Container container = null;
		TypeContainer typecontainer = null;
		Exportation exportation = new Exportation();
		try {
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
			chargeur = mi.GetChargeurByNomChargeur(ChargeurExportation);
			if (chargeur == null) {
				chargeur = new Chargeur();
				chargeur.setNomChargeur(ChargeurExportation);
				ichargeur.AddChargeur(chargeur);
				List<Chargeur> list = mi.GetChargeurMax();
				if (list.isEmpty() == false)
					for (Chargeur temp : list) {
						chargeur = temp;
					}
			}
			origine = mi.GetOrigineByNomOrigine(paysOrigine);
			if (origine == null) {
				origine = new Origine();
				origine.setNomOrigine(paysOrigine);
				iorigine.AddOrigine(origine);
				List<Origine> list = mi.GetOrigineMax();
				if (list.isEmpty() == false)
					for (Origine temp : list) {
						origine = temp;
					}
			}
			pays = mi.GetPaysDestinataireByNom(paysDestination);
			if (pays == null) {
				pays = new Pays();
				pays.setPays(paysDestination);
				ipays.AddPays(pays);
				List<Pays> list = mi.GetPaysDestinataireMax();
				if (list.isEmpty() == false)
					for (Pays temp : list) {
						pays = temp;
					}
			}
			pays = mi.GetPaysDestinataireByNom(paysDestination);
			if (pays == null) {
				pays = new Pays();
				pays.setPays(paysDestination);
				ipays.AddPays(pays);
				List<Pays> list = mi.GetPaysDestinataireMax();
				if (list.isEmpty() == false)
					for (Pays temp : list) {
						pays = temp;
					}
			}
			destinataire = mi.GetDestinataireByPrenomEtNomEtAdresse(PrenomDestinataire, NomDestinataire, AdresseDestinataire);
			if (destinataire == null) {
				destinataire = new Destinataire();
				destinataire.setPrenomDestinataire(PrenomDestinataire);
				destinataire.setNomDestinataire(NomDestinataire);
				destinataire.setAdresseDestinataire(AdresseDestinataire);
				idestinataire.addDestinataire(destinataire);
				List<Destinataire> list = mi.GetDestinataireMax();
				if (list.isEmpty() == false)
					for (Destinataire temp : list) {
						destinataire = temp;
					}
			}
			exportation.setChargeur(chargeur);
			exportation.setCodeExportation(mi.generateCodeExportation());
			exportation.setDestinataire(destinataire);
			exportation.setPays(pays);
			exportation.setOrigine(origine);
			exportation.setDateExportation(mi.formatDate(DateExportation));
			exportation.setUtilisateur(utilisateur);
			exportation.setRegle(0);
			iexportation.AddExportation(exportation);
			List<Exportation> listexportation = mi.GetExportationMax();
			if (listexportation.isEmpty() == false)
				for (Exportation temp : listexportation) {
					exportation = temp;
				}
			JSONArray jsonArray = new JSONArray(tab);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				EspeceDemoulee especeDemoulee = null;
				EspeceDebarqueeTransportees EspeceDebarqueeTransportees = new EspeceDebarqueeTransportees();
				Stock stock = new Stock();
				Stock ancienStock = null;
				float poids = (object.getInt(("poids")));
				float nombreCarton;
				float nbCarton = 0;
				espece = mi.GetEspeceByNom(object.getString("espece"));
				qualite = mi.GetQualiteByNom(object.getString("qualite"));
				List<EspeceDemoulee> list = null;
				List<Stock> liststock = null;
				if (object.getString("calibre").equals("GROS POISSON")) {
					grospoisson = mi.GetCalibreGrosPoisson(object.getString("calibre"));
					nombreCarton = -1 * poids;
					list = mi.GetEspeceGrosPoissonDemoulee(espece, grospoisson, qualite);
					if (list.isEmpty() == false)
						for (EspeceDemoulee temp : list) {
							especeDemoulee = temp;
						}
					liststock = mi.GetStockByEspeceGrosPoissonDemoulee(especeDemoulee);
					if (liststock.isEmpty() == false)
						for (Stock temp : liststock) {
							ancienStock = temp;
						}
					stock.setSoldeAvant(ancienStock.getSoldeStock());
					stock.setSoldeStock(ancienStock.getSoldeStock() - poids);
					stock.setEspeceDemoulee(especeDemoulee);
					stock.setDate(new Date());
					stock.setNombre(nombreCarton);
					stock.setAfficher(1);
					 is.AddStock(stock);
					 if(ancienStock!=null){
							ancienStock.setAfficher(0);
							is.UpdateStock(ancienStock);
						}
					 EspeceDebarqueeTransportees.setNombreTransporte(poids);
				} else {
					calibre = mi.GetCalibreByNom(object.getString("calibre"));
					nbCarton = Float.parseFloat(object.getString("nbCarton"));
					EspeceDebarqueeTransportees.setNombreTransporte(nbCarton);
					nombreCarton = Float.parseFloat(object.getString("nbCarton"));
					nombreCarton = -1 * nombreCarton;
					typecarton = mi.GetTypeCartonByLibelle(object.getString("typecarton"));
					list = mi.GetEspeceDemoulee(espece, calibre, typecarton, qualite);
					if (list.isEmpty() == false)
						for (EspeceDemoulee temp : list) {
							especeDemoulee = temp;
						}
					liststock = mi.GetStockByEspeceDemoulee(especeDemoulee);
					if (liststock.isEmpty() == false)
						for (Stock temp : liststock) {
							ancienStock = temp;
						}
					stock.setSoldeAvant(ancienStock.getSoldeStock());
					stock.setSoldeStock(ancienStock.getSoldeStock() + nombreCarton);
					stock.setEspeceDemoulee(especeDemoulee);
					stock.setDate(new Date());
					stock.setNombre(nombreCarton);
					stock.setAfficher(1);
					 is.AddStock(stock);
					 if(ancienStock!=null){
							ancienStock.setAfficher(0);
							is.UpdateStock(ancienStock);
						}
				}
				typecontainer= mi.GetTypeContainerByNom(object.getString("typeContainer"));
				String NumContainer=object.getString("NumContainer");
				String NumPlombs=object.getString("NumPlombs");
				container = mi.GetContainerByNumContainerEtNumPlombs(NumContainer, NumPlombs);
				if (container == null) {
					container = new Container();
					container.setNumeroContaineur(NumContainer);
					container.setNumeroPlombs(NumPlombs);
					container.setTypeContainer(typecontainer);
					icontainer.addContainer(container);
					List<Container> listcontainer = mi.GetContainerMax();
					if (list.isEmpty() == false)
						for (Container temp : listcontainer) {
							container = temp;
						}
				}
				EspeceDebarqueeTransportees.setContainer(container);
				EspeceDebarqueeTransportees.setPoids(poids);
				EspeceDebarqueeTransportees.setEspeceDemoulee(especeDemoulee);
				EspeceDebarqueeTransportees.setExportation(exportation);
				iespecedebTrans.AddEspeceDebarqueTransp(EspeceDebarqueeTransportees);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return exportation;

	}

}

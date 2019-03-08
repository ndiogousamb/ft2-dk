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

import importexport.dao.IClient;
import importexport.dao.IEspeceDemoulee;
import importexport.dao.IEspeceDemouleeAchetee;
import importexport.dao.IStock;
import importexport.dao.IUsers;
import importexport.dao.IVenteLocale;
import importexport.dao.MonInterface;
import importexport.model.*;

@Controller
@RequestMapping("/VenteLocale")
public class VenteLocaleController {
	@Autowired
	public IStock is;
	@Autowired
	public IEspeceDemouleeAchetee iEDemouleeAchetee;
	@Autowired
	private IUsers iUser;
	@Autowired
	private IClient icl;
	@Autowired
	public IEspeceDemoulee ied;
	@Autowired
	private IVenteLocale iVentelocale;
	@Autowired
	ServletContext context;
	@Autowired
	public MonInterface mi;

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=iUser.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "MenuVenteLocale";
	}

	@RequestMapping(value = "/ListeVenteLocaleAConsulter", method = RequestMethod.GET)
	public String ListeFacturationVenteLocaleAConsulter(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeVenteLocaleAConsulter";
	}
	
	@RequestMapping(value = "/ListeVenteLocaleAModifier", method = RequestMethod.GET)
	public String ListeVenteLocaleAModifier(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeVenteLocaleAModifier";
	}
	
	@RequestMapping(value = "/addVenteLocale", method = RequestMethod.GET)
	public String addVenteLocale(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "AddVenteLocale";
	}
	@RequestMapping(value = "/GetVenteLocale", method = RequestMethod.GET)
	public String GetVenteLocale(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetVenteLocale";
	}
	
	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/", method = RequestMethod.GET)
	public String GetVenteLocaleAModifier(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetVenteLocaleAModifier";
	}
	
	@RequestMapping(value = "/EspeceDemouleeDejaFacturer_VenteLocale", method = RequestMethod.GET)
	public @ResponseBody List<EscepeDemouleeAchetee> EspeceDemouleeDejaFacturer_VenteLocale(
			@RequestParam("Code") String Code) {
		List<EscepeDemouleeAchetee> lC = mi.listEspeceDemouleeAcheteByCodeRegle(Integer.parseInt(Code));
		return lC;
	}
	
	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/EspeceDemoulee_VenteLocalePourModification", method = RequestMethod.GET)
	public @ResponseBody List<EscepeDemouleeAchetee> EspeceDemoulee_VenteLocalePourModification(
			@RequestParam("Code") String Code) {
		List<EscepeDemouleeAchetee> lC = mi.listEspeceDemouleeAcheteByCodeRegle(Integer.parseInt(Code));
		return lC;
	}
	@RequestMapping(value = "/listEspeces", method = RequestMethod.GET)
	public @ResponseBody List<Espece> listEspeces() {
		List<Espece> lE = mi.ListEspeces();
		return lE;
	}
	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/listCartons", method = RequestMethod.GET)
	public @ResponseBody List<TypeCarton> listTypeCartons() {
		List<TypeCarton> lC = mi.ListTypeCarton();
		return lC;
	}
	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/listCalibres", method = RequestMethod.GET)
	public @ResponseBody List<Calibre> lisCalibres() {
		List<Calibre> lC = mi.ListCalibres();
		return lC;
	}
	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/listEspeces", method = RequestMethod.GET)
	public @ResponseBody List<Espece> listEspecesVenteLocale() {
		List<Espece> lE = mi.ListEspeces();
		return lE;
	}
	

	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/UpdateEspeceAchetees", method = RequestMethod.GET)
	public @ResponseBody Object updateruser(
			@RequestParam("calibre") String calibre,
			@RequestParam("espece") String espece, 
			@RequestParam("nbCarton") String nbCarton,
			@RequestParam("typecarton") String typecarton,
			@RequestParam("idEspeceAchete") String idEspeceAchete

	) {
		
		
		Calibre ObjectCalibre = null;
		Espece ObjectEspece = null;
		Float nombreCarton = Float.parseFloat(nbCarton);
		TypeCarton objectTypeCarton=null;
		EscepeDemouleeAchetee escepeDemouleeAchetee = null;
		EspeceDemoulee especeDemoulee=null;
		Achat achat=null;
		float poids = 0;

		try {
			ObjectCalibre = mi.GetCalibreByNom(calibre);
			ObjectEspece = mi.GetEspeceByNom(espece);
			objectTypeCarton=mi.GetTypeCartonByLibelle(typecarton);
			escepeDemouleeAchetee = mi.GetEspeceDemouleeAcheteById(Integer.parseInt(idEspeceAchete));
			especeDemoulee=mi.GetEspeceDemouleeByEspeceCalibreEtTypeCarton(ObjectEspece, ObjectCalibre, objectTypeCarton);
			achat=escepeDemouleeAchetee.getAchat();
			if(typecarton.equals("14 KG"))
				poids=nombreCarton*14;
			else if(typecarton.equals("20 KG"))
				poids=nombreCarton*20;
			else if (typecarton.equals("28 KG"))
				poids=nombreCarton*28;
			achat.setRegle(0);
			escepeDemouleeAchetee.setEspeceDemoulee(especeDemoulee);
			escepeDemouleeAchetee.setPoids(poids);
			escepeDemouleeAchetee.setNombreCartonAchete(nombreCarton);
			iVentelocale.updateAchat(achat);
			iEDemouleeAchetee.UpdateEscepeDemouleeAchetee(escepeDemouleeAchetee);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return escepeDemouleeAchetee;
	}
	

	@RequestMapping(value = "/listCalibres", method = RequestMethod.GET)
	public @ResponseBody List<Calibre> lisCalibresVenteLocale() {
		List<Calibre> lC = mi.ListCalibres();
		return lC;
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
	
	@RequestMapping(value = "/ListeVenteLocaleAModifier/GetVenteLocaleAModifier/GetDispoStockPourModification", method = RequestMethod.GET)
	public @ResponseBody Object GetSoldeActuel(
			@RequestParam("espece") String espece,
			@RequestParam("calibre") String calibre) {
		Stock stock = null;
		List<Stock> list = mi.GetActuelPourModification(espece, calibre);
		if (list.isEmpty() == false)
			for (Stock temp : list) {
				stock = temp;
				return stock;
			}
		return new Stock(0);

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
	@RequestMapping(value = "/listTousLesVenteLocales", method = RequestMethod.GET)
	public @ResponseBody List<Achat> listTousLesVenteLocales() {
		List<Achat> lp = mi.listTousLesVenteLocales();
		return lp;
	}
	@RequestMapping(value = "/saveVenteLocale", method = RequestMethod.GET)
	public @ResponseBody Object saveVenteLocale(@RequestParam("PrenomClient") String PrenomClient,
			@RequestParam("NomClient") String NomClient, @RequestParam("DateAchat") String DateAchat,
			@RequestParam(value = "lesElements") String[] items) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);

		Calibre calibre = null;
		Espece espece = null;
		TypeCarton typecarton = null;

		Client client = null;
		Qualite qualite = null;
		CalibreGP grospoisson = null;
		Achat achat = new Achat();

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
			client = mi.GetClientByPrenomEtNom(PrenomClient, NomClient);
			if (client == null) {
				client = new Client();
				client.setPrenomClient(PrenomClient);
				client.setNomClient(NomClient);
				icl.addClient(client);
				List<Client> list = mi.GetClientMax();
				if (list.isEmpty() == false)
					for (Client temp : list) {
						client = temp;
					}
			}
			achat.setClient(client);
			achat.setDateAchat(mi.formatDate(DateAchat));
			achat.setCodeAchat(mi.generateCodeAchat());
			achat.setUtilisateur(utilisateur);
			iVentelocale.addAchat(achat);
			List<Achat> listAchat = mi.GetAchatMax();
			if (listAchat.isEmpty() == false)
				for (Achat temp : listAchat) {
					achat = temp;
				}
			JSONArray jsonArray = new JSONArray(tab);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				EspeceDemoulee especeDemoulee = null;
				EscepeDemouleeAchetee escepeDemouleeAchetee = new EscepeDemouleeAchetee();
				Stock stock = new Stock();
				Stock ancienStock = null;
				float poids = (object.getInt(("poids")));
				float nombreCarton;
				float nbCarton=0;
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

				} else {
					calibre = mi.GetCalibreByNom(object.getString("calibre"));
					 nbCarton=Float.parseFloat(object.getString("nbCarton"));
					 escepeDemouleeAchetee.setNombreCartonAchete(nbCarton);
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
				escepeDemouleeAchetee.setAchat(achat);
				escepeDemouleeAchetee.setEspeceDemoulee(especeDemoulee);
				escepeDemouleeAchetee.setPoids(poids);
				iEDemouleeAchetee.AddEscepeDemouleeAchetee(escepeDemouleeAchetee);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return achat;

	}
}

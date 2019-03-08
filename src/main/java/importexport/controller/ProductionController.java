package importexport.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.servlet.view.RedirectView;

import importexport.dao.IEspeceProduite;
import importexport.dao.IMarayeur;
import importexport.dao.IProduction;
import importexport.dao.IUsers;
import importexport.dao.IVehicule;
import importexport.dao.MonInterface;
import importexport.model.Calibre;
import importexport.model.Espece;
import importexport.model.EspeceProduite;
import importexport.model.Marayeur;
import importexport.model.Production;
import importexport.model.Profil;
import importexport.model.UserRoles;
import importexport.model.Utilisateur;
import importexport.model.Vehicule;

@Controller
@RequestMapping("/production")
public class ProductionController {
	@Autowired
	ServletContext context;
	@Autowired
	public MonInterface mi;
	@Autowired
	public IProduction ip;
	@Autowired
	public IEspeceProduite iep;
	@Autowired
	public IVehicule iv;
	@Autowired
	public IMarayeur im;
	@Autowired
	private IUsers iUser;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String production(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "production";
	}

	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public String MenuProduction(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuProduction";
	}

	@RequestMapping(value = "/ListeProductionAModifier", method = RequestMethod.GET)
	public String ListeProductionAModifier(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeProductionAModifier";
	}

	@RequestMapping(value = "/ListeProduction", method = RequestMethod.GET)
	public String ConsulterProduction(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ConsultationProduction";
	}

	
	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier", method = RequestMethod.GET)
	public String GetProductionAModifier(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		System.out.println(username);
		Utilisateur utilisateur = iUser.GetUtilisateur(username);

		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetProductionAModifier";

	}

	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier/listEspeces", method = RequestMethod.GET)
	public @ResponseBody List<Espece> listEspecesAModifier() {
		List<Espece> lE = mi.ListEspeces();
		return lE;
	}

	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier/listCalibres", method = RequestMethod.GET)
	public @ResponseBody List<Calibre> lisCalibresAModifier() {
		List<Calibre> lC = mi.ListCalibres();
		return lC;
	}

	@RequestMapping(value = "/ListeProduction/ConsulterProduction", method = RequestMethod.GET)
	public String GetProduction(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetProduction";
	}

	@RequestMapping(value = "/ListeProduction/ConsulterProduction/EspeceProduite", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspeceProduite(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCodeProduction(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier/EspeceProduite", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspeceProduiteAModifier(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCodeProduction(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier/UpdateEspeceProduite", method = RequestMethod.GET)
	public @ResponseBody Object updateruser(@RequestParam("calibre") String calibre,
			@RequestParam("espece") String espece, @RequestParam("poids") String poids,
			@RequestParam("idEspeceProduite") String idEspeceProduite

	) {

		Calibre ObjectCalibre = null;
		Espece ObjectEspece = null;
		Float nouveauPoids = null;

		EspeceProduite especeProduite = null;

		try {
			ObjectCalibre = mi.GetCalibreByNom(calibre);
			ObjectEspece = mi.GetEspeceByNom(espece);
			nouveauPoids = Float.parseFloat(poids);
			especeProduite = mi.EspeceProduiteById(Integer.parseInt(idEspeceProduite));
			Float p = especeProduite.getPoids();
			if (especeProduite.getPoids() <= 0)
				especeProduite.setPoids(nouveauPoids);
			else {

				if (p <= nouveauPoids)
					especeProduite.setPoids(p + nouveauPoids);
				else
					especeProduite.setPoids(p - nouveauPoids);
			}
			especeProduite.setCalibre(ObjectCalibre);
			especeProduite.setEspece(ObjectEspece);
			especeProduite.setPlaignat(nouveauPoids);
			especeProduite.setRegle(0);
			Production prod=especeProduite.getProduction();
			prod.setRegle(0);
			ip.UpdateProduction(prod);
			iep.UpdateEspeceProduite(especeProduite);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return especeProduite;
	}

	@RequestMapping(value = "/addProduction", method = RequestMethod.GET)
	public String accueil(Model model) {
		if( SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser"))
			return "redirect:/user/login";
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = iUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "addProduction";
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

	@RequestMapping(value = "/verifierMarayeur", method = RequestMethod.GET)
	public @ResponseBody Object verifierLogin(@RequestParam("PrenomMarayeur") String PrenomMarayeur,
			@RequestParam("NomMarayeur") String NomMarayeur) {
		Marayeur marayeur = mi.MarayeurByNomEtPrenom(PrenomMarayeur, NomMarayeur);
		if (marayeur != null)
			return marayeur;
		return new Marayeur(0);

	}

	@RequestMapping(value = "/saveProduction", method = RequestMethod.GET)
	public @ResponseBody Object saveproduction(@RequestParam("PrenomMarayeur") String PrenomMarayeur,
			@RequestParam("NomMarayeur") String NomMarayeur, @RequestParam("Immatricule") String Immatricule,
			@RequestParam("Debdate") String Debdate, @RequestParam("Findate") String Findate,
			@RequestParam("CIN") String CIN, @RequestParam(value = "items") String[] items) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Production production = new Production();

		Vehicule vehicule = new Vehicule();
		Calibre calibre = null;
		Espece espece = null;
		Marayeur marayeur = new Marayeur();

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
			marayeur = mi.MarayeurByCIN(CIN);
			if (marayeur == null) {
				marayeur = new Marayeur();
				marayeur.setNomMarayeur(NomMarayeur);
				marayeur.setCodeMarayeur(mi.generateCodeMarayeur());
				marayeur.setCinMarayeur(CIN);
				marayeur.setPrenomMarayeur(PrenomMarayeur);
				im.AddMarayeur(marayeur);
				marayeur = mi.MarayeurByCIN(CIN);
			}
			vehicule = mi.GetVehiculeByMatricule(Immatricule);
			if (vehicule == null) {
				vehicule = new Vehicule();
				vehicule.setNumImmatriculation(Immatricule);
				iv.addVehicule(vehicule);
				vehicule = mi.GetVehiculeByMatricule(Immatricule);
			}

			Utilisateur utilisateur = iUser.GetUtilisateur(username);
			production.setCodeProduction(mi.generateCodeProduction());
			production.setDateDebut(mi.formatDate(Debdate));
			production.setDateFin(mi.formatDate(Findate));
			production.setMarayeur(marayeur);
			production.setVehicule(vehicule);
			production.setUtilisateur(utilisateur);
			ip.AddProduction(production);
			production = mi.GetProductionMaximal();
			JSONArray jsonArray = new JSONArray(tab);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				espece = mi.GetEspeceByNom(object.getString("espece"));
				calibre = mi.GetCalibreByNom(object.getString("calibre"));
				float poids = (Float.parseFloat(object.getString("poids")));
				EspeceProduite especeProduite = null;
				List<EspeceProduite> list = mi.GetEspeceProduiteByEspeceEtCalibre(espece, calibre);
				if (list.isEmpty() == false) {
					for (EspeceProduite temp : list) {
						especeProduite = temp;
					}
				}

				if (especeProduite == null) {
					especeProduite = new EspeceProduite();
					especeProduite.setCalibre(calibre);
					especeProduite.setEspece(espece);
					especeProduite.setCodeEspeceProduite(espece.getCodeEspece() + calibre.getCodeCalibre());
					especeProduite.setPoids(poids);
					especeProduite.setPlaignat(poids);
					especeProduite.setPoidsRestantADemouler(0);
					especeProduite.setProduction(production);
					especeProduite.setDemoule(0);
					EspeceProduite ep = especeProduite;
					iep.AddEspeceProduite(ep);
				} else {
					EspeceProduite ep = new EspeceProduite();
					float poids_restant = especeProduite.getPoidsRestantADemouler();
					float actuel = especeProduite.getPoids();
					ep.setPlaignat(poids);
					ep.setCalibre(calibre);
					ep.setEspece(espece);
					ep.setCodeEspeceProduite(espece.getCodeEspece() + calibre.getCodeCalibre());
					if (especeProduite.getDemoule() == 0) {
						ep.setPoids(poids + poids_restant + actuel);
						especeProduite.setDemoule(1);
						iep.UpdateEspeceProduite(especeProduite);
					} else
						ep.setPoids(poids + poids_restant);
					ep.setProduction(production);
					ep.setDemoule(0);
					ep.setPoidsRestantADemouler(0);
					iep.AddEspeceProduite(ep);
				}

			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
			//return "redirect:/production/ListeProduction/ConsulterProduction/?"+production.getId();
		return production;
	}

	@RequestMapping(value = "/EspeceProduiteByCodeProduction", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduites(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCodeProduction(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/listProduction", method = RequestMethod.GET)
	public @ResponseBody List<Production> listProduction() {
		List<Production> lp = mi.listProductionNonDemoule();
		return lp;
	}

	@RequestMapping(value = "/listTousLesProduction", method = RequestMethod.GET)
	public @ResponseBody List<Production> listTousLesProduction() {
		List<Production> lp = mi.listProductionNonDemoule();
		return lp;
	}

	@RequestMapping(value = "/ListeProduction/listProduction", method = RequestMethod.GET)
	public @ResponseBody List<Production> listProductionProduction() {
		List<Production> lp = mi.listProduction();
		return lp;
	}

	@RequestMapping(value = "/ListeProduction/EspeceProduiteByCodeProduction", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduitesProduction(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCodeProduction(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/verifierCIN", method = RequestMethod.GET)
	public @ResponseBody Object verifierLogin(@RequestParam("CIN") String CIN) {
		Marayeur marayeur = mi.MarayeurByCIN(CIN);
		if (marayeur != null)
			return marayeur;
		return new Marayeur(0);

	}
	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier/verifierCIN", method = RequestMethod.GET)
	public @ResponseBody Object verifierCIN(@RequestParam("CIN") String CIN) {
		Marayeur marayeur = mi.MarayeurByCIN(CIN);
		if (marayeur != null)
			return marayeur;
		return new Marayeur(0);

	}
	
	
	
	@RequestMapping(value = "/ListeProductionAModifier/GetProductionAModifier/UpdateProduction", method = RequestMethod.GET)
	public @ResponseBody Object UpdateProduction(@RequestParam("PrenomMarayeur") String PrenomMarayeur,
			@RequestParam("NomMarayeur") String NomMarayeur, @RequestParam("Immatricule") String Immatricule,
			@RequestParam("Debdate") String Debdate, @RequestParam("Findate") String Findate,
			@RequestParam("CIN") String CIN,@RequestParam("CodeProduction") String CodeProduction,
			@RequestParam("Code") String Code) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Production production = null;
		Vehicule vehicule = null;
		Marayeur marayeur = null;
		try {
			production=mi.GetProductionById(Code);
			marayeur = mi.MarayeurByCIN(CIN);
			if (marayeur == null) {
				marayeur = new Marayeur();
				marayeur.setNomMarayeur(NomMarayeur);
				marayeur.setCodeMarayeur(mi.generateCodeMarayeur());
				marayeur.setCinMarayeur(CIN);
				marayeur.setPrenomMarayeur(PrenomMarayeur);
				im.AddMarayeur(marayeur);
				marayeur = mi.MarayeurByCIN(CIN);
			}
			vehicule = mi.GetVehiculeByMatricule(Immatricule);
			if (vehicule == null) {
				vehicule = new Vehicule();
				vehicule.setNumImmatriculation(Immatricule);
				iv.addVehicule(vehicule);
				vehicule = mi.GetVehiculeByMatricule(Immatricule);
			}

			Utilisateur utilisateur = iUser.GetUtilisateur(username);
			production.setCodeProduction(CodeProduction);
			if(Debdate.contains("/"))
			production.setDateDebut(mi.formatDate(Debdate));
			if(Findate.contains("/"))
			production.setDateFin(mi.formatDate(Findate));
			production.setRegle(0);
			production.setMarayeur(marayeur);
			production.setVehicule(vehicule);
			production.setUtilisateur(utilisateur);
			ip.UpdateProduction(production);
			

			

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return production;
	}

}

package importexport.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import importexport.dao.IEspeceDemoulee;
import importexport.dao.IEspeceProduite;
import importexport.dao.IProduction;
import importexport.dao.IStock;
import importexport.dao.IUsers;
import importexport.dao.MonInterface;
import importexport.model.*;

@Controller
@RequestMapping("/demoulage")
public class DemoulageController {
	@Autowired
	ServletContext context;
	@Autowired
	public MonInterface mi;
	@Autowired
	public IProduction ip;
	@Autowired
	public IEspeceProduite iep;
	@Autowired
	public IEspeceDemoulee ied;
	@Autowired
	private IUsers iUser;
	@Autowired
	public IStock is;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String Demoulage(Model model) {
//		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	     String username = user.getUsername(); 
//	     Utilisateur utilisateur=IUser.GetUtilisateur(username);
//	     String nomComplet=utilisateur.getNomComplet();
//	     model.addAttribute("nomComplet", nomComplet);
//		return "ListeAdemouler";
//	}
	
	@RequestMapping(value = "/AddDemoulage", method = RequestMethod.GET)
	public String accueil(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=iUser.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "AddDemoulage";
	}
	

	@RequestMapping(value = "/AddDemoulage/listEspeces", method = RequestMethod.GET)
	public @ResponseBody List<Espece> listEspeces() {
		List<Espece> lE = mi.ListEspeces();
		return lE;
	}

	@RequestMapping(value = "/AddDemoulage/listCalibres", method = RequestMethod.GET)
	public @ResponseBody List<Calibre> lisCalibres() {
		List<Calibre> lC = mi.ListCalibres();
		return lC;
	}

	@RequestMapping(value = "/AddDemoulage/listCartons", method = RequestMethod.GET)
	public @ResponseBody List<TypeCarton> listCartons() {
		List<TypeCarton> lC = mi.ListTypeCarton();
		return lC;
	}

	@RequestMapping(value = "/AddDemoulage/listQualites", method = RequestMethod.GET)
	public @ResponseBody List<Qualite> listQualites() {
		List<Qualite> lC = mi.ListQualites();
		return lC;
	}

	@RequestMapping(value = "/AddDemoulage/listTunnel", method = RequestMethod.GET)
	public @ResponseBody List<Tunnel> listTunnel() {
		List<Tunnel> lC = mi.ListTunnel();
		return lC;
	}
	@RequestMapping(value = "/listProduction", method = RequestMethod.GET)
	public @ResponseBody List<Production> listProduction() {
		List<Production> lp = mi.listProductionNonDemoule();
		return lp;
	}

	@RequestMapping(value = "/EspeceProduiteByCode", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduites(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCode(Integer.parseInt(Code));
		return lC;
	}
	@RequestMapping(value = "/EspeceProduiteNonDemoule", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspeceProduiteNonDemoule(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCode(Integer.parseInt(Code));
		return lC;
	}
	@RequestMapping(value = "/AddDemoulage/ListEspeceProduiteNonDemoule", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> ListEspeceProduiteNonDemoule(){
		List<EspeceProduite> lC = mi.listEspeceProduiteNonDemoules();
		return lC;
	}
	@RequestMapping(value = "/EspeceProduiteByCodeProduction", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduitesNonDemoule(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCode(Integer.parseInt(Code));
		return lC;
	}
	
	@RequestMapping(value = "/AddDemoulage/saveDemoulage", method = RequestMethod.GET)
	public  @ResponseBody Object saveproduction(
			@RequestParam("espece") String espece,
			@RequestParam("calibre") String calibre,
			@RequestParam("poids") String poids,
			@RequestParam("typecarton") String typecarton, 
			@RequestParam("nbCarton") String nbCarton,
			@RequestParam("qualite") String qualite, 
			@RequestParam("tunnel") String tunnel,
			@RequestParam("id") String id) {
		Production production = new Production();
		EspeceProduite especeproduite = new EspeceProduite();
		EspeceDemoulee especedemoulee = new EspeceDemoulee();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Stock stock=new Stock();
		try {
			
			especeproduite = mi.EspeceProduiteById(Integer.parseInt(id));
			production = especeproduite.getProduction();
			int typC = 0;
			float poidsUtiliser = 0;
			Espece espece_new = new Espece();
			Calibre calibre_new = new Calibre();
			espece_new = mi.GetEspeceByNom(espece);
			calibre_new = mi.GetCalibreByNom(calibre);
			List <EspeceDemoulee> list = mi.GetEspeceDemouleeByEspeceEtCalibre(espece_new, calibre_new);
			if (list.isEmpty()==false){
			for (EspeceDemoulee temp : list) {
				
				especedemoulee=temp;
				especedemoulee.setId(temp.getId());
				}
			}
			else{
				especedemoulee=null;
			}
			EspeceDemoulee ep= new EspeceDemoulee();
			if (especedemoulee == null) {
				
				ep.setCalibre(calibre_new);
				ep.setEspece(espece_new);
			}
			else{
				especedemoulee.setAfficher(0);
			}
			
			ep.setAfficher(1);
			ep.setCalibre(calibre_new);
			ep.setEspece(espece_new);
			ep.setPoids(Float.parseFloat(poids));
			TypeCarton typeCarton_new = new TypeCarton();
			typeCarton_new = mi.GetTypeCartonById((typecarton));
			if (typeCarton_new.getId() == 1)
				typC = 14;
			else if (typeCarton_new.getId() == 2)
				typC = 20;
			else
				typC = 28;
			float nombreCarton = Float.parseFloat(nbCarton);
			float poids_new = Float.parseFloat(poids);
			Qualite qualite_new = new Qualite();
			qualite_new = mi.GetQualiteById(Integer.parseInt(qualite));
			poidsUtiliser = nombreCarton * typC;
			float poidsrestant=poids_new-poidsUtiliser;
			
			if (poidsrestant>0)
				especeproduite.setPoidsRestantADemouler(poidsrestant);
			Tunnel tunnel_new = new Tunnel();
			tunnel_new = mi.GetTunnelById(Integer.parseInt(tunnel));
			String codeProduction=production.getCodeProduction();
			ep.setCodeEspecedemoulee(espece + "-" + calibre+"-"+codeProduction);
			ep.setQualite(qualite_new);
			ep.setTypeCarton(typeCarton_new);
			production.setTunnel(tunnel_new);
			production.setDemoule(1);
			especeproduite.setDemoule(1);
			ip.UpdateProduction(production);
			production=mi.GetProductionByCode(codeProduction);
			ep.setProduction(production);
			Utilisateur utilisateur = iUser.GetUtilisateur(username);
			ep.setUtilisateur(utilisateur);
			ied.AddDemoulage(ep);
			iep.UpdateEspeceProduite(especeproduite);
			if(especedemoulee!=null){
				ied.UpdateDemoulage(especedemoulee);
			}
			ep=mi.GetEspeceDemouleeMax();
			Stock ancienStock=null;
			List <Stock> liststock = mi.GetStockByEspeceDemoulee(ep);
			if(liststock.isEmpty()==false)
			for (Stock temp : liststock) {
				ancienStock=temp;
			}
			if (ancienStock!=null){
			stock.setSoldeAvant(ancienStock.getSoldeStock());
			stock.setSoldeStock(ancienStock.getSoldeStock()+nombreCarton);
			}
			else{
				stock.setSoldeStock(nombreCarton);
				stock.setSoldeAvant(0);
			}
			stock.setEspeceDemoulee(ep);
			stock.setDate(new Date());
			stock.setNombre(nombreCarton);
			stock.setAfficher(1);
			is.AddStock(stock);
			if(ancienStock!=null){
				ancienStock.setAfficher(0);
				is.UpdateStock(ancienStock);
			}
			
				
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return production;
	}

}

package importexport.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

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
import org.springframework.web.servlet.view.jasperreports.JasperReportsHtmlView;

import com.google.zxing.Dimension;
import com.mysql.jdbc.Connection;

import importexport.dao.IDebarquement;
import importexport.dao.IEspeceDebarqueTransp;
import importexport.dao.IEspeceDemoulee;
import importexport.dao.IEspeceDemouleeAchetee;
import importexport.dao.IEspeceProduite;
import importexport.dao.IExportation;
import importexport.dao.IProduction;
import importexport.dao.IUsers;
import importexport.dao.IVenteLocale;
import importexport.dao.MonInterface;
import importexport.model.*;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
//
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperPrintManager;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

@Controller
@RequestMapping("/facturation")
public class FacturationController {
	@Autowired
	public MonInterface mi;
	@Autowired
	public IEspeceProduite iep;
	@Autowired
	public IEspeceDemoulee ied;
	@Autowired
	public IEspeceDemouleeAchetee iedAchete;
	@Autowired
	public IEspeceDebarqueTransp iedTranspor;
	@Autowired
	public IVenteLocale iventeLoc;
	@Autowired
	public IDebarquement ideb;
	@Autowired
	public IProduction ip;
	@Autowired
	private IUsers IUser;
	@Autowired
	private IExportation iexportation;

	@RequestMapping(value = "/production/addfacturationproduction", method = RequestMethod.GET)
	public String addFacturationMarayeur(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "AddFacturationProduction";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String MenuProduction(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuFacturation";
	}

	@RequestMapping(value = "/MenuFacturationProduction", method = RequestMethod.GET)
	public String MenuFacturationProduction(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuFacturationProduction";
	}

	@RequestMapping(value = "/MenuFacturationDebarquement", method = RequestMethod.GET)
	public String MenuFacturationDebarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuFacturationDebarquement";
	}

	@RequestMapping(value = "/MenuFacturationExportation", method = RequestMethod.GET)
	public String MenuFacturationExportation(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuFacturationExportation";
	}

	@RequestMapping(value = "/production/GetFacturationProduction", method = RequestMethod.GET)
	public String GetFacturationProduction(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetFacturationProduction";
	}

	@RequestMapping(value = "/debarquement/GetFacturationDebarquement", method = RequestMethod.GET)
	public String GetFacturationDebarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetFacturationDebarquement";
	}

	@RequestMapping(value = "/VenteLocale/GetFacturationVenteLocale", method = RequestMethod.GET)
	public String GetFacturationVenteLocale(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetFacturationVenteLocale";
	}

	@RequestMapping(value = "/production/ListeFacturationProductionAconsulter", method = RequestMethod.GET)
	public String ListeFacturationProductionAconsulter(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeFacturationProductionAconsulter";
	}

	@RequestMapping(value = "/MenuFacturationVenteLocale", method = RequestMethod.GET)
	public String ventelocale(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "MenuFacturationVenteLocale";
	}

	@RequestMapping(value = "/production", method = RequestMethod.GET)
	public String marayeur(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "FacturationProduction";
	}

	@RequestMapping(value = "/debarquement", method = RequestMethod.GET)
	public String Debarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "FacturationDebarquement";
	}

	@RequestMapping(value = "/exportation", method = RequestMethod.GET)
	public String exportation(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "FacturationExportation";
	}

	@RequestMapping(value = "/VenteLocale", method = RequestMethod.GET)
	public String VenteLocale(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "FacturationVenteLocale";
	}

	@RequestMapping(value = "/VenteLocale/ListeFacturationVenteLocaleAConsulter", method = RequestMethod.GET)
	public String ListeFacturationVenteLocaleAConsulter(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeFacturationVenteLocaleAConsulter";
	}

	@RequestMapping(value = "/VenteLocale/listVenteLocaleADejaFacture", method = RequestMethod.GET)
	public @ResponseBody List<Achat> listVenteLocaleADejaFacture() {
		List<Achat> lp = mi.listVenteLocaleRegle();
		return lp;
	}

	@RequestMapping(value = "VenteLocale/addfacturationventelocale", method = RequestMethod.GET)
	public String addFacturationVenteLocale(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "AddFacturationVenteLocale";
	}

	@RequestMapping(value = "exportation/addfacturationExportation", method = RequestMethod.GET)
	public String addfacturationExportation(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "AddFacturationExportation";
	}

	@RequestMapping(value = "/debarquement/addfacturationproduction", method = RequestMethod.GET)
	public String addFacturationDebarquement(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "AddFacturationDebarquement";
	}

	@RequestMapping(value = "/debarquement/EspeceDemouleByCode", method = RequestMethod.GET)
	public @ResponseBody List<EspeceDemoulee> listEspeceDemoulee(@RequestParam("Code") String Code) {
		List<EspeceDemoulee> lC = mi.listEspeceDemouleeByCodeNonRegle(Integer.parseInt(Code));
		return lC;
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

	@RequestMapping(value = "/listProduction", method = RequestMethod.GET)
	public @ResponseBody List<Production> listProduction() {
		List<Production> lp = mi.listProductionNonRegle();
		return lp;
	}

	@RequestMapping(value = "/listDebarquement", method = RequestMethod.GET)
	public @ResponseBody List<Debarquement> listDebarquement() {
		List<Debarquement> lp = mi.listDebarquementNonRegle();
		return lp;
	}

	@RequestMapping(value = "/listVenteLocaleNonRegle", method = RequestMethod.GET)
	public @ResponseBody List<Achat> listVenteLocaleNonRegle() {
		List<Achat> lp = mi.listVenteLocaleNonRegle();
		return lp;
	}

	@RequestMapping(value = "/debarquement/ListeFacturationDebarquementAconsulter", method = RequestMethod.GET)
	public String ListeFacturationDebarquementAconsulter(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeFacturationDebarquementAconsulter";
	}

	@RequestMapping(value = "/exportation/ListeFacturationExportationAConsulter", method = RequestMethod.GET)
	public String ListeFacturationExportationAconsulter(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "ListeFacturationExportationAConsulter";
	}

	@RequestMapping(value = "/debarquement/listDebarquementRegle", method = RequestMethod.GET)
	public @ResponseBody List<Debarquement> listDebarquementRegle() {
		List<Debarquement> lp = mi.listDebarquementRegle();
		return lp;
	}

	@RequestMapping(value = "/listVenteLocaleAFacturer", method = RequestMethod.GET)
	public @ResponseBody List<Achat> listVenteLocaleAFacturer() {
		List<Achat> lp = mi.listVenteLocaleNonRegle();
		return lp;
	}

	@RequestMapping(value = "/listExportationAFacturer", method = RequestMethod.GET)
	public @ResponseBody List<Exportation> listExportationAFacturer() {
		List<Exportation> lp = mi.listExportationNonRegle();
		return lp;
	}

	@RequestMapping(value = "exportation/listExportationDejaFacture", method = RequestMethod.GET)
	public @ResponseBody List<Exportation> listExportationDejaFacture() {
		List<Exportation> lp = mi.listExportationRegle();
		return lp;
	}

	@RequestMapping(value = "/exportation/GetFacturationExportation", method = RequestMethod.GET)
	public String GetFacturationExportation(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Utilisateur utilisateur = IUser.GetUtilisateur(username);
		String nomComplet = utilisateur.getNomComplet();
		model.addAttribute("nomComplet", nomComplet);
		return "GetFacturationExportation";
	}

	@RequestMapping(value = "exportation/EspeceTransporteExportation", method = RequestMethod.GET)
	public @ResponseBody List<EspeceDebarqueeTransportees> EspeceTransporteExportation(
			@RequestParam("Code") String Code) {
		List<EspeceDebarqueeTransportees> lC = mi
				.listEspeceDebarqueeTransporteesByCodePourConsulterExportation(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/VenteLocale/EspeceDemouleePourReglerFactureVenteLocale", method = RequestMethod.GET)
	public @ResponseBody List<EscepeDemouleeAchetee> EspeceDemouleePourReglerFactureVenteLocale(
			@RequestParam("Code") String Code) {
		List<EscepeDemouleeAchetee> lC = mi.listEspeceDemouleeAcheteByCodeNonRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/exportation/EspeceTransportePourReglerFactureExportation", method = RequestMethod.GET)
	public @ResponseBody List<EspeceDebarqueeTransportees> EspeceTransportePourReglerFactureExportation(
			@RequestParam("Code") String Code) {
		List<EspeceDebarqueeTransportees> lC = mi.listEspeceDebarqueeTransporteesByCodeNonRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/production/ListeFacturationProductionAconsulter/listProductionRegle", method = RequestMethod.GET)
	public @ResponseBody List<Production> listProductionRegle() {
		List<Production> lp = mi.listProductionRegle();
		return lp;
	}

	@RequestMapping(value = "/production/EspeceProduiteByCode", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduites(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCodeNonRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/production/EspeceProduiteRegle", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduitesRegle(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/debarquement/EspeceDemouleReglePourFacturation", method = RequestMethod.GET)
	public @ResponseBody List<EspeceDemoulee> EspeceDemouleReglePourFacturation(@RequestParam("Code") String Code) {
		List<EspeceDemoulee> lC = mi.listEspeceDemouleRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/production/EspeceProduiteReglePourFacturation", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> EspeceProduiteReglePourFacturation(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/VenteLocale/EspeceDemouleeDejaFacturer_VenteLocale", method = RequestMethod.GET)
	public @ResponseBody List<EscepeDemouleeAchetee> EspeceDemouleeDejaFacturer_VenteLocale(
			@RequestParam("Code") String Code) {
		List<EscepeDemouleeAchetee> lC = mi.listEspeceDemouleeAcheteByCodeRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/production/EspeceProduiteByCodeNonRegle", method = RequestMethod.GET)
	public @ResponseBody List<EspeceProduite> listEspecesProduitesNonRegle(@RequestParam("Code") String Code) {
		List<EspeceProduite> lC = mi.listEspeceProduiteByCodeNonRegle(Integer.parseInt(Code));
		return lC;
	}

	@RequestMapping(value = "/verifierCIN", method = RequestMethod.GET)
	public @ResponseBody Object verifierLogin(@RequestParam("CIN") String CIN) {
		Marayeur marayeur = mi.MarayeurByCIN(CIN);
		if (marayeur != null)
			return marayeur;
		return new Marayeur(0);

	}

	@RequestMapping(value = "/production/ImprimerFactureProduction", method = RequestMethod.GET)
	public @ResponseBody void ImprimerFactureProduction(@RequestParam(value = "Code") String Code) {
		Production production=null;
		try {
			production=mi.GetProductionById(Code);
			String reportSrcFile = "/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/FactureProd.jrxml";
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("Parameter1", production.getId());
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
			File outDir = new File("C:/test");
			outDir.mkdirs();
			JRPdfExporter exporter = new JRPdfExporter();
			ExporterInput exporterInput = new SimpleExporterInput(print);
			exporter.setExporterInput(exporterInput);
			String nom = production.getCodeProduction();
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/Documents/" + nom + ".pdf");
			exporter.setExporterOutput(exporterOutput);
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			// JasperPrintManager.printReport( print, true);
		//	JasperViewer.viewReport(print,false);
			
			JasperViewer jv=new JasperViewer(print, false);

			//set title for the jasper viewer
		jv.setTitle("PRODUCTION " + nom + "");
			jv.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/VenteLocale/ImprimerFactureVenteLocale", method = RequestMethod.GET)
	public @ResponseBody void ImprimerFactureVenteLocale(@RequestParam(value = "Code") String Code) {
		Achat achat = null;
		Integer id = Integer.parseInt(Code);
		try {
			achat = mi.GetAchatById(id);
			String reportSrcFile = "/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/FacturationVenteLocale.jrxml";
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("Parameter1", achat.getId());
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
			File outDir = new File("C:/test");
			outDir.mkdirs();
			JRPdfExporter exporter = new JRPdfExporter();
			ExporterInput exporterInput = new SimpleExporterInput(print);
			exporter.setExporterInput(exporterInput);
			String nom = achat.getCodeAchat();
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/Documents/"+nom+".pdf");
			exporter.setExporterOutput(exporterOutput);
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			// JasperPrintManager.printReport( print, false);
			JasperViewer.viewReport(print, false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/production/saveFactureProduction", method = RequestMethod.GET)
	public @ResponseBody Object saveproduction(@RequestParam(value = "listespeces") String[] listespeces) {

		Production production = new Production();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		try {
			for (int i = 0; i < listespeces.length; i++) {
				if (i != listespeces.length - 1)
					listespeces[i] = listespeces[i] + ',';
				else
					listespeces[i] = listespeces[i];

			}
			String tab = null;
			for (int i = 0; i < listespeces.length; i++) {
				if (i == 0)
					tab = "[";
				tab = tab + listespeces[i];
				if (i == listespeces.length - 1)
					tab = tab + "]";
			}
			System.out.println(tab);
			JSONArray jsonArray = new JSONArray(tab);
			int montant = 0;
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				EspeceProduite especeProduite = new EspeceProduite();
				especeProduite = mi.EspeceProduiteById((object.getInt("id")));
				production = especeProduite.getProduction();
				especeProduite.setPrixEspeceCalibree(Float.parseFloat(object.getString("prixunitaire")));
				especeProduite.setMontant((object.getInt(("montant"))));
				montant += object.getInt("montant");
				especeProduite.setRegle(1);
				iep.UpdateEspeceProduite(especeProduite);
			}
			ConvertierMontantEnLettre c = new ConvertierMontantEnLettre();
			c.setMontant("" + montant + ".00");
			c.calculer_glob();
			String montantEnLetter = c.getMontantLettre();
			montantEnLetter = montantEnLetter + "francs CFA";

			Utilisateur utilisateur = IUser.GetUtilisateur(username);
			production.setUtilisateur(utilisateur);
			production.setMontantProduction(montant);
			production.setRegle(1);
			production.setCodeFacture(mi.genererFactureProduction());
			System.out.println(mi.genererFactureProduction());
			production.setMontantEnLettre(montantEnLetter);
			ip.UpdateProduction(production);

			String reportSrcFile = "/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/FactureProd.jrxml";
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("Parameter1", production.getId());
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
			File outDir = new File("C:/test");
			outDir.mkdirs();
			JRPdfExporter exporter = new JRPdfExporter();
			ExporterInput exporterInput = new SimpleExporterInput(print);
			exporter.setExporterInput(exporterInput);
			String nom = production.getCodeProduction();
		//	OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("C:/test/" + nom + ".pdf");
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/Documents/" + nom + ".pdf");
			///Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/Documents
			exporter.setExporterOutput(exporterOutput);
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			// JasperPrintManager.printReport( print, true);
			// JasperReportsHtmlView
			JasperViewer.viewReport(print, false);

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return production;
	}

	@RequestMapping(value = "/VenteLocale/saveFactureVenteLocale", method = RequestMethod.GET)
	public @ResponseBody Object saveFactureVenteLocale(@RequestParam(value = "listespeces") String[] listespeces) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Achat achat = null;
		try {

			for (int i = 0; i < listespeces.length; i++) {
				if (i != listespeces.length - 1)
					listespeces[i] = listespeces[i] + ',';
				else
					listespeces[i] = listespeces[i];

			}
			String tab = null;
			for (int i = 0; i < listespeces.length; i++) {
				if (i == 0)
					tab = "[";
				tab = tab + listespeces[i];
				if (i == listespeces.length - 1)
					tab = tab + "]";
			}
			System.out.println(tab);
			JSONArray jsonArray = new JSONArray(tab);
			float montant = 0;
			Utilisateur utilisateur = IUser.GetUtilisateur(username);

			Integer idAchat = null;
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				EscepeDemouleeAchetee especeDemouleeAchetee = null;
				especeDemouleeAchetee = mi.GetEspeceDemouleeAcheteById((object.getInt("id")));
				especeDemouleeAchetee.setPrixUnitaire(Float.parseFloat(object.getString("prixunitaire")));
				idAchat = object.getJSONObject("achat").getInt("id");
				especeDemouleeAchetee.setMontant((float) (object.getInt(("montant"))));
				montant += object.getInt("montant");
				iedAchete.UpdateEscepeDemouleeAchetee(especeDemouleeAchetee);
			}

			achat = mi.GetAchatById(idAchat);
			achat.setMontantAchat(montant);
			ConvertierMontantEnLettre c = new ConvertierMontantEnLettre();
			c.setMontant("" + montant + ".00");
			c.calculer_glob();
			String montantEnLetter = c.getMontantLettre();
			montantEnLetter = montantEnLetter + "francs CFA";
			achat.setCodeFacture(mi.genererFactureVenteLocale());
			achat.setMontantEnLettre(montantEnLetter);
			achat.setRegle(1);
			achat.setUtilisateurFacturation(utilisateur);
			iventeLoc.updateAchat(achat);
			String reportSrcFile = "/Users/ndiogousamb/eclipse-workspace/GestionImportExport/src/main/webapp/Impression/FacturationVenteLocale.jrxml";
			JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
			Connection conn = MySQLConnUtils.getMySQLConnection();
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("Parameter1", achat.getId());
			JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
			File outDir = new File("C:/test");
			outDir.mkdirs();
			JRPdfExporter exporter = new JRPdfExporter();
			ExporterInput exporterInput = new SimpleExporterInput(print);
			exporter.setExporterInput(exporterInput);
			String nom = achat.getCodeAchat();
			OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput("C:/test/" + nom + ".pdf");
			exporter.setExporterOutput(exporterOutput);
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			exporter.setConfiguration(configuration);
			exporter.exportReport();
			// JasperPrintManager.printReport( print, false);
			JasperViewer.viewReport(print, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achat;
	}

	@RequestMapping(value = "/exportation/saveFactureExportation", method = RequestMethod.GET)
	public @ResponseBody Object saveFactureExportation(
			@RequestParam(value = "listespecesExportees") String[] listespeces) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Exportation exportation = null;
		try {

			for (int i = 0; i < listespeces.length; i++) {
				if (i != listespeces.length - 1)
					listespeces[i] = listespeces[i] + ',';
				else
					listespeces[i] = listespeces[i];

			}
			String tab = null;
			for (int i = 0; i < listespeces.length; i++) {
				if (i == 0)
					tab = "[";
				tab = tab + listespeces[i];
				if (i == listespeces.length - 1)
					tab = tab + "]";
			}
			System.out.println(tab);
			JSONArray jsonArray = new JSONArray(tab);
			float montant = 0;
			Utilisateur utilisateur = IUser.GetUtilisateur(username);

			Integer idExportation = null;
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				EspeceDebarqueeTransportees especeDebarqueeTransportees = null;
				especeDebarqueeTransportees = mi.GetEspeceTransporteesAcheteById((object.getInt("id")));
				especeDebarqueeTransportees.setPrixUnitaire(Float.parseFloat(object.getString("prixunitaire")));
				idExportation = object.getJSONObject("exportation").getInt("id");
				especeDebarqueeTransportees.setMontantPartiel((float) (object.getInt(("montant"))));
				montant += object.getInt("montant");
				iedTranspor.UpdateEspeceDebarqueTransp(especeDebarqueeTransportees);
			}

			exportation = mi.GetExportationById(idExportation);
			ConvertierMontantEnLettre c = new ConvertierMontantEnLettre();
			c.setMontant("" + montant + ".00");
			c.calculer_glob();
			String montantEnLetter = c.getMontantLettre();
			montantEnLetter = montantEnLetter + "francs CFA";
			exportation.setCodeFacture(mi.genererFactureExportation());
			exportation.setMontantEnLettre(montantEnLetter);
			exportation.setMontantExportation(montant);
			exportation.setRegle(1);
			exportation.setUtilisateurFacturation(utilisateur);
			iexportation.UpdateExportation(exportation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exportation;
	}

	@RequestMapping(value = "/debarquement/saveFactureDebarquement", method = RequestMethod.GET)
	public @ResponseBody Object saveFacturationDebarquement(@RequestParam(value = "listespeces") String[] listespeces) {

		Debarquement debarquement = null;
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();

		try {

			for (int i = 0; i < listespeces.length; i++) {
				if (i != listespeces.length - 1)
					listespeces[i] = listespeces[i] + ',';
				else
					listespeces[i] = listespeces[i];

			}
			String tab = null;
			for (int i = 0; i < listespeces.length; i++) {
				if (i == 0)
					tab = "[";
				tab = tab + listespeces[i];
				if (i == listespeces.length - 1)
					tab = tab + "]";
			}
			System.out.println(tab);
			JSONArray jsonArray = new JSONArray(tab);
			float montant = 0;
			Utilisateur utilisateur = IUser.GetUtilisateur(username);
			EspeceDemoulee especeDemoulee = null;
			Integer idDebarquement = null;
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				especeDemoulee = null;
				especeDemoulee = mi.GetEspeceDemouleeById((object.getInt("id")));
				especeDemoulee.setPrixUnitaire(Float.parseFloat(object.getString("prixunitaire")));
				idDebarquement = object.getJSONObject("debarquement").getInt("id");
				especeDemoulee.setMontant((float) (object.getInt(("montant"))));
				montant += object.getInt("montant");
				especeDemoulee.setRegle(1);
				especeDemoulee.setUtilisateurFacturation(utilisateur);
				ied.UpdateDemoulage(especeDemoulee);
			}

			debarquement = mi.GetDebarquementById(idDebarquement);
			debarquement.setMontant(montant);
			debarquement.setRegle(1);
			debarquement.setUtilisateurFacturation(utilisateur);
			ideb.updateDebarquement(debarquement);
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return debarquement;
	}
}
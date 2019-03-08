package importexport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import importexport.dao.IUsers;
import importexport.dao.MonInterface;
import importexport.model.Espece;
import importexport.model.Stock;
import importexport.model.Utilisateur;

@Controller
@RequestMapping("/stock")
public class StockController {
	@Autowired
	private IUsers IUser;
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String production(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=IUser.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "ViewStock";
	}
	@Autowired
	public MonInterface mi;
	@RequestMapping(value = "/listStock", method = RequestMethod.GET)
	public @ResponseBody List<Stock> listStock() {
		List<Stock> lS = mi.GetListStock();
		return lS;
	}
}

package importexport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import importexport.dao.IUsers;
import importexport.model.Utilisateur;
@Controller
@RequestMapping("/")
public class AccueilController {
	@Autowired
	private IUsers iUser;
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=iUser.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "accueil";
		
	}
	 
}


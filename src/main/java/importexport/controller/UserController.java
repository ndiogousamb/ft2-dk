package importexport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import importexport.dao.IUserDao;
import importexport.dao.IUsers;
import importexport.model.Profil;
import importexport.model.UserRoles;
import importexport.model.Utilisateur;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String login() {
		return "403";
	}
	@Autowired
	private IUsers iu;
	@Autowired
	private IUserDao IUser;
	@RequestMapping(value = "/sincrire", method = RequestMethod.GET)
	public String sincrire(Model model) {
		model.addAttribute("listProfils", iu.ListProfils());
		model.addAttribute("listRoles", iu.ListRoles());
		return "sincrire";
	}
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public @ResponseBody Object adduser(
			@RequestParam("nomComplet")String nomComplet,
			@RequestParam("login")String login,
			@RequestParam("password")String password,
			@RequestParam("profil")String profil,
			@RequestParam("role")String role
			
			){
		Utilisateur user=new Utilisateur();
		UserRoles userRoles=iu.GetRole(Integer.parseInt(role));	
		Profil pf=iu.GetProfil(Integer.parseInt(profil));
		user.setRole(userRoles);
		user.setProfil(pf);
		user.setLogin(login);
		user.setNomComplet(nomComplet);
		user.setPassword(password);
		IUser.AddUser(user);
		return user;
	}
	
	@RequestMapping(value="/verifierLogin",method=RequestMethod.GET)
	public @ResponseBody Object verifierLogin(
			@RequestParam("login")String login	
			){
		Utilisateur user=iu.GetUtilisateur(login);
		if (user != null)
			return user;
		return new Utilisateur(0);

	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout)
	{

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
			}
		

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		model.setViewName("login");

		return model;

	}

}

package importexport.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import importexport.model.*;
import importexport.dao.IUserDao;
import importexport.dao.IUsers;

@Controller
@RequestMapping("/")
public class AdministrerUserController {
	@Autowired
	ServletContext context;
	@Autowired
	public IUsers iu;
	@Autowired
	public IUserDao IUser;
	@Autowired
	private IUsers IUsers;
	@RequestMapping(value = "/administration", method = RequestMethod.GET)
	public String administration(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	     String username = user.getUsername(); 
	     Utilisateur utilisateur=IUsers.GetUtilisateur(username);
	     String nomComplet=utilisateur.getNomComplet();
	     model.addAttribute("nomComplet", nomComplet);
		return "administration";
	}
	@RequestMapping(value="/listUsers",method=RequestMethod.GET)
	public @ResponseBody List<Utilisateur> listUsers(){
		 List<Utilisateur> lu=iu.ListUtilisateur();
		 return lu;
	}
	@RequestMapping(value="/listProfils",method=RequestMethod.GET)
	public @ResponseBody List<Profil> listProfils(){
		 List<Profil> lp=iu.ListProfils();
		 return lp;
	}
	@RequestMapping(value="/listRoles",method=RequestMethod.GET)
	public @ResponseBody List<UserRoles> listRoles(){
		 List<UserRoles> lr=iu.ListRoles();
		 return lr;
	}
	@RequestMapping(value="/activerUser",method=RequestMethod.GET)
	public @ResponseBody Object activeruser(
			@RequestParam("nomComplet")String nomComplet,
			@RequestParam("login")String login,
			@RequestParam("profil")String profil,
			@RequestParam("role")String role,
			@RequestParam("idUser")String id
			){
		Utilisateur user=iu.GetUtilisateurById(Integer.parseInt(id));
		Profil pf=null;
		UserRoles userRoles=null;
		if(isNumber(profil)==false)
		{
			pf=iu.GetProfilByProfil(profil);
		}
		else{
			pf=iu.GetProfil(Integer.parseInt(profil));
		}
		if(isNumber(role)==false)
		{
			userRoles=iu.GetRoleByRole(role);
		}
		else{
			userRoles=iu.GetRole(Integer.parseInt(role));
		}
			user.setRole(userRoles);
			user.setProfil(pf);
			user.setLogin(login);
			user.setNomComplet(nomComplet);
			user.setEnabled(true);
			IUser.UpdateUser(user);
			return user;
	}
	@RequestMapping(value="/UpdateUser",method=RequestMethod.GET)
	public @ResponseBody Object updateruser(
			@RequestParam("nomComplet")String nomComplet,
			@RequestParam("login")String login,
			@RequestParam("profil")String profil,
			@RequestParam("role")String role,
			@RequestParam("idUser")String id
		
			){
		Utilisateur user=iu.GetUtilisateurById(Integer.parseInt(id));
		Profil pf=null;
		UserRoles userRoles=null;
		if(isNumber(profil)==false)
		{
			pf=iu.GetProfilByProfil(profil);
		}
		else{
			pf=iu.GetProfil(Integer.parseInt(profil));
		}
		if(isNumber(role)==false)
		{
			userRoles=iu.GetRoleByRole(role);
		}
		else{
			userRoles=iu.GetRole(Integer.parseInt(role));
		}
			user.setRole(userRoles);
			user.setProfil(pf);
			user.setLogin(login);
			user.setNomComplet(nomComplet);
			IUser.UpdateUser(user);
			return user;
	}
	@RequestMapping(value="/desactiverUser",method=RequestMethod.GET)
	public @ResponseBody Object desactiveruser(
			@RequestParam("idUser")String id	
			){
		Utilisateur user=iu.GetUtilisateurById(Integer.parseInt(id));
		user.setEnabled(false);
		IUser.UpdateUser(user);
		return user;
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.GET)
	public @ResponseBody Object deleteuser(
			@RequestParam("idUser")String id	
			){
		Utilisateur user=iu.GetUtilisateurById(Integer.parseInt(id));
		IUser.DeleteUser(user);
		return user;
	}
	public static boolean isNumber(String solde) {
		boolean stricterFilter = true;
		String stricterFilterString = "[0-9]+";
		String laxString = "";
		String emailRegex = stricterFilter ? stricterFilterString : laxString;
		Pattern p = Pattern.compile(emailRegex);
		Matcher m = p.matcher(solde);
		return m.matches();
	}

}

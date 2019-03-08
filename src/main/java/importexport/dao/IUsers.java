package importexport.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import importexport.model.*;
public interface IUsers {
	public List<Utilisateur>ListUtilisateur();
	public List<Profil>ListProfils();
	public List<UserRoles>ListRoles();
	public Utilisateur GetUtilisateur(String login);
	public Utilisateur GetUtilisateurById(int id);
	public UserRoles GetRole(int id);
	public UserRoles GetRoleByRole(String role);
	
	public Profil GetProfil(int id);
	public Profil GetProfilByProfil(String nomProfil);

}

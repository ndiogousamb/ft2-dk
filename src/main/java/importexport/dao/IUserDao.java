package importexport.dao;

import java.util.List;

import importexport.model.UserRoles;
import importexport.model.Utilisateur;

public interface IUserDao {
	
	public void AddUser(Utilisateur user);
	public void UpdateUser(Utilisateur user);
	public void DeleteUser(Utilisateur user);
	
	
}

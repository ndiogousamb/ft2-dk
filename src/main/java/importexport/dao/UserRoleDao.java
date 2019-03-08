package importexport.dao;

import importexport.model.UserRoles;
import importexport.model.Utilisateur;

public class UserRoleDao extends AbstractDao<Integer, UserRoles>implements IUserDao {

	public void AddUser(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	public void UpdateUser(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	public void DeleteUser(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	public Utilisateur ActiverUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void AddRoleToUser(UserRoles ur) {
		persist(ur);
		
	}

}

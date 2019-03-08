package importexport.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.UserRoles;
import importexport.model.Utilisateur;

@Repository
@Transactional
public class UserDao extends AbstractDao<Integer, Utilisateur>implements IUserDao {

	public void AddUser(Utilisateur user) {
	persist(user);	
	}

	public void UpdateUser(Utilisateur user) {
		update(user);
		
	}

	public void DeleteUser(Utilisateur user) {
		delete(user);
		
	}

	

	

	

}

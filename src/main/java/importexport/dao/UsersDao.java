package importexport.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import importexport.model.Profil;
import importexport.model.UserRoles;
import importexport.model.Utilisateur;

@Repository
@Transactional
public class UsersDao implements IUsers {

	@Autowired
	private SessionFactory factory;

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Utilisateur> ListUtilisateur() {
		return (List<Utilisateur>) getSession().createQuery("FROM Utilisateur as u").list();
	}

	public Utilisateur GetUtilisateur(String login) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("FROM Utilisateur u WHERE u.login = :login");
		query.setParameter("login", login);
		return (Utilisateur) query.uniqueResult();
	}
	
	public Utilisateur GetUtilisateurById(int id) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("FROM Utilisateur u WHERE u.id = :id");
		query.setParameter("id", id);
		return (Utilisateur) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Profil> ListProfils() {
		return (List<Profil>) getSession().createQuery("SELECT p FROM Profil p").list();
	}

	@SuppressWarnings("unchecked")
	public List<UserRoles> ListRoles() {
		return (List<UserRoles>) getSession().createQuery("SELECT u FROM UserRoles u").list();

	}

	public UserRoles GetRole(int id) {
		Query query = getSession().createQuery("FROM UserRoles u WHERE u.userRoleId = :userRoleId");
		query.setParameter("userRoleId", id);
		return (UserRoles) query.uniqueResult();
	}

	public Profil GetProfil(int id) {
		Query query = getSession().createQuery("SELECT p FROM Profil p WHERE p.id = :id");
		query.setParameter("id", id);
		return (Profil) query.uniqueResult();
	}

	public UserRoles GetRoleByRole(String role) {
		Query query = getSession().createQuery("FROM UserRoles u WHERE u.role = :role");
		query.setParameter("role", role);
		return (UserRoles) query.uniqueResult();
	}

	public Profil GetProfilByProfil(String nomProfil) {

		Query query = getSession().createQuery("SELECT p FROM Profil p WHERE p.nomProfil = :nomProfil");
		query.setParameter("nomProfil", nomProfil);
		return (Profil) query.uniqueResult();

	}

}

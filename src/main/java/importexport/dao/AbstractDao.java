package importexport.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
// LES METHODE DE BASSE 
public abstract class AbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	//PERMET DE RECUPERER LA SESSION ET ACCERDER A BD
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){//
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {//OBJET A TRAVER UN ID
		return (T) getSession().get(persistentClass, key);
	}

	public void persist(T entity) {//ENREGISTRER
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){//REQUETE AVEC WHERE
		return getSession().createCriteria(persistentClass);
	}

}

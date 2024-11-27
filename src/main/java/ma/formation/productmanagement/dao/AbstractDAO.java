package ma.formation.productmanagement.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAO {

	protected EntityManagerFactory emf;

	public AbstractDAO() {
		this.emf = Persistence.createEntityManagerFactory("shoppingAppPersistenceUnit");
	}

}

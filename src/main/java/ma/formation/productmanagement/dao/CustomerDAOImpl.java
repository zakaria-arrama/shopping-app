package ma.formation.productmanagement.dao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.formation.productmanagement.domain.Customer;

public class CustomerDAOImpl implements CustomerDAO{

	private EntityManagerFactory emf;
	
	public CustomerDAOImpl() {
		this.emf = Persistence.createEntityManagerFactory("shoppingAppPersistenceUnit");
	}
	
	@Override
	public void create(Customer customer)  {
		
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
			System.out.println("Customer created : "+ customer.getFirstName() + " " + customer.getLastName());
		}finally {
			em.close();
		}

	}

}

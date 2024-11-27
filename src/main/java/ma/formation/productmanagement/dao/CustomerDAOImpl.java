package ma.formation.productmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.formation.productmanagement.domain.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	
	
	protected EntityManagerFactory emf;

	
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

	@Override
	public List<Customer> listAll() {
		EntityManager em = emf.createEntityManager();
		List<Customer> list = null;
		try {
			String query = "SELECT c FROM Customer c";
			list =  em.createQuery(query).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		
		return list;

	}

}

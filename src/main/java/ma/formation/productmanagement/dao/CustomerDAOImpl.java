package ma.formation.productmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.formation.productmanagement.domain.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @PersistenceContext
    private EntityManager em;


	@Override
	@Transactional
	public void create(Customer customer)  {
        em.persist(customer);
	}

	@Override
	public List<Customer> listAll() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
	}

}
	
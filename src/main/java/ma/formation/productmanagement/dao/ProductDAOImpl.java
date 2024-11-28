package ma.formation.productmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.formation.productmanagement.domain.Customer;
import ma.formation.productmanagement.domain.Product;

public class ProductDAOImpl implements ProductDAO{

	protected EntityManagerFactory emf;
	
	
    public ProductDAOImpl(EntityManagerFactory emf) {
        this.emf = emf; // Injected by Spring
    }
    
	@Override
	public void create(Product product) {
		EntityManager em = emf.createEntityManager();
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
			System.out.println("Customer created : "+ product.getId() + " " + product.getName());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}

		
	}

	@Override
	public List<Product> listAll() {		
		EntityManager em = emf.createEntityManager();
		List<Product> listOfProducts;
		listOfProducts =  em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
		return listOfProducts;
	}

	

}

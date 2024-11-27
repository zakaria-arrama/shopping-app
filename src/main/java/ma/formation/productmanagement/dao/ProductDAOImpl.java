package ma.formation.productmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.formation.productmanagement.domain.Customer;
import ma.formation.productmanagement.domain.Product;

public class ProductDAOImpl extends AbstractDAO implements ProductDAO{

	EntityManager em;
	
	@Override
	public void create(Product product) {
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
		em = emf.createEntityManager();
		List<Product> listOfProducts;
		listOfProducts =  em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
		return listOfProducts;
	}

	

}

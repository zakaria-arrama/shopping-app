package ma.formation.productmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ma.formation.productmanagement.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

    @PersistenceContext
    private EntityManager em;
	
	@Override
	@Transactional
	public void create(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> listAll() {		
		return  em.createQuery("SELECT p FROM Product p",Product.class).getResultList();
	}

	

}

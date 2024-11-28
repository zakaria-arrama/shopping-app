package ma.formation.productmanagement.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import ma.formation.productmanagement.domain.Customer;
import ma.formation.productmanagement.domain.Order;
import ma.formation.productmanagement.domain.Product;

public class OrderDAOImpl implements OrderDAO{

	
    @PersistenceContext
    private EntityManager em;


	@Override
	@Transactional
	public void create(Order order, List<Integer> productIds, Integer customerId) {
		TypedQuery<Product> query = em.createQuery("FROM Product p WHERE p.id in :productIds ",Product.class);
		query.setParameter("productIds", productIds);
		
		Customer customer = em.find(Customer.class, customerId);
		order.setCustomer(customer);
		
		List<Product> existingProducts = query.getResultList();
		Set<Product> productsSet = existingProducts.stream().collect(Collectors.toSet());
		order.setProducts(productsSet);
        em.persist(order);
	}

}

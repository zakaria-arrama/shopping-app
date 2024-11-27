package ma.formation.productmanagement.dao;

import java.util.List;

import ma.formation.productmanagement.domain.Product;

public interface ProductDAO {

	void create(Product product) ;
	List<Product> listAll();

}

package ma.formation.productmanagement.dao;

import java.io.IOException;
import java.util.List;

import ma.formation.productmanagement.domain.Customer;

public interface CustomerDAO {
	
	void create(Customer customer) ;

	List<Customer> listAll();


}

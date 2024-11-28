package ma.formation.productmanagement.dao;

import java.util.List;

import ma.formation.productmanagement.domain.Order;


public interface OrderDAO {

	void create(Order order, List<Integer> productIds,Integer customerId) ;

}

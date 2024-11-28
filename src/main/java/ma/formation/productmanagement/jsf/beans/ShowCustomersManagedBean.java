package ma.formation.productmanagement.jsf.beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import jakarta.annotation.PostConstruct;
import ma.formation.productmanagement.dao.CustomerDAO;
import ma.formation.productmanagement.domain.Customer;

@ManagedBean
@ViewScoped
public class ShowCustomersManagedBean {

    private List<Customer> customers;

    @ManagedProperty("#{customerDAO}")
    private CustomerDAO customerDAO;

    

    private void loadCustomers() {
        customers = customerDAO.listAll();
	}

	public List<Customer> getCustomers() {
	    if (customers == null) {
	        customers = customerDAO.listAll();
	    }
	    return customers;

    }

    
	public void setCustomerDAO(CustomerDAO customerDAO) {
	    this.customerDAO = customerDAO;
	}

}

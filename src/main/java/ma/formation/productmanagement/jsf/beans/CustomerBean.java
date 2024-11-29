package ma.formation.productmanagement.jsf.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ma.formation.productmanagement.dao.CustomerDAO;
import ma.formation.productmanagement.domain.Customer;
import ma.formation.productmanagement.domain.Order;

@ManagedBean
@ViewScoped
public class CustomerBean {

	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String adresse;
    
    
    @ManagedProperty("#{customerDAO}")
    private CustomerDAO customerDAO;

    
    private List<Customer> customers;

    

    public void saveCustomer() {
    	Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAdresse(adresse);
        customer.setPhoneNumber(phoneNumber);
        customers.add(customer);        

        customerDAO.create(customer);
        
        
        firstName = null;
        lastName = null;
        email = null;
        phoneNumber = null;
        adresse = null;

    }

    public void showOrders(Customer customer) {
        System.out.println("Show Orders for Customer: " + customer.getId());
        
         Set<Order> orders = customer.getOrders();
         if(orders!= null && orders.size() > 0)
         for (Order order : orders) {
			System.out.println(order.getId());
		}

    }

    public void editCustomer(Customer customer) {
        System.out.println("Edit Customer: " + customer.getId());
    }

    public void deleteCustomer(Customer customer) {
        System.out.println("Delete Customer: " + customer.getId());
        customers.remove(customer); // Remove from the list
        //customerDAO.delete(customer); // Call DAO to delete from the database

        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Customer Deleted", "Customer " + customer.getId() + " has been removed."));
    }


    public List<Customer> getCustomers() {
	    if (customers == null) {
	        customers = customerDAO.listAll();
	    }
	    return customers;

    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
    
	public void setCustomerDAO(CustomerDAO customerDAO) {
	    this.customerDAO = customerDAO;
	}

    
    private List<String> selectedOptions;

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

}

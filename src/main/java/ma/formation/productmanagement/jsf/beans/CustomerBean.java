package ma.formation.productmanagement.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ma.formation.productmanagement.dao.CustomerDAO;
import ma.formation.productmanagement.domain.Customer;

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


    
    private List<String> customers = new ArrayList<>();

    public void saveCustomer() {
    	Customer customer = new Customer();
        customers.add(firstName + " " + lastName);        
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAdresse(adresse);
        customer.setPhoneNumber(phoneNumber);
        
        customerDAO.create(customer);
        
        
        firstName = null;
        lastName = null;
        email = null;
        phoneNumber = null;
        adresse = null;

    }

    public List<String> getCustomers() {
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

	public void setCustomers(List<String> customers) {
		this.customers = customers;
	}
    
	public void setCustomerDAO(CustomerDAO customerDAO) {
	    this.customerDAO = customerDAO;
	}

    
}

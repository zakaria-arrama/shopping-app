package ma.formation.productmanagement.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CustomerBean {
    private String firstName;
    private String lastName;
    private List<String> customers = new ArrayList<>();

    public void saveCustomer() {
        customers.add(firstName + " " + lastName);
        firstName = null;
        lastName = null;
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
}

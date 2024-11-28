package ma.formation.productmanagement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.formation.productmanagement.dao.CustomerDAO;
import ma.formation.productmanagement.dao.CustomerDAOImpl;
import ma.formation.productmanagement.domain.Customer;

@WebServlet("/createDummyCustomer")
public class CreateDummyCustomer extends HttpServlet {
	
	private CustomerDAO customerDAO;

	@Override
	public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.customerDAO = (CustomerDAO) context.getBean("customerDAO");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setFirstName("Zakaria");
		customer.setLastName("ARRAMA");
		customer.setEmail("zakaria.arrama@gmail.com");
		customer.setPhoneNumber("+212123456789");
		
		try {
			customerDAO.create(customer);
			resp.getWriter().println("Utilisateur crée avec succès : "+customer.getId() + "|" + customer.getEmail());

		} catch (Exception e) {
			resp.getWriter().println("Erreur durant la création du Customer ");
		}
		
		
	}
}

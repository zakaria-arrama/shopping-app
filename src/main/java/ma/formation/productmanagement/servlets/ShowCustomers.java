package ma.formation.productmanagement.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.formation.productmanagement.dao.CustomerDAO;
import ma.formation.productmanagement.domain.Customer;
import ma.formation.productmanagement.domain.Order;

@WebServlet("/showCustomers")
public class ShowCustomers extends HttpServlet{

	private CustomerDAO customerDAO;
	
	@Override
	public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.customerDAO = (CustomerDAO) context.getBean("customerDAO");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Customer> listDeCustomers = customerDAO.listAll();
		resp.getWriter().println("List de customers : ");

		for(Customer customerItem : listDeCustomers) {
			resp.getWriter().println(" - "+customerItem.getId()+"|"+customerItem.getFirstName());
				for(Order o: customerItem.getOrders()) {
					resp.getWriter().println(" - "+o.getId()+"|"+o.getTotalPrice());
				}
		}
	}



}

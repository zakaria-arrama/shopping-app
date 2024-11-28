package ma.formation.productmanagement.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.formation.productmanagement.dao.OrderDAO;
import ma.formation.productmanagement.dao.ProductDAO;
import ma.formation.productmanagement.dao.ProductDAOImpl;
import ma.formation.productmanagement.domain.Order;
import ma.formation.productmanagement.domain.Product;

@WebServlet("/createOrder")
public class CreateOrder extends HttpServlet{

	private OrderDAO orderDAO;
	
	@Override
	public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.orderDAO = (OrderDAO) context.getBean("orderDAO");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		order.setTotalPrice(100.0);
		
		try {
			List<Integer> productIds = Arrays.asList(1,2,3);
			orderDAO.create(order,productIds,1);
			resp.getWriter().println("Order crée avec succès : "+order.getId());

		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Erreur durant la création ");
		}
		
		
	}



}

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

import ma.formation.productmanagement.dao.ProductDAO;
import ma.formation.productmanagement.domain.Product;

@WebServlet("/showProducts")
public class ShowProducts extends HttpServlet{

	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Product> listDeProduits = productDAO.listAll();
		resp.getWriter().println("List de produits : ");

		for(Product productItem : listDeProduits) {
			resp.getWriter().println(" - "+productItem.getId()+"|"+productItem.getName()+"|"+productItem.getPrice());
		}
	}



}

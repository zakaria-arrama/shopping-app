package ma.formation.productmanagement.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.formation.productmanagement.dao.ProductDAO;
import ma.formation.productmanagement.dao.ProductDAOImpl;
import ma.formation.productmanagement.domain.Product;

@WebServlet("/createProduct")
public class CreateProduct extends HttpServlet{

	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		product.setDescription(req.getParameter("description"));
		product.setPrice(Double.valueOf(req.getParameter("price")));
		product.setName(req.getParameter("name"));
		try {
			productDAO.create(product);
			resp.getWriter().println("Produit crée avec succès : "+product.getId() + "|" + product.getName());

		} catch (Exception e) {
			resp.getWriter().println("Erreur durant la création du produit ");
		}
		
		
	}



}

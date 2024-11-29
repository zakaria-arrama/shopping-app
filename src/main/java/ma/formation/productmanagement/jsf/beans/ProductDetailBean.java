package ma.formation.productmanagement.jsf.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import ma.formation.productmanagement.dao.ProductDAO;
import ma.formation.productmanagement.domain.Product;

@ManagedBean
@RequestScoped
public class ProductDetailBean implements Serializable{
	

	private static final long serialVersionUID = 1891311575709117352L;

	@ManagedProperty(value = "#{param.productId}")
	private Integer productId;
    
    private Product product;

    
    @ManagedProperty("#{productDAO}")
    private ProductDAO productDAO;


    public void initialize() {
        if (productId != null) {
            try {
                long id = productId;
                product = productDAO.findById(id);
               
            } catch (NumberFormatException e) {
            	e.printStackTrace();
                product = null;
            }
        }
    }




	public Integer getProductId() {
		return productId;
	}




	public void setProductId(Integer productId) {
		this.productId = productId;
	}




	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}




	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	
    
}

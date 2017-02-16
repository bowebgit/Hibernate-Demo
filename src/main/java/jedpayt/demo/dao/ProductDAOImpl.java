package jedpayt.demo.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jedpayt.demo.dao.api.ProductDAO;
import jedpayt.demo.entity.Product;

@Service
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);	
	}
	public Product findProduct(String name){
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from Product where prod_name = :name");
		query.setParameter("name", name);
		return (Product) query.list().get(0);
	}
	public Product findProduct(int id) {
		return (Product) sessionFactory.
				getCurrentSession().
				get(Product.class, id);
	}

	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	public void deleteProduct(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}


}

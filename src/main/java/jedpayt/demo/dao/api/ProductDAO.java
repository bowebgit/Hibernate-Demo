package jedpayt.demo.dao.api;

import jedpayt.demo.entity.Product;

public interface ProductDAO {
	
	void insertProduct(Product product);
	Product findProduct(String name);
	Product findProduct(int id);
	void updateProduct(Product product);
	void deleteProduct(Product product);

}

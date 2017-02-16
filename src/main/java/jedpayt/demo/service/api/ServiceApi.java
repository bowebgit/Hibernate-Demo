
/**
 * Service.java provides all application services, Product and Vendor.
 */

package jedpayt.demo.service.api;

import java.util.List;

import jedpayt.demo.entity.Product;
import jedpayt.demo.entity.Vendor;

public interface ServiceApi {

	
	void createProduct(Product product);
	Product getProductByName(String name);
	Product getProductById(int id);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	
	
	void createVendor(Vendor vendor);
	Vendor getVendorByName(String name);
	Vendor getVendorById(int id);
	List<Vendor> getAllVendors();
	void updateVendor(Vendor vendor);
	void deleteVendor(Vendor vendor);
	
}

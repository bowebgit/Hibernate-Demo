package jedpayt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jedpayt.demo.dao.api.ProductDAO;
import jedpayt.demo.dao.api.VendorDAO;
import jedpayt.demo.entity.Product;
import jedpayt.demo.entity.Vendor;
import jedpayt.demo.service.api.ServiceApi;

@Service
@Transactional
public class ServiceImpl implements ServiceApi{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private VendorDAO vendorDAO;
	
	
	public void createProduct(Product product) {
		productDAO.insertProduct(product);
	}
	
	public Product getProductByName(String name){
		return productDAO.findProduct(name);
	}
	
	public Product getProductById(int id) {
		return productDAO.findProduct(id);
	}
	
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	
	public void deleteProduct(Product product) {
		productDAO.deleteProduct(product);
	}
	
	public void createVendor(Vendor vendor) {
		vendorDAO.insertVendor(vendor);
	}
	
	public Vendor getVendorByName(String name){
		return vendorDAO.findVendor(name);
	}
	
	public Vendor getVendorById(int id) {
		return vendorDAO.findVendor(id);
	}
	
	public List<Vendor> getAllVendors() {
		return vendorDAO.findAllVendors();
	}
	
	public void updateVendor(Vendor vendor) {
		vendorDAO.updateVendor(vendor);
	}
	
	public void deleteVendor(Vendor vendor) {
		vendorDAO.deleteVendor(vendor);
	}

}

package jedpayt.demo.dao.api;

import java.util.List;

import jedpayt.demo.entity.Vendor;

public interface VendorDAO {

	void insertVendor(Vendor vendor);
	Vendor findVendor(String name);
	Vendor findVendor(int id);
	void updateVendor(Vendor vendor);
	void deleteVendor(Vendor vendor);
	List<Vendor> findAllVendors();
}

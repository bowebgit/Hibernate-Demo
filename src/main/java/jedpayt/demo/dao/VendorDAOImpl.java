package jedpayt.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jedpayt.demo.dao.api.VendorDAO;
import jedpayt.demo.entity.Vendor;

@Service
public class VendorDAOImpl implements VendorDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().save(vendor);
	}
	public Vendor findVendor(String name){
		Query query = sessionFactory.
				getCurrentSession().
				createQuery("from Vendor where vendor_name = :name");
		query.setParameter("name", name);
		return (Vendor) query.list().get(0);
	}
	public Vendor findVendor(int id) {
		return (Vendor) sessionFactory.
				getCurrentSession().
				get(Vendor.class, id);
	}

	public void updateVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().update(vendor);
	}

	public void deleteVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().delete(vendor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Vendor> findAllVendors() { 
		Criteria criteria = sessionFactory.getCurrentSession(). 
				createCriteria(Vendor.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	
	}

}

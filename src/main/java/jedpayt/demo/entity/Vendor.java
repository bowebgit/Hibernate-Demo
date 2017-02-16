package jedpayt.demo.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vendor_id", nullable = false)
	private int vendor_id;
	
	@Column(name="vendor_name")
	private String vendor_name;
	
	@Column(name="vendor_address")
	private String vendor_address;
	
	@Column(name="vendor_city")
	private String vendor_city;
	
	@Column(name="vendor_state")
	private String vendor_state;
	
	@Column(name="vendor_zip")
	private String vendor_zip;
	
	@Column(name="vendor_contact")
	private String vendor_contact;
	
	@Column(name="vendor_phone")
	private String vendor_phone;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="vendor")
	private Set<Product> products;
	
	public Vendor(){}
	
	public Vendor(String vendor_name, String vendor_address, String vendor_city, String vendor_state, 
			String vendor_zip, String vendor_contact, String vendor_phone){
		this.vendor_name = vendor_name;
		this.vendor_address = vendor_address;
		this.vendor_city = vendor_city;
		this.vendor_state = vendor_state;
		this.vendor_zip = vendor_zip;
		this.vendor_contact = vendor_contact;
		this.vendor_phone = vendor_phone;
	}


	public Set<Product> getProducts(){
		return products;
	}
	public void setProducts(Set<Product> products){
		this.products = products;
	}
	
	public int getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_address() {
		return vendor_address;
	}

	public void setVendor_address(String vendor_address) {
		this.vendor_address = vendor_address;
	}

	public String getVendor_city() {
		return vendor_city;
	}

	public void setVendor_city(String vendor_city) {
		this.vendor_city = vendor_city;
	}

	public String getVendor_state() {
		return vendor_state;
	}

	public void setVendor_state(String vendor_state) {
		this.vendor_state = vendor_state;
	}

	public String getVendor_zip() {
		return vendor_zip;
	}

	public void setVendor_zip(String vendor_zip) {
		this.vendor_zip = vendor_zip;
	}

	public String getVendor_contact() {
		return vendor_contact;
	}

	public void setVendor_contact(String vendor_contact) {
		this.vendor_contact = vendor_contact;
	}

	public String getVendor_phone() {
		return vendor_phone;
	}

	public void setVendor_phone(String vendor_phone) {
		this.vendor_phone = vendor_phone;
	}

	@Override
	public String toString() {
		return "Vendor ID: " + vendor_id + "\n"
				+ " vendor_name=" + vendor_name 
				+ ", vendor_contact=" + vendor_contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vendor_city == null) ? 0 : vendor_city.hashCode());
		result = prime * result + ((vendor_name == null) ? 0 : vendor_name.hashCode());
		result = prime * result + ((vendor_state == null) ? 0 : vendor_state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		if (vendor_city == null) {
			if (other.vendor_city != null)
				return false;
		} else if (!vendor_city.equals(other.vendor_city))
			return false;
		if (vendor_name == null) {
			if (other.vendor_name != null)
				return false;
		} else if (!vendor_name.equals(other.vendor_name))
			return false;
		if (vendor_state == null) {
			if (other.vendor_state != null)
				return false;
		} else if (!vendor_state.equals(other.vendor_state))
			return false;
		return true;
	}
	
	
	
}

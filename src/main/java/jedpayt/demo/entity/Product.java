package jedpayt.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="prod_id", nullable = false)
	private int prod_id;
	
	@Column(name="prod_name")
	private String prod_name; 
	
	@Column(name="prod_description")
	private String prod_description;
	
	@Column(name="prod_price")
	private double prod_price;
	
	@Column(name="prod_qoh")
	private int prod_qoh;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vendor_id")
	private Vendor vendor;
	
	public Product(){}
	
	public Product(String name, String prod_description, double prod_price, int prod_qoh){
		this.prod_name = name;
		this.prod_description = prod_description;
		this.prod_price = prod_price;
		this.prod_qoh = prod_qoh;
	}

	// Getters and Setters
	public Vendor getVendor(){
		return this.vendor;
	}
	public void setVendor(Vendor vendor){
		this.vendor = vendor;
	}
	
	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_description() {
		return prod_description;
	}

	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}

	public double getProd_price() {
		return prod_price;
	}

	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_qoh() {
		return prod_qoh;
	}

	public void setProd_qoh(int prod_qoh) {
		this.prod_qoh = prod_qoh;
	}

	@Override
	public String toString() {
		return "* Product ID: " + prod_id + "\n"
				+ "  prod_name=" + prod_name + ", prod_price=" + prod_price + ", prod_qoh=" + prod_qoh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + prod_id;
		result = prime * result + ((prod_name == null) ? 0 : prod_name.hashCode());
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
		Product other = (Product) obj;
		if (prod_id != other.prod_id)
			return false;
		if (prod_name == null) {
			if (other.prod_name != null)
				return false;
		} else if (!prod_name.equals(other.prod_name))
			return false;
		return true;
	}
	
	
}
